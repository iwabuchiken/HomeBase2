package myapp.homebase2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener {

	// instance
	HomeBase2Activity context;
	
	public ButtonClickListener(HomeBase2Activity context) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.context = context;
	}

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		// tag
		 String tag	= (String)v.getTag();
		
		 // switching
		 if (tag.equals("generatePassword")) {
			showDialogPassword();
		} else {//if (tag.equalsIgnoreCase("generatePassword"))
			
		}//if (tag.equalsIgnoreCase("generatePassword"))

	}

	/**
	 * showDialogPassword()
	 * 
	 */
	// set vars
	/*
	 * "Alphabets only"	=> MyLib.PwdTypes.ALPHA = 0
	 * "Numbers only"	=> MyLib.PwdTypes.NUM = 1
	 * "Mixture"	=> MyLib.PwdTypes.ALNUM = 2
	 */
	final String[] items	= new String[]{
			"Alphabets only",
			"Numbers only",
			"Mixture"
	};
	
	final String[] lengths	= new String[]{
			"5", "7", "10"
	};
	
	// selected item id
	int which = 0;
	
	// password length
	int passwdLength = 5;		/* default length is 5		*/
	
	// method
	private void showDialogPassword() {
		// TODO 自動生成されたメソッド・スタブ
		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
		 // set title
		 dialog.setTitle("Generate a password");
		 
		 // set items: types
		 dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO 自動生成されたメソッド・スタブ
				which = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		 });//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		 
		 //set items: length
		 dialog.setSingleChoiceItems(lengths, 0, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int whichButton) {
					// TODO 自動生成されたメソッド・スタブ
					passwdLength = Integer.parseInt(lengths[whichButton]);
				}//public void onClick(DialogInterface dialog, int which)
			});//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		
		 // set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO 自動生成されたメソッド・スタブ
				// get a  text view
				TextView tv = (TextView) context.findViewById(R.id.t1_LL1_tv1);

				// set text
//				tv.setText(MyLib.generatePassword(which));
				tv.setText(MyLib.generatePassword(which, passwdLength));
				
			}//public void onClick()
		});//dialog.setPositiveButton()
		 
		 // show dialog		 
		 dialog.show();
		
	}//private void showDialogPassword()

}
