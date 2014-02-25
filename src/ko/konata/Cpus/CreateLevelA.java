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
		//  ������ɳ�ʼ��	// ��ʱ��
		int timer = (int) Math.floor(CGame.timer);
		//��һʱ��� һ��
		if (timer > 0 && timer % timeMax == 1 && pigList.size() == 0) {
			// �ȼ�����
			CGame.Level = (int) (Math.floor(timer / timeMax) + 1);
			// �������
			int lel = (CGame.Level > 15) ? 15 : CGame.Level;
			int count = pigMax + CGame.Level * (pigRate + lel / 4);
			for (int i = 0; i < count; i++ ) {
				// ����
				pigList.add(pigRobot.RandomCreate());
			}
			Collections.sort(pigList, new MyComparator());
			// ����������
			K.game.add(new Bell(-1,0,0,0), G.LayerItem);
		}
		
	}

}
