package ko.konata.GConfig;

import java.util.ArrayList;

import ko.K;
import ko.KEntity;
import ko.konata.G;
import ko.konata.Cpus.CreateMagicA;
import ko.konata.Monos.Player;
import ko.konata.Panels.GameOver;

public class CPlayer {
	private static int _hp= 0;
	private static final int hpMax= 3;

	private static int LVPowA= 0;
	private static int LVPowB= 0;
	private static int LVPowC= 0;
	private static int LVPowD= 0;
	private static Boolean IsAvatar = false;
	private static Boolean IsDeath = false;

	public static final int energyVol= 60;
	public static final int energyMax= 150;

	public static int SelectType= 0;
	public static final int SelectTypeMax= 4;
	public static Boolean IsDrawArm;
	public static Boolean IsGameOver;
	public static ArrayList<Integer> powEnergy;

	private static final int max= 5;
	
	public static void Create() {
		powEnergy = new ArrayList<Integer>();
		_hp = hpMax;
		SelectType = 0;
		LVPowA = LVPowB = LVPowC = LVPowD = 0;
		LVPowA = 1;
		IsAvatar = IsDeath = false;
		IsDrawArm = true;
		IsGameOver = false;
		for (int i = 0; i < SelectTypeMax; i++){
			int value = energyMax;
			powEnergy.add(value);
		}
	}

	public static void AvatarPlayer() {
		if (IsAvatar == false){
			KEntity entity= K.game.getEntity("player1", G.LayerPanel);
			if (entity != null) {
				Player p1 = (Player) entity;
				Player p2 = new Player();
				p1.player2 = p2;
				p2.name = "player2";
				p1.x = (G.AndW / 4) - p1.getHalfWidth();
				p2.x = (G.AndW / 4 * 3) - p2.getHalfWidth();
				p1.y = p2.y = G.AndH - p2.getHeight() - 80;
				K.game.add(p2, G.LayerPanel);
			}
			IsAvatar = true;
		}
	}

	public static void DeathPlayer(){
		if (IsDeath == false){
			K.game.add(new CreateMagicA());
			IsDeath = true;
		}
	}

	public static void SetPow(int type) {
		IsDrawArm = true; // ¸Ã»­Í¼
		switch (type){
			case 0:
				LVPowA += 1;
				LVPowA = (LVPowA > max) ? max : LVPowA;
				break;
			case 1:
				LVPowB += 1;
				LVPowB = (LVPowB > max) ? max : LVPowB;
				break;
			case 2:
				LVPowC += 1;
				LVPowC = (LVPowC > max) ? max : LVPowC;
				break;
			case 3:
				LVPowD += 1;
				LVPowD = (LVPowD > max) ? max : LVPowD;
				break;
		}
	}

	public static int GetPowLevel(int value) {
		value = (value == -1) ? SelectType : value;
		switch (value){
			case 0:
				return LVPowA;
			case 1:
				return LVPowB;
			case 2:
				return LVPowC;
			case 3:
				return LVPowD;
		}
		return LVPowA;
	}

	public static Boolean IsDelEnergy() {
		int ve = powEnergy.get(SelectType) - energyVol;
		if (ve >= 0){
			powEnergy.set(SelectType, ve);
			return true;
		} else {
			return false;
		}
	}

	static public Boolean GetDeath() {
		return IsDeath;
	}
	
	static public Boolean GetIsAvatar()
	{
		return IsAvatar;
	}

	static public int HP() {
		return _hp;
	}

	static public void SetHP(int value) {
		if(IsGameOver == true) return;
		if (_hp + value <= hpMax) {
			_hp += value;
			_hp = (_hp < 0) ? 0 : _hp;
			if (_hp == 0 && IsGameOver == false) {
				K.game.add(new GameOver());
				IsGameOver = true;
			}
		}
	}
}
