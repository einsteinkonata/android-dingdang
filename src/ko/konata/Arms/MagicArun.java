package ko.konata.Arms;

import ko.K;
import ko.KEntity;
import ko.konata.G;
import ko.konata.GConfig.CPlayer;

public class MagicArun extends KEntity {
	private int index;
	private int prame;

	public MagicArun() {
		visible = false;
		index = 0;
		prame = 35;
	}

	@Override
	public void update() {
		index += 1 + prame;
		index %= prame;
		if (CPlayer.GetDeath() == true && index == 1) {
			K.game.add(new MagicA(), G.LayerPow);
		}
	}
}