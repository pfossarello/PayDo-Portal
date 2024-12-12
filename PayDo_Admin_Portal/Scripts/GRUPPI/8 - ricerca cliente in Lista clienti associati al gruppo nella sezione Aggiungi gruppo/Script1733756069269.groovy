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

WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Nome gruppo_description'), 'DescrizioneCliente2P')

//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/option_Agenzia Giorgia 1'))
//
//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/option_Antonio Marco'))

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
WebUI.delay(3)

// Trova l'elemento <select> usando l'XPath
TestObject selectObject1 = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//div[@class='rdl-list-box rdl-selected']//div[@class='rdl-control-container']//select[@class='rdl-control']")

// Verifica che l'elemento <select> esista
WebUI.verifyElementPresent(selectObject1, 10)

// Ottieni l'elemento <select> come WebElement
WebElement selectElement1 = WebUI.findWebElement(selectObject1)

// Usa Selenium's Select per interagire con il <select>
Select select1 = new Select(selectElement1)

// Ottieni tutte le opzioni disponibili
List<WebElement> options1 = select1.getOptions()

// Scegli un'opzione casuale
Random random1 = new Random()
int randomIndex1 = random1.nextInt(options1.size()) // Genera un indice casuale
WebElement randomOption1 = options1.get(randomIndex1)

// Ottieni il valore del testo dell'opzione casuale
String selectedOptionText1 = randomOption1.getText()
println selectedOptionText1

// Inserisci il testo dell'opzione selezionata nel campo di input
TestObject searchField = findTestObject('Object Repository/GRUPPI/8 - ricerca cliente in Lista clienti associati al gruppo nella sezione Aggiungi gruppo/Campo ricerca Lista clienti associati')

// Inserisce il valore dell'opzione selezionata nel campo di input
WebUI.setText(searchField, selectedOptionText1)

String insertedText1 = WebUI.getAttribute(searchField, "value")
WebUI.comment("Testo inserito nel campo di ricerca: " + insertedText1)

WebUI.delay(3)

// Trova l'elemento <select> usando l'XPath
TestObject selectObject2 = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//div[@class='rdl-list-box rdl-selected']//div[@class='rdl-control-container']//select[@class='rdl-control']")

// Verifica che l'elemento <select> esista
WebUI.verifyElementPresent(selectObject2, 10)

// Ottieni l'elemento <select> come WebElement
WebElement selectElement2 = WebUI.findWebElement(selectObject2)

// Usa Selenium's Select per interagire con il <select>
Select select2 = new Select(selectElement2)

// Ottieni tutte le opzioni disponibili
List<WebElement> options2 = select2.getOptions()

// Dichiarazione della variabile String per memorizzare l'opzione
String selectedOptionText2 = ""

// Verifica se c'è solo un'opzione
if (options2.size() == 1) {
	// Se c'è solo un'opzione, memorizza il testo in una variabile String
	WebElement singleOption2 = options2.get(0)
	selectedOptionText2 = singleOption2.getText()
	WebUI.comment("L'unica opzione disponibile è: " + selectedOptionText2)
} else {
	// Altrimenti, se ci sono più opzioni, stampale tutte
	for (WebElement option : options2) {
		WebUI.comment("Opzione disponibile: " + option.getText())
	}
}

println insertedText1
println selectedOptionText2


WebUI.verifyMatch(selectedOptionText2, insertedText1, true)
WebUI.closeBrowser()