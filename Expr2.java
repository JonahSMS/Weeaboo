import java.util.ArrayList;

public class Expr2 extends NonTerminal {
	private NonTerminal nonter1;
	private NonTerminal nonter2;
	
	private String operator;
	private String thisString;

	public Expr2(String pattern) {
		super("expr",pattern);
	}

	public void interpret() throws Exception {
		switch(getProdString()) {
			case "expr2 * expr3":
				nonter1 = (NonTerminal)getComponent("expr2");
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("expr3");
				nonter2.interpret();
				operator = "*";
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr2 / expr3":
				nonter1 = (NonTerminal)getComponent("expr2");
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("expr3");
				nonter2.interpret();
				operator = "/";
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr2 % expr3":
				nonter1 = (NonTerminal)getComponent("expr2");
				nonter1.interpret();
				nonter2 = (NonTerminal)getComponent("expr3");
				nonter2.interpret();
				operator = "%";
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			case "expr3":
				nonter1 = (NonTerminal)getComponent("expr3");
				nonter1.interpret();
				operator = "";
				put("lineNo",nonter1.getAsInt("lineNo"));
				break;
			default:
		}
	}

	public void execute() {
		boolean error = false;
		switch(operator) {
			case "*":
				nonter1.execute();
				nonter2.execute();
				put("type","int");
				put("value",nonter1.getAsInt("value") * nonter2.getAsInt("value"));
				if( error ) {
					put("type","error");
					System.out.println("Unsupported operator " 
													+ nonter1 + "*" + nonter2 
													+ " at line " 
													+ getAsInt("lineNo"));
				} else {
					updateString();
				}
				break;
			case "/":
				nonter1.execute();
				nonter2.execute();
				put("type","int");
				put("value",nonter1.getAsInt("value") / nonter2.getAsInt("value"));
				if( error ) {
					put("type","error");
					System.out.println("Unsupported operator " 
													+ nonter1 + "/" + nonter2 
													+ " at line " 
													+ getAsInt("lineNo"));
				} else {
					updateString();
				}
				break;
			case "%":
				nonter1.execute();
				nonter2.execute();
				put("type","int");
				put("value",nonter1.getAsInt("value") % nonter2.getAsInt("value"));
				if( error ) {
					put("type","error");
					System.out.println("Unsupported operator " 
													+ nonter1 + "%" + nonter2 
													+ " at line " 
													+ getAsInt("lineNo"));
				} else {
					updateString();
				}
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