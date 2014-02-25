package ko.konata.Monos;

import ko.K;
import ko.KRectangleEntity;
import ko.konata.G;
import ko.konata.Arms.EffectA;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;
import ko.konata.Items.Bell;

public class PigBase extends KRectangleEntity {
	public int point = 0;

	public PigBase(float x, float y, int width, int height) {
		super(x, y, width, height);
	}

	public void OnDeath(Boolean IsKill) {
		K.game.add(new EffectA(this.getCenterW(), this.getCenterH()),"last");

		K.game.remove(this);

		if (IsKill == false) {
			ko.KSources.play("m008ite");
			CPlayer.SetHP(-1);
			return;
		}else{
			ko.KSources.play("m007clier");
		}
		if (K.randomInt(17) <= 1) {
			K.game.add(new Bell( -1, -3f, (int) this.x + 8,(int) this.y + 8));
		}
		CGame.point += point;
	}
}
