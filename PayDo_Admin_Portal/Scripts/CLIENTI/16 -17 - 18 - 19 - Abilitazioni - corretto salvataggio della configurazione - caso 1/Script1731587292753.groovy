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
WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/svg_Elementi per pagina_w-5 h-5 text-white'))
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/colore_tema'))
String randomNome = RandomStringUtils.randomAlphabetic(6)
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/name'), randomNome)

// Funzione per generare una partita IVA casuale
String generateRandomPartitaIVA() {
	Random random = new Random()
	String partitaIVA = ""

	// Genera le prime 10 cifre in modo casuale
	for (int i = 0; i < 10; i++) {
		partitaIVA += random.nextInt(10)  // Aggiunge un numero da 0 a 9
	}
	
	// Calcola l'ultima cifra per raggiungere le 11 cifre
	partitaIVA += random.nextInt(10)

	return partitaIVA
}

// Usa la funzione per ottenere una partita IVA
String partitaIVA = generateRandomPartitaIVA()
println("Partita IVA generata: " + partitaIVA)
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/taxCode'), partitaIVA)

String randomEmail = "test" + System.currentTimeMillis() + "@example.com"
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/email'), randomEmail)


WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/input_Phone'),'3297656234')
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/website'),'www.prova.com')
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/serviceName'),'service new')
// Cancella il campo
TestObject phoneField1 = findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/phone client service')
// Clicca sul campo per attivarlo
WebUI.click(phoneField1)

// Seleziona tutto il testo nel campo (Ctrl+A)
WebUI.sendKeys(phoneField1, Keys.chord(Keys.CONTROL, 'a'))

// Cancella il testo selezionato (tasto Delete)
//for (int i = 0; i < 13; i++) {
//    WebUI.sendKeys(phoneField1, "\b") // Usa "\b" per il BACKSPACE
//}
WebUI.sendKeys(phoneField1, "\b")
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/phone client service'),'3297656333')
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button banca'))
WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button_Aggiungi'))


String pngPath = '1726582212751.PNG'
println pngPath
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/div_Aggiungi logo primario'))


Robot robot = new Robot()

// Copia il percorso del file negli appunti
StringSelection selection = new StringSelection(pngPath)
println selection
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null)

robot.delay(1000)

robot.keyPress(KeyEvent.VK_CONTROL)
robot.keyPress(KeyEvent.VK_V)
robot.keyRelease(KeyEvent.VK_V)
robot.keyRelease(KeyEvent.VK_CONTROL)
robot.delay(2000)
// Premere Enter per confermare il caricamento
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button_Aggiungi'))
WebUI.delay(2)
TestObject dynamicSpanObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Cliente aggiunto')]"
)


TestObject dynamicSpanObject1 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Entità creata con successo')]"
)
WebUI.delay(2)
String esito1 = WebUI.getText(dynamicSpanObject)
println esito1
WS.verifyMatch(esito1, "Cliente aggiunto", true)

String esito = WebUI.getText(dynamicSpanObject1)
println esito
WS.verifyMatch(esito, "Entità creata con successo.", true)
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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


WebUI.delay(7)
// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Abilitazioni'))
String nome1 = nome.toUpperCase()
String Nome_utente = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/Nome_utente'))
WebUI.verifyMatch(Nome_utente, nome1, true)
String Metodo_pagamento = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Metodi di pagamento'))
WebUI.verifyMatch(Metodo_pagamento, "METODI DI PAGAMENTO", true)
String Canali_comunicazione = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Canali di comunicazione'))
WebUI.verifyMatch(Canali_comunicazione, "CANALI DI COMUNICAZIONE", true)
String Reminder = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Reminder'))
WebUI.verifyMatch(Reminder, "REMINDER", true)
String Notifiche = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Notifiche'))
WebUI.verifyMatch(Notifiche, "NOTIFICHE", true)
String License = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_License'))
WebUI.verifyMatch(License, "LICENSE", true)
String Callback = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Callback'))
WebUI.verifyMatch(Callback, "CALLBACK", true)
String Exit_URL = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Exit Url'))
WebUI.verifyMatch(Exit_URL, "EXIT URL", true)
String Allegati = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/p_Allegati'))
WebUI.verifyMatch(Allegati, "ALLEGATI", true)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/div_Exit Url'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/Exit-url-configurazione'))
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/input_Configurazioni exit url_exitUrlTiming'), '10')
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/button_Salva-Exit URL'))
WebUI.delay(7)


WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/div_Callback AUTH'))
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/input_Callback AUTH_outcomeCallback'), 'www.prova.com')
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/button_Salva-Callback'))
WebUI.delay(7)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/div_Configurazione license'))
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/input_Secret_sftpUsername'), '127.1.1.234')
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/input_SFTP Username_sftpHash'), '127.1.1.555')
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/button_Salva-License'))
WebUI.delay(7)

WebUI.executeJavaScript("window.scrollTo(0, 0);", null)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Esito pagamento'))
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/REMINDER 1/div_Reminder 1'))
TestObject giorni_reminder = findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/REMINDER 1/input_Reminder 1_reminder1')
WebUI.click(giorni_reminder)
WebUI.sendKeys(giorni_reminder, '10')
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/REMINDER 1/button_Salva_reminder'))
WebUI.delay(6)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Whatsapp'))
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Axerve'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/svg__inline-block cursor-pointer'))
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Configurazioni integrazione Axerve_axerveShopLogin'), 'www.shop.com')
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve Shop Login_axerveApiKey'), '1232414')
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve ApiKey_axerveApiUrl'), 'www.axerve.it')
WebUI.setText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve ApiUrl_axerveLightboxJsUrl'), 'www.axerve-light.com')
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/button_Salva_Axerve_configuration'))
WebUI.delay(7)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/button_Salva configurazione'))
WebUI.delay(5)

TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Configurazione aggiornata')]"
)


TestObject dynamicSpanObject3 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito2 = WebUI.getText(dynamicSpanObject2)
println esito2
WS.verifyMatch(esito2, "Configurazione aggiornata", true)

String esito3 = WebUI.getText(dynamicSpanObject3)
println esito3
WS.verifyMatch(esito3, "Operazione eseguita con successo", true)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/a_Clients'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Abilitazioni'))
String nome2 = nome.toUpperCase()
String Nome_utente1 = WebUI.getText(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/Nome_utente'))
WebUI.verifyMatch(Nome_utente1, nome2, true)

//apro le singole sezioni e verifico il mantenimento dei dati

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/div_Axerve'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/svg__inline-block cursor-pointer'))
String axerve_shop = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Configurazioni integrazione Axerve_axerveShopLogin'), 'value')
String axerve_key = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve Shop Login_axerveApiKey'), 'value')
String axerve_apiurl = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve ApiKey_axerveApiUrl'), 'value')
String axerve_lightbox = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/AXERVE/input_Axerve ApiUrl_axerveLightboxJsUrl'), 'value')
println axerve_shop
println axerve_key
println axerve_apiurl
println axerve_lightbox

WebUI.verifyMatch(axerve_shop, "www.shop.com", true)
WebUI.verifyMatch(axerve_key, "1232414", true)
WebUI.verifyMatch(axerve_apiurl, "www.axerve.it", true)
WebUI.verifyMatch(axerve_lightbox, "www.axerve-light.com", true)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/X CHIUSURA CONFIGURAZIONI/X_chiudi Configurazioni axerve'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/REMINDER 1/div_Reminder 1'))
String giorni_reminder1 = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/REMINDER 1/input_Reminder 1_reminder1'),'value')
println giorni_reminder1
WebUI.verifyMatch(giorni_reminder1, "10", true)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/X CHIUSURA CONFIGURAZIONI/X_chiudi Configurazioni reminder'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/div_Configurazione license'))
String Username = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/input_Secret_sftpUsername'), 'value')
String Hash = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CONFIGURAZIONI LICENSE/input_SFTP Username_sftpHash'), 'value')
println Username
println Hash
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/X CHIUSURA CONFIGURAZIONI/X_chiudi Configurazioni license'))
WebUI.verifyMatch(Username, "127.1.1.234", true)
WebUI.verifyMatch(Hash, "127.1.1.555", true)
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/div_Callback AUTH'))
String Callback_url = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/input_Callback AUTH_outcomeCallback'), 'value')
println Callback_url
WebUI.verifyMatch(Callback_url, "www.prova.com", true)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/X CHIUSURA CONFIGURAZIONI/X_chiudi Configurazioni callback'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/div_Exit Url'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/Exit-url-configurazione'))
String Tempo_redirect = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/EXIT URL/input_Configurazioni exit url_exitUrlTiming'),'value')
println Tempo_redirect
WebUI.verifyMatch(Tempo_redirect, "10", true)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/X CHIUSURA CONFIGURAZIONI/X_chiudi Configurazioni exit url'))
WebUI.delay(2)


//Disattivo la callback
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/div_Callback AUTH'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/X disattivazione callback'))
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/CALLBACK/button_Salva-Callback'))

TestObject dynamicSpanObject4 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Configurazione aggiornata')]"
)


TestObject dynamicSpanObject5 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito4 = WebUI.getText(dynamicSpanObject4)
println esito4
WS.verifyMatch(esito4, "Configurazione aggiornata", true)

String esito5 = WebUI.getText(dynamicSpanObject5)
println esito5
WS.verifyMatch(esito5, "Operazione eseguita con successo", true)

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/16 - 17 - 18 - 19 - Abilitazioni - corretto salvataggio della configurazione - caso 1/Button Clients'))

//////ELIMINAZIONE CLIENTE INSERITO//////////////////////
// Trova l'elemento della tabella
WebElement table3 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows3 = table3.findElements(By.tagName('tr'))

println rows3

int z = 1

WebElement row3 = rows3.get(z)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns3 = row3.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome3 = columns3.get(0).getText()
String cognome3 = columns3.get(1).getText()


// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome3)
println("Cognome: " + cognome3)

WebUI.delay(6)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/div_Elimina'))

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_SI'))

TestObject dynamicSpanObject7 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente eliminato')]"
)


TestObject dynamicSpanObject8 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito7 = WebUI.getText(dynamicSpanObject7)
println esito7
WS.verifyMatch(esito7, "Utente eliminato", true)

String esito8 = WebUI.getText(dynamicSpanObject8)
println esito8
WS.verifyMatch(esito8, "Operazione eseguita con successo", true)
WebUI.delay(6)
WebUI.closeBrowser()