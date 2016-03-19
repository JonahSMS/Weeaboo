import java.util.ArrayList;

public class Assign_list extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Assign_list(String pattern) {
		super("assign_list",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "assignment , assign_list ":
				nonter1 = (NonTerminal)getComponent("assignment");
				propagate(nonter1);
				nonter1.interpret();
				printIndent(",");
				nonter2 = (NonTerminal)getComponent("assign_list");
				propagate(nonter2);
				nonter2.interpret();
				operator = "&&"; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "assignment":
				nonter1 = (NonTerminal)getComponent("assignment");
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