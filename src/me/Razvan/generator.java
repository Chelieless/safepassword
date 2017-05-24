package me.Razvan;

import java.security.SecureRandom;

public class generator {
	
	static final String A = "123456789ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz";
	static final String B = "123456789ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()";
	static SecureRandom rnd = new SecureRandom();
	
	public static String Generate(int len, boolean special) {
		
		StringBuilder sb = new StringBuilder(len);
		
		if(special) {
			
			for(int i = 0; i < len; i++)
				sb.append(B.charAt(rnd.nextInt(B.length())));
			
		}
		if(!special) {
			
			for(int i = 0; i < len; i++)
				sb.append(A.charAt(rnd.nextInt(A.length())));
			
		}
		
		return sb.toString();
	}
	

}
