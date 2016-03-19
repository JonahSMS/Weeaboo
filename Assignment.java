import java.util.ArrayList;

public class Assignment extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	private NonTerminal nonter3;
	
	private String operator;
	private String thisString;

	public Assignment(String pattern) {
		super("assignment",pattern);
	}

	public void interpret() throws Exception {
		printBranch();
		switch(getProdString()) {
			case "varname = assignment":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("=");
				nonter2 = (NonTerminal)getComponent("assignment");
				propagate(nonter2);
				nonter2.interpret();
				operator = "="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname = cond":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("=");
				nonter2 = (NonTerminal)getComponent("cond");
				propagate(nonter2);
				nonter2.interpret();
				operator = "="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname = expr":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("=");
				nonter2 = (NonTerminal)getComponent("expr");
				propagate(nonter2);
				nonter2.interpret();
				operator = "="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname = func_call":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				printIndent("=");
				nonter2 = (NonTerminal)getComponent("func_call");
				propagate(nonter2);
				nonter2.interpret();
				operator = "="; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname array_index = assignment":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("array_index");
				propagate(nonter2);
				nonter2.interpret();
				printIndent("=");
				nonter3 = (NonTerminal)getComponent("assignment");
				propagate(nonter3);
				nonter3.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname array_index = cond":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("array_index");
				propagate(nonter2);
				nonter2.interpret();
				printIndent("=");
				nonter3 = (NonTerminal)getComponent("cond");
				propagate(nonter3);
				nonter3.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname array_index = expr":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("array_index");
				propagate(nonter2);
				nonter2.interpret();
				printIndent("=");
				nonter3 = (NonTerminal)getComponent("expr");
				propagate(nonter3);
				nonter3.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "varname array_index = func_call":
				nonter1 = (NonTerminal)getComponent("varname");
				propagate(nonter1);
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("array_index");
				propagate(nonter2);
				nonter2.interpret();
				printIndent("=");
				nonter3 = (NonTerminal)getComponent("func_call");
				propagate(nonter3);
				nonter3.interpret();
				operator = ""; // review o.o
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;					
			case "cond":
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