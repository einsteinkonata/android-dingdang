package ko.konata.Arms;

import android.graphics.Bitmap.Config;
import android.util.Log;
import ko.K;
import ko.KCircleEntity;
import ko.KEmitter;
import ko.KSources;
import ko.konata.G;

public class PowB extends KCircleEntity {
	private KEmitter emitter;
	private int powLevel;
	private int timeIndex = 0;
	private int timeMax = 30;

	public PowB(float x, float y, int powLevel) {
		super(x, y, 10);
		this.powLevel = powLevel;

		//
		draw(0xff00eecc);
		//
		emitter = new KEmitter(this.renderData.copy(Config.ARGB_8888, false),
				(int) this.getDiameter(), (int) this.getDiameter());
		emitter.newType("a", null);
		emitter.setAlpha("a", 1, 0);
	}

	@Override
	public void update() {
		if (this.x < G.OverX || this.x >= G.OverW || this.y < G.OverY
				|| this.y >= G.OverH) {
			K.game.remove(this);
		}
		OnMove();
		OnEmitter();
	}

	private void OnMove() {
		timeIndex += 1;
		if (timeIndex > timeMax) {
			final int powNum = powLevel;
			float cx = this.getCenterW();
			float cy = this.getCenterH();
			for (int i = 0, count = powNum; i < count; i++) {
				float angle = ((i + 1) * 360f / powNum - 90f) * K.MPI180;
				K.game.add(new PowB2(cx, cy, angle), G.LayerPow);
			}
			ko.KSources.play("m003pow");
			K.game.remove(this);
		}
	}

	int emi = 0;
	private void OnEmitter() {
		if (emi++ % 4 == 0) {
			float valueAngle = new Float(timeIndex) / timeMax * 360f + 90f;
			emitter.setMotion("a", valueAngle, 30f, 0.4f, 0f, 0f, 0f);
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
		this.renderData = KSources.getBitmap(1, 0, 5);
		this.my = this.mx = -this.renderData.getWidth() / 2;
	}
}
