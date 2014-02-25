package ko.konata;

//import com.waps.AppConnect;
//import com.waps.UpdatePointsNotifier;

import ko.K;
import ko.KESourceComplete;
import ko.KEvent;
import ko.KSources;
import ko.util.KEventObject;
import ko.util.ParamImage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class TankeActivity  extends ko.KEngine {//implements UpdatePointsNotifier 
	public static TankeActivity T;
	final Handler mHandler = new Handler();
	
	public int pointTotal = 0;
	public String currencyName = "����";
	public String displayPointsText = "";
	
	public TankeActivity() {
		super(240, 400, 60, 0xff000000);
		T = this;
	}
	// ˢ�»���
//	public void OngetPoint(){
//		AppConnect.getInstance(this).getPoints(this);
//	}
	// ������� �û�����
//	public void OnShowFeedback() {
//		this.setRun(false);
//		AppConnect.getInstance(this).showFeedback();
//	}
	// ȡֵ�Ƿ񼤻�
	public void getPref(){
		SharedPreferences settings = getSharedPreferences(G.Dingdang, 0);  
		G.On = settings.getBoolean(G.IsOn, false);
	}
	// ����50����Ҽ�����Ϸ
//	public void OnSpendPoints(){
//		AppConnect.getInstance(this).spendPoints(50, this);
//		
//		SharedPreferences settings = getSharedPreferences(G.Dingdang, 0);  //
//		SharedPreferences.Editor editor = settings.edit();  
//		editor.putBoolean(G.IsOn, true);  
//		editor.commit();  
//		
//		getPref();
//	}
	// ��ʾҪ���ػ���
	public void OnShopPoint() {
		//this.setRun(false);
		
		Intent intent = new Intent();
        intent.setClass(TankeActivity.this, dilogActivity.class);
        startActivity(intent);
        //TankeActivity.this.finish();
	}
	// ��������� ȡ����
//	public void OnGetPoint() {		
//		this.setRun(false);
//		AppConnect.getInstance(TankeActivity.T).showOffers(TankeActivity.T);
//	}
//	class pointOnClickListener implements DialogInterface.OnClickListener
//	{
//		@Override
//		public void onClick(DialogInterface dialog, int which) {
//			AppConnect.getInstance(TankeActivity.this).showOffers(TankeActivity.this);
//		}
//	}
	public void getUpdatePoints(String currencyName, int pointTotal) {
		this.currencyName = currencyName;
		this.pointTotal = pointTotal;
		mHandler.post(mUpdateResults);
	}
	// ����һ���߳�  �������
	final Runnable mUpdateResults = new Runnable() {
		public void run() {
			displayPointsText = currencyName + ":" + pointTotal; 
			Log.i("point", currencyName + ": " + pointTotal);
		}
	};
	//
	@Override
	public void StartEngine() {
//		AppConnect.getInstance("78595aa9a44f6dc91b4c7108a6714b72", "WAPS", this);
//		// ʹ���Զ����OffersWebView
//		AppConnect.getInstance(this).setAdViewClassName("ko.konata.MyAdView");
//		// ���ô��󱨸�
//		AppConnect.getInstance(this).setCrashReport(false);
//		// �ֹ��Զ�����
//		if(G.On == false && TankeActivity.T.pointTotal >= 50){
//			TankeActivity.T.OnSpendPoints();
//		}
//		// ȡֵ�Ƿ񼤻�
//		getPref();
		
		
		KSources ks = new KSources();

		ks.addImages(new ParamImage(R.drawable.p001mono16, new Rect(0, 0, 16, 16)));
		ks.addImages(new ParamImage(R.drawable.p002mono32, new Rect(0, 0, 32, 32)));
		ks.addImages(new ParamImage(R.drawable.p003mono16, new Rect(0, 0, 16, 16)));
		ks.addImages(new ParamImage(R.drawable.p004map, new Rect(0, 0, 240, 400)));
		ks.addImages(new ParamImage(R.drawable.p005text8, new Rect(0, 0, 8, 8)));
		ks.addImages(new ParamImage(R.drawable.p006text16, new Rect(0, 0, 16, 16)));
		ks.addImages(new ParamImage(R.drawable.p007text32, new Rect(0, 0, 32, 32)));
		ks.addImages(new ParamImage(R.drawable.p008mono8, new Rect(0, 0, 8, 8)));
		ks.addImages(new ParamImage(R.drawable.p009map, new Rect(0, 0, 240, 400)));
		
		ks.addSounds(R.raw.m001bg);
		ks.addSounds(R.raw.m002start);
		ks.addSounds(R.raw.m003pow);
		ks.addSounds(R.raw.m004get);
		ks.addSounds(R.raw.m005up);
		ks.addSounds(R.raw.m006ding);
		ks.addSounds(R.raw.m007clier);
		ks.addSounds(R.raw.m008ite);
		ks.addSounds(R.raw.m009over);
		
		ks.addEventListener(KEvent.COMPLETE, new onComplete());
		ks.Load();
	}
	
	class onComplete extends KESourceComplete {
		@Override
		public void EventActivated(KEventObject e) {
			Log.i("A002Activity", "onComplete");
			
			Game.T = new Game();
			Game.T.Op();
		}
	}

//	@Override
//	protected void onResume() {
//		// �ӷ������˻�ȡ��ǰ�û����������.
//		// ���ؽ���ڻص�����getUpdatePoints(...)�д���
//		AppConnect.getInstance(this).getPoints(this);
//		super.onResume();
//	}
//	
	/* (non-Javadoc)
	 * @see ko.KEngine#onDestroy()
	 */
	@Override
	protected void onDestroy() {
//		AppConnect.getInstance(this).finalize();
		super.onDestroy();
		T = null;
	}
	/* (non-Javadoc)
	 * @see ko.KEngine#KEYCODE_HOME()
	 */
	@Override
	public boolean KEYCODE_HOME() {
		this.setRun(false);
		return super.KEYCODE_HOME();
	}
//	@Override
//	public void getUpdatePointsFailed(String error) {
//		displayPointsText = error;
//		mHandler.post(mUpdateResults);
//	}
}