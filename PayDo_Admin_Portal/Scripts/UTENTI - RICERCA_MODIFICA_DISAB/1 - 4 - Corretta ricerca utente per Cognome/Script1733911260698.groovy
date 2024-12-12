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

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Button Gestione Utenti'))


// Trova l'elemento della tabella
WebElement table = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))

// Trova tutte le righe all'interno della tabella
List<WebElement> rows = table.findElements(By.tagName('tr'))

println rows

int i = 1

WebElement row = rows.get(i)

// Trova tutte le celle (colonne) della riga corrente
List<WebElement> columns = row.findElements(By.tagName('td'))

// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
//String nome = columns.get(0).getText()
String cognome = columns.get(1).getText()


// Stampa i valori estratti o usali come preferisci
//println("Nome: " + nome)
println("Cognome: " + cognome)


//WebUI.setText(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/2- Gestione Utenti - Corretta ricerca utente per Nome Cognome/Page_PlickUp-Admin/input_Filtri_firstName'), nome)
WebUI.setText(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/2- Gestione Utenti - Corretta ricerca utente per Nome Cognome/Page_PlickUp-Admin/input_Filtri_lastName'), cognome)
WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/2- Gestione Utenti - Corretta ricerca utente per Nome Cognome/Page_PlickUp-Admin/svg_Cerca per gruppo_Componente_100_4'))

//dichiario le due variabili nome_1 e cognome_1 che userò dentro al for
String nome_1 = ""
String cognome_1 = ""


for (int J = 1; J < rows.size(); J++) {

		
		WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))
		// Ricarica la lista `rows` all'inizio di ogni iterazione per evitare riferimenti obsoleti
		rows = table1.findElements(By.tagName('tr'))
		
		WebElement rownew = rows.get(J)

		// Trova tutte le celle (colonne) della riga corrente
		List<WebElement> columnsnew = rownew.findElements(By.tagName('td'))

		// Estrai i valori di Nome, Cognome ed Email (supponendo l'ordine delle colonne come Nome, Cognome, Email)
		 nome_1 = columnsnew.get(0).getText()
		 cognome_1 = columnsnew.get(1).getText()
	

		// Stampa i valori estratti o usali come preferisci
		println("Nome: " + nome_1)
		println("Cognome: " + cognome_1)

//		WS.verifyMatch(nome, nome_1, true)
		WS.verifyMatch(cognome, cognome_1, true)

}


WebUI.closeBrowser()
