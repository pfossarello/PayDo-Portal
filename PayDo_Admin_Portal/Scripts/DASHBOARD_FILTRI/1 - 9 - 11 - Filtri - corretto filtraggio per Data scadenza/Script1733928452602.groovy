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

	
			// Apri il calendario
			WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/FILTRI APPOGGIO/Page_PlickUp-Admin/Data scadenza'))
			
			// Calcola il primo giorno del mese corrente e l'ultimo giorno dell'anno
			LocalDate firstDayOfCurrentMonth = LocalDate.now().withDayOfMonth(1)
			LocalDate lastDayOfYear = LocalDate.now().withDayOfYear(LocalDate.now().lengthOfYear())
			
			// Formatta le date in modo leggibile dal calendario
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern('d') // Giorno senza zeri iniziali
			String firstDay = firstDayOfCurrentMonth.format(formatter)
			String lastDay = lastDayOfYear.format(formatter)
			
			// Vai al mese corrente
			TestObject calendarPrevButton = new TestObject().addProperty(
				"xpath", ConditionType.EQUALS, "//button[contains(@class, 'react-datepicker__navigation--previous')]"
			)
			TestObject calendarNextButton = new TestObject().addProperty(
				"xpath", ConditionType.EQUALS, "//button[contains(@class, 'react-datepicker__navigation--next')]"
			)
			
			// Naviga al primo mese dell'intervallo, se necessario
			LocalDate currentCalendarMonth = firstDayOfCurrentMonth
			while (currentCalendarMonth.isBefore(firstDayOfCurrentMonth)) {
				WebUI.click(calendarPrevButton)
				currentCalendarMonth = currentCalendarMonth.minusMonths(1)
			}
			
			// Seleziona il primo giorno del mese corrente
			TestObject firstDayObject = new TestObject().addProperty(
				"xpath", ConditionType.EQUALS,
				"//div[contains(@class, 'react-datepicker__day') and text()='" + firstDay + "']"
			)
			WebUI.click(firstDayObject)
			
			// Naviga al mese di dicembre, se necessario
			while (currentCalendarMonth.isBefore(lastDayOfYear.withDayOfMonth(1))) {
				WebUI.click(calendarNextButton)
				currentCalendarMonth = currentCalendarMonth.plusMonths(1)
			}
			
			// Seleziona l'ultimo giorno dell'anno
			TestObject lastDayObject = new TestObject().addProperty(
				"xpath", ConditionType.EQUALS,
				"//div[contains(@class, 'react-datepicker__day') and text()='" + lastDay + "']"
			)
			WebUI.click(lastDayObject)
			
			// Chiudi il calendario cliccando fuori
			TestObject bodyObject = new TestObject().addProperty(
				"xpath",
				ConditionType.EQUALS,
				"//body"
			)
			
			WebUI.click(bodyObject)
			
			
			WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))
			
				WebUI.comment("Risultati trovati: procedo con il resto dello script.")

			// Calcolare il primo giorno del mese corrente
			Calendar calendar = Calendar.getInstance()
			calendar.set(Calendar.DAY_OF_MONTH, 1) // Imposta al primo giorno del mese
			Date primoGiornoMese = calendar.getTime()
			
			// Calcolare l'ultimo giorno dell'anno corrente
			calendar.set(Calendar.MONTH, Calendar.DECEMBER) // Imposta a dicembre
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) // Imposta all'ultimo giorno del mese
			Date ultimoGiornoAnno = calendar.getTime()
			
			
			// Formatta le date limite
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
			println "Primo giorno del mese: " + sdf.format(primoGiornoMese)
			println "Ultimo giorno dell'anno: " + sdf.format(ultimoGiornoAnno)

				// esploro la tabella di ogni pagina e per ogni riga recupero data di scadenza
				WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
				
				// Trova tutte le righe all'interno della tabella
				List<WebElement> rows1 = table1.findElements(By.tagName('tr'))
				
				// Stampa il numero di righe trovate
				println "Numero di righe nella tabella: ${rows1.size()}"
				
				// Itera su ogni riga della tabella
				for (int k = 0; k < rows1.size(); k++) {
					WebElement row1 = rows1.get(k)
				
					// Trova tutte le celle (colonne) della riga corrente
					List<WebElement> columns1 = row1.findElements(By.tagName('td'))
				
					// Controlla se ci sono abbastanza colonne per evitare errori
					if (columns1.size() > 1) {
						// Estrai i valori delle prime due colonne
						String dataScadenza = columns1.get(6).getText()
						println dataScadenza
						
						// Converte la stringa dataScadenza in un oggetto Date (modifica il formato se necessario)
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
						Date dataScadenzaDate = dateFormat.parse(dataScadenza)
						
						
						// Verifica se la data è compresa tra il primo giorno del mese e l'ultimo giorno dell'anno
						if (dataScadenzaDate.before(primoGiornoMese) || dataScadenzaDate.after(ultimoGiornoAnno)) {
							// Se la data non è compresa nell'intervallo, fai fallire il test
							WebUI.verifyMatch("Data Scadenza fuori intervallo", "Data non valida", false) // Fai un errore con un messaggio personalizzato
							break // Fermati se trovi un errore
						}
					}
			}	


WebUI.closeBrowser()
	

}			