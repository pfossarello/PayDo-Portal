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
import org.openqa.selenium.WebElement


WebUI.openBrowser('')

WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'),
	'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_accedi'))

//WebUI.delay(20)


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Button Gestione Utenti'))


WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/svg_Elementi per pagina_w-5 h-5 text-white'))


WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Aggiungi'))

// Attendi qualche secondo che i messaggi di errore compaiano
WebUI.delay(1)  

// Crea un Test Object dinamico per selezionare tutti i messaggi di errore con un XPath generico
TestObject errorMessageObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[(text() = 'Il campo è obbligatorio' or . = 'Il campo è obbligatorio')]"
)

// Conta tutti gli elementi che corrispondono al messaggio "Il campo è obbligatorio"
List<WebElement> errorMessages = WebUI.findWebElements(errorMessageObject, 10)

println errorMessages

int numberOfErrors = errorMessages.size()
println numberOfErrors

// Verifica se il numero di messaggi di errore è uguale a 6
int expectedErrorCount = 6
WebUI.verifyEqual(numberOfErrors, expectedErrorCount)

String errore_ruolo = WebUI.getText(findTestObject('Object Repository/UTENTI - INSERIMENTO/7 - Creazione nuovo utente AdminPayDo senza inserire alcun dato - errore/Page_PlickUp-Admin/p_Il ruolo  obbligatorio'))
println errore_ruolo
WS.verifyMatch('Il ruolo è obbligatorio', errore_ruolo, true)

String errormessage = WebUI.getText(findTestObject('Object Repository/UTENTI - INSERIMENTO/5 - Creazione nuovo utente AdminPayDo senza nessun prodotto associato - errore/Page_PlickUp-Admin/p_Selezionare il prodotto'))
println errormessage
WS.verifyMatch(errormessage, "Selezionare il prodotto", true)
WebUI.closeBrowser()