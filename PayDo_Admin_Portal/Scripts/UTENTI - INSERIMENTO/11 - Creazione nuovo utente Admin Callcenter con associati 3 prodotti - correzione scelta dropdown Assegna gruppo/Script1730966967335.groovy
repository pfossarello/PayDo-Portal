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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'),
	'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/button_accedi'))

//WebUI.delay(20)
//
//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/div_Gestione utenti'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/svg_Elementi per pagina_w-5 h-5 text-white'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/3 - Creazione nuovo utente Admin Callcenter con associati 3 prodotti/Page_PlickUp-Admin/label_Admin Callcenter'))


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/div_RuoloAdmin PayDoOperatore PayDoAdmin Ca_1053b1'))
// Crea un Test Object dinamico con XPath per il tag <p> contenente la classe specificata
TestObject labelObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[contains(@class, 'text-right w-28 font-mediumMontserrat text-lg') and contains(text(), 'Admin Callcenter')]"
)

// Recupera il testo dal Test Object
String ruolo = WebUI.getText(labelObject)
println ruolo


String randomNome = RandomStringUtils.randomAlphabetic(6)
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__firstName'), randomNome)

String randomCognome = RandomStringUtils.randomAlphabetic(10)
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__lastName'),randomCognome)

String randomEmail = "test" + System.currentTimeMillis() + "@example.com"
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__email'), randomEmail)


WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/input_Phone_form-control w-full h-10'),
	'+39 352 35252')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'SkwO0jEy3+SQ4ga6o8OdVA==')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/input_Phone_temporaryPassword'),
	'SkwO0jEy3+SQ4ga6o8OdVA==')

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/label_Plick'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/label_PlickUp'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/label_Prelievi e versamenti'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/3 - Creazione nuovo utente Admin Callcenter con associati 3 prodotti/Dropdown list/Page_PlickUp-Admin/svg_Gruppo_css-8mmkcg'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/3 - Creazione nuovo utente Admin Callcenter con associati 3 prodotti/Dropdown list/Page_PlickUp-Admin/div_test'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/3 - Creazione nuovo utente Admin Callcenter con associati 3 prodotti/Dropdown list/Page_PlickUp-Admin/svg_Gruppo_css-8mmkcg'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Aggiungi'))

TestObject errorMessageObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[(text() = 'Il campo è obbligatorio' or . = 'Il campo è obbligatorio')]"
)

String esito = WebUI.getText(errorMessageObject)
println esito
WS.verifyMatch(esito, "Il campo è obbligatorio", true)

WebUI.closeBrowser()