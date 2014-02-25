package ko.konata.Cpus;

import java.util.ArrayList;
import java.util.Collections;

import android.util.Log;

import ko.K;
import ko.KEntity;
import ko.konata.G;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;
import ko.konata.Items.Bell;
import ko.konata.Objs.MyComparator;
import ko.konata.Objs.ObjectPig;

public class CreateLevelA extends CreateLevelBase {
	public CreateLevelA() {
		super();
		timeMax = 30;
		pigMax = 5;
		pigRate = 1;
		pigRobot = new PigRobotA(this);
	}

	@Override public void InitPigList()
	{
		//  随机生成初始怪	// 总时间
		int timer = (int) Math.floor(CGame.timer);
		//到一时间段 一次
		if (timer > 0 && timer % timeMax == 1 && pigList.size() == 0) {
			// 等级提升
			CGame.Level = (int) (Math.floor(timer / timeMax) + 1);
			// 随机数量
			int lel = (CGame.Level > 15) ? 15 : CGame.Level;
			int count = pigMax + CGame.Level * (pigRate + lel / 4);
			for (int i = 0; i < count; i++ ) {
				// 核心
				pigList.add(pigRobot.RandomCreate());
			}
			Collections.sort(pigList, new MyComparator());
			// 升级送内容
			K.game.add(new Bell(-1,0,0,0), G.LayerItem);
		}
		
	}

}
