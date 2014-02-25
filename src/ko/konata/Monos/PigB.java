package ko.konata.Monos;

import java.util.Arrays;

import ko.K;
import ko.KAnimMap;
import ko.konata.G;
import ko.konata.GConfig.CGame;

public class PigB extends PigBase {

	public PigB() {
		super(0, 0, 16, 16);

		this.x = (float) (Math.random() * (G.AndW - this.getWidth()));
		this.y = -this.getHeight();
		//
		speed = 1f;
		speed += Math.random() * CGame.Level / 6f;
		point = 50;
		//
		//draw(0xaa0000aa);
		InitAnim();
	}

	private void InitAnim() {
		_animMap = new KAnimMap();
		_animMap.add("move",
				Arrays.asList(200, 210, 220, 230, 240, 250, 260, 270), 0.05f);
		_animMap.play("move");
	}

	@Override
	public void update() {
		vy = speed;

		if (this.x < G.OverX || this.x >= G.OverW || this.y >= G.AndH - 80) {
			this.OnDeath(false);
			K.game.remove(this);
		}
	}

	@Override
	public void render() {	
		_animMap.update();
		this.renderData = _animMap._source;
	}
}
