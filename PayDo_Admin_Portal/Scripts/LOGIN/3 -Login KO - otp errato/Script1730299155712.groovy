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

WebUI.setText(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/input_accedi_username'), 'paolofossarello@libero.it')

WebUI.setEncryptedText(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/input_accedi_password'), 'So1Ubt5L+nyt5nnQHelfVw==')

WebUI.click(findTestObject('Object Repository/LOGIN/Login 2/Page_PlickUp-Admin/button_accedi'))

WebUI.setText(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/input_Invia_OTP'), '232523')

WebUI.click(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/button_Invia'))

def testo = WebUI.getText(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/label_Invalid code or auth state for the user'))
println testo

WS.verifyMatch('Invalid code or auth state for the user.', testo, true)

WebUI.click(findTestObject('Object Repository/LOGIN/Login 3/Page_PlickUp-Admin/svg_Password attempts exceeded_cursor-point_2ef602'))

WebUI.delay(3)
WebUI.closeBrowser()

