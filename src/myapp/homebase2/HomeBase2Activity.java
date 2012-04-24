package myapp.homebase2;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeBase2Activity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // create tabs
        TabUtils.createTabsN(this, 3);
        
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
    }
}