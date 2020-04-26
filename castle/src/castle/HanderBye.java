package castle;

public class HanderBye extends Hander {

	public HanderBye( Game game) {
		super(game);
	}
	@Override
	public boolean isBye() {
		return true;
	}
}
