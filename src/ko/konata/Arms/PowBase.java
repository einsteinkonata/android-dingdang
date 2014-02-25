package ko.konata.Arms;

import ko.K;
import ko.KCircleEntity;
import ko.KHit;
import ko.KRectangleEntity;
import ko.konata.Monos.PigBase;
import ko.util.IHitTypes;

public class PowBase extends KCircleEntity implements IHitTypes {

	public PowBase(float x, float y, float radius) {
		super(x, y, radius);
	}
	
	@Override public void vsOBB(KRectangleEntity rect) {
		if (KHit.RectHitCircle(rect, this) == true) {
			if (rect instanceof PigBase) {
				((PigBase)rect).OnDeath(true);
			}
			K.game.remove(this);
		}
	}

	@Override public void vsCircle(KCircleEntity circle) {

	}
}
