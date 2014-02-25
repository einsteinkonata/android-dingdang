package ko.konata.Arms;

import java.util.Arrays;

import ko.K;
import ko.KAnimMap;
import ko.KEntity;

public class EffectB extends KEntity {
	public EffectB(float x, float y) {
		super(x - 16, y - 16);

		this._animMap = new KAnimMap();
		_animMap.add("pow", Arrays.asList(105, 115, 125, 135), 0.06f, false);
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
