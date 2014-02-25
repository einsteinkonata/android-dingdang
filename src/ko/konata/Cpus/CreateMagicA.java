package ko.konata.Cpus;

import ko.K;
import ko.KEntity;
import ko.konata.G;
import ko.konata.Arms.MagicA;
import ko.konata.GConfig.CPlayer;

public class CreateMagicA extends KEntity {
	private int index;
private int prame;

public CreateMagicA(){
	super();
	visible = false;
	index = 0;
	prame = 25;
}

@Override public void update() {
	index += 1 + prame;
	index %= prame;
	if (CPlayer.GetDeath() == true && index == 1){
		K.game.add(new MagicA(), G.LayerPow);
	}
}
}
