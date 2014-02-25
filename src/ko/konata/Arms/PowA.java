package ko.konata.Arms;

import android.graphics.Bitmap.Config;
import ko.K;
import ko.KEmitter;
import ko.KEntity;
import ko.KSources;
import ko.konata.G;

public class PowA extends PowBase {
	private float angle;
	private KEmitter emitter;

	public PowA(float x, float y, float angle){
		super(x, y, 5);
		this.hitLayers.add(G.LayerPig);

		this.angle = angle;
		speed = 9;

		draw(0xcc00ff00);
		this.mx = -7;
		emitter = new KEmitter(this.renderData.copy(Config.ARGB_8888, false), (int)this.getDiameter(), (int)this.getDiameter());
		emitter.newType("a", null);
		emitter.setAlpha("a", 0.6f, 0);
	}
	int emi = 0;
	@Override public void update() {
		vx = (float) (Math.cos(angle) * speed);
		vy = (float) (Math.sin(angle) * speed);
		//
		if (this.x < G.OverX || this.x >= G.OverW || this.y < G.OverY || this.y >= G.OverH){
			K.game.remove(this);
		}
		
	}
	@Override public void draw(int color) 
	{
		this.renderData = KSources.getBitmap(2, 0, 9);
	}
}
