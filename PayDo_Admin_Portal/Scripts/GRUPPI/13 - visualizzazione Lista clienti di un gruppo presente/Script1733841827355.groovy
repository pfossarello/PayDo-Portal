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
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver


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

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/svg_Elementi per pagina_w-5 h-5 text-white'))

String randomNomeGruppo = RandomStringUtils.randomAlphabetic(6)
WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Elementi per pagina_name'), randomNomeGruppo)

WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Nome gruppo_description'), 'DescrizioneIMgKTZ')

////////////////////////////////////////////////////////////////////////////////////////////////////////77
// Assicurati che il selettore sia presente
TestObject selectObject = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//select[contains(@class, 'rdl-control') and @multiple='']")

// Attendi che il selettore sia presente
WebUI.waitForElementPresent(selectObject, 10)

// Ottieni l'elemento WebElement per il <select>
WebElement selectElement = WebUI.findWebElement(selectObject)

// Usa Selenium's Select per manipolare il dropdown
Select select = new Select(selectElement)
List<WebElement> options = select.getOptions()

// Verifica che ci siano almeno due opzioni disponibili
if (options.size() < 2) {
    WebUI.comment("Non ci sono abbastanza opzioni disponibili per effettuare due selezioni casuali.")
    return // Termina l'esecuzione dello script
}

// Scegli due opzioni casuali non uguali
Random random = new Random()

// Prima opzione casuale
int firstRandomIndex = random.nextInt(options.size())
WebElement firstRandomOption = options.get(firstRandomIndex)

// Rimuovi l'opzione selezionata per evitare duplicati
options.remove(firstRandomIndex)

// Seconda opzione casuale (dal set rimanente)
int secondRandomIndex = random.nextInt(options.size())
WebElement secondRandomOption = options.get(secondRandomIndex)

// Seleziona e interagisci con la prima opzione
select.selectByValue(firstRandomOption.getAttribute('value'))
WebUI.comment("Prima opzione selezionata: " + firstRandomOption.getText())

TestObject firstOptionObject = new TestObject()
firstOptionObject.addProperty('xpath', ConditionType.EQUALS, "//option[@value='${firstRandomOption.getAttribute('value')}']")
WebUI.doubleClick(firstOptionObject)

// Attendi brevemente
WebUI.delay(2)

// Seleziona e interagisci con la seconda opzione
select.selectByValue(secondRandomOption.getAttribute('value'))
WebUI.comment("Seconda opzione selezionata: " + secondRandomOption.getText())

TestObject secondOptionObject = new TestObject()
secondOptionObject.addProperty('xpath', ConditionType.EQUALS, "//option[@value='${secondRandomOption.getAttribute('value')}']")
WebUI.doubleClick(secondOptionObject)

// Attendi brevemente per osservare il risultato
WebUI.delay(2)

//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/img_Filter available_pt-1 w-auto h-12'))
WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_Aggiungi'))

WebUI.delay(1)

TestObject dynamicSpanObject = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Gruppo aggiunto\')]')

TestObject dynamicSpanObject1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Operazione eseguita con successo\')]')

String esito = WebUI.getText(dynamicSpanObject)

println(esito)

WS.verifyMatch(esito, 'Gruppo aggiunto', true)

String esito1 = WebUI.getText(dynamicSpanObject1)

println(esito1)

WS.verifyMatch(esito1, 'Operazione eseguita con successo', true)

WebUI.delay(6)
//////////////////////////////////////////////////////////////////////////////////////////////////////7
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

WebUI.verifyMatch(Nome_gruppo1, randomNomeGruppo, true)


WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/svg_IMgKTZ_inline-block w-5 h-5'))
WebUI.click(findTestObject('Object Repository/GRUPPI/13 - visualizzazione Lista clienti di un gruppo presente/Page_PlickUp-Admin/chiudi lista clienti'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/div_Elimina'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/button_SI'))

WebUI.delay(1)

TestObject dynamicSpanObject2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Gruppo eliminato\')]')

TestObject dynamicSpanObject3 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Operazione eseguita con successo\')]')

String esito2 = WebUI.getText(dynamicSpanObject2)

println(esito2)

WS.verifyMatch(esito2, 'Gruppo eliminato', true)

String esito3 = WebUI.getText(dynamicSpanObject3)

println(esito3)

WS.verifyMatch(esito3, 'Operazione eseguita con successo', true)

WebUI.delay(6)

WebUI.closeBrowser()
