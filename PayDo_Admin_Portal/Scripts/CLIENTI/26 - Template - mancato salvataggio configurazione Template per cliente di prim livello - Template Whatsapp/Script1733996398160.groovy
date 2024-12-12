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
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/hamburger menu'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/p_Clienti'))

// Prova a trovare l'oggetto "Nessun risultato trovato"
TestObject nessunRisultato = findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/Nessun risultato ricerca')

// Verifica se l'elemento è presente sulla pagina entro un timeout specifico (es. 5 secondi)
boolean isPresent = WebUI.waitForElementPresent(nessunRisultato, 3, FailureHandling.OPTIONAL)

// Condizione: se l'elemento è visibile, termina l'esecuzione
if (isPresent) {
	WebUI.comment("Nessun risultato trovato: il filtro non ha restituito risultati. Fine script.")
	WebUI.closeBrowser()
	return // Termina l'esecuzione dello script
} else {
	

			// Trova l'elemento della tabella
			WebElement table = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))
			
			// Trova tutte le righe all'interno della tabella
			List<WebElement> rows = table.findElements(By.tagName('tr'))
			
			println rows
			
			int k = 1
			
			WebElement row = rows.get(k)
			
			// Trova tutte le celle (colonne) della riga corrente
			List<WebElement> columns = row.findElements(By.tagName('td'))
			
			// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
			String nome = columns.get(0).getText()
			
			
			WebUI.click(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/div_Template'))
			
			
			//RETAIL - apertura template whatsapp Richiesta di pagamento
			
			WebUI.click(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/div_Aggiungi template'))
			WebUI.setText(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/input_Canale_description'), 'Invio a retail')
			WebUI.setText(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/input_Lingua_sender'), 'Retail')
			WebUI.setText(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/input_Sender_subject'), 'Invio richiesta')
			WebUI.click(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/button_Salva template'))
			String Messaggio_errore = WebUI.getText(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/p_Il campo  obbligatorio'))
			println Messaggio_errore
			WebUI.verifyMatch(Messaggio_errore, "Il campo è obbligatorio", true)
			WebUI.delay(4)
			WebUI.closeBrowser()
}