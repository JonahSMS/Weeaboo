public class Print extends NonTerminal {
	private NonTerminal nt;

	public Print(String pattern) {
		super("print_stmt",pattern);
	}

	public void interpret() throws Exception {
		switch(getProdString()) {
			case "print ( cond )":
				nt = (NonTerminal)getComponent("cond");
				nt.interpret();
				put("lineNo",nt.getAsInt("lineNo"));
				break;
			case "print ( func_call )":
				//TODO
				break;
			case "print ( assignment )":
				//TODO
				break;
			default:
		}
	}

	public void execute() {
		nt.execute();
		if( getProdString().startsWith("print")) {
			System.out.println(nt);
		} else {
			System.out.print(nt);
		}
	}
}