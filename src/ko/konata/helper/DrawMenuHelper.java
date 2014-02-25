package ko.konata.helper;

import ko.KSources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;

public class DrawMenuHelper {
	public static void DrawMenu(Canvas can, int countX, int countY, int bx,
			int by, int x, int y) {
		int b0 = 0 + bx, b1 = 1 + bx, b2 = 2 + bx, c0 = 0 + by, c1 = 1 + by, c2 = 2 + by;

		Bitmap bmp1 = KSources.getBitmap(4, b0, c0);// 7
		Bitmap bmp2 = KSources.getBitmap(4, b2, c0);// 9
		Bitmap bmp3 = KSources.getBitmap(4, b0, c2);// 1
		Bitmap bmp4 = KSources.getBitmap(4, b2, c2);// 3
		Bitmap bmp5 = KSources.getBitmap(4, b1, c0);// 8
		Bitmap bmp6 = KSources.getBitmap(4, b1, c2);// 2
		Bitmap bmp7 = KSources.getBitmap(4, b0, c1);// 4
		Bitmap bmp8 = KSources.getBitmap(4, b2, c1);// 6
		Bitmap bmp9 = KSources.getBitmap(4, b1, c1);// 5

		int i, j;
		float tx, ty;
		for (i = 0; i < countX; i++) {
			for (j = 0; j < countY; j++) {
				if (i > 0 && i < countX - 1) {
					if (j == 0) {
						tx = i * bmp1.getWidth();
						ty = 0;
						can.drawBitmap(bmp5, x + tx, y + ty, null);
					} else if (j == countY - 1) {
						tx = i * bmp1.getWidth();
						ty = j * bmp1.getHeight();
						can.drawBitmap(bmp6, x + tx, y + ty, null);
					}
					//
				} else if (j > 0 && j < countY - 1) {
					if (i == 0) {
						tx = 0;
						ty = j * bmp1.getHeight();
						can.drawBitmap(bmp7, x + tx, y + ty, null);
					} else if (i == countX - 1) {
						tx = i * bmp1.getWidth();
						ty = j * bmp1.getHeight();
						can.drawBitmap(bmp8, x + tx, y + ty, null);
					}
				}
				if (i > 0 && i < countX - 1 && j > 0 && j < countY - 1) {
					tx = i * bmp1.getWidth();
					ty = j * bmp1.getHeight();
					can.drawBitmap(bmp9, x + tx, y + ty, null);
				}
			}
		}
		int w = countX * bmp1.getWidth(),
			h = countY * bmp1.getHeight();
		can.drawBitmap(bmp1, x + 0, y + 0, null);
		tx = w - bmp1.getWidth();
		can.drawBitmap(bmp2, x + tx, y + 0, null);
		tx = 0;
		ty = h - bmp1.getHeight();
		can.drawBitmap(bmp3, x + tx, y + ty, null);
		tx = w - bmp1.getWidth();
		ty = h - bmp1.getHeight();
		can.drawBitmap(bmp4, x + tx, y + ty, null);
	}
}
