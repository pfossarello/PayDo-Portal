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

WebUI.callTestCase(findTestCase('Test Cases/UTENTI - RICERCA_MODIFICA_DISAB/16 - 17 - Corretta modifica utente già registrato - disabilitazione utenza'), [:], FailureHandling.STOP_ON_FAILURE)



//// Trova l'elemento della tabella
//WebElement table = WebUI.findWebElement(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/Tabella risultati utenti'))
//
//// Trova tutte le righe all'interno della tabella
//List<WebElement> rows = table.findElements(By.tagName('tr'))


	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/div_Abilita'))
	
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/button_NO'))
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/div_Abilita'))
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/UTENTI - RICERCA_MODIFICA_DISAB/17 - Corretta modifica utente già registrato - riabilitazione utenza/Page_PlickUp-Admin/button_SI'))
	// Crea un Test Object dinamico con XPath per il tag <span> contenente 'Utente modificato ' e 'Entità modificata con successo'
TestObject dynamicSpanObject1 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Utente abilitato')]"
)


TestObject dynamicSpanObject2 = new TestObject().addProperty(
	"xpath",
	ConditionType.EQUALS,
	"//span[contains(text(), 'Operazione eseguita con successo')]"
)

String esito1 = WebUI.getText(dynamicSpanObject1)
println esito1
WS.verifyMatch(esito1, "Utente abilitato", true)

String esito = WebUI.getText(dynamicSpanObject2)
println esito
WS.verifyMatch(esito, "Operazione eseguita con successo", true)

WebUI.closeBrowser()

