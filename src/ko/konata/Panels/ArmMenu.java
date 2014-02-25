package ko.konata.Panels;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import ko.K;
import ko.KEntity;
import ko.KHit;
import ko.KInput;
import ko.KSources;
import ko.konata.G;
import ko.konata.TextHelper;
import ko.konata.GConfig.CPlayer;
import ko.konata.helper.DrawMenuHelper;

public class ArmMenu extends KEntity {
	// private TextFormat tformat;
	private final int paddingH = 40;
	private final int paddingW = 40;
	private final int padding = 10;
	private final int rectW = 10 + paddingW;

	private ArrayList<Rect> rectList;

	public ArmMenu() {
		super(0, 0);
		this.x = 0;
		this.y = G.AndH - (paddingW + padding * 2);
		this.bitmapW = G.AndW;
		this.bitmapH = G.AndH;
		//
		InitRect();
		super.draw(0x00000000);
//		p.setColor(0);
//		c.drawRect(0, 0, this.bitmapW, this.bitmapH, p);
		
		c = new Canvas(this.renderData);
		// tformat = new TextFormat(null, 30);
	}

	private void InitRect() {
		rectList = new ArrayList<Rect>();
		for (int i = 0, count = 4; i < count; i++) {
			int sx = (int) (this.x + 25 + rectW * i);
			int ex = rectW;
			int sy = (int) (this.y + padding);
			int ey = (int) this.bitmapH;

			sx = (i == 0) ? 0 : sx;
			ex = (i == 0) ? ex + 25 : ex;

			ex = (i == 3) ? ex + paddingW : ex;

			rectList.add(new Rect(sx, sy, ex, ey));
		}
	}

	private Canvas c;
	private Paint p = new Paint();

	@Override
	public void draw(int color) {
		c.drawColor(Color.TRANSPARENT, Mode.CLEAR);
		for (int i = 0, count = 4; i < count; i++) {
			int tx = 25 + rectW * i;
			int ty = padding;
			// ÄÜÁ¿
			float ew = (float)( CPlayer.powEnergy.get(i) * 28 /  CPlayer.energyMax) ;
			p.setColor(0xff5294ef);
			c.drawRect(tx + 10, ty + 2, tx + 10 + ew, ty + 8, p);
			//
			c.drawBitmap(KSources.getBitmap(7, 0, 8), tx + 8 * 1, ty, null);
			c.drawBitmap(KSources.getBitmap(7, 1, 8), tx + 8 * 2, ty, null);
			c.drawBitmap(KSources.getBitmap(7, 1, 8), tx + 8 * 3, ty, null);
			c.drawBitmap(KSources.getBitmap(7, 2, 8), tx + 8 * 4, ty, null);
			
			if(CPlayer.SelectType != i){
				DrawMenuHelper.DrawMenu(c, 5, 5, 6, 5,tx,ty + 8);
			}else{
				DrawMenuHelper.DrawMenu(c, 5, 5, 3, 5,tx,ty + 8);
			}
			
			// ×Ö
			TextHelper.TextToDraw(String.valueOf(CPlayer.GetPowLevel(i)), 8, c, p, tx, ty);
			//
			c.drawBitmap(KSources.getBitmap(0, 0, i + 1), tx + 12,ty + 20,null);
			c.save();
		}
		c.restore();
	}

	// private Bitmap getBitmapData(Bitmap data, int color, int i) {
	// Canvas c = new Canvas(data);
	// Paint p = new Paint();
	// p.setColor(color);
	// c.drawRect(0f, 0f, (float) paddingW, (float) paddingH, p);
	// float ew = (CPlayer.powEnergy.get(i) / CPlayer.energyMax) * paddingW;
	// p.setColor(0xff00ff00);
	// c.drawRect(0f, 0f, ew, 10, p);
	//
	// String text = String.valueOf(CPlayer.GetPowLevel(i));
	// c.drawText(text, i, ew, p);
	//
	// return data;
	// }

	@Override
	public void update() {
		if (KInput.mouseDown == true) {
			for (int i = 0, count = 4; i < count; i++) {
				if (KHit.RectHitXY(rectList.get(i), KInput.mouseX(),
						KInput.mouseY()) == true) {
					CPlayer.SelectType = i;
					CPlayer.IsDrawArm = true;
					break;
				}
			}
		}
		EnergyUpdate();
	}

	private void EnergyUpdate() {
		int value;
		int index = CPlayer.powEnergy.size();
		while (index-- > 0) {
			value = CPlayer.powEnergy.get(index);
			CPlayer.powEnergy.set(index,
					(value < CPlayer.energyMax) ? value + 1 : value);
		}
	}

	@Override
	public void render() {
		draw(0x00000000);
	}
}
