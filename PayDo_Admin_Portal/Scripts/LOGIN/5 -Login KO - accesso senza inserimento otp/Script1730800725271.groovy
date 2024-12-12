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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://admin.test.plickup.eu/')


//WebUI.click(findTestObject('Object Repository/Login 5/Page_PlickUp-Admin/body_PlickUp-AdminDati accessoaccediid(root_4d2434'))

WebUI.setText(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/input_accedi_username'), 'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/input_accedi_password'), 'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/button_accedi'))

WebUI.click(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/button_Invia'))

def testo = WebUI.getText(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/p_Inserisci OTP ricevuto per SMS'))
WS.verifyMatch('Inserisci OTP ricevuto per SMS', testo, true)


def testo1 = WebUI.getText(findTestObject('Object Repository/LOGIN/Login 5/Page_PlickUp-Admin/p_Il campo  obbligatorio'))
println testo1

WS.verifyMatch('Il campo è obbligatorio', testo1, true)

WebUI.closeBrowser()

