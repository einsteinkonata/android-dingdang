package ko.konata.Panels;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import ko.KEntity;
import ko.KHit;
import ko.KInput;
import ko.KSources;
import ko.konata.G;
import ko.konata.Game;
import ko.konata.TankeActivity;
import ko.konata.TextHelper;

public class GameStart extends KEntity {
	private Bitmap bg;
	private Bitmap button1Down;
	private Bitmap button1Up;
	private Matrix button1Matrix;
	private Rect button1Rect;
	private String button1Text = "play";
	
	
	private String button2Text = "feedback";
	private Matrix button2Matrix;
	private Rect button2Rect;
	private Bitmap button2Up;
	private Bitmap button2Down;

	public GameStart() {
		this.bitmapW = G.AndW;
		this.bitmapH = G.AndH;
		
		super.draw(0);
		
		InitDraw();
	}

	private void InitDraw() {
		bg = KSources.getBitmap(8).copy(Config.ARGB_8888, true);
		InitButton();
		InitButton2();
		
		
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//    	builder.setTitle("免费获取积分");
//    	builder.setMessage("50点积分即可永久使用此应用,点击确定,进入积分商店!/n/r您的当前积分：" + String.valueOf(pointTotal));
	}

	private void InitButton() {
		int w = 3 * G.Size32;
		int h = G.Size32;
		int bx = (int) ((this.bitmapW - w) / 2);
		int by = (int) (this.bitmapH - (5 * G.Size32));
		button1Matrix = new Matrix();
		button1Matrix.setTranslate(bx, by);
		button1Rect = new Rect((int) this.x + bx, (int) this.y + by, w, h);

		button1Up = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		button1Down = button1Up.copy(Config.ARGB_8888, true);
		Canvas cb1 = new Canvas(button1Down);
		Canvas cb2 = new Canvas(button1Up);

		Bitmap d1 = KSources.getBitmap(1, 0, 9);// 1
		Bitmap d2 = KSources.getBitmap(1, 1, 9);// 2
		Bitmap d3 = KSources.getBitmap(1, 2, 9);// 3
		//
		Bitmap d4 = KSources.getBitmap(1, 3, 9);// 1
		Bitmap d5 = KSources.getBitmap(1, 4, 9);// 2
		Bitmap d6 = KSources.getBitmap(1, 5, 9);// 3

		int tx = 0, ty = 0;
		cb1.drawBitmap(d1, 0, 0, null);
		cb2.drawBitmap(d4, 0, 0, null);
		tx += G.Size32;
		cb1.drawBitmap(d2, tx, 0, null);
		cb2.drawBitmap(d5, tx, 0, null);
		tx += G.Size32;
		cb1.drawBitmap(d3, tx, 0, null);
		cb2.drawBitmap(d6, tx, 0, null);

		tx = 4 * G.Size8;
		ty = 12;
		TextHelper.TextToDraw(button1Text, 8, cb1, p, tx, ty);
		TextHelper.TextToDraw(button1Text, 8, cb2, p, tx, ty);
	}
	
	private void InitButton2() {
		int w = 3 * G.Size32;
		int h = G.Size32;
		int bx = (int) ((this.bitmapW - w) / 2);
		int by = (int) (this.bitmapH - (3 * G.Size32));
		button2Matrix = new Matrix();
		button2Matrix.setTranslate(bx, by);
		button2Rect = new Rect((int) this.x + bx, (int) this.y + by, w, h);

		button2Up = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		button2Down = button2Up.copy(Config.ARGB_8888, true);
		Canvas cb1 = new Canvas(button2Down);
		Canvas cb2 = new Canvas(button2Up);

		Bitmap d1 = KSources.getBitmap(1, 0, 9);// 1
		Bitmap d2 = KSources.getBitmap(1, 1, 9);// 2
		Bitmap d3 = KSources.getBitmap(1, 2, 9);// 3
		//
		Bitmap d4 = KSources.getBitmap(1, 3, 9);// 1
		Bitmap d5 = KSources.getBitmap(1, 4, 9);// 2
		Bitmap d6 = KSources.getBitmap(1, 5, 9);// 3

		int tx = 0, ty = 0;
		cb1.drawBitmap(d1, 0, 0, null);
		cb2.drawBitmap(d4, 0, 0, null);
		tx += G.Size32;
		cb1.drawBitmap(d2, tx, 0, null);
		cb2.drawBitmap(d5, tx, 0, null);
		tx += G.Size32;
		cb1.drawBitmap(d3, tx, 0, null);
		cb2.drawBitmap(d6, tx, 0, null);

		tx = 2 * G.Size8;
		ty = 12;
		TextHelper.TextToDraw(button2Text, 8, cb1, p, tx, ty);
		TextHelper.TextToDraw(button2Text, 8, cb2, p, tx, ty);
	}

	@Override
	public void update() {
		draw(0);
		
		if (KInput.mouseUp == true) {
			KInput.mouseUp = false;
			if(KHit.RectHitXY(button1Rect, KInput.mouseX(), KInput.mouseY()) == true) {
				//弹出窗		钱不够
//				if(G.On == false) {
//					TankeActivity.T.OnShopPoint();
//					return;
//				}
				Game.T.Start();
				KSources.play("m002start");
			}
//			else if(KHit.RectHitXY(button2Rect, KInput.mouseX(), KInput.mouseY()) == true) {
//			//  	用户反馈
////				TankeActivity.T.OnShowFeedback();
//			}else{
////				if(G.On == false) {
////					TankeActivity.T.OnShopPoint();
////				}
//			}
		}
	}

	@Override
	public void draw(int color) {
		c.drawBitmap(bg, 0, 0, null);
		DrawButton();
	}

	private void DrawButton() {
		if (KInput.mouseDown == true) {
			c.drawBitmap(button1Down, button1Matrix,null);
		}else {
			c.drawBitmap(button1Up, button1Matrix,null);
		}
		
		if(KInput.mouseDown == true
			&& KHit.RectHitXY(button2Rect, KInput.mouseX(), KInput.mouseY()) == true) {
			c.drawBitmap(button2Down, button2Matrix,null);
		}
		else{
			c.drawBitmap(button2Up, button2Matrix,null);
		}
	}
}
