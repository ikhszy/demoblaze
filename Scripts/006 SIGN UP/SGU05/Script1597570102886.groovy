import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('001 HOME/001 HOME/HOM01'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Random'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('006 SIGN UP/001 Menu Sign Up'))

WebUI.waitForPageLoad(2)

WebUI.setText(findTestObject('006 SIGN UP/003 Input Username'), GlobalVariable.randomUsername)

WebUI.setText(findTestObject('006 SIGN UP/004 Input Password'), 'password')

WebUI.click(findTestObject('006 SIGN UP/005 Button SignUp'))

WebUI.delay(1)

//String alertText = WebUI.getAlertText()
//
//def check = ['Sign', 'up', 'success', 'successful', 'successfuly']
//
//verif = check.findAll({ 
//        alertText.contains(it)
//    })
//
//if (verif == true) {
//    KeywordUtil.markPassed('Berhasil melakukan Sign Up')
//
//    WebUI.acceptAlert()
//} else {
//    KeywordUtil.markFailed('Gagal melakukan Sign Up')
//}

WebUI.acceptAlert()

WebUI.delay(1)

WebUI.click(findTestObject('006 SIGN UP/001 Menu Sign Up'))

WebUI.waitForPageLoad(2)

WebUI.setText(findTestObject('006 SIGN UP/003 Input Username'), GlobalVariable.randomUsername)

WebUI.setText(findTestObject('006 SIGN UP/004 Input Password'), 'password')

WebUI.click(findTestObject('006 SIGN UP/005 Button SignUp'))

WebUI.delay(1)

String alertText2 = WebUI.getAlertText()

def check2 = ['user', 'already']

verif2 = check2.findAll({ 
        alertText2.contains(it)
    })

if (verif2 == true) {
    KeywordUtil.markPassed('Alert sudah sesuai')

    WebUI.acceptAlert()

    WebUI.closeBrowser()
} else {
    KeywordUtil.markFailed('Alert belum sesuai')

    WebUI.closeBrowser()
}

