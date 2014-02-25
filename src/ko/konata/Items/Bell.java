package ko.konata.Items;

import java.util.Arrays;

import android.util.Log;

import ko.K;
import ko.KAnimMap;
import ko.KCircleEntity;
import ko.KHit;
import ko.KRectangleEntity;
import ko.konata.G;
import ko.konata.Arms.EffectB;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;

public class Bell extends KCircleEntity {
	private int index = 0;
	private int indexMin = 6;
	private float offset = 0.5f;
	private float speedX = 0;

	private float gravity = 0.06f;
	private int offsetMaxX = 80;
	private float speedMaxY = 2.5f;

	private int status = -1;
	private int chance = 0; // ¿É¹¥»÷´ÎÊý

	private int chanceMin = 13;
	private int chanceMax = 20;

	// status:int = -1, speed:Number = 0, x:int = 0, y:int = 0){
	public Bell(int status, float speed, int x, int y) {
		super(0, 0, 10);

		this.hitLayers.add(G.LayerPow);

		this.x = (float) ((x == 0) ? Math.random()
				* (G.AndW - this.getRadius()) : x);
		this.y = (y == 0) ? -this.getDiameter() : y;
		this.my = this.mx = -16 / 2;

		this.speed = speed;

		SetOffset();

		this.status = status;
		Init();
		InitAnim();
		AnimPlay();
	}

	private void Init() {
		chance = (int) (chanceMin + chanceMax * Math.random());
	}

	private void InitAnim() {
		_animMap = new KAnimMap();
		for (int i = 0; i < 10; i++) {
			String name = "00" + String.valueOf(i);
			int v1 = 0 + i;
			int v2 = 10 + i;
			int v3 = 20 + i;
			int v4 = 30 + i;
			int v5 = 40 + i;
			_animMap.add(name, Arrays.asList(v1, v2, v3, v2, v1, v4, v5, v4), 0.13f);
		}
	}

	private void AnimPlay() {
		String name = "00" + String.valueOf(status + 1);
		_animMap.play(name);
	}

	private void RandomStatus() {
		if(index < indexMin) {
			if (2 < K.randomInt(7)) {
				status = -1;
				index += 1;
				return;
			}
		}
		index = 0;
		
		int ran = K.randomInt(24);
		//Log.i("random", String.valueOf(ran));
		if (2 < ran) {
			status = K.randomInt(3);
			return;
		} else {
			status = 4;
			return;
		}
	}

	@Override
	public void update() {
		speed += gravity;
		vy = (speed > speedMaxY) ? speedMaxY : speed;
		vx = speedX;

		if (this.x < G.OverX || this.x >= G.OverW || this.y >= G.AndH - 80) {
			SetPowValue();
			K.game.remove(this);
		}
	}

	private void SetPowValue() {
		if (status < 0) {
			ko.KSources.play("m004get");
			CGame.point += 200;
		} else if (status >= 0 && status <= 3) {
			ko.KSources.play("m005up");
			CPlayer.SetPow(status);
//		} else if (status == 4) {
//			CPlayer.AvatarPlayer();
//		} else if (status == 5) {
//			CPlayer.DeathPlayer();
		} else if (status == 4) {
			ko.KSources.play("m004get");
			CPlayer.SetHP(1);
		}
	}

	@Override
	public void render() {
		_animMap.update();
		this.renderData = _animMap._source;
	}

	private void SetOffset() {
		if (this.x < offsetMaxX) {
			speedX = offset;
		} else if (this.x > G.AndW - offsetMaxX) {
			speedX = offset * -1;
		} else {
			speedX = (Math.round(Math.random()) == 1) ? offset * -1 : offset;
		}
	}

	@Override
	public void vsOBB(KRectangleEntity rect) {
	}

	@Override
	public void vsCircle(KCircleEntity circle) {
		if (KHit.CircleHitCircle(circle, this) == true) {
			K.game.add(new EffectB(this.getCenterW(), this.getCenterH() + 8), "last");
			ko.KSources.play("m006ding");
			this.speed = -3;
			SetOffset();
			RandomStatus();
			AnimPlay();
			chance -= 1;
			if (chance <= 0)
				K.game.remove(this);
			K.game.remove(circle);
		}
	}
}
