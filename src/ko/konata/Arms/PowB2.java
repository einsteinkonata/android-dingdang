package ko.konata.Arms;

import android.graphics.Bitmap.Config;
import android.util.Log;
import ko.K;
import ko.KEmitter;
import ko.KSources;
import ko.konata.G;

public class PowB2 extends PowBase {
	private float angle;
	private KEmitter emitter;

	public PowB2(float x, float y, float angle) {
		super(x, y, 5);
		this.hitLayers.add(G.LayerPig);

		this.angle = angle;
		speed = 11;

		draw(0x8800eecc);

		emitter = new KEmitter(this.renderData.copy(Config.ARGB_8888, false),
				this.renderData.getWidth(), this.renderData.getHeight());
		emitter.newType("a", null);
		emitter.setAlpha("a", 0.6f, 0);
	}

	int emi = 0;

	@Override
	public void update() {
		vx = (float) (Math.cos(angle) * speed);
		vy = (float) (Math.sin(angle) * speed);

		if (this.x < G.OverX || this.x >= G.OverW || this.y < G.OverY
				|| this.y >= G.OverH) {
			K.game.remove(this);
		}

		if (emi++ % 4 == 0) {
			emitter.setMotion("a", 0, 0, 0.4f, 0, 0, 0);
			emitter.emit("a", this.x + this.mx, this.y + this.my);
		}
		emitter.update();
	}

	@Override
	public void render() {
		emitter.render();
		K.game.RenderHelper(emitter);
	}
	@Override public void draw(int dc)
	{
		this.renderData = KSources.getBitmap(7, 4, 0);
		this.my = this.mx = -this.renderData.getWidth() / 2;
		Log.i("",String.valueOf(this.renderData.getWidth()));
	}
}
