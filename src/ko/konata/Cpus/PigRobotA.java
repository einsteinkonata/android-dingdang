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
		// �������
		obj.entity = RandomPig();
		// ���ʱ��
		obj.spac = (float) (Math.random() * CL.timeMax);// 30 ���� ����
		obj.spac += ((CGame.Level - 1) * CL.timeMax); // �����ʱ��
		return obj;
	}
	
	private KEntity RandomPig() {// �������
		KEntity entity = null;
		int index = K.randomInt(2);
		//return new PigA();		// test
		switch (index) {
			case 0:				//	entity = RandomPigA(); Ĭ��
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