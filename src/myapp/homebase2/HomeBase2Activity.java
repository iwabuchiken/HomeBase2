package myapp.homebase2;

import java.io.FileNotFoundException;
import java.io.InputStream;

//import myapp.homebase2.MyLib.FTPManager;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeBase2Activity extends TabActivity {

	// File input stream
	InputStream in;
	
	/* Request codes
	 * 
	 */
	// Gallery
	private static final int REQUEST_CODE_GALLARY = 0;
	private Bitmap picture;

	/* Fileds for the tab 3
	 * 
	 */
	// timerStatus
	//	0 => Stop
	//	1 => Counting
	private static int timerStatus = 0;
//	public static int timerStatus = 0;

	// TimerManager
	TimerManager tm = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // create tabs
        TabUtils.createTabsN(this, 3);
        
        /* Tab 1
         * 
         */
        
        // Set a listener to the button
        Button t1_LL1_btn1 = (Button) findViewById(R.id.t1_LL1_btn1);
        t1_LL1_btn1.setTag("generatePassword");
        t1_LL1_btn1.setOnClickListener(new ButtonClickListener(this));
        
        // Set a listener to the button: Type
        Button t1_LL2_btn1 = (Button) findViewById(R.id.t1_LL2_btn1);
        t1_LL2_btn1.setTag("setType");
        t1_LL2_btn1.setOnClickListener(new ButtonClickListener(this));
        
        // Set a listener to the button: Type
        Button t1_LL3_btn1 = (Button) findViewById(R.id.t1_LL3_btn1);
        t1_LL3_btn1.setTag("setLength");
        t1_LL3_btn1.setOnClickListener(new ButtonClickListener(this));
        
        /* Tab 2
         * 
         */
        // Set listener: "Choose"
        Button t2_LL1_btn1 = (Button) findViewById(R.id.t2_LL1_btn1);
        t2_LL1_btn1.setTag("choseFiles");
        t2_LL1_btn1.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// インテント生成
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				// インテントタイプを画像で設定
				intent.setType("image/*");
				// ギャラリー起動
				startActivityForResult(Intent.createChooser(intent, MyLib
						.getString(HomeBase2Activity.this,
								R.string.picture_select_title)),
						REQUEST_CODE_GALLARY );

			}
        	
        });//t2_LL1_btn1.setOnClickListener()
        
        // Set listener: "Upload"
        Button t2_LL1_btn2 = (Button) findViewById(R.id.t2_LL1_btn2);
        t2_LL1_btn2.setTag("uploadFiles");
        t2_LL1_btn2.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// disenable the button
				Button uploadBtn = (Button) findViewById(R.id.t2_LL1_btn2);
				uploadBtn.setText("Uploading");
				uploadBtn.setEnabled(false);
				
				//debug
				// Reset the temp view text
				TextView tempMessageView = (TextView) findViewById(R.id.t2_LL_TEMP1_tv1);
				tempMessageView.setText("Temp view");
				
				// declare an FTPClient obj
				FTPManager ftpMng = new FTPManager();
				
//				// connect to remote
//				ftpMng.ftpConnect();
				
//				//debug
				//debug
				TextView tempView = (TextView) findViewById(R.id.t2_LL_TEMP1_tv1);
//				String tempTxt = "FTPManager.ftpConnect()=" + FTPManager.ftpConnect(in);
				String tempTxt = FTPManager.ftpConnect(in);
				tempView.setText(tempTxt);
				
				// enable the button again
				uploadBtn.setText("Upload");
				uploadBtn.setEnabled(true);
//				uploadBtn.setText("Upload");
				
//				// debug
//				Toast.makeText(HomeBase2Activity.this, "Upload files", Toast.LENGTH_SHORT).show();
			}
        	
        });//t2_LL1_btn1.setOnClickListener()
        
        /* tab 3
         * 
         */
        // Set a listener: "Timer"
        Button t3_start_button = (Button) findViewById(R.id.t3_start_button);
        t3_start_button.setTag("timer");
        t3_start_button.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				if (timerStatus == 0) {
					// Change the timer status to 1
					timerStatus = 1;
					
					// Get the count down time
					Spinner spinner = (Spinner) findViewById(R.id.t3_selection);
					String selectedTime = (String) spinner.getSelectedItem();
					
					// Define timer manager
//					TimerManager tm = 
					tm = new TimerManager(Integer.parseInt(selectedTime) * 1000,
																1000, 
																HomeBase2Activity.this);
					// Start timer
					tm.start();
				} else if (timerStatus == 1) {//if (timerStatus == 0)
					mylib.MyLib.showToast(HomeBase2Activity.this, "Counting down !", 1);
				} else {//if (timerStatus == 0)
					mylib.MyLib.showToast(
										HomeBase2Activity.this, 
										"What's going on ? Timer status = " + timerStatus, 1);
				}//if (timerStatus == 0)
				
				
					
					
				
			}//public void onClick(View v)
        	
        });//t2_LL1_btn1.setOnClickListener()
        
     // Set a listener: "Stop"
        Button t3_stop_button = (Button) findViewById(R.id.t3_stop_button);
        t3_stop_button.setTag("timerStop");
        t3_stop_button.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// Cancel the timer
				if (timerStatus == 1) {
					// Cancel
					tm.cancel();
					
					// Set a message on the time view
					TextView tvTime = (TextView) findViewById(R.id.t3_time);
					tvTime.setText("Stopped counting down.");
					
					// Set the timer status back to 0
					timerStatus = 0;
					
				} else if (timerStatus == 0) {//if (timerStatus == 1)
					mylib.MyLib.showToast(
									HomeBase2Activity.this, 
									"Year, I'm not counting down.", 1);
				} else {//if (timerStatus == 1)
					mylib.MyLib.showToast(
									HomeBase2Activity.this, 
									"I'm confused. The status is: " + timerStatus, 1);
				}//if (timerStatus == 1)
				
			}//public void onClick(View v)
        	
        });//t2_LL1_btn1.setOnClickListener()
        
    }//public void onCreate(Bundle savedInstanceState)
    
    // onActivityResultメソッド(画面再表示時イベント)
 	@Override
 	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 			// 処理結果がOKの場合、処理終了
 			if (resultCode != RESULT_OK) {
 				// show message
				Toast.makeText(HomeBase2Activity.this, 
								"resultCode=" + String.valueOf(resultCode), 
								Toast.LENGTH_LONG).show();
 				return;
 			}
 			
 			// requestCode is REQUEST_CODE_GALLARY
 			if (requestCode == REQUEST_CODE_GALLARY) {

 				
 				try {
 					// open stream
//					InputStream in = getContentResolver().openInputStream(data.getData());
					in = getContentResolver().openInputStream(data.getData());

					// display image
					setPicture(BitmapFactory.decodeStream(in));
					
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					Log.e(getClass().getSimpleName(), "get image failed.", e);
				}

 			}//if (requestCode == REQUEST_CODE_GALLARY)

 	}

	private void setPicture(Bitmap picture) {
		// define picture
		this.picture = picture;
		
		// get a image view
		ImageView imageView = (ImageView) findViewById(R.id.t2_iv);
		
		// set image
		imageView.setImageBitmap(MyLib.resizePicture(picture, 180, 180));

	}

	public static void setTimerStatusToZero() {
		// TODO 自動生成されたメソッド・スタブ
		timerStatus = 0;
	}
}