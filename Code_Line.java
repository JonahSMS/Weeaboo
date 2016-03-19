import java.util.ArrayList;

public class Code_Line extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;

	public Code(String pattern) {
		super("code_line",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "safe_code_line":
				nonter1 = (NonTerminal)getComponent("safe_code_line");
				propagate(nonter1);
				nonter1.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "if_stmt":
				nonter1 = (NonTerminal)getComponent("if_stmt");
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