package ko.konata;

import ko.K;
import ko.KSources;
import ko.konata.Arms.EffectA;
import ko.konata.Backgrounds.SceneA;
import ko.konata.Cpus.CreateLevelA;
import ko.konata.GConfig.CGame;
import ko.konata.GConfig.CPlayer;
import ko.konata.Items.Bell;
import ko.konata.Monos.PigA;
import ko.konata.Monos.Player;
import ko.konata.Panels.ArmMenu;
import ko.konata.Panels.EmitterPanel;
import ko.konata.Panels.GameStart;
import ko.konata.Panels.MessagePanel;

public class Game {
	public static Game T;
	private CreateLevelA createLevel;
	public Game(){
		TextHelper.CreateTextDic();	
		InitLayer();
	}
	private void InitLayer()
	{
		K.game.addLayer(G.LayerPig);
		K.game.addLayer(G.LayerItem);
		K.game.addLayer(G.LayerPow);
		K.game.addLayer(G.LayerPanel);
	}
	
	public void Op() {
		K.game.removeAll();
		//KSources.stop("m001bg");
		K.game.add(new GameStart());
	}
	
	public void Start() 
	{
		K.game.removeAll();
		//KSources.loop("m001bg");
		
		CGame.Create();
		CPlayer.Create();
		
		createLevel = new CreateLevelA();
		
		InitMain();
		InitCpu();
		InitPlayer();
		InitGame();
	}
	
	private void InitMain()
	{
		K.game.add(new SceneA(), "first");
		K.game.add(new ArmMenu(),G.LayerPanel);
		K.game.add(new MessagePanel(), G.LayerPanel);
	}
	
	private void InitCpu()
	{
		K.game.add(createLevel);
	}
	
	private void InitPlayer()
	{
		Player p1 = new Player();
		p1.name = "player1";
		p1.x = G.AndW / 2 - p1.getHalfWidth();
		p1.y = G.AndH - p1.getHeight() - 80;
		K.game.add(p1, G.LayerPanel);
		//
//		CPlayer.AvatarPlayer();
//		CPlayer.DeathPlayer();
	}
	
	private void InitGame()
	{
		//K.game.add(new MenuDialog());
		//K.game.add(new MenuDialogB(0, 50));
		//K.game.add(new Bell(5,0,0,0), G.LayerItem);
	}
}


















