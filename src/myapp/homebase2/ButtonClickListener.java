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

	// Choices for type
	final String[] typeItems = new String[]{
			"Alphabets only",
			"Numbers only",
			"Mixture"
	};//final String[] items

	// Choices for length
	final String[] lengthItems = new String[]{
			"5",
			"7",
			"10"
	};//final String[] items

	// chosen length for "Length" button
	int chosenLength = 0;		/* default is 0		*/
	
//	// Password types
//	enum PasswdType {
//		ALPHA, NUM, ALNUM
//	}
	
//	// Chosen type => default is ALPHA
//	PasswdType chosenType = PasswdType.ALPHA;
	
	public ButtonClickListener(HomeBase2Activity context) {
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
		this.context = context;
	}

	public void onClick(View v) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
				// TODO �����������ꂽ���\�b�h�E�X�^�u
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
	// Chosen item
	int chosenItem = 0;
	
//	// Choices
//	final String[] typeItems = new String[]{
//			"Alphabets only",
//			"Numbers only",
//			"Mixture"
//	};//final String[] items
			
	private void setType() {
		// Choices
		final String[] items = new String[]{
				"Alphabets only",
				"Numbers only",
				"Mixture"
		};//final String[] items
		
//		// Chosen item
//		int chosenItem = 0;
		
		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
		 // set title
		 dialog.setTitle("Choose the type");
		 
		 // set items: types
		 dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				chosenItem = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		 });//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		
		// set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// set value to the text view
				TextView tv = (TextView) context.findViewById(R.id.t1_LL2_tv1);
				tv.setText(typeItems[chosenItem]);
				
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
//		// selected item id
//		int which = 0;
		 
		 // set title
		 dialog.setTitle("Generate a password");
		 
		 // set items: types
		 dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				which = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		 });//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		 
		 //set items: length
		 dialog.setSingleChoiceItems(lengths, 0, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int whichButton) {
					// TODO �����������ꂽ���\�b�h�E�X�^�u
					passwdLength = Integer.parseInt(lengths[whichButton]);
				}//public void onClick(DialogInterface dialog, int which)
			});//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		
		 // set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
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
