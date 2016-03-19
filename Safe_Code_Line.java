import java.util.ArrayList;

public class Safe_Code_Line extends NonTerminal {
	private NonTerminal code;

	public Safe_Code_Code(String pattern) {
		super("safe_code_line",pattern);
	}

	public void interpret() throws Exception {
		if(Driver.SHOW_TREE) {
			printBranch();
		}
		switch(getProdString()) {
			case "declaration ;":
				code = (NonTerminal)getComponent("declaration");
				propagate(code);
				code.interpret();
				put("lineNo",code.getAsInt("lineNo"));
				printIndent(";");
				break;
			case "assignment ;":
				code = (NonTerminal)getComponent("assignment");
				propagate(code);
				code.interpret();
				put("lineNo",code.getAsInt("lineNo"));
				printIndent(";");
				break;
			case "return_stmt ;":
				printIndent(";");
				break;
			case "BREAK ;":
				printIndent("BREAK");
				printIndent(";");
				put("lineNo",((Token)getComponent("BREAK")).lineNo());
				break;
			case "switch_stmt":
				break;
			case "print_stmt ;":
				code = (NonTerminal)getComponent("print_stmt");
				propagate(code);
				code.interpret();
				printIndent(";");
				put("lineNo",code.getAsInt("lineNo"));
				break;
			case "scan_stmt ;":
				printIndent(";");
				break;
			case "func_call ;":
				printIndent(";");
				break;
			case "loop":
				break;
			default:
		}
	}

	public void execute() {

	}
}