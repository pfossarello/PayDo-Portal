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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

WebUI.callTestCase(findTestCase('Test Cases/PLICKUP/test ID 2 - CreateRTP - areaCode 39'), [:], FailureHandling.STOP_ON_FAILURE)


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

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_filtri'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Dropdown_stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Page_PlickUp-Admin/span_Created'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))

// Prova a trovare l'oggetto "Nessun risultato trovato"
TestObject nessunRisultato = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 25.1 - Filtri - corretto filtraggio per Stato e Data di passaggio e visualizzazione del dettaglio - Autorizzata - nessun risultato/Page_PlickUp-Admin/Filtro - nessun risultato')

boolean isVisible = WebUI.waitForElementVisible(nessunRisultato, 3, FailureHandling.OPTIONAL)

// Condizione: se l'elemento è visibile, termina l'esecuzione
if (!isVisible) {
	WebUI.comment("Nessun risultato trovato: il filtro non ha restituito risultati. Fine script.")
//	WebUI.closeBrowser()
	return // Termina l'esecuzione dello script
} else {
	WebUI.comment("Risultati trovati: procedo con il resto dello script.")

	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/div_Forza stato pagata'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_SI'))
	
	TestObject dynamicSpanObject = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Stato modificato')]"
	)
	
	
	TestObject dynamicSpanObject1 = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Operazione eseguita con successo')]"
	)

	String esito1 = WebUI.getText(dynamicSpanObject)
	println esito1
	WS.verifyMatch(esito1, "Stato modificato", true)
	
	String esito = WebUI.getText(dynamicSpanObject1)
	println esito
	WS.verifyMatch(esito, "Operazione eseguita con successo", true)
	WebUI.delay(6)

	//Esploro la tabella e prendo i dati della prima riga
	// Trova l'elemento della tabella
	WebElement table = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
	
	// Trova tutte le righe all'interno della tabella
	List<WebElement> rows = table.findElements(By.tagName('tr'))
	
	println rows
	
	int i = 1
	
	WebElement row = rows.get(i)
	
	// Trova tutte le celle (colonne) della riga corrente
	List<WebElement> columns = row.findElements(By.tagName('td'))
	
	// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
	String identificativo = columns.get(0).getText()
	String Creazione = columns.get(1).getText()
	String Importo = columns.get(2).getText()
	String Stato = columns.get(4).getText()
	String Ultimo_stato = columns.get(5).getText()
	String Scadenza = columns.get(6).getText()
	
	// Stampa i valori estratti o usali come preferisci
	println("Identificativo: " + identificativo)
	println("Creazione: " + Creazione)
	println("Importo: " + Importo)
	println("Stato: " + Stato)
	println("Ultimo_stato: " + Ultimo_stato)
	println("Scadenza: " + Scadenza)
	
	
	
	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
	
	String data_creazione = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/data di creazione'))
	println(data_creazione)
	String data_cambio_stato = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/data cambio stato in pagata'))
	println(data_cambio_stato)
	String importo = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Importo_2'))
	println(importo)
	String Identificativo = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Identificativo'))
	println(Identificativo)
	String Data_creazione = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Data_creazione'))
	println(Data_creazione)
	String Data_scadenza = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/data_scadenza'))
	println(Data_scadenza)
	String Stato_pratica = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Stato_pratica'))
	println(Stato_pratica)
	
	
	WebUI.verifyMatch(data_creazione, Creazione, true)
	LocalDate today = LocalDate.now();  // Data odierna
	// Definisci il formato della data
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY")
	
	String todayString = today.format(formatter)
	WebUI.verifyMatch(data_cambio_stato, todayString, true)
	WebUI.verifyMatch(importo, Importo, true)
	WebUI.verifyMatch(Identificativo, identificativo, true)
	WebUI.verifyMatch(Data_creazione, Creazione, true)
	WebUI.verifyMatch(Stato, "Pagata", true)
	WebUI.verifyMatch(Data_scadenza, Scadenza, true)
	WebUI.verifyMatch(Stato_pratica, "Pagata", true)

WebUI.closeBrowser()
}