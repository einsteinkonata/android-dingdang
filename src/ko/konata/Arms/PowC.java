package ko.konata.Arms;

import android.graphics.Bitmap.Config;
import ko.K;
import ko.KEmitter;
import ko.KSources;
import ko.konata.G;

public class PowC extends PowBase {
	private float angle;
	private KEmitter emitter;

public  PowC(float x,float y,float  angle) {
	super(x, y, 5);
	this.hitLayers.add(G.LayerPig);

	this.angle = angle;
	speed = 3;

	draw(0xaa00ff00);
	this.mx = -8;
}

//int emi = 0;
@Override public void update()
{
	vx = (float) (Math.cos(angle) * speed);
	vy = (float) (Math.sin(angle) * speed);
	
	if (this.x < G.OverX || this.x >= G.OverW
	|| this.y < G.OverY || this.y >= G.OverH) {
		K.game.remove(this);
	}
	
}
@Override public void draw(int color) 
{
    //this.matrix.rotate(angle + 90 * K.MPI180);
	this.renderData = KSources.getBitmap(2, 0, 9);
}
}
