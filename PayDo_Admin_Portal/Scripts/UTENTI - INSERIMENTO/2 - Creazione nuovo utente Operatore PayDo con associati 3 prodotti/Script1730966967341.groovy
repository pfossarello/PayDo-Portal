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
WebUI.maximizeWindow()
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

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/label_Operatore PayDo'))


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/div_RuoloAdmin PayDoOperatore PayDoAdmin Ca_1053b1'))
// Crea un Test Object dinamico con XPath per il tag <p> contenente la classe specificata
TestObject labelObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[contains(@class, 'text-right w-28 font-mediumMontserrat text-lg') and contains(text(), 'Operatore PayDo')]"
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

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Aggiungi'))

// Trova l'elemento della tabella
WebElement table = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows = table.findElements(By.tagName('tr'))

println rows

int i = 1

WebElement row = rows.get(i)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns = row.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome = columns.get(0).getText()
String cognome = columns.get(1).getText()
String email = columns.get(2).getText()
String Ruolo = columns.get(3).getText()

// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome)
println("Cognome: " + cognome)
println("Email: " + email)
println("Ruolo: " + Ruolo)

WS.verifyMatch(nome, randomNome, true)
WS.verifyMatch(cognome, randomCognome, true)
WS.verifyMatch(email, randomEmail, true)
WS.verifyMatch(Ruolo, ruolo, true)

// Imposta i valori delle variabili globali
GlobalVariable.Nome_general = nome
GlobalVariable.Cognome_general = cognome
GlobalVariable.Ruolo_general = Ruolo

// Crea un Test Object dinamico con XPath per il tag <span> contenente 'Utente Creato' e 'Entità creata con successo'
TestObject dynamicSpanObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente creato')]"
)


TestObject dynamicSpanObject1 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Entità creata con successo')]"
)

String esito1 = WebUI.getText(dynamicSpanObject)
println esito1
WS.verifyMatch(esito1, "Utente creato", true)

String esito = WebUI.getText(dynamicSpanObject1)
println esito
WS.verifyMatch(esito, "Entità creata con successo.", true)

WebUI.closeBrowser()