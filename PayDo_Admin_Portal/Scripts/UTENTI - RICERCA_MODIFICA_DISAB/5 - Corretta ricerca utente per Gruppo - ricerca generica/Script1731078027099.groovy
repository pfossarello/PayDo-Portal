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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions


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
WebUI.delay(3)
//println(GlobalVariable.nomegruppo)


// Trova la dropdown list come elemento Web e identifica le opzioni
WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/5 - Corretta ricerca utente per Gruppo/Page_PlickUp-Admin/div_Cerca per gruppo_css-19bb58m'))

List<WebElement> elements = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/5 - Corretta ricerca utente per Gruppo/Page_PlickUp-Admin/Dropdown gruppi'), 30)
println elements



Random randomGenerator = new Random()  // Inizializza Random una sola volta
    int lastIndex = -1  // Variabile per salvare l'indice usato l'ultima volta
    int randomIndex = randomGenerator.nextInt(elements.size())  // Genera un indice iniziale
    
    // Continua a generare un indice finché non è diverso dall'ultimo
    while (randomIndex == lastIndex) {
        randomIndex = randomGenerator.nextInt(elements.size())
    }
    
//    lastIndex = randomIndex  // Aggiorna l'indice usato l'ultima volta
    WebElement randomOption = elements.get(randomIndex)
    println("Elemento selezionato casualmente: " + randomOption.getText())
	randomOption.click()

WebElement selectedValueElement = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/5 - Corretta ricerca utente per Gruppo/Page_PlickUp-Admin/gruppo selezionato'), 10)
String grupposelezionato = selectedValueElement.getText()
println	grupposelezionato
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/appoggio/Page_PlickUp-Admin/svg_Cerca per gruppo_Componente_100_4'))
//WebElement svgElement = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/appoggio/Page_PlickUp-Admin/svg_Cerca per gruppo_Componente_100_4'), 10)
WebDriver driver = DriverFactory.getWebDriver()
WebElement svgElement = driver.findElement(By.xpath("//*[name()='g' and @id='Raggruppa_1177']//*[name()='path' and @id='Tracciato_1800']"))

// Clicca con JavaScript
JavascriptExecutor js = (JavascriptExecutor) driver
js.executeScript("var evt = document.createEvent('MouseEvents'); evt.initEvent('mouseup', true, true); arguments[0].dispatchEvent(evt);", svgElement)


JavascriptExecutor jst = (JavascriptExecutor) DriverFactory.getWebDriver()

// Scrolla fino in fondo alla pagina
jst.executeScript("window.scrollTo(0, document.body.scrollHeight);")

WebElement table = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))



List<WebElement> rows = table.findElements(By.tagName('tr'))

println rows

int i = 1

WebElement row = rows.get(i)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns = row.findElements(By.tagName('td'))
println columns
// Estrai i valori di Gruppi

String Gruppo = columns.get(4).getText()
print Gruppo

// Stampa i valori estratti o usali come preferisci

println("Gruppi: " + Gruppo)


WS.verifyMatch(Gruppo, grupposelezionato, true)

WebUI.waitForElementVisible(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)
// Esegui lo scroll fino alla dropdown
JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getWebDriver()
js1.executeScript("window.scrollTo(0, document.body.scrollHeight)")

WebUI.selectOptionByValue(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'),
	'50', false)

WebUI.waitForElementVisible(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)
// Esegui lo scroll fino alla dropdown
JavascriptExecutor js2 = (JavascriptExecutor) DriverFactory.getWebDriver()
js2.executeScript("window.scrollTo(0, document.body.scrollHeight)")

WebUI.delay(5)
WebUI.closeBrowser()
