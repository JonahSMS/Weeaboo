import java.util.ArrayList;

public class Cond4 extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Cond4(String pattern) {
		super("cond4",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "expr <= expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("<=");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = "<="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr >= expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent(">=");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = ">="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr < expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("<");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = "<"; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr > expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent(">");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = ">"; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr == expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("==");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = "=="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr != expr":
				nonter1 = (NonTerminal)getComponent("expr");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("!=");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = "!="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;					
			case "bool_value":
				nonter1 = (NonTerminal)getComponent("bool_value");
				propagate(nonter1);
				nonter1.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "( cond )":
				printIndent("(");
				nonter1 = (NonTerminal)getComponent("cond");
				propagate(nonter1);
				nonter1.interpret();
				printIndent(")");
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