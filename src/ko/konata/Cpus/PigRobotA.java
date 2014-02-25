package ko.konata.Cpus;

import ko.K;
import ko.KEntity;
import ko.konata.GConfig.CGame;
import ko.konata.Monos.PigA;
import ko.konata.Monos.PigB;
import ko.konata.Monos.PigC;
import ko.konata.Objs.ObjectPig;

public class PigRobotA extends PigRobotBase {
	public PigRobotA(CreateLevelBase cl) {
		CL = cl;
		
	}
	
	@Override public ObjectPig RandomCreate() {
		ObjectPig obj = new ObjectPig();
		// 随机敌人
		obj.entity = RandomPig();
		// 随机时间
		obj.spac = (float) (Math.random() * CL.timeMax);// 30 分钟 毫秒
		obj.spac += ((CGame.Level - 1) * CL.timeMax); // 加最大时间
		return obj;
	}
	
	private KEntity RandomPig() {// 随机敌人
		KEntity entity = null;
		int index = K.randomInt(2);
		//return new PigA();		// test
		switch (index) {
			case 0:				//	entity = RandomPigA(); 默认
			break;
			case 1:
				entity = new PigB();
			break;
			case 2:
				entity = new PigC();
			break;
		}
		return (entity == null) ? new PigA() : entity;
	}
}