package myapp.homebase2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener {

	// instance
	HomeBase2Activity context;

	// Choices for type
	static String[] typeItems;

	// Choices for length
	final String[] lengthItems = new String[]{
			"5",
			"7",
			"10"
	};//final String[] items

	// Chosen item
	int chosenType = -1;

	// chosen length for "Length" button
	int chosenLength = -1;		/* default is 0		*/

	private static void setTypeItems(Context context) {
		typeItems = new String[]{
			MyLib.getString(context, R.string.password_type_alphabet),
			MyLib.getString(context, R.string.password_type_number),
			MyLib.getString(context, R.string.password_type_alnum)

		};//final String[] typeItems
	}
	
	public ButtonClickListener(HomeBase2Activity context) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.context = context;

		setTypeItems(context);
	}

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		// tag
		 String tag	= (String)v.getTag();
		
		 // switching
		 if (tag.equals("generatePassword")) {
			showDialogPassword();
		} else if (tag.equals("setType")) {//if (tag.equalsIgnoreCase("generatePassword"))
			setType();
		} else if (tag.equals("setLength")) {//if (tag.equalsIgnoreCase("generatePassword"))
			setLength();
		}//if (tag.equalsIgnoreCase("generatePassword"))

	}

	private void setLength() {
		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
		 // set title
		 dialog.setTitle("Choose the length");
		 
		 // set items: types
		 dialog.setSingleChoiceItems(lengthItems, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO 自動生成されたメソッド・スタブ
				chosenLength = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		 });//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		
		// set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {

				// set value to the text view
				TextView tv = (TextView) context.findViewById(R.id.t1_LL3_tv1);
				tv.setText(lengthItems[chosenLength]);
				
			}//public void onClick()
		 });//dialog.setPositiveButton()
		 
		 // show dialog
		 dialog.show();
		
	}//private void setLength()

	/* setType()
	 * 
	 */

	private void setType() {

		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
		 // set title
		 dialog.setTitle("Choose the type");
		 
		 // set items: types
		 dialog.setSingleChoiceItems(typeItems, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO 自動生成されたメソッド・スタブ
				chosenType = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		 });//dialog.setSingleChoiceItems(typeItems, 0, new DialogInterface.OnClickListener()
		
		// set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {

				// set value to the text view
				TextView tv = (TextView) context.findViewById(R.id.t1_LL2_tv1);
				tv.setText(typeItems[chosenType]);
				
			}//public void onClick()
		 });//dialog.setPositiveButton()
		 
		 // show dialog
		 dialog.show();
		 
	}//private void setType()

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

	final String[] lengths	= new String[]{
			"5", "7", "10"
	};
	
	// selected item id
	int which = 0;
	
	// password length
	int passwdLength = 5;		/* default length is 5		*/
	
	// method
	private void showDialogPassword() {
		
		// get a  text view

		// Get from the text views: type and number
		TextView tvNumber = (TextView) context.findViewById(R.id.t1_LL3_tv1);
		TextView tvType = (TextView) context.findViewById(R.id.t1_LL2_tv1);
		
		// Choices done?
		// message string
		String tempMessage = null;
		
		// judge: if not chosen, then return
		if (tvType.getText().toString() == MyLib.getString(context, R.string.txt_t1_LL2_tv1)
				&& tvNumber.getText().toString() == MyLib.getString(context, R.string.txt_t1_LL3_tv1)) {
			// set message
			tempMessage = "Please choose type and number";
		} else if (tvType.getText().toString() == MyLib.getString(context, R.string.txt_t1_LL2_tv1)) {
			// set message
			tempMessage = "Please choose type";

		} else if (tvNumber.getText().toString() == MyLib.getString(context, R.string.txt_t1_LL3_tv1)) {
			// set message
			tempMessage = "Please choose number";
		}
		
		if (tempMessage != null) {

			return;
		}//if (tempMessage != null)

		// get a  text view: Generate password
		TextView tvPasswd = (TextView) context.findViewById(R.id.t1_LL1_tv1);
		
		// get index of type
		int tempNum = getArrayIndex(typeItems, tvType.getText().toString());
		if (tempNum == -1) {
			tempNum = 0;
		}//if (tempNum == -1)

		tvPasswd.setText(

				MyLib.generatePassword(
													getArrayIndex(typeItems, tvType.getText().toString()), 
													Integer.parseInt(tvNumber.getText().toString()))

				);

		// set text

	}//private void showDialogPassword()

	private int getArrayIndex(String[] items, String target) {
		// 
		for (int i = 0; i < items.length; i++) {

			if (items[i].equals(target)) {
				return i;
			}//if (items[i] == target)
		}//for (int i = 0; i < items.length; i++)
		return -1;
	}

}
