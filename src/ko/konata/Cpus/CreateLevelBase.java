package ko.konata.Cpus;

import java.util.ArrayList;

import ko.K;
import ko.KEntity;
import ko.konata.G;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;
import ko.konata.Objs.ObjectPig;

public class CreateLevelBase extends KEntity {
	public ArrayList<ObjectPig> pigList;
	//
	public int timeMax;
	public int pigMax;
	public int pigRate;

	public PigRobotBase pigRobot;

	public CreateLevelBase() {
		pigList = new ArrayList<ObjectPig>();
		timeMax = G.TimeMax;
		pigMax = G.PigMax;
		pigRate = G.PigRate;
	}

	@Override
	public void update() {
		InitPigList();
		runPigList();
	}

	public void InitPigList() {
		return;
	}

	public void runPigList() {// 增加该出场 敌人
		if (pigList == null || pigList.size() == 0 || CPlayer.HP() == 0) return;
		if (CGame.timer >= pigList.get(0).spac) {
			K.game.add(pigList.remove(0).entity, G.LayerPig);
		}
	}

	@Override
	public void removed() {
		pigRobot = null;
	}
}
