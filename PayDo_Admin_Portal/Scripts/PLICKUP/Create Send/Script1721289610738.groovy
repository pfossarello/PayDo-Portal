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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'richiamo la Authenitication per recuperare il token'
ResponseToken = WS.sendRequest(findTestObject('Authentication/Authentication', [('Environment') : GlobalVariable.Path]))

'prendi il valore "access_token" che arriva dalla response (ResponseToken) di authentication   e lo metto nella variabile Token'
Token = WS.getElementPropertyValue(ResponseToken, 'access_token')

'stampo la variabile Token'
KeywordUtil.logInfo(Token)

'passo a Create RTP quello che c\'è dentro alla variabile token ed estraggo in output la response della RTP'
ResponseCreateSend = WS.sendRequest(findTestObject('CREATE SEND RTP/Create Send', [('Environment') : GlobalVariable.Path, ('Token') : Token]))

WS.verifyResponseStatusCode(ResponseCreateSend, 200)

WebUI.openBrowser(WS.getElementPropertyValue(ResponseCreateSend, 'item.rtpUrl'))

Id = WS.getElementPropertyValue(ResponseCreateSend, 'item._id')

'stampo la variabile Id'
KeywordUtil.logInfo(Id)

