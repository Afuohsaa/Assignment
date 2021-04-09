
public class Shiftcount {
	
	public static String encrypt(String plainText, int shift) {
		if(shift>26) {
			shift = shift%26;
		}
		else if(shift<0) {
			shift = (shift%26)+26;
		}
		
		String cipherText = "";
		int length = plainText.length();
		for (int i = 0; i<length; i++) {
			char b1 = plainText.charAt(i);
			if(Character.isLetter(b1)) {
				if(Character.isLowerCase(b1)) {
					char B = (char)(b1+shift);
					if(B> 'z') {
						cipherText += (char)(b1 - (26-shift));
					}
					else {
						cipherText += B;
					}
				}
				else if(Character.isUpperCase(b1)) {
					char B = (char)(b1+shift);
					if(B> 'Z') {
						cipherText += (char)(b1 - (26-shift));
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
public static void main(String[] args) {
	String text = "Facebook is ComPromized";
	String cipher = encrypt(text, 4);
	System.out.println(cipher);
		
	}
	
}