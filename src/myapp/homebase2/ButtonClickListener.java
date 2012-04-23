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
		} else {//if (tag.equalsIgnoreCase("generatePassword"))
			
		}//if (tag.equalsIgnoreCase("generatePassword"))
		;
		
//		// debug
////		Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
//		
//		// get a TextView object
//		TextView tv1 = (TextView) context.findViewById(R.id.t1_LL1_tv1);
//		
//		// set a text
////		tv1.setText("YES");
//		tv1.setText(MyLib.generatePassword());
		
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
	
	// selected item id
	int which = 0;
	
	// method
	private void showDialogPassword() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		// define a dialog
		 AlertDialog.Builder dialog	= new AlertDialog.Builder(context);
		 
		 // set title
		 dialog.setTitle("Generate a password");
		 
		 // set items
		 dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				which = whichButton;
			}//public void onClick(DialogInterface dialog, int which)
		});//dialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
		
		 // set button
		 dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				// get the selected item
//				String selected = items[which];
				
				// set text
				TextView tv = (TextView) context.findViewById(R.id.t1_LL1_tv1);
//				tv.setText(selected);
				tv.setText(MyLib.generatePassword());
//				tv.setText(MyLib.generatePassword(MyLib.PwdTypes.ALPHA));
//				tv.setText(selected + "/" + "whichButton=" + String.valueOf(whichButton));
				
			}//public void onClick()
		});//dialog.setPositiveButton()
		 
		 // show dialog		 
		 dialog.show();
		
	}//private void showDialogPassword()

}
