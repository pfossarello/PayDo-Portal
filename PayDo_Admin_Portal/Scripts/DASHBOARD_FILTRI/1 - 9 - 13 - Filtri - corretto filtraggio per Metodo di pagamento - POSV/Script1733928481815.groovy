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



//filtro per metodo di pagamento PISP
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/FILTRI APPOGGIO/Page_PlickUp-Admin/Metodo di pagamento'))
WebUI.click(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 13 - Filtri - corretto filtraggio per Metodo di pagamento - POSV/span_Created_1'))
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

String Metodo_pagamento = ""
// Naviga tra le pagine finché il pulsante "Avanti" è abilitato
while (true) {
	
	// Scrolla fino in fondo alla pagina in incrementi
	for (int w = 0; w < 2; w++) {
		WebUI.executeJavaScript("window.scrollBy(0, 4000);", [])
		WebUI.delay(1)  // Pausa per 1 secondo tra ogni scroll
	}
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
		Metodo_pagamento = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 12 - Filtri - corretto filtraggio per Causale e Metodo di pagamento - PISP/Metodo pagamento'))
		println(Metodo_pagamento)
		WebUI.verifyMatch(Metodo_pagamento, "POSV", true)
	
	
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
			
			
			// Controlla se NON siamo all'ultima riga della tabella
				if (k < rows1.size() - 1) { // Se non è l'ultima riga
					WebUI.click(dynamicButton)
					WebUI.delay(1) // Aspetta che il dettaglio venga caricato
							Metodo_pagamento1 = WebUI.getText(findTestObject('Object Repository/DASHBOARD_FILTRI/9 - 12 - Filtri - corretto filtraggio per Causale e Metodo di pagamento - PISP/Metodo pagamento'))
							println(Metodo_pagamento1)
							WebUI.verifyMatch(Metodo_pagamento1, "POSV", true)
					WebUI.click(dynamicButton) // Chiude il dettaglio
				}
		}
	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////77
	  
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