package myapp.homebase2;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeBase2Activity extends TabActivity {
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

			private static final int REQUEST_CODE_GALLARY = 0;

			public void onClick(View v) {
				// �C���e���g����
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				// �C���e���g�^�C�v���摜�Őݒ�
				intent.setType("image/*");
				// �M�������[�N��
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
}