package ko.konata.Backgrounds;

import ko.KEntity;
import ko.KSources;

public class SceneA extends KEntity {
	public SceneA() {
		draw(0);
	}
	
	@Override public void draw(int color){
		this.renderData = KSources.getBitmap(3);
	}
}
