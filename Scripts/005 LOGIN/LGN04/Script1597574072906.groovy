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

WebUI.callTestCase(findTestCase('001 HOME/001 HOME/HOM01'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('005 LOGIN/001 Menu Login'))

WebUI.delay(1)

WebUI.setText(findTestObject('005 LOGIN/003 Input Username'), 'ikhszy')

WebUI.setText(findTestObject('005 LOGIN/004 Input Password'), '')

WebUI.click(findTestObject('005 LOGIN/005 Button Login'))

WebUI.delay(1)

String alert = WebUI.getAlertText()

WebUI.comment(alert)

if(alert == 'Please fill out Username and Password.') {
	KeywordUtil.markPassed('Alert sudah sesuai')
	WebUI.acceptAlert()
	WebUI.closeBrowser()
}else {
	KeywordUtil.markFailed('Alert belum sesuai')
	WebUI.acceptAlert()
	WebUI.closeBrowser()
}

