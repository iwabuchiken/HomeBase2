package myapp.homebase2;


//import myapp.youtubeviewer.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;


public class TabUtils {

	// get a TabHost
    static TabHost tabHost;// = new TabActivity().getTabHost();
    
    // onCreate
    public void onCreate(Bundle savedInstanceState) {
    	
    }//public void onCreate(Bundle savedInstanceState)
    
    public static void createTabs(HomeBase2Activity mainActivity) {
    	// tabHost
//    	tabHost = new TabActivity().getTabHost();
    	tabHost = mainActivity.getTabHost();
    	
    	// inflater
    	LayoutInflater.from(mainActivity)
    				.inflate(R.layout.homebase, 
    						tabHost.getTabContentView(), true);
 
    	// �^�u1�̐ݒ�
        TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setIndicator("Timer1");
        tab1.setContent(R.id.tab1);
        
        // �^�u2�̐ݒ�
        TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setIndicator("Timer2",mainActivity.getResources().getDrawable(android.R.drawable.ic_menu_edit));
        tab2.setContent(R.id.tab2);

        // �^�u3�̐ݒ�
        TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setIndicator("Timer3",mainActivity.getResources().getDrawable(android.R.drawable.ic_menu_search));
        tab3.setContent(R.id.tab3);

        // �e�^�u��TabHost�ɐݒ�
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

        // �����\���̃^�u�ݒ�
        tabHost.setCurrentTab(1);
 
    }

    public static void createTabsN(HomeBase2Activity mainActivity, int number) {
    	// tabHost
//    	tabHost = new TabActivity().getTabHost();
    	tabHost = mainActivity.getTabHost();
    	
    	// inflater
    	LayoutInflater.from(mainActivity)
    				.inflate(R.layout.homebase, 
    						tabHost.getTabContentView(), true);
 
    	//debug
    	TabSpec[] tabs = new TabSpec[number];
    	
//    	for (int i = 0; i < tabs.length; i++) {
    	for (int i = 0; i < tabs.length; i++) {
			tabs[i] = tabHost.newTabSpec("tab" + String.valueOf(i));
			tabs[i].setIndicator(
							"Timer" + String.valueOf(i),
							mainActivity.getResources().getDrawable(android.R.drawable.ic_menu_edit));
//			tabs[i].setContent((new MyLib().getIdMap()).get(i).intValue());
			tabs[i].setContent(new MyLib().getIdMap().get(i).intValue());
		}
    	
    	for (int i = 0; i < tabs.length; i++) {
    		tabHost.addTab(tabs[i]);
		}
    	
//    	// debug
//		Toast.makeText(mainActivity,
////				"hello",
//				String.valueOf(new MyLib().getIdMap().get(1).intValue()),
//				Toast.LENGTH_SHORT).show();
    	
//    	// �^�u1�̐ݒ�
//        TabSpec tab1 = tabHost.newTabSpec("tab1");
//        tab1.setIndicator("Timer1");
////        tab1.setContent(R.id.tab1);
//        tab1.setContent(new MyLib().getIdMap().get(1).intValue());
//
//        // �^�u2�̐ݒ�
//        TabSpec tab2 = tabHost.newTabSpec("tab2");
//        tab2.setIndicator("Timer2",mainActivity.getResources().getDrawable(android.R.drawable.ic_menu_edit));
//        tab2.setContent(R.id.tab2);
//
//        // �^�u3�̐ݒ�
//        TabSpec tab3 = tabHost.newTabSpec("tab3");
//        tab3.setIndicator("Timer3",mainActivity.getResources().getDrawable(android.R.drawable.ic_menu_search));
//        tab3.setContent(R.id.tab3);
//
//        // �e�^�u��TabHost�ɐݒ�
//        tabHost.addTab(tab1);
//        tabHost.addTab(tab2);
//        tabHost.addTab(tab3);

        // �����\���̃^�u�ݒ�
        tabHost.setCurrentTab(2);
 
    }//public static void createTabsN(HomeBaseActivity mainActivity, int number)

}
