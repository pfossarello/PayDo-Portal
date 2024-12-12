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
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

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

// Identifica  l'ultimo pulsante di navigazione pagine prima del >

TestObject lastNumericButton = new TestObject()
lastNumericButton.addProperty("xpath", ConditionType.EQUALS, "//div[@class='py-4 text-right flex space-x-12 justify-end items-center']//button[not(@disabled)][last()-1]")

// Ottieni il testo del pulsante
String numeroPulsante = WebUI.getText(lastNumericButton)

// Stampa il numero recuperato
println("Numero acquisito dal pulsante: " + numeroPulsante)

// Converte il numero acquisito in un intero
int numeroPulsante_intero = Integer.parseInt(numeroPulsante)

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_filtri'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Dropdown_stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Page_PlickUp-Admin/span_Created'))

// Apri il calendar
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 22 - Filtri - corretto filtraggio per Stato e Data di passaggio con visualizzazione del dettaglio - Created/Page_PlickUp-Admin/Date calendario'))

// Calcola le date necessarie
LocalDate today = LocalDate.now()
LocalDate firstDayLastMonth = today.minusMonths(1).withDayOfMonth(1)

// Formatta le date come stringhe (adatta al formato che il calendario riconosce)
DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d")
String firstDayLastMonthStr = dayFormatter.format(firstDayLastMonth)
String todayStr = dayFormatter.format(today)

// Seleziona il primo giorno del mese precedente
TestObject firstDayObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//div[contains(@class, 'react-datepicker__day') and text()='" + firstDayLastMonthStr + "']"
)
WebUI.click(firstDayObject)

// Seleziona la data odierna
TestObject todayObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//div[contains(@class, 'react-datepicker__day') and @aria-current='date']"
)
WebUI.click(todayObject)

// Chiudi il calendario cliccando fuori
TestObject bodyObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//body"
)
WebUI.click(bodyObject)

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))


// Identifica  l'ultimo pulsante di navigazione pagine prima del >

TestObject lastNumericButton1 = new TestObject()
lastNumericButton1.addProperty("xpath", ConditionType.EQUALS, "//div[@class='py-4 text-right flex space-x-12 justify-end items-center']//button[not(@disabled)][last()-1]")

// Ottieni il testo del pulsante
String numeroPulsante1 = WebUI.getText(lastNumericButton1)

// Stampa il numero recuperato
println("Numero acquisito dal pulsante: " + numeroPulsante1)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 26 - Filtri - corretto annullamento filtro impostato/Pulsante disabilita filtro'))

// Identifica  l'ultimo pulsante di navigazione pagine prima del >

TestObject lastNumericButton2 = new TestObject()
lastNumericButton2.addProperty("xpath", ConditionType.EQUALS, "//div[@class='py-4 text-right flex space-x-12 justify-end items-center']//button[not(@disabled)][last()-1]")

// Ottieni il testo del pulsante
String numeroPulsante2 = WebUI.getText(lastNumericButton2)

// Stampa il numero recuperato
println("Numero acquisito dal pulsante: " + numeroPulsante2)

// Converte il numero acquisito in un intero
int numeroPulsante2_intero = Integer.parseInt(numeroPulsante2)

WebUI.verifyEqual(numeroPulsante2_intero, numeroPulsante_intero)
WebUI.delay(3)
WebUI.closeBrowser()
