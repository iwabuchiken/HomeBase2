package myapp.homebase2;

import java.util.HashMap;
import java.util.Random;

import android.content.Context;

public class MyLib {
	//
	static HashMap<Integer, Integer> tabSet = new HashMap<Integer, Integer>();
	
	// String for "generatePassword()"
	static String charSource = "abcdefghijklmn";
	
	// Password types			//=> NOT USED
	enum PwdTypes {
			ALPHA, NUM, ALNUM
	}
	
	//
	public MyLib() {
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
	public static String generatePassword(int type) {
		
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// Random
		Random rd =		/* used to pick up a char							*/
				new Random((long) (Math.random()*1000000));
		Random rd2 =		/* used as a flag for chars and numbers	*/
				new Random((long) (Math.random()*1000000));
		/*
		 *  build a string
		 */

		// switching
		if (type == 0) {							// alphabets only
			
			for (int i = 0; i < 5; i++) {
				sb.append(charSource.charAt(rd.nextInt(charSource.length())));
			}//for (int i = 0; i < 5; i++)
			
		} else if (type == 1){					// numbers only
			
			for (int i = 0; i < 5; i++) {
				sb.append(String.valueOf(rd.nextInt(10)));
			}//for (int i = 0; i < 5; i++)
			
		} else if (type == 2){					// mixture
			
			for (int i = 0; i < 5; i++) {
				int flag = rd2.nextInt(2);
				switch (flag) {
					case 0:
						sb.append(charSource.charAt(rd.nextInt(charSource.length())));
						break;
					case 1:
						sb.append(String.valueOf(rd.nextInt(10)));
						break;
					default:
						break;
				}//switch (flag)
			}//for (int i = 0; i < 5; i++)
			
		}//if (type == 0)
		
		return sb.toString();
		
	}//generatePassword()

	public static String generatePassword(int type, int passwdLength) {
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// Random
		Random rd =		/* used to pick up a char							*/
				new Random((long) (Math.random()*1000000));
		Random rd2 =		/* used as a flag for chars and numbers	*/
				new Random((long) (Math.random()*1000000));
		/*
		 *  build a string
		 */

		// switching
		if (type == 0) {							// alphabets only
			
			for (int i = 0; i < passwdLength; i++) {
				sb.append(charSource.charAt(rd.nextInt(charSource.length())));
			}//for (int i = 0; i < passwdLength; i++)
			
		} else if (type == 1){					// numbers only
			
			for (int i = 0; i < passwdLength; i++) {
				sb.append(String.valueOf(rd.nextInt(10)));
			}//for (int i = 0; i < passwdLength; i++)
			
		} else if (type == 2){					// mixture
			// flag for judging if the generated password is uniform
			boolean isUniform = true;
//			while (!isUniform) {
			while (isUniform) {
				// generate a password
				for (int i = 0; i < passwdLength; i++) {
					int flag = rd2.nextInt(2);
					switch (flag) {
						case 0:
							sb.append(charSource.charAt(rd.nextInt(charSource.length())));
							break;
						case 1:
							sb.append(String.valueOf(rd.nextInt(10)));
							break;
						default:
							break;
					}//switch (flag)
				}//for (int i = 0; i < passwdLength; i++)
				
				// judge
				if (isUniformString(sb.toString()) == false) {
					isUniform = false;
				}//if (isUniform)
			}//while (!isUniform)
		}//if (type == 0)
		
		return sb.toString();
		
	}//public static String generatePassword(int type, int passwdLength)
	
	private static boolean isUniformString(String targetString) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	// getStringメソッド(メッセージ取得処理)
	// source=C:\WORKS\WORKSPACES2\Sample\Chapter7\PictureJumpSample\src\jp\co\techfun\picturejump\AppUtil.java
    public static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }//public static String getString(Context context, int resId)
}
