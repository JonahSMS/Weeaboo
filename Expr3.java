import java.util.ArrayList;

public class Expr3 extends NonTerminal {
	private NonTerminal nonter1;
	
	private String thisString;

	public Expr3(String pattern) {
		super("expr3",pattern);
	}

	public void interpret() throws Exception {
		switch(getProdString()) {
			case "+ expr3":
				nonter1 = (NonTerminal)getComponent("expr3");
				nonter1.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "- expr3":
				nonter1 = (NonTerminal)getComponent("expr3");
				nonter1.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr4":
				nonter1 = (NonTerminal)getComponent("expr4");
				nonter1.interpret();
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			default:
		}
	}

	public void execute() {
		boolean error = false;
		switch(getProdString()) {
			case "+ expr3":
				nonter1.execute();
				put("type",nonter1.getAsString("type"));
				put("value",nonter1.getAsInt("value"));
				thisString = "" + getAsInt("value");
				break;
			case "- expr3":
				nonter1.execute();
				put("type",nonter1.getAsString("type"));
				put("value",-nonter1.getAsInt("value"));
				thisString = "" + -getAsInt("value");
				break;
			default:
				nonter1.execute();
				put("type",nonter1.getAsString("type"));
				put("value",nonter1.getAsInt("value"));
				thisString = "" + getAsInt("value");
		}
	}

	private void updateString() {
		thisString = "" + getAsInt("value");
	}

	public String toString() {
		return thisString;
	}
}