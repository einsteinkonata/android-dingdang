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
			     // 广告
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
//				if(G.On == true){	// 激活成功
//					Toast.makeText(dilogActivity.this, "激活成功,您现在可以畅玩游戏!", Toast.LENGTH_LONG).show();
//				}else{// 未能成功激活,请检查网络
//					Toast.makeText(dilogActivity.this, "未能成功激活,积分不足或网络异常!", Toast.LENGTH_LONG).show();
//				}
//				TankeActivity.T.OngetPoint();
//				textView1.setText("您当前" + TankeActivity.T.displayPointsText);
//			 }
//		 });
		
//		button3 = (Button) this.findViewById(R.id.button3);
//		button3.setOnClickListener(new OnClickListener(){
//			@Override
//			 public void onClick(View v){
//				TankeActivity.T.OngetPoint();
//				textView1.setText("您当前" + TankeActivity.T.displayPointsText);
//			 }
//		 });
	}
	
//	@Override 
//	public boolean onTouchEvent(MotionEvent event) {
//		// 取积分
//		TankeActivity.T.OngetPoint();
//		// 自动激活
//		if(G.On == false && TankeActivity.T.pointTotal >= 50){
//			TankeActivity.T.OnSpendPoints();
//		}
//		// 显示信息
//		String str = TankeActivity.T.displayPointsText;
//		if(G.On == true) str = "游戏已激活";
//		if(str == "") str = "积分同步中...";	
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
//					// 取积分
//					TankeActivity.T.OngetPoint();
//					// 自动激活
//					if(G.On == false && TankeActivity.T.pointTotal >= 50){
//						TankeActivity.T.OnSpendPoints();
//					}
//					// 显示信息
//					String str = TankeActivity.T.displayPointsText;
//					if(G.On == true) str = "游戏已激活";
//					if(str == "") str = "积分同步中...";
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
