package ko.konata.Monos;

import java.util.Arrays;

import ko.K;
import ko.KAnimMap;
import ko.konata.G;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;
import android.graphics.Point;
import android.graphics.PointF;

public class PigC extends PigBase {
	private PointF endPoint;
	private int maxx = G.AndW;
	private int maxy = 300;
	private int stopIndex = 0;
	
	private int actIndex = 0;
	private int actInt = 350;
	private int actMax = 300;

	public PigC() {
		super(0, 0, 16, 16);

		this.x = (float) (Math.random() * (G.AndW - this.width));
		this.y = -this.height;
		this.mx = -8;
		this.my = -8;
		this.speed = 1.5f;
		this.speed += Math.random() * CGame.Level / 4;

		this.point = 150;

		actInt = actInt - (CGame.Level * 10);
		actInt = (actInt < 150) ? 150 : actInt;
		actInt += K.randomInt(actMax);
		endPoint = new PointF();
		initEndPoint();

		draw(0xaa0000aa);
		InitAnim();
	}

	private void InitAnim() {
		_animMap = new KAnimMap();
		_animMap.add("move", Arrays.asList(104, 114, 124, 134), 0.12f);
		_animMap.play("move");
	}

	@Override
	public void update() {
		float dx = endPoint.x - this.x;
		float dy = endPoint.y - this.y;
		if (Math.abs(dx) > 2 && Math.abs(dy) > 2) {
			float ang = (float) Math.atan2(dy, dx);
			vx = (float) (Math.cos(ang) * speed);
			vy = (float) (Math.sin(ang) * speed);
		} else {
			initEndPoint();
		}
		OnAct();
	}
	private void OnAct() {
		actIndex += 1 + actInt;
		actIndex %= actInt;
		if (actIndex == 0 && CPlayer.IsGameOver == false) {
			PigC pig = new PigC();
			pig.x = this.x;
			pig.y = this.y;
			K.game.add(pig, G.LayerPig);
			actInt += K.randomInt(actMax);
		}
	}
	

	@Override
	public void render() {
		_animMap.update();
		this.renderData = _animMap._source;

	}

	private void initEndPoint() {
		endPoint.x = (float) (Math.random() * (maxx - 30));
		endPoint.y = (float) (Math.random() * maxy);
	}
}
