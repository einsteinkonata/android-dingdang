package ko.konata.Panels;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Region.Op;
import ko.K;
import ko.KEntity;
import ko.KSources;
import ko.konata.G;
import ko.konata.TextHelper;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;

public class MessagePanel extends KEntity {
	private int paddingH = 40;
	private int paddingW = G.AndW;
	private int padding = 10;
	private String timeText;
	private String pointText;

	public MessagePanel() {
		super(0, 0);
		this.bitmapW = paddingW;
		this.bitmapH = paddingH;

		super.draw(0);
		setTimeText();
	}

	@Override
	public void update() {
		CGame.timer += K.elapsed;
		setTimeText();
	}

	private void setTimeText() {
		timeText = String.valueOf((int) CGame.timer);
		timeText = timeText.length() == 1 ? "00" + timeText
				: timeText.length() == 2 ? "0" + timeText : timeText;
	}

	@Override
	public void draw(int color) {
		c.drawColor(Color.TRANSPARENT, Mode.CLEAR);
		
		DrawLevel();
		DrawPoint();
		DrawTime();
		DrawHP();
	}

	private void DrawLevel() {
		int size = 8;
		String lvText = "LV-" + CGame.Level;
		int tx = padding * 2;
		int ty = padding;
		TextHelper.TextToDraw(lvText, size, c, p, tx, ty);
	}

	private void DrawPoint() {
		int size = 8;
		pointText = "";
		int i = String.valueOf(CGame.point).length();
		for (; i < 6; i++) {
			pointText += "0";
		}
		pointText += String.valueOf(CGame.point).toString();

		int tx = padding * 2;
		int ty = padding + size;
		TextHelper.TextToDraw(pointText, size, c, p, tx, ty);

		pointText = timeText.length() == 1 ? "00" + timeText : timeText
				.length() == 2 ? "0" + timeText : timeText;
	}

	private void DrawTime() {
		int size = 16;
		int sizeW = timeText.length() * size;
		int sizeH = size;
		int maxW = 3 * sizeH;
		int tx = (3 - (sizeW / sizeH)) * sizeH
				+ G.AndW / 2 - maxW / 2;
		int ty = padding;
		TextHelper.TextToDraw(timeText, 16, c, p, tx, ty);
	}

	private void DrawHP() {
		int count = CPlayer.HP();
		for (int i = 0; i < count; i++) {
			int tx = G.AndW - (16 * (i + 1) + padding * 2);
			int ty = padding + 1;
			c.drawBitmap(KSources.getBitmap(2, 9, 9),tx,ty,null);
		}
	}

	@Override
	public void render() {
		draw(0);
	}
}
