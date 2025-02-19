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

//AGGIUNTA CLIENTE PRIMO LIVELLO BANCA//////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////AGGIUNTA CLIENTE SECONDO LIVELLO BANCA////////////////////////////////////////
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



// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome)


WebUI.click(findTestObject('Object Repository/CLIENTI/12 - Aggiunta nuovo cliente secondo livello Banca/div_Aggiungi 2 livello'))


WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/colore_tema'))
String randomNome1 = RandomStringUtils.randomAlphabetic(6)
println randomNome1
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/name'), randomNome1)

// Funzione per generare una partita IVA casuale
String generateRandomPartitaIVA1() {
	Random random = new Random()
	String partitaIVA = ""

	// Genera le prime 10 cifre in modo casuale
	for (int z = 0; z < 10; z++) {
		partitaIVA += random.nextInt(10)  // Aggiunge un numero da 0 a 9
	}
	
	// Calcola l'ultima cifra per raggiungere le 11 cifre
	partitaIVA += random.nextInt(10)

	return partitaIVA
}

// Usa la funzione per ottenere una partita IVA
String partitaIVA1 = generateRandomPartitaIVA1()
println("Partita IVA generata: " + partitaIVA1)
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/taxCode'), partitaIVA1)

String randomEmail1 = "test" + System.currentTimeMillis() + "@example.com"
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/email'), randomEmail1)


WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/input_Phone'),'3297656234')
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/website'),'www.prova.com')
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/serviceName'),'service new')
// Cancella il campo
TestObject phoneField2 = findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/phone client service')
// Clicca sul campo per attivarlo
WebUI.click(phoneField2)

// Seleziona tutto il testo nel campo (Ctrl+A)
WebUI.sendKeys(phoneField2, Keys.chord(Keys.CONTROL, 'a'))

// Cancella il testo selezionato (tasto Delete)
//for (int i = 0; i < 13; i++) {
//    WebUI.sendKeys(phoneField1, "\b") // Usa "\b" per il BACKSPACE
//}
WebUI.sendKeys(phoneField2, "\b")
WebUI.setText(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/phone client service'),'3297656333')
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button corporate'))
WebUI.delay(2)

String pngPath1 = '1726582212751.PNG'
println pngPath1
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/div_Aggiungi logo primario'))


Robot robot1 = new Robot()

// Copia il percorso del file negli appunti
StringSelection selection1 = new StringSelection(pngPath1)
println selection1
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null)

robot1.delay(1000)

robot1.keyPress(KeyEvent.VK_CONTROL)
robot1.keyPress(KeyEvent.VK_V)
robot1.keyRelease(KeyEvent.VK_V)
robot1.keyRelease(KeyEvent.VK_CONTROL)

// Premere Enter per confermare il caricamento
robot1.keyPress(KeyEvent.VK_ENTER)
robot1.keyRelease(KeyEvent.VK_ENTER)

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/8 - Aggiunta nuovo cliente primo livello Banca/Page_PlickUp-Admin/button_Aggiungi'))

TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Cliente aggiunto')]"
)


TestObject dynamicSpanObject3 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Entità creata con successo')]"
)

String esito2 = WebUI.getText(dynamicSpanObject2)
println esito2
WS.verifyMatch(esito2, "Cliente aggiunto", true)

String esito3 = WebUI.getText(dynamicSpanObject3)
println esito3
WS.verifyMatch(esito3, "Entità creata con successo.", true)

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Trova l'elemento della tabella
WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows1 = table1.findElements(By.tagName('tr'))

println rows1

int v = 1

WebElement row1 = rows1.get(v)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns1 = row1.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome1 = columns1.get(0).getText()
String cognome1 = columns1.get(1).getText()
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
WebUI.delay(6)
WebUI.click(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/div_Clienti 2 livello'))

//// Dichiarazione delle variabili prima del ciclo for
//String nome2 = ""
//String Partita_iva = ""
//String Email = ""
//String Cliente_primo_livello = ""
//
//// Trova l'elemento della tabella
WebElement table2 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/Page_PlickUp-Admin/Table secondo livello'))
//
//// Scorri fino a che `table2` non è visibile
WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(table2))
//
//// Trova tutte le righe all'interno della tabella
List<WebElement> rows2 = table2.findElements(By.tagName('tr'))
//
//
//// Scorri tutte le righe della tabella
//for (int i = 0; i < rows2.size(); i++) {
//    WebElement row2 = rows2.get(i)
//
//    // Trova tutte le celle (colonne) della riga corrente
//    List<WebElement> columns2 = row2.findElements(By.tagName('td'))
//    println columns2
//    // Assicurati che la riga abbia almeno 6 celle (dato che stai cercando di accedere all’indice 5)
//    if (columns2.size() >= 5) {
//         nome2 = columns2.get(0).getText()
//
//        // Controllo per verificare se nome2 è uguale a randomNome
//        if (nome2.equals(randomNome)) {
//            println("Stringa trovata in riga " + (i + 1) + ". Uscita dal ciclo.")
//			 Partita_iva = columns2.get(1).getText()
//			 Email = columns2.get(2).getText()
//			 Cliente_primo_livello = columns2.get(5).getText()
//            break // Esce dal ciclo se nome2 corrisponde a randomNome
//        }
//
//
//
//        // Stampa i valori delle celle per la riga corrente
//        println("Riga " + (i + 1) + ": " + nome2 + " | " + Partita_iva + " | " + Email + " | " + Cliente_primo_livello)
//    } else {
//        println("Riga " + (i + 1) + " non ha abbastanza colonne.")
//    }
//}



////////////////////////////////////////////////////////////////////////////////////////////////
println rows2

int j = 1

WebElement row2 = rows2.get(j)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns2 = row2.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
String nome2 = columns2.get(0).getText()
String Partita_iva = columns2.get(1).getText()
String Email = columns2.get(2).getText()
String Cliente_primo_livello = columns2.get(5).getText()

// Stampa i valori estratti o usali come preferisci
println("Nome: " + nome2)
println("P.IVA: " + Partita_iva)
println("Email " + Email)
println("Cliente_primo_livello " + Cliente_primo_livello)

WebUI.verifyMatch(nome2, randomNome1, true)
WebUI.verifyMatch(Partita_iva, partitaIVA1, true)
WebUI.verifyMatch(Email, randomEmail1, true)
WebUI.verifyMatch(Cliente_primo_livello, nome, true)

WebUI.delay(3)
//WebUI.click(findTestObject('Object Repository/CLIENTI/20 - Visualizzazione sezione cliente di secondo livello/Page_PlickUp-Admin/Chiudi tabella secondo livello_1'))



WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/24 - Eliminazione cliente secondo livello/Page_PlickUp-Admin/div_Elimina'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_NO'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/24 - Eliminazione cliente secondo livello/Page_PlickUp-Admin/div_Elimina'))
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

//WebUI.closeBrowser()
//ELIMINAZIONE CLIENTE PRIMO LIVELLO/////////////////////////////////////////////////////////////
// Trova l'elemento della tabella
WebElement table3 = WebUI.findWebElement(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/Table'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows3 = table3.findElements(By.tagName('tr'))

println rows3

int K = 1

WebElement row3 = rows3.get(K)

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
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_NO'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/div_Elimina'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CLIENTI/11 - eliminazione cliente censito/button_SI'))

TestObject dynamicSpanObject6 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente eliminato')]"
)


TestObject dynamicSpanObject7 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito6 = WebUI.getText(dynamicSpanObject6)
println esito6
WS.verifyMatch(esito6, "Utente eliminato", true)

String esito7 = WebUI.getText(dynamicSpanObject7)
println esito7
WS.verifyMatch(esito7, "Operazione eseguita con successo", true)
WebUI.delay(6)
WebUI.closeBrowser()