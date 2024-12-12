import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.By // Importa la classe By
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import java.util.stream.Collectors
import org.apache.commons.io.FileUtils
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent


WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'),
	'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_accedi'))
//WebUI.delay(20)


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_PlickUp'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/hamburger menu'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/p_Clienti'))
WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/svg_Elementi per pagina_w-5 h-5 text-white'))

WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button_Aggiungi'))

// Crea un Test Object dinamico per selezionare tutti i messaggi di errore con un XPath generico
TestObject errorMessageObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[(text() = 'Il campo è obbligatorio' or . = 'Il campo è obbligatorio')]"
)

// Conta tutti gli elementi che corrispondono al messaggio "Il campo è obbligatorio"
List<WebElement> errorMessages = WebUI.findWebElements(errorMessageObject, 10)
// Ottieni il numero di elementi
int numberOfErrors = errorMessages.size()
println numberOfErrors

// Verifica se il numero di messaggi di errore è uguale a 4
int expectedErrorCount = 4
WebUI.verifyEqual(numberOfErrors, expectedErrorCount)

String errore_logo = WebUI.getText(findTestObject('Object Repository/CLIENTI/10 - Blocco aggiunta nuovo cliente senza campi obbligatori/Page_PlickUp-Admin/p_Il logo primario  obbligatorio'))
println errore_logo
WS.verifyMatch('Il logo primario è obbligatorio', errore_logo, true)

String error_tema = WebUI.getText(findTestObject('Object Repository/CLIENTI/10 - Blocco aggiunta nuovo cliente senza campi obbligatori/Page_PlickUp-Admin/p_Il tema  obbligatorio'))
println error_tema
WS.verifyMatch(error_tema, "Il tema è obbligatorio", true)

String error_cliente = WebUI.getText(findTestObject('Object Repository/CLIENTI/10 - Blocco aggiunta nuovo cliente senza campi obbligatori/Page_PlickUp-Admin/p_Selezionare la tipologia cliente'))
println error_cliente
WS.verifyMatch(error_cliente, "Selezionare la tipologia cliente", true)

WebUI.delay(5)
WebUI.closeBrowser()
