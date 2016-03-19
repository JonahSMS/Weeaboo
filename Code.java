import java.util.ArrayList;

public class Code extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;

	public Code(String pattern) {
		super("code",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "code_line code":
				nonter1 = (NonTerminal)getComponent("code_line");
				propagate(nonter1);
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("code");
				propagate(nonter2);
				nonter2.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "code":
				nonter1 = (NonTerminal)getComponent("code");
				propagate(nonter1);
				nonter1.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			default:
		}
	}

	public void execute() {

	}
}