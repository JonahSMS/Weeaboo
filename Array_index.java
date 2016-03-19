import java.util.ArrayList;

public class Array_index extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Array_index(String pattern) {
		super("array_index",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "[ int ] array_index":
				printIndent("[");
				nonter1 = (NonTerminal)getComponent("int");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("]");
				nonter2 = (NonTerminal)getComponent("array_index");
				propagate(nonter2);
				nonter2.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "[ int ]":
				printIndent("[");
				nonter1 = (NonTerminal)getComponent("int");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("]");
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