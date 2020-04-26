package castle;

public class HanderGo extends Hander {
	public HanderGo( Game game) {
		super(game);
	}

	@Override
	public void doCmd(String str) {
		game.goRoom(str);
	}
	
}
