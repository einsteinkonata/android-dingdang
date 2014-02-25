package ko.konata.Arms;

import java.util.Arrays;

import android.util.Log;

import ko.K;
import ko.KAnimMap;
import ko.KEntity;

public class EffectA extends KEntity {
	public EffectA(float x, float y) {
		super(x - 8, y - 8);
		InitAnim();
	}
	
	private void InitAnim() 
	{
		this._animMap = new KAnimMap();
		_animMap.add("pow", Arrays.asList(103, 113, 123, 133, 143), 0.03f,false);
		_animMap.play("pow");
	}

	@Override public void update() {
		if (_animMap.IsOver() == true) {
			K.game.remove(this);
		}		
	}

	@Override public void render() {
		_animMap.update();
		this.renderData = _animMap._source;
	}
}
