package myapp.homebase2;

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
		// debug
//		Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
		
		// get a TextView object
		TextView tv1 = (TextView) context.findViewById(R.id.t1_LL1_tv1);
		
		// set a text
//		tv1.setText("YES");
		tv1.setText(MyLib.generatePassword());
		
	}

}
