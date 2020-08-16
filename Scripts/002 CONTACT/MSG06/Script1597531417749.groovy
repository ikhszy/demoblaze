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

WebUI.delay(1)

WebUI.click(findTestObject('002 CONTACT/001 Menu Contact'))

WebUI.delay(0.5)

verif = WebUI.verifyElementText(findTestObject('002 CONTACT/002 Label Pop Up'), 'New message')

if (verif == true) {
    KeywordUtil.markPassed('Berhasil akses pop up Contact')
} else {
    KeywordUtil.markFailed('Gagal akses pop up Contact')
}

WebUI.setText(findTestObject('002 CONTACT/003 Input Email'), 'ikhszy@gmail.com')

WebUI.setText(findTestObject('002 CONTACT/004 Input Name'), '')

WebUI.setText(findTestObject('002 CONTACT/005 Input Message'), 'Need help with my recent purchase')

WebUI.click(findTestObject('002 CONTACT/006 Button SendMessage'), FailureHandling.STOP_ON_FAILURE)

verif2 = WebUI.verifyAlertPresent(0)

if (verif2 == true) {
    String alertText = WebUI.getAlertText()
	def checker = ['required', 'empty','name', 'cannot']
	def verif3 = checker.findAll {alertText.contains (it)}
    if (verif3 == true) {
        KeywordUtil.markPassed('Alert muncul dan teks sudah sesuai')
		WebUI.comment(alertText)
        WebUI.acceptAlert()
        WebUI.closeBrowser()
    } else {
        KeywordUtil.markFailed('teks alert belum sesuai')
		WebUI.comment(alertText)
        WebUI.closeBrowser()
    }
} else {
    KeywordUtil.markFailed('Alert tidak muncul')
    WebUI.closeBrowser()
}

