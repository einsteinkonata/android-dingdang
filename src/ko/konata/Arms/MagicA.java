package ko.konata.Arms;

import java.util.Arrays;

import ko.K;
import ko.KAnimMap;
import ko.KCircleEntity;
import ko.KHit;
import ko.KRectangleEntity;
import ko.konata.G;

public class MagicA extends KCircleEntity {
	private int timeStart = 0;
private int timeMax = 40;
private float angle = 0;

public  MagicA()
{
	super(0, 0, 4);
	
	this.x = (float) (Math.random() * (G.AndW - 60) + 30);
	this.y = (float) (Math.random() * (G.AndH - 180) + 20);
	this.angle = (float) (Math.random() * 360 * K.MPI180);
	
	this.mx = this.my = -4;
	
	speed = 3;
	
	//draw(0xccdd0000);
	InitAnim();
}

private void InitAnim() {
	_animMap = new KAnimMap();
	_animMap.add("move",
			Arrays.asList(700, 710, 720, 730), 0.08f);
	_animMap.play("move");
}


@Override public void update()
{
	if (timeStart < timeMax) {
		if (timeStart == timeMax - 1) this.hitLayers.add(G.LayerPig);
		
		timeStart += 1;
	}
	else {
		vx = (float) (Math.cos(angle) * speed);
		vy = (float) (Math.sin(angle) * speed);
		
		if (this.x < G.OverX || this.x >= G.OverW
		|| this.y < G.OverY || this.y >= G.OverH) {
			K.game.remove(this);
		}
	}
}
@Override public void render() {
	_animMap.update();
	this.renderData = _animMap._source;
}
@Override public void vsOBB(KRectangleEntity rect) {
	if (KHit.RectHitCircle(rect,this) == true) {
		K.game.remove(rect);
		K.game.remove(this);
	}
}

@Override public void vsCircle(KCircleEntity circle) {
	
}
}
