import internal.GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String chars = "abcdefghijklmnopqrstuvwxyz0123456789"
//String code = "1234567890"

public String randomString(String chars, int length) {
  Random rand = new Random();
  StringBuilder sb = new StringBuilder();
  for (int i=0; i<length; i++) {
	sb.append(chars.charAt(rand.nextInt(chars.length())));
  }
  return sb.toString();
}

//public String randomcode(String code, int length) {
//	Random rand = new Random();
//	StringBuilder sb = new StringBuilder();
//	for (int i=0; i<length; i++) {
//	  sb.append(code.charAt(rand.nextInt(code.length())));
//	}
//	return sb.toString();
//  }

//def randomCode = randomcode(code, 3)
def randomString = randomString(chars, 5)

WebUI.comment ("untuk name: " + randomString)
//WebUI.comment ("untuk code: " + randomCode)

GlobalVariable.randomUsername = 'user_' + randomString
//GlobalVariable.randomCode = randomCode