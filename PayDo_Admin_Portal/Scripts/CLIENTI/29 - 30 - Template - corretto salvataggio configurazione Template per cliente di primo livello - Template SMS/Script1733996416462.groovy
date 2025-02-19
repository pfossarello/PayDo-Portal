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

// Premere Enter per confermare il caricamento
robot.keyPress(KeyEvent.VK_ENTER)
robot.keyRelease(KeyEvent.VK_ENTER)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button_Aggiungi'))

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

String esito1 = WebUI.getText(dynamicSpanObject)
println esito1
WS.verifyMatch(esito1, "Cliente aggiunto", true)

String esito = WebUI.getText(dynamicSpanObject1)
println esito
WS.verifyMatch(esito, "Entità creata con successo.", true)

WebUI.delay(6)

///////////CONFIGURAZIONE TEMPLATE/////////////////
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

WebUI.click(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/div_Aggiungi template_SMS'))
WebUI.setText(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/input_Canale_description_SMS'), 'Invio a retail')
WebUI.setText(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/input_Lingua_sender'), 'Invio a Retail')
WebUI.setText(findTestObject('Object Repository/CLIENTI/27 - corretto salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/div__cm-activeLine cm-line'),
	'{\n' +
	'\t"name": "${name_retail_template}",\n' +
	'\t"channel": "${channel_retail_template}",\n' +
	'\t"recipient": "${recipient_retail_template}"' 
)
WebUI.click(findTestObject('Object Repository/CLIENTI/26 - mancato salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/button_Salva template'))

TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Template aggiunto')]"
)


TestObject dynamicSpanObject3 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito2 = WebUI.getText(dynamicSpanObject2)
println esito2
WS.verifyMatch(esito2, "Template aggiunto", true)

String esito3 = WebUI.getText(dynamicSpanObject3)
println esito3
WS.verifyMatch(esito3, "Operazione eseguita con successo", true)


TestObject slider = new TestObject("slider")
slider.addProperty("xpath", ConditionType.EQUALS, "//div[contains(@class, 'md:w-1/2') and contains(@class, 'w-full') and contains(@class, 'flex') and contains(@class, 'flex-col') and contains(@class, 'font-skin-base')][./p[text()='Template notifiche retail']]//div[contains(@class, 'rounded-md') and contains(@class, 'p-4')][./p[text()='Richiesta pagamento']]//div[contains(@class, 'space-y-2') and contains(@class, 'w-full')]/div[contains(@class, 'flex') and contains(@class, 'justify-between') and contains(@class, 'items-center')][./p[text()='Template SMS']]//div/button[contains(@class, 'bg-skin-fillTo') and contains(@class, 'inline-flex') and @role='switch']")

// Ottieni il valore dell'attributo aria-checked
String isChecked = WebUI.getAttribute(slider, "aria-checked")

// Verifica se lo slider è attivo o meno
if (isChecked == "true") {
	println("Lo slider è attivo.")
} else {
	println("Lo slider non è attivo.")
}

WebUI.verifyMatch(isChecked, "true", true)
WebUI.delay(6)

//Verifico la configurazione salvata
WebUI.click(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/div_Modifica template_SMS'))
String Descrizione = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/input_Canale_description_SMS'), 'value')
String Sender = WebUI.getAttribute(findTestObject('Object Repository/CLIENTI/29 - 30 - Template - corretto salvataggio configurazione Template per cliente di primo livello - Template SMS/input_Lingua_sender'), 'value')

// Trova l'elemento con il testo JSON completo
TestObject divElement = findTestObject('Object Repository/CLIENTI/28 - verifica corretta configurazione Template per cliente di primo livello - Template Whatsapp/div_recupera template')

// Recupera tutto il testo, includendo più tag di testo
String template = WebUI.getText(divElement).replaceAll("\n", " ").trim()

// Stampa il testo per verifica
println("Il testo completo del template è: \n" + template)
String template_recuperato = WebUI.getText(divElement).replaceAll("\\s+", "").trim()
println template_recuperato

WebUI.verifyMatch(Descrizione, "Invio a retail", true)
WebUI.verifyMatch(Sender, "Invio a Retail", true)


String jsonTemplate = '{"name":"${name_retail_template}","channel":"${channel_retail_template}","recipient":"${recipient_retail_template}"}'
println jsonTemplate
WebUI.verifyMatch(template_recuperato, jsonTemplate, false)

///////////ELIMINO IL CLIENTE INSERITO///////////////////////////
WebUI.click(findTestObject('Object Repository/CLIENTI/27 - corretto salvataggio configurazione Template per cliente di primo livello - Template Whatsapp/Page_PlickUp-Admin/Return Clients'))


// Trova l'elemento della tabella
WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows1 = table1.findElements(By.tagName('tr'))

println rows1

int j = 1

WebElement row1 = rows1.get(j)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns1 = row1.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome1 = columns1.get(0).getText()
String cognome1 = columns1.get(1).getText()


// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome1)
println("Cognome: " + cognome1)

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/div_Elimina'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_SI'))

TestObject dynamicSpanObject4 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente eliminato')]"
)


TestObject dynamicSpanObject5 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito4 = WebUI.getText(dynamicSpanObject4)
println esito4
WS.verifyMatch(esito4, "Utente eliminato", true)

String esito5 = WebUI.getText(dynamicSpanObject5)
println esito5
WS.verifyMatch(esito5, "Operazione eseguita con successo", true)
WebUI.delay(6)
WebUI.closeBrowser()
