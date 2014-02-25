package ko.konata;

import java.util.ArrayList;
import java.util.Hashtable;

import ko.KSources;
import android.graphics.Canvas;
import android.graphics.Paint;

public class TextHelper {
	private static Hashtable<String, Integer> modeList;
	public static void CreateTextDic() {
		modeList = new Hashtable<String, Integer>();
		modeList.put("a", 0);modeList.put("k", 1); modeList.put("u", 2);
		modeList.put("b", 10);modeList.put("l", 11); modeList.put("v", 12);
		modeList.put("c", 20); modeList.put("m", 21); modeList.put("w", 22);			
		modeList.put("d", 30); modeList.put("n", 31); modeList.put("x", 32);
		modeList.put("e", 40); modeList.put("o", 41); modeList.put("y", 42);			
		modeList.put("f", 50); modeList.put("p", 51); modeList.put("z", 52);
		modeList.put("g", 60); modeList.put("q", 61); modeList.put("!", 62);
		modeList.put("h", 70); modeList.put("r", 71); modeList.put("?", 72);
		modeList.put("i", 80); modeList.put("s", 81); modeList.put("-", 82);
		modeList.put("j", 90); modeList.put("t", 91); modeList.put(".", 92);
		//
		modeList.put("0", 3); modeList.put("4", 43); modeList.put("8", 83);
		modeList.put("1", 13); modeList.put("5", 53); modeList.put("9", 93);
		modeList.put("2", 23); modeList.put("6", 63); modeList.put(" ", 99);
		modeList.put("3", 33); modeList.put("7", 73);
	}
	//str:String = "", size:int = 8)
	public static void TextToDraw(String str, int size,Canvas c,Paint p, int tx,int ty) {
		if (str == null || str.length() == 0 || c == null) return;
		str = str.toLowerCase();
		int index0 = (size == 16) ? 005 : (size == 32) ? 006 : 004;
		ArrayList<String> strList = new ArrayList<String>();
		String chr;
		int i;
		
		for (i = 0; i < str.length(); i++) {
			chr = str.substring(i, i+1);
			strList.add(chr);
		}

		for (i = 0; i < strList.size(); i++) {
			chr = strList.get(i);
			int param = modeList.get(chr);
			int index1 = (int) Math.floor((param % 100) / 10);
			int index2 = (int) Math.floor(param % 10);

			c.drawBitmap(KSources.getBitmap(index0, index1, index2),tx + i * size, ty, null);
		}
	}
}
