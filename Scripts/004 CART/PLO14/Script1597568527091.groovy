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

WebUI.callTestCase(findTestCase('004 CART/PLO00'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

verif1 = WebUI.verifyElementPresent(findTestObject('004 CART/016 Cart 1st Data'), 0)

if (verif1 == true) {
    KeywordUtil.markPassed('Data awal muncul')
} else {
    KeywordUtil.markFailed('Data awal tidak ada')
}

WebUI.delay(0.5)

WebUI.click(findTestObject('004 CART/015 Button Delete'))

WebUI.delay(2)

verif2 = WebUI.verifyElementNotPresent(findTestObject('004 CART/016 Cart 1st Data'), 0)

if (verif2 == true) {
	KeywordUtil.markPassed('Berhasil delete data')
	WebUI.closeBrowser()
} else {
	KeywordUtil.markFailed('Gagal delete data')
	WebUI.closeBrowser()
}

