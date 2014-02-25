package ko.konata.Arms;

import java.util.Arrays;

import ko.K;
import ko.KAnimMap;
import ko.konata.G;
import android.graphics.PointF;

public class PowD extends PowBase {
	private float angle;
	private float angleBRate = 0.3f;
	private PointF ps = new PointF();

	public int speedB = 20;

	public PowD(float x, float y, float angle) {
		super(x, y, 5);
		this.hitLayers.add(G.LayerPig);
		ps.x = x;
		ps.y = y;

		this.angle = angle;
		speed = 5;

		// draw(0x8800dd22);
		InitAnim();
	}

	private void InitAnim() {
		_animMap = new KAnimMap();
		_animMap.add("move", Arrays.asList(700, 710, 720, 730), 0.2f);
		_animMap.play("move");
	}

	@Override
	public void update() {
		float dx = this.x - ps.x;
		float dy = this.y - ps.y;
		float angleB = (float) Math.atan2(dy, dx);
		angleB += angleBRate;

		ps.x += (Math.cos(angle)) * speed;
		ps.y += (Math.sin(angle)) * speed;

		this.x = (float) (ps.x + Math.cos(angleB) * speedB);
		this.y = (float) (ps.y + Math.sin(angleB) * speedB);

		if (this.x < G.OverX || this.x >= G.OverW || this.y < G.OverY
				|| this.y >= G.OverH) {
			K.game.remove(this);
		}
	}

	@Override
	public void render() {
		_animMap.update();
		this.renderData = _animMap._source;
		this.my = this.mx = -this.renderData.getWidth() / 2;
	}
}
