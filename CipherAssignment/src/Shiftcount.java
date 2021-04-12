
public class Shiftcount {
	
	public static void main(String[] args) {

		//we use the formula [ShiftCount n]:[Encrypt 0/Decrypt 1]:[Alphabet 0-EN];[Plaintext/Cipher]
		
		String text   = "6:0:0:This Is Amazing, I Did It!";
		String cipher = encrypt(text, 6);
		System.out.println(cipher);
		System.out.println("  ");
		
		//Decryption of cipher text
		String cipher1 = "6:1:0:EUA NGBK HKKT IUSVXUSOFKJ, GHUXZ UVKXGZOUT!";
		String decryption = decrypt(cipher1, 6);
		System.out.println(decryption);

	}
	
	/*creation of Dictionary ("0" for the English Alphabets). 
	 * - shiftCount represents the number of shifts to be used in defining the key of any encryption */
	
	public static String encrypt(String plainText, int shiftCount) {
		if(shiftCount > 26) {
			shiftCount = shiftCount%26;
		}
		else if(shiftCount < 0) {
			shiftCount = (shiftCount%26) + 26;
		}

		//*PlainText definition within the confines of the English Alphabet (0)//
		
		String cipherText = " ";
		int length  = plainText.length();
		for (int i  = 0; i < length; i++) {
			char b1 = plainText.charAt(i);
			if(Character.isLetter(b1)) {
				if(Character.isLowerCase(b1)) {
					char B = (char)(b1 + shiftCount);
					if(B > 'z') {
						cipherText += (char)(b1 - (26-shiftCount));
					}
					else {
						cipherText += B;
					}
				}
				else if(Character.isUpperCase(b1)) {
					char B = (char)(b1 + shiftCount);
					if(B > 'Z') {
						cipherText += (char)(b1 - (26 - shiftCount));
					}
					else {
						cipherText += B;
					}
				}
			}
			else {
				cipherText += b1;
			}
		}
		return cipherText;
	}

	//Defining our decrpytion formula
	public static String decrypt(String plainText, int shiftCount) {
		if(shiftCount > 26) {
			shiftCount = shiftCount%26;
		}
		else if(shiftCount < 0) {
			shiftCount = (shiftCount%26) + 26;
		}

		String cipherText = " ";
		int length  = plainText.length();
		for (int i  = 0; i < length; i++) {
			char b1 = plainText.charAt(i);
			if(Character.isLetter(b1)) {
				if(Character.isLowerCase(b1)) {
					char B = (char)(b1 - shiftCount);
					if(B < 'a') {
						cipherText += (char)(b1 + (26 - shiftCount));
					}
					else {
						cipherText += B;
					}
				}
				else if(Character.isUpperCase(b1)) {
					char B = (char)(b1 - shiftCount);
					if(B < 'A') {
						cipherText += (char)(b1 + (26 - shiftCount));
					}
					else {
						cipherText += B;
					}
				}
			}
			else {
				cipherText += b1;
			}
		}
		return cipherText;
	}
	
}