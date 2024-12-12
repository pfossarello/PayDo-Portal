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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.testobject.TestObject
import java.util.Random
import org.apache.commons.lang.RandomStringUtils

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://admin.test.plickup.eu/')

WebUI.setText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_username'),
	'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/input_accedi_password'),
	'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_accedi'))
//WebUI.delay(20)


//WebUI.click(findTestObject('Object Repository/UTENTI - INSERIMENTO/1 - Creazione nuovo utente AdminPayDo con associati 3 prodotti/Page_PlickUp-Admin/button_Invia'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/div_Davide_z-10 absolute top-3 left-3 right_95b39b'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_Davide_w-24 h-20 bg-skin-bgBtnMenu f_410c06'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/span_Home'))

WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/svg_Elementi per pagina_w-5 h-5 text-white'))
String randomNomeGruppo = RandomStringUtils.randomAlphabetic(6)

WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Elementi per pagina_name'), randomNomeGruppo)

WebUI.setText(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/input_Nome gruppo_description'), 'DescrizioneCliente1s')

//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/option_Agenzia Giorgia 1'))


// Trova l'elemento <select> usando l'XPath
TestObject selectObject = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//select[contains(@class, 'rdl-control') and @multiple='']")

// Verifica che l'elemento <select> esista
WebUI.verifyElementPresent(selectObject, 10)

// Ottieni l'elemento <select> come WebElement
WebElement selectElement = WebUI.findWebElement(selectObject)

// Usa Selenium's Select per interagire con il <select>
Select select = new Select(selectElement)

// Ottieni tutte le opzioni disponibili
List<WebElement> options = select.getOptions()

// Scegli un'opzione casuale
Random random = new Random()
int randomIndex = random.nextInt(options.size()) // Genera un indice casuale
WebElement randomOption = options.get(randomIndex)

// Seleziona l'opzione casuale
select.selectByValue(randomOption.getAttribute('value'))

// Stampa l'opzione selezionata nella console
WebUI.comment("Opzione selezionata: " + randomOption.getText())

// Crea un TestObject per l'opzione selezionata
TestObject selectedOptionObject = new TestObject()
selectedOptionObject.addProperty('xpath', ConditionType.EQUALS, "//option[@value='${randomOption.getAttribute('value')}']")

// Esegui il doppio clic sull'opzione selezionata
WebUI.doubleClick(selectedOptionObject)

// Aggiungi un'attesa per osservare l'azione
WebUI.delay(5)


//WebUI.doubleClick(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/img_Filter available_pt-1 w-auto h-12'))
WebUI.click(findTestObject('Object Repository/GRUPPI/1 - 12 - Corretta creazione nuovo gruppo con un cliente associato e successiva eliminazione/button_Aggiungi'))

WebUI.delay(3)

//TestObject dynamicSpanObject = new TestObject().addProperty(
//	"xpath",
//	ConditionType.EQUALS,
//	"//span[contains(text(), 'Stato modificato')]"
//)
TestObject dynamicSpanObject = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Gruppo aggiunto\')]')

TestObject dynamicSpanObject1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Operazione eseguita con successo\')]')

String esito1 = WebUI.getText(dynamicSpanObject)

println(esito1)

WS.verifyMatch(esito1, 'Gruppo aggiunto', true)

String esito = WebUI.getText(dynamicSpanObject1)

println(esito)

WS.verifyMatch(esito, 'Operazione eseguita con successo', true)

WebUI.setText(findTestObject('Object Repository/GRUPPI/5 - ricerca gruppo in Elenco gruppi - rilsultato trovato/Page_PlickUp-Admin/Campo ricerca gruppi'), randomNomeGruppo)

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/div_Elimina'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GRUPPI/Page_PlickUp-Admin/button_SI'))

WebUI.delay(1)

TestObject dynamicSpanObject2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Gruppo eliminato\')]')

TestObject dynamicSpanObject3 = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(), \'Operazione eseguita con successo\')]')

String esito2 = WebUI.getText(dynamicSpanObject2)

println(esito2)

WS.verifyMatch(esito2, 'Gruppo eliminato', true)

String esito3 = WebUI.getText(dynamicSpanObject3)

println(esito3)

WS.verifyMatch(esito3, 'Operazione eseguita con successo', true)

WebUI.delay(6)
WebUI.closeBrowser()

