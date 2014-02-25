package ko.konata.Monos;

import java.util.Arrays;

import android.util.Log;

import ko.K;
import ko.KAnimMap;
import ko.konata.G;
import ko.konata.GConfig.CGame;

public class PigA extends PigBase {
	private float sx = 0;
	private int actIndex = 0;
	private int actInt = 250;
	private int actRandom = 90;

	public PigA() {
		super(0, 0, 18, 20);
		//
		this.x = Math.random() < 0.5 ? 0 - this.getWidth() : G.AndW;
		this.y = (float) (Math.random() * 140 + 10);
		this.mx -= 7;
		this.my -= 10;
		//
		draw(0xffffffff);
		speed = 1;
		point = 100;
		actInt = actInt - (CGame.Level * 5);
		actInt += K.randomInt(getRandom() * 2);
		//
		sx = this.x < 0 ? speed : speed * -1;
		//
		InitAnim();
	}

	private void InitAnim() {
		_animMap = new KAnimMap();
		_animMap.add("move", Arrays.asList(102, 112, 122, 132, 142, 152), 0.07f);
		_animMap.play("move");
		
	}

	@Override
	public void update() {
		if (this.x < 0) {
			sx *= -1;
			this.x = 0 + 1;
		} else if (this.x + this.getWidth() > G.AndW) {
			sx *= -1;
			this.x = G.AndW - this.getWidth() - 1;
		}
		OnAct();
		vx = sx;
	}

	private void OnAct() {
		actIndex += 1 + actInt;
		actIndex %= actInt;
		if (actIndex == 0) {
			PigB pig = new PigB();
			pig.x = this.x;
			pig.y = this.y;
			pig.speed -= 0.4f;
			actInt += K.randomInt(getRandom());
			if(CGame.Level > 5) K.game.add(pig, G.LayerPig);
		}
	}
	
	private int getRandom(){
		return actRandom;
	}

	@Override
	public void render() {
		_animMap.update();
		this.renderData = _animMap._source;
	}
}
