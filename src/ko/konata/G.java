package ko.konata;

public class G {
	// 大小
	public static final int Size = 40 ;
	public static final int Size8 = 8;
	public static final int Size16 = 16;
	public static final int Size32 = 32;
	// 宽高 游戏
	public static final int AndW = 240;
	public static final int AndH = 400 ;
	public static final int OverX = -40 ;
	public static final int OverY = -40 ;
	public static final int OverW = 240  + 40;
	public static final int OverH = 400  + 40;
	// 宽高 空白右边
	public static final int MenuW = 200 ;
	public static final int MenuH = 400 ;
	// 图层
	public static final String LayerPig = "layerPig";
	public static final String LayerItem = "layerItem";
	public static final String LayerPow = "layerPow";
	public static final String LayerPanel = "layerPanel";
			
	// 生成怪时间
	public static int TimeMax = 10;
	public static int PigMax = 3;
	public static int PigRate = 1;
	//
	public static final String Dingdang = "DingDang";
	public static final String IsOn = "IsOn";
	public static boolean On = false;
	
	
	public static void CreateG() {
	}
}