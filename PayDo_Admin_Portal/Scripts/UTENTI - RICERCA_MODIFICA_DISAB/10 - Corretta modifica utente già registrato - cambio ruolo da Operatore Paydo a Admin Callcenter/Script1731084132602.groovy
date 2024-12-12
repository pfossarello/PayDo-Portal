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
import internal.GlobalVariable as GlobalVariable


WebUI.callTestCase(findTestCase('Test Cases/UTENTI - INSERIMENTO/2 - Creazione nuovo utente Operatore PayDo con associati 3 prodotti'), [:], FailureHandling.STOP_ON_FAILURE)

// Accedi ai valori delle variabili globali
String Nome = GlobalVariable.Nome_general
String Cognome = GlobalVariable.Cognome_general
String Ruolo = GlobalVariable.Ruolo_general

println("Nome: " + Nome)
println("Cognome: " + Cognome)
println("Ruolo: " + Ruolo)

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
WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Button Gestione Utenti'))


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
String ruolo = columns.get(3).getText()

// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome)
println("Cognome: " + cognome)
println("Ruolo: " + ruolo)

WS.verifyMatch(nome, Nome, true)
WS.verifyMatch(cognome, Cognome, true)
WS.verifyMatch(ruolo, Ruolo, true)

WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/9 - Corretta modifica utente già registrato - cambio ruolo da AdminPayDo a Operatore Paydo/Page_PlickUp-Admin/div_Modifica'))
WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/3 - Creazione nuovo utente Admin Callcenter con associati 3 prodotti/Page_PlickUp-Admin/label_Admin Callcenter'))

// Crea un Test Object dinamico con XPath per il tag <p> contenente la classe specificata
TestObject labelObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[contains(@class, 'text-right w-28 font-mediumMontserrat text-lg') and contains(text(), 'Admin Callcenter')]"
)

// Recupera il testo dal Test Object
String ruolo_modificato = WebUI.getText(labelObject)
println ruolo_modificato
ruolo_modificato1 =  ruolo_modificato.replace("Admin Callcenter", "Admin Call Center")

WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/9 - Corretta modifica utente già registrato - cambio ruolo da AdminPayDo a Operatore Paydo/Page_PlickUp-Admin/label_Plick'))
WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/9 - Corretta modifica utente già registrato - cambio ruolo da AdminPayDo a Operatore Paydo/Page_PlickUp-Admin/button_Aggiorna'))

// Crea un Test Object dinamico con XPath per il tag <span> contenente 'Utente modificato ' e 'Entità modificata con successo'
TestObject dynamicSpanObject1 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente modificato')]"
)


TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito1 = WebUI.getText(dynamicSpanObject1)
println esito1
WS.verifyMatch(esito1, "Utente modificato", true)

String esito = WebUI.getText(dynamicSpanObject2)
println esito
WS.verifyMatch(esito, "Operazione eseguita con successo", true)



// Trova l'elemento della tabella
WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows1 = table1.findElements(By.tagName('tr'))

println rows1

int k = 1

WebElement row1 = rows1.get(k)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns_new = row1.findElements(By.tagName('td'))
String ruolonuovo = columns_new.get(3).getText()
println ruolonuovo
WS.verifyMatch(ruolonuovo, ruolo_modificato1, true)

WebUI.closeBrowser()



