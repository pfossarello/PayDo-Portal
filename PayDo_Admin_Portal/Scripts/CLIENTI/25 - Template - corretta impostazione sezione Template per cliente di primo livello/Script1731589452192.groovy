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
		
		
		//RETAIL
		
		String TEMPLATE_NOTIFICHE_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template notifiche retail'))
		println TEMPLATE_NOTIFICHE_RETAIL
		
		String RICHIESTA_PAGAMENTO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta pagamento_retail'))
		println RICHIESTA_PAGAMENTO_RETAIL
		String TEMPLATE_WHATSAPP_RICH_PAG_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta pagamento_retail'))
		println TEMPLATE_WHATSAPP_RICH_PAG_RETAIL
		String TEMPLATE_SMS_RICH_PAG_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta pagamento_retail'))
		println TEMPLATE_SMS_RICH_PAG_RETAIL
		String TEMPLATE_EMAIL_RICH_PAG_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta pagamento_retail'))
		println TEMPLATE_EMAIL_RICH_PAG_RETAIL
		
		String PAGAMENTO_CONFERMATO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Pagamento confermato_retail'))
		println PAGAMENTO_CONFERMATO_RETAIL
		String TEMPLATE_WHATSAPP_PAG_CONF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_pagamento_confermato_retail'))
		println TEMPLATE_WHATSAPP_PAG_CONF_RETAIL
		String TEMPLATE_SMS_PAG_CONF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_Pagamento confermato_retail'))
		println TEMPLATE_SMS_PAG_CONF_RETAIL
		String TEMPLATE_EMAIL_PAG_CONF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_Pagamento confermato_retail'))
		println TEMPLATE_EMAIL_PAG_CONF_RETAIL
		
		String PAGAMENTO_IN_CORSO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Pagamento in corso_retail'))
		println PAGAMENTO_IN_CORSO_RETAIL
		String TEMPLATE_WHATSAPP_PAG_IN_CORSO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_pagamento_in corso_retail'))
		println TEMPLATE_WHATSAPP_PAG_IN_CORSO_RETAIL
		String TEMPLATE_SMS_PAG_IN_CORSO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_Pagamento in corso_retail'))
		println TEMPLATE_SMS_PAG_IN_CORSO_RETAIL
		String TEMPLATE_EMAIL_PAG_IN_CORSO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_Pagamento in corso_retail'))
		println TEMPLATE_EMAIL_PAG_IN_CORSO_RETAIL
		
		String RICHIESTA_RIFIUTATA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta rifiutata_retail'))
		println RICHIESTA_RIFIUTATA_RETAIL
		String TEMPLATE_WHATSAPP_RICH_RIF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta rifiutata_retail'))
		println TEMPLATE_WHATSAPP_RICH_RIF_RETAIL
		String TEMPLATE_SMS_RICH_RIF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta rifiutata_retail'))
		println TEMPLATE_SMS_RICH_RIF_RETAIL
		String TEMPLATE_EMAIL_RICH_RIF_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_richiesta rifiutata_retail'))
		println TEMPLATE_EMAIL_RICH_RIF_RETAIL
		
		String RICHIESTA_AUTORIZZATA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta autorizzata_retail'))
		println RICHIESTA_AUTORIZZATA_RETAIL
		String TEMPLATE_WHATSAPP_RICH_AUT_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta autorizzata_retail'))
		println TEMPLATE_WHATSAPP_RICH_AUT_RETAIL
		String TEMPLATE_SMS_RICH_AUT_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta autorizzata_retail'))
		println TEMPLATE_SMS_RICH_AUT_RETAIL
		String TEMPLATE_EMAIL_RICH_AUT_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_richiesta autorizzata_retail'))
		println TEMPLATE_EMAIL_RICH_AUT_RETAIL
		
		String RICHIESTA_CANCELLATA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta cancellata_retail'))
		println RICHIESTA_CANCELLATA_RETAIL
		String TEMPLATE_WHATSAPP_RICH_CANC_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta cancellata_retail'))
		println TEMPLATE_WHATSAPP_RICH_CANC_RETAIL
		String TEMPLATE_SMS_RICH_CANC_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta cancellata_retail'))
		println TEMPLATE_SMS_RICH_CANC_RETAIL
		String TEMPLATE_EMAIL_RICH_CANC_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_richiesta cancellata_retail'))
		println TEMPLATE_EMAIL_RICH_CANC_RETAIL
		
		String RICHIESTA_ADDEBITATA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta addebitata_retail'))
		println RICHIESTA_ADDEBITATA_RETAIL
		String TEMPLATE_WHATSAPP_RICH_ADD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta addebitata_retail'))
		println TEMPLATE_WHATSAPP_RICH_ADD_RETAIL
		String TEMPLATE_SMS_RICH_ADD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta addebitata_retail'))
		println TEMPLATE_SMS_RICH_ADD_RETAIL
		String TEMPLATE_EMAIL_RICH_ADD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_richiesta addebitata_retail'))
		println TEMPLATE_EMAIL_RICH_ADD_RETAIL
		
		String PAGAMENTO_STORNATO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Pagamento stornato_retail'))
		println PAGAMENTO_STORNATO_RETAIL
		String TEMPLATE_WHATSAPP_PAG_STOR_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_pagamento stornato_retail'))
		println TEMPLATE_WHATSAPP_PAG_STOR_RETAIL
		String TEMPLATE_SMS_PAG_STOR_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_pagamento stornato_retail'))
		println TEMPLATE_SMS_PAG_STOR_RETAIL
		String TEMPLATE_EMAIL_PAG_STOR_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_pagamento stornato_retail'))
		println TEMPLATE_EMAIL_PAG_STOR_RETAIL
		
		String PAGAMENTO_FALLITO_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Pagamento fallito_retail'))
		println PAGAMENTO_FALLITO_RETAIL
		String TEMPLATE_WHATSAPP_PAG_FALL_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_pagamento fallito_retail'))
		println TEMPLATE_WHATSAPP_PAG_FALL_RETAIL
		String TEMPLATE_SMS_PAG_FALL_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_pagamento fallito_retail'))
		println TEMPLATE_SMS_PAG_FALL_RETAIL
		String TEMPLATE_EMAIL_PAG_FALL_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_pagamento fallito_retail'))
		println TEMPLATE_EMAIL_PAG_FALL_RETAIL
		
		String RICHIESTA_SCADUTA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta scaduta_retail'))
		println RICHIESTA_SCADUTA_RETAIL
		String TEMPLATE_WHATSAPP_RICH_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_richiesta scaduta_retail'))
		println TEMPLATE_WHATSAPP_RICH_SCAD_RETAIL
		String TEMPLATE_SMS_RICH_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_richiesta scaduta_retail'))
		println TEMPLATE_SMS_RICH_SCAD_RETAIL
		String TEMPLATE_EMAIL_RICH_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_richiesta scaduta_retail'))
		println TEMPLATE_EMAIL_RICH_SCAD_RETAIL
		
		String REMINDER_SCADENZA_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Reminder scadenza_retail'))
		println REMINDER_SCADENZA_RETAIL
		String TEMPLATE_WHATSAPP_REM_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Whatsapp_reminder scadenza-retail'))
		println TEMPLATE_WHATSAPP_REM_SCAD_RETAIL
		String TEMPLATE_SMS_REM_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template SMS_reminder scadenza-retail'))
		println TEMPLATE_SMS_REM_SCAD_RETAIL
		String TEMPLATE_EMAIL_REM_SCAD_RETAIL  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Template Email_reminder scadenza-retail'))
		println TEMPLATE_EMAIL_REM_SCAD_RETAIL
		
		
		//AGENT
		String RICHIESTA_PAGAMENTO_AGENT  =  WebUI.getText(findTestObject('Object Repository/CLIENTI/25 - corretta impostazione sezione Template per cliente di primo livello/Impostazione pagina/RETAIL/p_Richiesta pagamento_agent'))
		println RICHIESTA_PAGAMENTO_AGENT
		
		WebUI.closeBrowser()

}