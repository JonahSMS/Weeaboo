public class ConcreteNonTerminalFactory implements NonTerminalFactory {
	private static NonTerminalFactory instance = null;

	private ConcreteNonTerminalFactory() {}

	public static NonTerminalFactory instance() {
		if(instance == null ) {
			instance = new ConcreteNonTerminalFactory();
		}
        return instance;
	}

	public NonTerminal getNonTerminal(String type, String pattern) {
		switch(type) {
			case "main":
				// return new Main(pattern);
				return null;
			case "main_func":
				// return new MainFunc(pattern);
				return null;
			case "func_decs":
				// return new FuncDecs(pattern);
				return null;
			case "code":
				// return new Code(pattern);
				return null;
			case "code_line":
				// return new CodeLine(pattern);
				return null;
			case "safe_code_line":
				// return new SafeCodeLine(pattern);
				return null;
			case "print_stmt":
				return new Print(pattern);
			case "scan_stmt":
				//return new Scan_stmt(pattern);
				return null;
			case "type":
				//return new Type(pattern);
				return null;
			case "declaration":
				//return new Declaration(pattern);
				return null;
			case "var_list":
				//return new Var_list(pattern);
				return null;
			case "assignment":
				//return new Assignment(pattern);
				return null;
			case "assign_list":
				//return new Assign_list(pattern);
				return null;
			case "array_index":
				//return new Array_index(pattern);
				return null;
			case "array":
				//return new Array(pattern);
				return null;
			case "array_vals":
				//return new Array_vals(pattern);
				return null;
			case "value":
				// return new Value(pattern);
				return null;
			case "cond":
				//return new Cond(pattern);
				return null;
			case "cond2":
				//return new Cond2(pattern);
				return null;
			case "cond3":
				//return new Cond3(pattern);
				return null;
			case "cond4":
				//return new Cond4(pattern);
				return null;
			case "expr":
				return new Expr(pattern);
			case "expr2":
				return new Expr2(pattern);
			case "expr3":
				return new Expr3(pattern);
			case "code_body":
				//return new Code_body(pattern);
				return null;
			case "if_stmt":
				//return new If_stmt(pattern);
				return null;
			case "switch_stmt":
				//return new Switch_stmt(pattern);
				return null;
			case "switch_body":
				//return new Switch_body(pattern);
				return null;
			case "case_body":
				//return new Case_body(pattern);
				return null;
			case "default_body":
				//return new Default_body(pattern);
				return null;
			case "loop":
				//return new Loop(pattern);
				return null;
			case "for_loop":
				//return new For_loop(pattern);
				return null;
			case "while_loop":
				//return new While_loop(pattern);
				return null;
			case "do_while_loop":
				//return new Do_while_loop(pattern);
				return null;
			case "return_stmt":
				//return new Return_stmt(pattern);
				return null;
			case "func_dec":
				//return new Func_dec(pattern);
				return null;
			case "func_params":
				//return new Func_params(pattern);
				return null;
			case "func_call":
				//return new Func_call(pattern);
				return null;
			default:
				return null;
		}
	}
}