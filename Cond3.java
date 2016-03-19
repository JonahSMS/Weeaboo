import java.util.ArrayList;

public class Cond3 extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Cond3(String pattern) {
		super("cond3",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "! cond3":
				printIndent("!");
				nonter1 = (NonTerminal)getComponent("cond3");
				propagate(nonter1);
				nonter1.interpret();
				operator = "&&"; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "cond4":
				nonter1 = (NonTerminal)getComponent("cond4");
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