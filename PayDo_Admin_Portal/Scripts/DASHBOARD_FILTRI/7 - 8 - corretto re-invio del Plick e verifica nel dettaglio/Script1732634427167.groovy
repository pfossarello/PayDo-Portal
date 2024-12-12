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

WebUI.callTestCase(findTestCase('Test Cases/PLICKUP/creo e Invio RTP - test ID 2 di createRTP'), [:], FailureHandling.STOP_ON_FAILURE)


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
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/5 - Filtri - corretta forzatura stato pratica - (da inviata a pagata)/span_Inviata'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))

TestObject nessunRisultato = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 25.1 - Filtri - corretto filtraggio per Stato e Data di passaggio e visualizzazione del dettaglio - Autorizzata - nessun risultato/Page_PlickUp-Admin/Filtro - nessun risultato')

String Ricevente = ""
String Importo = ""
// Verifica se l'elemento è presente sulla pagina entro un timeout specifico
boolean isPresent = WebUI.waitForElementPresent(nessunRisultato, 3, FailureHandling.OPTIONAL)

if (!isPresent) {
	WebUI.comment("Nessun risultato trovato: il filtro non ha restituito risultati. Fine script.")
	WebUI.closeBrowser()
	return
} else {
	WebUI.comment("Risultati trovati: procedo con il resto dello script.")

//	// XPath per il pulsante "Avanti"
//	TestObject nextButton = new TestObject().addProperty(
//		"xpath",
//		ConditionType.EQUALS,
//		"//button[contains(@class, 'inline-flex') and contains(@class, 'pl-2') and not(@disabled)]"
//	)
//
//	// XPath per il pulsante "Avanti" disabilitato
//	TestObject nextButtonDisabled = new TestObject().addProperty(
//		"xpath",
//		ConditionType.EQUALS,
//		"//button[contains(@class, 'inline-flex') and contains(@class, 'pl-2') and @disabled]"
//	)
//
//	// Variabile di controllo per uscire dal ciclo while
//	boolean stopNavigation = false
//
//	while (!stopNavigation) {
		WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

		// Trova tutte le righe all'interno della tabella
		List<WebElement> rows1 = table1.findElements(By.tagName('tr'))
		println rows1

		int w = 1
		WebElement row1 = rows1.get(w)
		List<WebElement> columns1 = row1.findElements(By.tagName('td'))

//		// Azione sulla prima riga
//		WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
//		TestObject nessunDettaglio = findTestObject('Object Repository/DASHBOARD_FILTRI/appoggio/Page_PlickUp-Admin/Dettaglio non accessibile')
//
//		boolean isDetailMissing = WebUI.waitForElementPresent(nessunDettaglio, 3, FailureHandling.OPTIONAL)
//		if (isDetailMissing) {
//			WebUI.comment("Nessun dettaglio")
//			WebUI.delay(2)
//			
//		} else {
			 Importo = columns1.get(2).getText()
			println Importo
			 Ricevente = columns1.get(3).getText()
			println Ricevente
			
			// Se il dettaglio è disponibile, esegui l'azione di reinvio
			WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/7 - Filtri - corretto re-invio Plickup/span_re invio'))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_SI'))
//			stopNavigation = true
			WebUI.delay(6)
//		}

//		if (stopNavigation) {
//			break
//		}

		// Itera su ogni riga della tabella
//		for (int k = 1; k < rows1.size(); k++) {
//			println rows1.size()
//			WebElement table2 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
//			List<WebElement> rows2 = table2.findElements(By.tagName('tr'))
//			println k
//
//			WebElement row2 = rows2.get(k)
//			List<WebElement> columns2 = row2.findElements(By.tagName('td'))
//
//			if (columns2.size() > 4) {
//				String dynamicXPath = "(//td[@role='cell' and @style='min-width: 0px; max-width: 9.0072e+15px; width: 20px;']//div[@title='Toggle Row Expanded'])[" + (k + 1) + "]"
//				TestObject dynamicButton = new TestObject()
//				dynamicButton.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)
//
//				WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);", null)
//
//				if (k < rows2.size() - 1) {
//					WebUI.click(dynamicButton)
//					TestObject nessunDettaglio1 = findTestObject('Object Repository/DASHBOARD_FILTRI/appoggio/Page_PlickUp-Admin/Dettaglio non accessibile')
//					
//					boolean isDetailMissing1 = WebUI.waitForElementPresent(nessunDettaglio1, 3, FailureHandling.OPTIONAL)
//					if (isDetailMissing1) {
//						WebUI.comment("Nessun dettaglio")
//						WebUI.delay(6)
//						
//					} else {
//						 Importo = columns2.get(2).getText()
//						 println Importo
//						 Ricevente = columns2.get(3).getText()
//						println Ricevente
//						WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/7 - Filtri - corretto re-invio Plickup/span_re invio'))
//						WebUI.delay(1)
//						WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button_SI'))
//						stopNavigation = true
//						WebUI.delay(6)
//						break
//					}
//				}
//			}
//		
//
//		if (stopNavigation) {
//			break
//		}
//
//		TestObject nextButton1 = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 11- Filtri - corretto filtraggio per Data scadenza/Page_PlickUp-Admin/svg')
//		String disabledAttribute = WebUI.getAttribute(nextButton1, 'disabled')
//		println disabledAttribute
//
//		if (disabledAttribute == null) {
//			println("L'attributo 'disabled' non è presente. Il pulsante è abilitato.")
//		} else if (disabledAttribute.equals("true") || disabledAttribute.isEmpty()) {
//			println("Il pulsante è disabilitato (l'attributo 'disabled' è presente o vuoto).")
//			break
//		} else {
//			println("Il pulsante è abilitato.")
//		}
//
//		WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 11- Filtri - corretto filtraggio per Data scadenza/Page_PlickUp-Admin/svg'))
//		WebUI.delay(1)
//	}
//
//	println("Navigazione completata e re-invio avvenuto.")
//}

			
// Scroll fino in cima della pagina
WebUI.executeJavaScript("window.scrollTo(0, 0);", null)

WebUI.setText(findTestObject('Object Repository/DASHBOARD_FILTRI/FILTRI APPOGGIO/Page_PlickUp-Admin/Nome cognome ricevente'),Ricevente)
WebUI.setText(findTestObject('Object Repository/DASHBOARD_FILTRI/7 - 8 - corretto re-invio del Plick e verifica nel dettaglio/Page_PlickUp-Admin/Importo1'),Importo)
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/Dropdown_stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 13 - Filtri - corretto filtraggio per Metodo di pagamento - POSV/span_Created_1'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))
//WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/7 - 8 - corretto re-invio del Plick e verifica nel dettaglio/Page_PlickUp-Admin/Ordinamento Ultimo stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/7 - 8 - corretto re-invio del Plick e verifica nel dettaglio/Page_PlickUp-Admin/Ordinamento Ultimo stato'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
data_invio = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/6 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da inviata a pagata/data cambio stato in inviata'))
println data_invio

// Ottieni la data odierna
Date oggi = new Date()
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
String data_odierna = sdf.format(oggi)

WebUI.verifyMatch(data_invio, data_odierna, false)

WebUI.closeBrowser()
}