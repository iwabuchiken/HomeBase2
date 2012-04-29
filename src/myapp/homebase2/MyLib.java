package myapp.homebase2;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

//import myapp.homebase2.MyLib.FTPManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

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
				
//				//debug
//				isUniform = false;
				
				//judge
				if (isUniformString(sb.toString()) == false) {
					isUniform = false;
				} else {//if (isUniform)
					sb = new StringBuilder();
//					sb.append('*');
				}
			}//while (!isUniform)
		}//if (type == 0)
		
		return sb.toString();
		
	}//public static String generatePassword(int type, int passwdLength)
	
	public static boolean isUniformString(String targetString) {
		// get the type of the first char in the string
		int firstCharType = Character.getType(targetString.charAt(0));
		
		// flag: default => false (assumes the string is not uniform)
//		boolean isSame = false;
		
		// judge
		for (int i = 1; i < targetString.length(); i++) {
			if (Character.getType(targetString.charAt(0)) 
					!= Character.getType(targetString.charAt(i))) {
				return false;
			}//if (targetString.charAt(0) != targetString.charAt(i))
		}//for (int i = 1; i < targetString.length(); i++)
		
		/* if the rest of the chars are same as the first one
		 * 	=> return true (i.e., the string is consisted of the same type of char)
		 */
		return true;
	}

	// getStringメソッド(メッセージ取得処理)
	// source=C:\WORKS\WORKSPACES2\Sample\Chapter7\PictureJumpSample\src\jp\co\techfun\picturejump\AppUtil.java
    public static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }//public static String getString(Context context, int resId)

	public static Bitmap resizePicture(Bitmap picture, int maxWidth, int maxHeight) {
		// secure picture
		if (picture == null) {
            return null;
        }
		
		// 幅と高さで大きいほうに合わせてリサイズ
        int width = 0;
        int height = 0;

        if (picture.getWidth() > picture.getHeight()) {
            width = maxWidth;
            height = width * picture.getHeight() / picture.getWidth();
        } else {
            height = maxHeight;
            width = height * picture.getWidth() / picture.getHeight();
        }
		
        // 算定したサイズでビットマップ生成
        Bitmap result = Bitmap.createScaledBitmap(picture, width, height, true);
        
		return result;
	}
}

class FTPManager {

	/** uploadFiles(FTPClient, InputSteam)
	 * 
	 * @param ftpc
	 * @param in
	 * @return
	 * 
	 */
	public static String uploadFiles(FTPClient ftpc, InputStream in) {
//		// store input to remote
//		try {
////			ftpc.storeFile("/", in);
////			ftpc.storeFile("/home/stretchc/public_html", in);
////			ftpc.storeFile("/home/stretchc/public_html", BitmapFactory.decodeStream(in));
//			
//			return "File stored";
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
////			e.printStackTrace();
//			return e.toString();
//		}
		
		
		return null;
		
	}//uploadFiles()
	
	/*	disconnectFTP()
	 * 
	 * <Return>
	 * 		1	=> disconnected
	 * 		-1	=> Exception occurred
	 */
	public static int disconnectFTP(FTPClient ftpc) {
		try {
			ftpc.disconnect();
			
			return 1;
		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
			return -1;
		}//try
	}//disconnectFTP()
	
	public static String ftpConnect(InputStream in) {
		// instance of FTPClient
		FTPClient fc = new FTPClient();
		
		// message string
		StringBuilder sb = new StringBuilder();
		
		// set the default port
		fc.setDefaultPort(21);
		
		try {
			// connect
			fc.connect("174.132.28.185");
			
			
			// log in
			boolean boolResult = fc.login("polarbearland@stretch.cawing.info", "FQlRd2;i[77v");
			
			sb.append(String.valueOf("login=" + boolResult));
			sb.append("\n");
			
			// upload files
			String stringResult = FTPManager.uploadFiles(fc, in);
			
			sb.append("upload=" + stringResult);
			sb.append("\n");
			
			// disconnect
			int intResult = FTPManager.disconnectFTP(fc);
			
			sb.append(String.valueOf("disconnect=" + intResult));
			sb.append("\n");
			
			// return
			return sb.toString();
			
//			if (result == 1) {
//				return "disconnected";
//			} else if (result == -1){//if (result == 1)
//				return "Exception occurred";
//			} else {
//				return "Unknown error";
//			}//if (result == 1)
			
						
//			return sb.toString();
			
//			return String.valueOf(fc.login("polarbearland@stretch.cawing.info", "FQlRd2;i[77v"));
			
		} catch (SocketException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return e.toString();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return e.toString();
		} finally {
			
			try {
				fc.disconnect();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return e.toString();
			}
		}
		
//		return String.valueOf(fc.getReplyCode());
		
		// connect
//		try {
//			//debug
//			//6
//			fc.setDefaultPort(21);
//			fc.connect("174.132.28.185");
//			
////			//5
////			fc.setDefaultPort(21);
////			fc.connect("174.132.28.184");
//			
////			fc.connect("http://stretch.cawing.info/");
////			fc.connect("174.132.28.184");	//=> Permission denied
////			fc.connect("174.132.28.184:2082");	//=> UnknownHostException
////			fc.connect("ftp.stretch.cawing.info");//=> UnknownHostException
//			return String.valueOf(fc.getReplyCode());
////			FTPReply.isPositiveCompletion(fc.getReplyCode());
//		} catch (SocketException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return e.toString();
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return e.toString();
//		}
		
	}//ftpConnect()
//	// INSTANCE
//	private final FTPManager INSTANCE = new FTPManager();
//	
//	public FTPManager getInstance() {
//		
//		return INSTANCE;
//	}//public FTPManager getInstance()
	
}//class FTPManager
