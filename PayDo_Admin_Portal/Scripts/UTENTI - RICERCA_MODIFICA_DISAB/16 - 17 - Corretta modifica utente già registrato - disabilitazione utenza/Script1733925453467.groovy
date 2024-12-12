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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.callTestCase(findTestCase('Test Cases/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti'), [:], FailureHandling.STOP_ON_FAILURE)

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

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/16 - Corretta modifica utente già registrato - disabilitazione utenza/Page_PlickUp-Admin/div_Disabilita'))
		
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/16 - Corretta modifica utente già registrato - disabilitazione utenza/Page_PlickUp-Admin/button_NO'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/16 - Corretta modifica utente già registrato - disabilitazione utenza/Page_PlickUp-Admin/div_Disabilita'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/16 - Corretta modifica utente già registrato - disabilitazione utenza/Page_PlickUp-Admin/button_SI'))
		// Crea un Test Object dinamico con XPath per il tag <span> contenente 'Utente modificato ' e 'Entità modificata con successo'
	TestObject dynamicSpanObject1 = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Utente disabilitato')]"
	)
	
	
	TestObject dynamicSpanObject2 = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Operazione eseguita con successo')]"
	)
	
	String esito1 = WebUI.getText(dynamicSpanObject1)
	println esito1
	WS.verifyMatch(esito1, "Utente disabilitato", true)
	
	String esito = WebUI.getText(dynamicSpanObject2)
	println esito
	WS.verifyMatch(esito, "Operazione eseguita con successo", true)
	WebUI.delay(6)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
//	
//// Scorri fino alla cima della pagina
//WebUI.executeJavaScript("window.scrollTo(0, 0);", null)
	
	// Trova l'elemento della tabella
	WebElement table1 = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/16 - Corretta modifica utente già registrato - disabilitazione utenza/Page_PlickUp-Admin/tabella utenti_1'))
	
	// Trova tutte le righe all'interno della tabella
	List<WebElement> rows1 = table1.findElements(By.tagName('tr'))
	int i = 1
	
	WebElement row = rows1.get(i)
	
	// Trova tutte le celle (colonne) della riga corrente
	List<WebElement> columns1 = row.findElements(By.tagName('td'))
	String nome = columns1.get(0).getText()
	println nome
	
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/div_Abilita'))
		
		WebUI.delay(1)
	
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/button_NO'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/div_Abilita'))
		
		WebUI.delay(1)
		
		WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/button_SI'))
		// Crea un Test Object dinamico con XPath per il tag <span> contenente 'Utente modificato ' e 'Entità modificata con successo'
	TestObject dynamicSpanObject3 = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Utente abilitato')]"
	)
	
	
	TestObject dynamicSpanObject4 = new TestObject().addProperty(
		"xpath",
		ConditionType.EQUALS,
		"//span[contains(text(), 'Operazione eseguita con successo')]"
	)
	
	String esito3 = WebUI.getText(dynamicSpanObject3)
	println esito3
	WS.verifyMatch(esito3, "Utente abilitato", true)
	
	String esito4 = WebUI.getText(dynamicSpanObject4)
	println esito4
	WS.verifyMatch(esito4, "Operazione eseguita con successo", true)
	WebUI.delay(6)
	WebUI.closeBrowser()
	
	
