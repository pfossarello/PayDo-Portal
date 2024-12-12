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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.testobject.TestObject
import java.util.Random
import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'),
	'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_accedi'))
//WebUI.delay(20)


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/div_Davide_z-10 absolute top-3 left-3 right_95b39b'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_Davide_w-24 h-20 bg-skin-bgBtnMenu f_410c06'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/span_Home'))

///////////////////////////////////////////////////////////////////////////////////7
// Trova l'elemento della tabella
WebElement table = WebUI.findWebElement(findTestObject('Object Repository/GRUPPI/10 - mancata creazione nuovo gruppo senza nome inserito ma con clienti associati e corretta chiusura spalla dx/Page_PlickUp-Admin/tabella gruppi'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows = table.findElements(By.tagName('tr'))

println rows

int i = 1

WebElement row = rows.get(i)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns = row.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String Nome_gruppo = columns.get(0).getText()
println Nome_gruppo

///////////////////////////////////////////////////////////////////////////////////7

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/svg_Elementi per pagina_w-5 h-5 text-white'))

//WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Elementi per pagina_name'), 'ClienteTest1s')

WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Nome gruppo_description'), 'DescrizioneCliente1s')

// Trova l'elemento <select> usando l'XPath
TestObject selectObject = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//select[contains(@class, 'rdl-control') and @multiple='']")

// Verifica che l'elemento <select> esista
WebUI.verifyElementPresent(selectObject, 10)

// Ottieni l'elemento <select> come WebElement
WebElement selectElement = WebUI.findWebElement(selectObject)

// Usa Selenium's Select per interagire con il <select>
Select select = new Select(selectElement)

// Ottieni tutte le opzioni disponibili
List<WebElement> options = select.getOptions()

// Scegli un'opzione casuale
Random random = new Random()
int randomIndex = random.nextInt(options.size()) // Genera un indice casuale
WebElement randomOption = options.get(randomIndex)

// Seleziona l'opzione casuale
select.selectByValue(randomOption.getAttribute('value'))

// Stampa l'opzione selezionata nella console
WebUI.comment("Opzione selezionata: " + randomOption.getText())

// Crea un TestObject per l'opzione selezionata
TestObject selectedOptionObject = new TestObject()
selectedOptionObject.addProperty('xpath', ConditionType.EQUALS, "//option[@value='${randomOption.getAttribute('value')}']")

// Esegui il doppio clic sull'opzione selezionata
WebUI.doubleClick(selectedOptionObject)

// Aggiungi un'attesa per osservare l'azione
WebUI.delay(2)

//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/img_Filter available_pt-1 w-auto h-12'))
//WebUI.scrollToElement(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/svg_Elementi per pagina_inline-block w-4 h-4 cursor-pointer'), 3)
WebUI.scrollToPosition(0, 0)
WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/svg_Elementi per pagina_inline-block w-4 h-4 cursor-pointer'))

WebUI.delay(3)
//////////////////////////////////////////////////////////////////////////////////////////////////7
// Trova l'elemento della tabella
WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/GRUPPI/10 - mancata creazione nuovo gruppo senza nome inserito ma con clienti associati e corretta chiusura spalla dx/Page_PlickUp-Admin/tabella gruppi'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows1 = table1.findElements(By.tagName('tr'))

println rows1

int j = 1

WebElement row1 = rows1.get(j)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns1 = row1.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String Nome_gruppo1 = columns1.get(0).getText()
println Nome_gruppo1

WebUI.verifyMatch(Nome_gruppo1, Nome_gruppo, true)
WebUI.closeBrowser()

