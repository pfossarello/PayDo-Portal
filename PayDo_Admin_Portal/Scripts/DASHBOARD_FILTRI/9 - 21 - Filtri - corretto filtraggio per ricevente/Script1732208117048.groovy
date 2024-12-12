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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

String Ricevente = ""
String Ricevente1 = ""
String Ricevente2 = ""

		WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

		// Trova tutte le righe all'interno della tabella
		List<WebElement> rows1 = table1.findElements(By.tagName('tr'))
		println rows1

		int w = 1
		WebElement row1 = rows1.get(w)
		List<WebElement> columns1 = row1.findElements(By.tagName('td'))

			 Ricevente = columns1.get(3).getText()
			 println Ricevente
			

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Scroll fino in cima della pagina
WebUI.executeJavaScript("window.scrollTo(0, 0);", null)

////filtro per ricevente
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 26 - Filtri - corretto annullamento filtro impostato/Pulsante disabilita filtro'))
WebUI.setText(findTestObject('Object Repository/DASHBOARD_FILTRI/FILTRI APPOGGIO/Page_PlickUp-Admin/Nome cognome ricevente'),Ricevente)
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/3 - Filtri - corretta forzatura stato pratica - (da creata a pagata)/Page_PlickUp-Admin/button-filtraggio'))
// Prova a trovare l'oggetto "Nessun risultato trovato"
TestObject nessunRisultato1 = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 25.1 - Filtri - corretto filtraggio per Stato e Data di passaggio e visualizzazione del dettaglio - Autorizzata - nessun risultato/Page_PlickUp-Admin/Filtro - nessun risultato')

// Verifica se l'elemento è presente sulla pagina entro un timeout specifico (es. 5 secondi)
boolean isPresent1 = WebUI.waitForElementPresent(nessunRisultato1, 3, FailureHandling.OPTIONAL)

// Condizione: se l'elemento è visibile, termina l'esecuzione
if (!isPresent1) {
	WebUI.comment("Nessun risultato trovato: il filtro non ha restituito risultati. Fine script.")
	WebUI.closeBrowser()
	return // Termina l'esecuzione dello script
} else {
	WebUI.comment("Risultati trovati: procedo con il resto dello script.")

//WebUI.selectOptionByValue(findTestObject('Object Repository/CLIENTI/6 - navigazione tra pagine e impostazione elementi visibili per pagina/Page_PlickUp-Admin/select_5102550'),
//	'50', false)


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


// Naviga tra le pagine finché il pulsante "Avanti" è abilitato
while (true) {
	
WebElement table3 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
	List<WebElement> rows3 = table3.findElements(By.tagName('tr'))
	
	println rows3
	
	int z = 1
	
	WebElement row3 = rows3.get(z)
	
	// Trova tutte le celle (colonne) della riga corrente
	List<WebElement> columns3 = row3.findElements(By.tagName('td'))
	Ricevente2 = columns3.get(3).getText()
	
	//dal dettaglio pratica del primo record estraggo i valori sotto
	WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/4 - Filtri - corretto aggiornamento stato pratica nel dettaglio - da creata a pagata/Page_PlickUp-Admin/Apri_dettaglio'))
	Ricevente1 = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 21 - Filtri - corretto filtraggio per ricevente/Ricevente'))
	println(Ricevente1)
	
	
	
	WebUI.verifyMatch(Ricevente1, Ricevente, true)
	WebUI.verifyMatch(Ricevente2, Ricevente, true)
	
	// Itera su ogni riga della tabella
	for (int m = 0; m < rows3.size(); m++) {
		WebElement table4 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
		List<WebElement> rows4 = table4.findElements(By.tagName('tr'))
		WebElement row4 = rows4.get(m)
	
		// Trova tutte le celle (colonne) della riga corrente
		List<WebElement> columns4= row4.findElements(By.tagName('td'))
		
		// Controlla se ci sono abbastanza colonne per evitare errori
		if (columns4.size() > 1) {
			// Costruisci XPath dinamico per il pulsante della riga corrente
			String dynamicXPath = "(//td[@role='cell' and @style='min-width: 0px; max-width: 9.0072e+15px; width: 20px;']//div[@title='Toggle Row Expanded'])[" + (m + 1) + "]"
			TestObject dynamicButton = new TestObject()
			dynamicButton.addProperty("xpath", ConditionType.EQUALS, dynamicXPath)
			
			// Controlla se NON siamo all'ultima riga della tabella
				if (m < rows4.size() - 1) { // Se non è l'ultima riga
					Ricevente2 = columns4.get(3).getText()
					WebUI.click(dynamicButton)
					WebUI.delay(1) // Aspetta che il dettaglio venga caricato
					Ricevente = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 21 - Filtri - corretto filtraggio per ricevente/Ricevente'))
					println(Ricevente)
					WebUI.verifyMatch(Ricevente, Ricevente1, true)
					WebUI.verifyMatch(Ricevente2, Ricevente, true)
					WebUI.click(dynamicButton) // Chiude il dettaglio
				}
		}
	
	}
	  
	// Rilocazione del pulsante "next" dopo aver iterato sulle righe
	nextButton1 = findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 11- Filtri - corretto filtraggio per Data scadenza/Page_PlickUp-Admin/svg')
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

WebUI.closeBrowser()
}