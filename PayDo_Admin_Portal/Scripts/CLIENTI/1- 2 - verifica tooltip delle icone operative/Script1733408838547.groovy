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
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_PlickUp'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/hamburger menu'))
WebUI.click(findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/p_Clienti'))

//recupero il tooltip Abilitazioni
TestObject iconObject = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Abilitazioni') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject) // Passa il mouse sull'icona
TestObject tooltipObject = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Abilitazioni - tooltip')
WebUI.waitForElementVisible(tooltipObject, 1) 
String tooltip_abilitazioni = WebUI.getText(tooltipObject)
println("Testo del tooltip: " + tooltip_abilitazioni)

//recupero il tooltip Modifica
TestObject iconObject1 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Modifica') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject1) // Passa il mouse sull'icona
TestObject tooltipObject1 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Modifica - tooltip')
WebUI.waitForElementVisible(tooltipObject1, 1)
String tooltip_modifica = WebUI.getText(tooltipObject1)
println("Testo del tooltip: " + tooltip_modifica)

//recupero il tooltip Importa file
TestObject iconObject2 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Importa file') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject2) // Passa il mouse sull'icona
TestObject tooltipObject2 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Importa file - toolip')
WebUI.waitForElementVisible(tooltipObject2, 1)
String tooltip_importa_file = WebUI.getText(tooltipObject2)
println("Testo del tooltip: " + tooltip_importa_file)

//recupero il tooltip Template
TestObject iconObject3 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Template') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject3) // Passa il mouse sull'icona
TestObject tooltipObject3 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Template - tooltip')
WebUI.waitForElementVisible(tooltipObject3, 1)
String tooltip_template = WebUI.getText(tooltipObject3)
println("Testo del tooltip: " + tooltip_template)

//recupero il tooltip Aggiungi 2° livello
TestObject iconObject4 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Aggiungi 2 livello') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject4) // Passa il mouse sull'icona
TestObject tooltipObject4 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Aggiungi 2 livello - tooltip')
WebUI.waitForElementVisible(tooltipObject4, 1)
String tooltip_aggiungi_secondo_livello = WebUI.getText(tooltipObject4)
println("Testo del tooltip: " + tooltip_aggiungi_secondo_livello)

//recupero il tooltip clienti 2° livello
TestObject iconObject5 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Clienti 2 livello') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject5) // Passa il mouse sull'icona
TestObject tooltipObject5 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Clienti 2 livello - tootlip')
WebUI.waitForElementVisible(tooltipObject5, 1)
String tooltip_clienti_secondo_livello = WebUI.getText(tooltipObject5)
println("Testo del tooltip: " + tooltip_clienti_secondo_livello)

//recupero il tooltip elimina
TestObject iconObject6 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Elimina') // Modifica con il tuo oggetto icona
WebUI.mouseOver(iconObject6) // Passa il mouse sull'icona
TestObject tooltipObject6 = findTestObject('Object Repository/CLIENTI/2 - verifica tooltip delle icone operative/Page_PlickUp-Admin/div_Elimina - tooltip')
WebUI.waitForElementVisible(tooltipObject6, 1)
String tooltip_elimina = WebUI.getText(tooltipObject6)
println("Testo del tooltip: " + tooltip_elimina)

//confronto i tooltip recuperati con quelli attesi
WS.verifyMatch(tooltip_modifica, "Modifica", true)
WS.verifyMatch(tooltip_abilitazioni, "Abilitazioni", true)
WS.verifyMatch(tooltip_importa_file, "Importa file", true)
WS.verifyMatch(tooltip_template, "Template", true)
WS.verifyMatch(tooltip_aggiungi_secondo_livello, "Aggiungi 2° livello", true)
WS.verifyMatch(tooltip_clienti_secondo_livello, "Clienti 2° livello", true)
WS.verifyMatch(tooltip_elimina, "Elimina", true)

WebUI.closeBrowser()