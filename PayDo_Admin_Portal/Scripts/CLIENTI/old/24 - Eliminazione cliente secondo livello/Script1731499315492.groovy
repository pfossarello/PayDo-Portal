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

WebUI.callTestCase(findTestCase('Test Cases/CLIENTI/1 - 8 - 11 - Aggiunta ed eliminazione nuovo cliente primo livello Banca'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.delay(6)
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
String nome = columns.get(0).getText()


// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome)


//AGGIUNTA CLIENTE 2° LIVELLO 
WebUI.click(findTestObject('Object Repository/CLIENTI/12 - Aggiunta nuovo cliente secondo livello Banca/div_Aggiungi 2 livello'))


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
println randomEmail
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

WebUI.click(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/div_Clienti 2 livello'))
//// Trova l'elemento della tabella
WebElement table2 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/Page_PlickUp-Admin/Table secondo livello'))
//
//// Scorri fino a che `table2` non è visibile
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(table2))
//
//// Trova tutte le righe all'interno della tabella
List<WebElement> rows2 = table2.findElements(By.tagName('tr'))

println rows2

int j = 1

WebElement row2 = rows2.get(j)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns2 = row2.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome2 = columns2.get(0).getText()

if (nome2.equals(randomNome)) {
	
	
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/CLIENTI/24 - Eliminazione cliente secondo livello/Page_PlickUp-Admin/div_Elimina'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_NO'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/CLIENTI/24 - Eliminazione cliente secondo livello/Page_PlickUp-Admin/div_Elimina'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_SI'))
	
	
TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente eliminato')]"
)


TestObject dynamicSpanObject3 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito2 = WebUI.getText(dynamicSpanObject2)
println esito2
WS.verifyMatch(esito2, "Utente eliminato", true)

String esito3 = WebUI.getText(dynamicSpanObject3)
println esito3
WS.verifyMatch(esito3, "Operazione eseguita con successo", true)
	        }

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/Page_PlickUp-Admin/Chiudi tabella secondo livello_1'))

WebUI.closeBrowser()

























