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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.time.format.DateTimeFormatter
import java.time.LocalDate as LocalDate
//import org.openqa.selenium.Keys as Keys
String areaCode = '+39'
LocalDate expiredAt = LocalDate.now()
LocalDate expiredAtnew = expiredAt.plusDays(20)
System.out.println(expiredAtnew)

String name_retail_template = 'smsRequestRetail'
String channel_retail_template = 'SMS'
String recipient_retail_template = 'RETAIL'
String name_agent_template = 'smsRequestAgent'
String channel_agent_template = 'SMS'
String recipient_agent_template = 'AGENT'

'richiamo la Authenitication per recuperare il token'
ResponseToken = WS.sendRequest(findTestObject('Object Repository/PLICKUP/Authentication/Authentication', [('Environment') : GlobalVariable.Path]))

'prendi il valore "access_token" che arriva dalla response (ResponseToken) di authentication   e lo metto nella variabile Token'
Token = WS.getElementPropertyValue(ResponseToken, 'access_token')

'stampo la variabile Token'
KeywordUtil.logInfo(Token)

'passo a Create RTP quello che c\'è dentro alla variabile token ed estraggo in output la response della RTP'
ResponseRTP = WS.sendRequest(findTestObject('Object Repository/PLICKUP/CREATE RTP/Create RTP', [('Environment') : GlobalVariable.Path, ('Token') : Token, ('areaCode') : areaCode,('expiredAt'):expiredAtnew,('name_retail_template'):name_retail_template,('channel_retail_template'):channel_retail_template, ('recipient_retail_template'):recipient_retail_template,('name_agent_template'):name_agent_template,('channel_agent_template'):channel_agent_template, ('recipient_agent_template'):recipient_agent_template] ))
GlobalVariable.ResponseRTP = ResponseRTP

WS.verifyResponseStatusCode(ResponseRTP, 200)


message = WS.getElementPropertyValue(ResponseRTP, 'message')
state = WS.getElementPropertyValue(ResponseRTP, 'item.state')
System.out.println(message)

System.out.println(state)

WS.verifyMatch("Entità creata con successo.", message, true)
WS.verifyMatch("CREATED",state, true)

