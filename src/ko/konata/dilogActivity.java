package ko.konata;

import ko.KEngine;

//import com.waps.AppConnect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class dilogActivity extends Activity {
	private TextView textView1; 
	private Button button1; 
	private Button button2; 
	private Button button3; 
//	private KThread thread;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dilog);
		
//		thread = new KThread();
//		thread.start();
//		
		textView1 = (TextView) this.findViewById(R.id.textView1);
		
		
		button1 = (Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			 public void onClick(View v){
			     // ���
//				TankeActivity.T.OnGetPoint();
			 }
		 });
		
//		button2 = (Button) this.findViewById(R.id.button2);
//		button2.setOnClickListener(new OnClickListener(){
//			@Override
//			 public void onClick(View v){
//
//				if(G.On == false && TankeActivity.T.pointTotal >= 50){
//					TankeActivity.T.OnSpendPoints();
//				}
//				
//				if(G.On == true){	// ����ɹ�
//					Toast.makeText(dilogActivity.this, "����ɹ�,�����ڿ��Գ�����Ϸ!", Toast.LENGTH_LONG).show();
//				}else{// δ�ܳɹ�����,��������
//					Toast.makeText(dilogActivity.this, "δ�ܳɹ�����,���ֲ���������쳣!", Toast.LENGTH_LONG).show();
//				}
//				TankeActivity.T.OngetPoint();
//				textView1.setText("����ǰ" + TankeActivity.T.displayPointsText);
//			 }
//		 });
		
//		button3 = (Button) this.findViewById(R.id.button3);
//		button3.setOnClickListener(new OnClickListener(){
//			@Override
//			 public void onClick(View v){
//				TankeActivity.T.OngetPoint();
//				textView1.setText("����ǰ" + TankeActivity.T.displayPointsText);
//			 }
//		 });
	}
	
//	@Override 
//	public boolean onTouchEvent(MotionEvent event) {
//		// ȡ����
//		TankeActivity.T.OngetPoint();
//		// �Զ�����
//		if(G.On == false && TankeActivity.T.pointTotal >= 50){
//			TankeActivity.T.OnSpendPoints();
//		}
//		// ��ʾ��Ϣ
//		String str = TankeActivity.T.displayPointsText;
//		if(G.On == true) str = "��Ϸ�Ѽ���";
//		if(str == "") str = "����ͬ����...";	
//		textView1.setText(str);
//		return true;
//	} 
	
//	class KThread extends Thread {
//
//		public void run() {
//			Log.i("G.On" + String.valueOf(G.On)
//					, String.valueOf(TankeActivity.T.displayPointsText));
//			while (G.On == false || TankeActivity.T.displayPointsText == "") {
//				try {
//					// ȡ����
//					TankeActivity.T.OngetPoint();
//					// �Զ�����
//					if(G.On == false && TankeActivity.T.pointTotal >= 50){
//						TankeActivity.T.OnSpendPoints();
//					}
//					// ��ʾ��Ϣ
//					String str = TankeActivity.T.displayPointsText;
//					if(G.On == true) str = "��Ϸ�Ѽ���";
//					if(str == "") str = "����ͬ����...";
//					textView1.setText(str);
//					Thread.sleep(1500);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	@Override
	protected void onResume() {
//		thread = new KThread();
//		thread.start();
		super.onResume();
	}
}
