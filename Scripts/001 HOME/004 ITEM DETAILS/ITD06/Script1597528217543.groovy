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

WebUI.click(findTestObject('001 HOME/013 Category Monitors'))

WebUI.delay(2)

WebUI.click(findTestObject('001 HOME/015 1st Category Item'))

WebUI.delay(1)

WebUI.click(findTestObject('001 HOME/019 Button AddToCart'))

boolean verif1 = WebUI.verifyAlertPresent(0)

if (verif1 == true) {
    KeywordUtil.markPassed('Berhasil menambah Item Phone ke Cart')

    WebUI.acceptAlert()
} else {
    KeywordUtil.markFailed('Gagal menambah item')

    WebUI.closeBrowser()
}

WebUI.click(findTestObject('004 CART/001 Menu Cart'))

WebUI.delay(3)

boolean verif2 = WebUI.verifyTextPresent('Apple monitor 24', false)

if (verif2 == true) {
    KeywordUtil.markPassed('Barang muncul di list cart')

    WebUI.closeBrowser()
} else {
    KeywordUtil.markFailed('Barang tidak muncul di list cart')

    WebUI.closeBrowser()
}

