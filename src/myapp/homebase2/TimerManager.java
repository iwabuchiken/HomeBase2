package myapp.homebase2;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import mylib.MyLib;


public class TimerManager extends CountDownTimer {

	// Context
	Context con;
	
	public TimerManager(long millisInFuture, long countDownInterval, Context con) {
		super(millisInFuture, countDownInterval);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
		this.con = con;
	}

	@Override
	public void onFinish() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		MyLib.showToast((Activity)con, "Done", 1);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		// Get the text view
		TextView tv = (TextView) ((Activity)con).findViewById(R.id.t3_time);
		
		// Set text
		tv.setText(String.valueOf(millisUntilFinished/1000));
	}

}
