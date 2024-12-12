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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



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


WebUI.waitForElementVisible(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)
// Esegui lo scroll fino alla dropdown
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("window.scrollTo(0, document.body.scrollHeight)")
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 
    '10', false)

// Trova l'elemento della dropdown
WebElement dropdown1 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)



WebUI.waitForElementVisible(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)
// Esegui lo scroll fino alla dropdown
JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getWebDriver()
js1.executeScript("window.scrollTo(0, document.body.scrollHeight)")
WebUI.delay(2)
WebUI.selectOptionByValue(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 
    '5', false)

// Trova l'elemento della dropdown
WebElement dropdown2 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)

// Esegui lo scroll fino alla dropdown
JavascriptExecutor js2 = (JavascriptExecutor) DriverFactory.getWebDriver()
js2.executeScript("window.scrollTo(0, document.body.scrollHeight)")

WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/button_2'))

// Trova l'elemento della dropdown
WebElement dropdown3 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)

// Esegui lo scroll fino alla dropdown
JavascriptExecutor js3 = (JavascriptExecutor) DriverFactory.getWebDriver()
js3.executeScript("window.scrollTo(0, document.body.scrollHeight)")

WebUI.delay(4)
WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/button_1'))

// Trova l'elemento della dropdown
WebElement dropdown4 = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/6 - Corretto ordinamento risultati su pagina per numero record registrati/Page_PlickUp-Admin/select_5102550'), 10)

// Esegui lo scroll fino alla dropdown
JavascriptExecutor js4 = (JavascriptExecutor) DriverFactory.getWebDriver()
js4.executeScript("window.scrollTo(0, document.body.scrollHeight)")
WebUI.closeBrowser()
