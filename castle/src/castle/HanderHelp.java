package castle;

public class HanderHelp extends Hander {

	public HanderHelp( Game game) {
		super(game);
	}
	@Override
	public void doCmd(String str) {
		System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：go east");
	}

}
