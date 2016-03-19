import java.util.ArrayList;

public class Cond extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Cond(String pattern) {
		super("cond",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "cond || cond2":
				nonter1 = (NonTerminal)getComponent("cond");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("||");
				nonter2 = (NonTerminal)getComponent("cond2");
				propagate(nonter2);
				nonter2.interpret();
				operator = "||"; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "cond2":
				nonter1 = (NonTerminal)getComponent("cond2");
				propagate(nonter1);
				nonter1.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			default:
		}
	}

	

	private void updateString() {
		thisString = "" + getAsInt("value");
	}

	public String toString() {
		return thisString;
	}
}