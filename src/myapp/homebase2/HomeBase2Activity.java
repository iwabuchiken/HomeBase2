package myapp.homebase2;

import java.io.FileNotFoundException;
import java.io.InputStream;

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
import android.widget.TextView;
import android.widget.Toast;

public class HomeBase2Activity extends TabActivity {
	
	/* Request codes
	 * 
	 */
	// Gallery
	private static final int REQUEST_CODE_GALLARY = 0;
	
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

//			private static final int REQUEST_CODE_GALLARY = 0;

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
//				// debug
//				Toast.makeText(HomeBase2Activity.this, "Choose files", Toast.LENGTH_SHORT).show();
			}
        	
        });//t2_LL1_btn1.setOnClickListener()
        
        // Set listener: "Upload"
        Button t2_LL1_btn2 = (Button) findViewById(R.id.t2_LL1_btn2);
        t2_LL1_btn2.setTag("uploadFiles");
        t2_LL1_btn2.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// 
				// debug
				Toast.makeText(HomeBase2Activity.this, "Upload files", Toast.LENGTH_SHORT).show();
			}
        	
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
// 				//debug
// 				TextView tempView = (TextView) findViewById(R.id.t2_LL_TEMP1_tv1);
// 				String tempTxt = "data.getData()=" + data.getData().toString(); 
// 				tempView.setText(tempTxt);
 				
 				try {
 					// open stream
					InputStream in = getContentResolver().openInputStream(data.getData());
					
					//debug
					TextView tempView = (TextView) findViewById(R.id.t2_LL_TEMP1_tv1);
					String tempTxt = "in.toString=" + in.toString();
					tempView.setText(tempTxt);
					
					// display image
//					setPicture(BitmapFactory.decodeStream(in));
					
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					Log.e(getClass().getSimpleName(), "get image failed.", e);
				}
 				
// 				//debug
// 				TextView tempView = (TextView) findViewById(R.id.t2_LL_TEMP1_tv1);
// 				String tempTxt = "requestCode=" + String.valueOf(requestCode) +
//								"\n" +
//								"data=" + data.toString();
// 				tempView.setText(tempTxt);
// 				// debug
//				Toast.makeText(HomeBase2Activity.this, 
//								"requestCode=" + String.valueOf(requestCode) +
//								"\n" +
//								"data=" + data.toString(), 
//								Toast.LENGTH_LONG).show();
 			}//if (requestCode == REQUEST_CODE_GALLARY)
 			
// 		// debug
//		Toast.makeText(HomeBase2Activity.this, 
//						"resultCode=" + String.valueOf(resultCode) +
//						"\n" +
//						"RESULT_OK=" + String.valueOf(RESULT_OK) +
//						"\n" +
//						"(resultCode==RESULT_OK) = " + (resultCode == RESULT_OK), 
//						Toast.LENGTH_LONG).show();
 	}

	private void setPicture(Bitmap decodeStream) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}