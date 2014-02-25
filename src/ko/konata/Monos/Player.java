package ko.konata.Monos;

import android.util.Log;
import ko.K;
import ko.KInput;
import ko.KRectangleEntity;
import ko.KSources;
import ko.konata.G;
import ko.konata.Arms.PowA;
import ko.konata.Arms.PowB;
import ko.konata.Arms.PowBase;
import ko.konata.Arms.PowC;
import ko.konata.Arms.PowD;
import ko.konata.GConfig.CPlayer;

public class Player extends KRectangleEntity {
	public Player player2;
	private Boolean IsPow = false;

	public Player() {
		super(0, 0, 32, 32);

		draw(0);

	}

	@Override
	public void draw(int color) {
		// super.draw(dc, alpha);
		this.renderData = KSources.getBitmap(1);
		// this.renderData.draw(KSources.getBitmap(1));
	}

	@Override
	public void update() {
		if (this.name == "player2")
			return;
		if (IsPow == false && KInput.mouseDown == true && KInput.mouseY() < G.AndH - 60) {
			IsPow = true;
			if (CPlayer.GetPowLevel(-1) > 0 && (CPlayer.IsDelEnergy() == true)) {
				OnSelectPow();
				if (player2 != null)
					player2.OnSelectPow();
			}
		}
		if(KInput.mouseDown == false){
			IsPow = false;
		}
	}

	private void OnSelectPow() {
		if (this.name == "player1") {
			ko.KSources.play("m003pow");
		}
		switch (CPlayer.SelectType) {
		case 0:
			OnPowA();
			break;
		case 1:
			OnPowB();
			break;
		case 2:
			OnPowC();
			break;
		case 3:
			OnPowD();
			break;
		}
	}

	// É¢µ¯
	private void OnPowA() {
		final int powNum = CPlayer.GetPowLevel(-1);
		final int powAngle = 12;

		float angP = powAngle * K.MPI180;
		float angP1 = (powNum > 1) ? powNum / 2 * angP - (4 * K.MPI180)
				: (2 * K.MPI180);// ÐÞÕý(4 * K.MPI180): (2 * K.MPI180);
		float cx = this.getCenterW();
		float cy = this.getCenterH();
		float dx = KInput.mouseX() - cx;
		float dy = KInput.mouseY() - cy;
		float angM = (float) Math.atan2(dy, dx);
		for (int i = 0, count = powNum; i < count; i++) {
			float angle = angM - angP1 + angP * i;
			K.game.add(new PowA(cx, cy, angle), G.LayerPow);
		}
	}

	// »÷ÖÐ±¬Õ¨µ¯
	private void OnPowB() {
		if (this.name == "player1") {
			int numLV = (CPlayer.GetIsAvatar() == true) ? CPlayer.GetPowLevel(-1) * 2
					: CPlayer.GetPowLevel(-1);
			 K.game.add(new PowB(KInput.mouseX(), KInput.mouseY(), numLV));
		}
	}

	// ºáÅÅ
	private void OnPowC() {
		final int powNum = CPlayer.GetPowLevel(-1);
		final int powDis = 18;

		float cx, cy, dx, dy;
		dx = KInput.mouseX() - this.getCenterW();
		dy = KInput.mouseY() - this.getCenterH();
		float angM = (float) Math.atan2(dy, dx);
		float angM2 = angM + 90 * K.MPI180;

		float dis = (powNum - 1) * powDis / 2;
		for (int i = 0, count = powNum; i < count; i++) {
			float w2 = powDis * i - dis;
			cx = (float) (this.getCenterW() + Math.cos(angM2) * w2);
			cy = (float) (this.getCenterH() + Math.sin(angM2) * w2);

			K.game.add(new PowC(cx, cy, angM), G.LayerPow);
		}
	}

	// ×ª×ªµ¯
	private void OnPowD() {
		float powNum = CPlayer.GetPowLevel(-1);

		float cx = this.getCenterW();
		float cy = this.getCenterH();
		float dx = KInput.mouseX() - cx;
		float dy = KInput.mouseY() - cy;
		float angleM = (float) Math.atan2(dy, dx);
		for (int i = 0; i < powNum; i++) {
			float angleB = ((float)i / powNum * 360) * K.MPI180;

			 PowD powD = new PowD(cx, cy, angleM);
			 powD.x += Math.cos(angleB) * powD.speedB;
			 powD.y += Math.sin(angleB) * powD.speedB;			
			 K.game.add(powD, G.LayerPow);
		}
	}

	@Override
	public float getCenterW() {
		return this.x + this.getHalfWidth();
	}

	@Override
	public float getCenterH() {
		return this.y + this.getHalfHeight();
	}
}
