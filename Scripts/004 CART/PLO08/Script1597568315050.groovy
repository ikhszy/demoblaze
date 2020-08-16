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

WebUI.click(findTestObject('004 CART/003 Button PlaceOrder'))

WebUI.waitForPageLoad(0)

def verif1 = WebUI.verifyElementVisible(findTestObject('004 CART/004 Label Form PlaceOrder'))

if (verif1 == true) {
    KeywordUtil.markPassed('Berhasil membuka form PlaceOrder')
} else {
    KeywordUtil.markFailed('Gagal membuka form PlaceOrder')

    WebUI.closeBrowser()
}

WebUI.setText(findTestObject('004 CART/005 Input Name'), 'Muhammad Ikhsan')

WebUI.setText(findTestObject('004 CART/006 Input Country'), 'Indonesia')

WebUI.setText(findTestObject('004 CART/007 Input City'), 'Jakarta')

WebUI.setText(findTestObject('004 CART/008 Input CreditCard'), '0000-0000-0000-0000')

WebUI.setText(findTestObject('004 CART/009 Input Month'), '')

WebUI.setText(findTestObject('004 CART/010 Input Year'), '2020')

WebUI.click(findTestObject('004 CART/012 Button Purchase'))

WebUI.delay(1)

String alertText = WebUI.getAlertText()
def check = ['Month', 'fill']
verif2 = check.findAll {alertText.contains(it)}

if(verif2 == true){
	KeywordUtil.markPassed('Alert muncul dan teks sudah sesuai')
	WebUI.closeBrowser()
}else {
	KeywordUtil.markFailed('Alert tidak sesuai')
	WebUI.closeBrowser()
}

