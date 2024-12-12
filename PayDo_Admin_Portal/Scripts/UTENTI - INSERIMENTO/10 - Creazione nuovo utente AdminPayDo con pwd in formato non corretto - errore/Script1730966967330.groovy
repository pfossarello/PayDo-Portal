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

WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'), 
    'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'), 
    'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_accedi'))

//WebUI.delay(20)


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Button Gestione Utenti'))


WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/svg_Elementi per pagina_w-5 h-5 text-white'))

WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/div__z-10 absolute top-3 left-3 right-3 bot_19ecdc'))

// Verifica che il pulsante sia visibile nello stato selezionato (se c’è un cambiamento visibile)
WebUI.verifyElementVisible(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/div__z-10 absolute top-3 left-3 right-3 bot_19ecdc'))

String randomNome = RandomStringUtils.randomAlphabetic(6)
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__firstName'), randomNome)

String randomCognome = RandomStringUtils.randomAlphabetic(10)
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__lastName'),randomCognome)

String randomEmail = "test" + System.currentTimeMillis() + "@example.com"
WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input__email'), randomEmail)


WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_Phone_form-control w-full h-10'),'+39 329 7656234')

// TestObject per il campo pwd
TestObject pwdField = findTestObject('Object Repository/UTENTI - INSERIMENTO/7 - Creazione nuovo utente AdminPayDo senza inserire alcun dato - errore/Page_PlickUp-Admin/input_Phone_password')

// Definisco una lista di pwd non valide
List<String> invalidPwd = [ "prova123%","Prova123","Prova%", "PROVA1234%", "PROVAMIA%"]

// TestObject per il pulsante AGGIUNGI
TestObject addButton = findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Aggiungi')

// TestObject per il messaggio di errore sotto il campo email
TestObject errorMessageObject = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//p[(text() = 'Il valore inserito non corrisponde al formato richiesto' or . = 'Il valore inserito non corrisponde al formato richiesto')]"
)

// Definisci la variabile di controllo per la prima iterazione
boolean isFirstIteration = true

// Itera su ogni pwd non valida
for (String pwd in invalidPwd) {
	
	// Inserisci la pwd non valida nel campo pwd
	WebUI.setText(pwdField, pwd)
	print pwd
	
	// Esegui il click sul pulsante "AGGIUNGI" solo alla prima iterazione
    if (isFirstIteration) {
        WebUI.click(addButton)
        // Imposta la variabile di controllo a false dopo il primo click
        isFirstIteration = false
    }
	

	// Attendi che il messaggio di errore sia visibile
	WebUI.waitForElementVisible(errorMessageObject, 2)
	
	// Verifica se il messaggio di errore è presente
	boolean isErrorDisplayed = WebUI.verifyElementPresent(errorMessageObject, 5, FailureHandling.CONTINUE_ON_FAILURE)
	
	if (isErrorDisplayed) {
		
		String errorpwd = WebUI.getText(findTestObject('Object Repository/UTENTI - INSERIMENTO/10 - Creazione nuovo utente AdminPayDo con pwd in formato non corretto - errore/Page_PlickUp-Admin/p_Il valore inserito non corrisponde'))
		println errorpwd
		
		WS.verifyMatch(errorpwd, "Il valore inserito non corrisponde al formato richiesto", true)
		
	}
	// Pulisci il campo email per la prossima iterazione
	WebUI.clearText(pwdField)
}
WebUI.closeBrowser()