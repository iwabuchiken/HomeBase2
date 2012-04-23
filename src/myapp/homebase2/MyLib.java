package myapp.homebase2;

import java.util.HashMap;
import java.util.Random;

public class MyLib {
	//
	static HashMap<Integer, Integer> tabSet = new HashMap<Integer, Integer>();
	
	// String for "generatePassword()"
	static String charSource = "abcdefghijklmn";
	
	// Password types
	enum PwdTypes {
			ALPHA, NUM, ALNUM
	}
	
	//
	public MyLib() {
//		tabSet.put(1, R.id.tab1);
//		tabSet.put(2, R.id.tab2);
//		tabSet.put(3, R.id.tab3);
		tabSet.put(0, R.id.tab1);
		tabSet.put(1, R.id.tab2);
		tabSet.put(2, R.id.tab3);
	}//public MyLib()
	
	// get values
	public HashMap<Integer, Integer> getIdMap() {
		
		return tabSet;
		
	}//public static HashMap<Integer, Integer> getIdMap()
	
	// generate a password
	public static String generatePassword() {
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// get chars
		Random rd;
		int judge;
		for (int i = 0; i < 5; i++) {
			// instance
			rd = new Random((long) (Math.random()*1000000));
			
			// alphabet or number ?
			judge = rd.nextInt(2);
			
			
			// get a char
			sb.append(charSource.charAt(rd.nextInt(charSource.length())));
		}//for (int i = 0; i < array.length; i++)
		
		// get a string		
		
		return sb.toString();
		
	}//generatePassword()

	// generate a password
	public static String generatePassword(PwdTypes pwdType) {
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// get chars
		Random rd;
		int judge;
		
		for (int i = 0; i < 5; i++) {
			// instance
			rd = new Random((long) (Math.random()*1000000));
			
//			// alphabet or number ?
//			judge = rd.nextInt(2);
//			if (judge == 0) {
//				// get a char
//				sb.append(charSource.charAt(rd.nextInt(charSource.length())));
//			} else if (judge == 1) {//if (judge == 0)
//				// get a number
//				sb.append(charSource.charAt(rd.nextInt(charSource.length())));
//			}//if (judge == 0)
//			
			
			// get a char
			sb.append(charSource.charAt(rd.nextInt(charSource.length())));
		}//for (int i = 0; i < array.length; i++)
		
		// get a string		
		
		return sb.toString();
		
	}//generatePassword()
}
