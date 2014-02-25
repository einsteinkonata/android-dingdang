package ko.konata.Panels;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import ko.K;
import ko.KEntity;
import ko.KHit;
import ko.KInput;
import ko.KSources;
import ko.konata.G;
import ko.konata.Game;
import ko.konata.TextHelper;
import ko.konata.GConfig.CGame;
import ko.konata.helper.DrawMenuHelper;

public class GameOver extends KEntity {
	private int padding = 16;
	private Bitmap menu;
	private Bitmap button1;
	private Bitmap button2;
	private Matrix matrixButton;
	private Matrix matrixText;
	private Rect rect;
	
	private String endLv;
	private String endTime;
	private String endPoint;
	// lv  point
	private int viewIndex = 0;
	private int viewMax = 15;
	public GameOver() {
		this.bitmapW = 11 * G.Size16;
		this.bitmapH = 9 * G.Size16;
		this.x = (G.AndW - this.bitmapW) / 2;
		this.y = 80;
		
		endLv = String.valueOf(CGame.Level);
		endTime = String.valueOf((int)(CGame.timer));
		endPoint = String.valueOf(CGame.point);

		super.draw(0);

		InitButton();
		InitMenu();
		
		ko.KSources.play("m009over");
	}

	@Override
	public void update() {
		DrawMenu();
		DrawGameOver();
		DrawMessage();

		if (KInput.mouseUp == true 
			&& (viewIndex > viewMax * 4)
			&& KHit.RectHitXY(rect, KInput.mouseX(), KInput.mouseY()) == true) {
			KInput.mouseUp = false;
			K.game.removeAll();
			Game.T.Op();
		}
	}

	private void InitButton() {
		final int size = 32;
		int w = 3 * size;
		int h = size;
		int bx = (int) ((this.bitmapW - w) / 2);
		int by = (int) this.bitmapH - (padding + G.Size32);
		rect = new Rect((int) this.x + bx, (int) this.y + by, w, h);
		button1 = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		button2 = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas cb1 = new Canvas(button1);
		Canvas cb2 = new Canvas(button2);
		Bitmap d1 = KSources.getBitmap(1, 0, 9);
		Bitmap d2 = KSources.getBitmap(1, 1, 9);
		Bitmap d3 = KSources.getBitmap(1, 2, 9);
		//
		Bitmap d4 = KSources.getBitmap(1, 3, 9);
		Bitmap d5 = KSources.getBitmap(1, 4, 9);
		Bitmap d6 = KSources.getBitmap(1, 5, 9);
		//
		int tx = 0, ty = 0;
		cb1.drawBitmap(d1, 0, 0, null);
		cb2.drawBitmap(d4, tx, 0, null);
		tx += size;
		cb1.drawBitmap(d2, tx, 0, null);
		cb2.drawBitmap(d5, tx, 0, null);
		tx += size;
		cb1.drawBitmap(d3, tx, 0, null);
		cb2.drawBitmap(d6, tx, 0, null);

		matrixText = new Matrix();
		tx = 8 * 3;
		ty = 12;
		matrixText.setTranslate(tx, ty);

		TextHelper.TextToDraw("return", 8, cb1, p, tx, ty);
		TextHelper.TextToDraw("return", 8, cb2, p, tx, ty);

		matrixButton = new Matrix();
		matrixButton.setTranslate(bx, by);
	}
	
	private void DrawMessage()
	{
		if (viewIndex > viewMax) DrawLv();
		if (viewIndex > viewMax * 2) DrawTime();
		if (viewIndex > viewMax * 3) DrawPoint();
		if (viewIndex > viewMax * 4) DrawButton();
		viewIndex += 1;
	}
	private final int sizeTxt = G.Size8;
	private void DrawPoint()
	{
		String str = "Point ";
		TextHelper.TextToDraw(str + endPoint, 8, c, p, 
				(int)this.bitmapW / 2 - (str.length() - 1) * sizeTxt
				, padding + 4 * G.Size16);
	}
	
	private void DrawTime()
	{
		String str = "Time ";
		TextHelper.TextToDraw(str + endTime, 8, c, p, 
				(int)this.bitmapW / 2 - (str.length() - 1) * sizeTxt
				, padding + 3 * G.Size16);
	}
	
	private void DrawLv() 
	{
		String str = "LV ";
		TextHelper.TextToDraw(str + endLv, 8, c, p, 
				(int)this.bitmapW / 2 - (str.length() - 1) * sizeTxt
				, padding + 2 * G.Size16);
	}
	private void DrawMenu() {
		c.drawColor(Color.TRANSPARENT, Mode.CLEAR);
		if (menu != null){
			c.drawBitmap(menu, 0, 0, null);
		}
	}

	private void DrawGameOver() {
		TextHelper.TextToDraw("game over", 16, c, p, padding, padding);
	}

	private void DrawButton() {
		if (KInput.mouseDown == true) {
			c.drawBitmap(button1, matrixButton, null);
		} else {
			c.drawBitmap(button2, matrixButton, null);
		}
	}

	private void InitMenu() {
		menu = this.renderData.copy(Config.ARGB_8888, true);
		Canvas c2 = new Canvas(menu);
		DrawMenuHelper.DrawMenu(c2, 22, 18, 0, 5,0,0);
	}
}
