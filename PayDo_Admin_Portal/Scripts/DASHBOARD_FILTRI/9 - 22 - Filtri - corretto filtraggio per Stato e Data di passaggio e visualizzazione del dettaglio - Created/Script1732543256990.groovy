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


WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_filtri'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Dropdown_stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Page_PlickUp-Admin/span_Created'))

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Apri il calendar
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 22 - Filtri - corretto filtraggio per Stato e Data di passaggio con visualizzazione del dettaglio - Created/Page_PlickUp-Admin/Date calendario'))


// Calcola le date necessarie
LocalDate today = LocalDate.now()
LocalDate firstDayLastMonth = today.minusMonths(1).withDayOfMonth(1)

// Estrai mese e anno correnti e precedenti
int currentMonth = today.getMonthValue()
int currentYear = today.getYear()
int lastMonth = firstDayLastMonth.getMonthValue()
int lastMonthYear = firstDayLastMonth.getYear()

// Formatta le date come stringhe
DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d")
String firstDayLastMonthStr = dayFormatter.format(firstDayLastMonth)
String todayStr = dayFormatter.format(today)

// Naviga fino al mese precedente se necessario
while (currentYear > lastMonthYear || currentMonth > lastMonth) {
	WebUI.click(new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//button[contains(@class, 'react-datepicker__navigation--previous')]"
	))
	currentMonth--
	if (currentMonth == 0) {
		currentMonth = 12
		currentYear--
	}
}

// Seleziona il primo giorno del mese precedente
TestObject firstDayObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//div[contains(@class, 'react-datepicker__day') and text()='" + firstDayLastMonthStr + "']"
)
WebUI.click(firstDayObject)

// Naviga avanti fino al mese corrente se necessario
while (currentYear < today.getYear() || currentMonth < today.getMonthValue()) {
	WebUI.click(new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//button[contains(@class, 'react-datepicker__navigation--next')]"
	))
	currentMonth++
	if (currentMonth == 13) {
		currentMonth = 1
		currentYear++
	}
}

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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Dichiarazioni comuni
//int currentYear = today.getYear()  // Anno corrente
//int currentMonth = today.getMonthValue()  // Mese corrente

// Calcola i giorni come numeri interi
int firstDay = Integer.parseInt(firstDayLastMonthStr)  // Converte la stringa in int
int lastDay = Integer.parseInt(todayStr)  // Converte la stringa in int


// Creiamo le date complete con il formato dd/MM/yyyy
DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy")

// Calcola la prima data dell'intervallo (primo giorno del mese precedente)
//LocalDate firstDayLastMonth = today.minusMonths(1).withDayOfMonth(1)
String firstDayStr = firstDayLastMonth.format(formatter1)

// Ultima data dell'intervallo
LocalDate lastDayDate = LocalDate.of(currentYear, currentMonth, lastDay)
String lastDayStr = lastDayDate.format(formatter1)

// Stampa delle date finali
println("First Day Date: " + firstDayStr)  // Formato: dd/MM/yyyy
println("Last Day Date: " + lastDayStr)   // Formato: dd/MM/yyyy

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))
// Prova a trovare l'oggetto "Nessun risultato trovato"
TestObject nessunRisultato = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 25.1 - Filtri - corretto filtraggio per Stato e Data di passaggio e visualizzazione del dettaglio - Autorizzata - nessun risultato/Page_PlickUp-Admin/Filtro - nessun risultato')

// Verifica se l'elemento è presente sulla pagina entro un timeout specifico (es. 5 secondi)
boolean isPresent = WebUI.waitForElementPresent(nessunRisultato, 3, FailureHandling.OPTIONAL)

// Condizione: se l'elemento è visibile, termina l'esecuzione
if (!isPresent) {
	WebUI.comment("Nessun risultato trovato: il filtro non ha restituito risultati. Fine script.")
	WebUI.closeBrowser()
	return // Termina l'esecuzione dello script
} else {
	WebUI.comment("Risultati trovati: procedo con il resto dello script.")
	
// XPath per il pulsante "Avanti" >
TestObject nextButton = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//button[contains(@class, 'inline-flex') and contains(@class, 'pl-2') and not(@disabled)]"
)


// XPath per il pulsante "Avanti" disabilitato
TestObject nextButtonDisabled = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//button[contains(@class, 'inline-flex') and contains(@class, 'pl-2') and @disabled]"
)

String data_creazione = ""

// Naviga tra le pagine finché il pulsante "Avanti" è abilitato
while (true) {
	
//	// Scrolla fino in fondo alla pagina in incrementi
//	for (int w = 0; w < 2; w++) {
//		WebUI.executeJavaScript("window.scrollBy(0, 4000);", [])
//		WebUI.delay(1)  // Pausa per 1 secondo tra ogni scroll
//	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
	List<WebElement> rows1 = table1.findElements(By.tagName('tr'))
	
	println rows1
	
	int w = 1
	
	WebElement row1 = rows1.get(w)
	
	// Trova tutte le celle (colonne) della riga corrente
	List<WebElement> columns1 = row1.findElements(By.tagName('td'))

	//dal dettaglio pratica del primo record estraggo i valori sotto
	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
	data_creazione = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/data di creazione'))
	println(data_creazione)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Controlla che data_creazione sia nel range
	if (!data_creazione) {
		WebUI.comment("data_creazione è vuota o null!")
		WebUI.verifyEqual(false, true) // Fai fallire il test
	}

	// Parsea la data di creazione nel formato "dd/MM/yyyy"
	LocalDate dataCreazioneDate = LocalDate.parse(data_creazione, formatter1)
	
	// Converte firstDayStr e lastDayStr da String a LocalDate per il confronto
	LocalDate firstDayDate1 = LocalDate.parse(firstDayStr, formatter1)  // prima data dell'intervallo selezionato nel calendar
	LocalDate lastDayDate1 = LocalDate.parse(lastDayStr, formatter1)    // ultima  data (data odierna) dell'intervallo selezionato nel calendar
	
	
	// Controlla se la dataCreazioneDate è nel range tra firstDayDate e lastDayDate
	if (dataCreazioneDate.isBefore(firstDayDate1) || dataCreazioneDate.isAfter(lastDayDate1)) {
	    WebUI.comment("data_creazione ${data_creazione} NON è nel range tra ${firstDayStr} e ${lastDayStr}")
	    WebUI.verifyEqual(false, true) // Fai fallire il test
	} else {
	    WebUI.comment("data_creazione ${data_creazione} è nel range tra ${firstDayStr} e ${lastDayStr}")
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Itera su ogni riga della tabella
	for (int k = 0; k < rows1.size(); k++) {
		WebElement table2 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
		List<WebElement> rows2 = table2.findElements(By.tagName('tr'))
		WebElement row2 = rows2.get(k)
	
		// Trova tutte le celle (colonne) della riga corrente
		List<WebElement> columns2= row2.findElements(By.tagName('td'))
		
		// Controlla se ci sono abbastanza colonne per evitare errori
		if (columns2.size() > 1) {
			// Costruisci XPath dinamico per il pulsante della riga corrente
			println k
			String dynamicXPath = "(//td[@role='cell' and @style='min-width: 0px; max-width: 9.0072e+15px; width: 20px;']//div[@title='Toggle Row Expanded'])[" + (k + 1) + "]"
			                        
			TestObject dynamicButton = new TestObject()
			dynamicButton.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)
			//WebUI.scrollToPosition(9999999, 9999999)
			WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)

			// Controlla se NON siamo all'ultima riga della tabella
				if (k < rows1.size() - 1) { // Se non è l'ultima riga
					WebUI.click(dynamicButton)
					data_creazione = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/data di creazione'))
					
						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						//Controlla che data_creazione sia nel range
						if (!data_creazione) {
							WebUI.comment("data_creazione è vuota o null!")
							WebUI.verifyEqual(false, true) // Fai fallire il test
						}
										
						// Parsea la data di creazione nel formato "dd/MM/yyyy"
						LocalDate dataCreazioneDate2 = LocalDate.parse(data_creazione, formatter1)
						
						// Converte firstDayStr e lastDayStr da String a LocalDate per il confronto
						LocalDate firstDayDate2 = LocalDate.parse(firstDayStr, formatter1)  // prima data dell'intervallo selezionato nel calendar
						LocalDate lastDayDate2 = LocalDate.parse(lastDayStr, formatter1)    // ultima  data (data odierna) dell'intervallo selezionato nel calendar
						
						
								// Controlla se la dataCreazioneDate è nel range tra firstDayDate e lastDayDate
								if (dataCreazioneDate2.isBefore(firstDayDate2) || dataCreazioneDate2.isAfter(lastDayDate2)) {
								    WebUI.comment("data_creazione ${data_creazione} NON è nel range tra ${firstDayStr} e ${lastDayStr}")
								    WebUI.verifyEqual(false, true) // Fai fallire il test
								} else {
								    WebUI.comment("data_creazione ${data_creazione} è nel range tra ${firstDayStr} e ${lastDayStr}")
								}
								///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}
		}
	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////77

	TestObject nextButton1 = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 11- Filtri - corretto filtraggio per Data scadenza/Page_PlickUp-Admin/svg')

	// Recupera il valore dell'attributo 'disabled'
String disabledAttribute = WebUI.getAttribute(nextButton1, 'disabled')
println disabledAttribute


// Verifica se l'attributo 'disabled' è null o una stringa vuota
if (disabledAttribute == null) {
	println("L'attributo 'disabled' non è presente. Il pulsante è abilitato.")
} else if (disabledAttribute.equals("true") || disabledAttribute.isEmpty()) {
	println("Il pulsante è disabilitato (l'attributo 'disabled' è presente o vuoto).")
	break
} else {
	println("Il pulsante è abilitato.")
}

WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 11- Filtri - corretto filtraggio per Data scadenza/Page_PlickUp-Admin/svg'))
WebUI.delay(1)
}
println("Navigazione completata.")
//
WebUI.closeBrowser()
}