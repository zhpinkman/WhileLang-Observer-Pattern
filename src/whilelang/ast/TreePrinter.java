package whilelang.ast;

public class TreePrinter implements Visitor<String> {
	int level = 0;
	void incLevel() { 
		level = level + 1; 
	}
	void decLevel() { 
		level = level - 1; 
	}

	String printInc() { 
		char[] chars = new char[level];
		java.util.Arrays.fill(chars, '\t');
		return new String(chars);
	}
	
	public String visit( Var n) {
		return n.varID;
	}
	
	public String visit( IntLiteral n) {
		return Integer.toString(n.value);
	}
	
	public String visit( Plus n) { 
		return "(" + n.lhs.accept(this) + " + " + n.rhs.accept(this) + ")"; 
	}
	
	public String visit ( Minus n) {
		return "(" + n.lhs.accept(this) + " - " + n.rhs.accept(this) + ")";
	}
	
	public String visit( Times n) {
		return "(" + n.lhs.accept(this) + " * " + n.rhs.accept(this) + ")"; 
	}
	
	public String visit( Division n) { 
		return "(" + n.lhs.accept(this) + " / " + n.rhs.accept(this) + ")";
	}
	
	public String visit( Modulo n) {
		return "(" + n.lhs.accept(this) + " % " + n.rhs.accept(this) + ")";
	}
	
	public String visit( Equals n) { 
		return "(" + n.lhs.accept(this) + " == " + n.rhs.accept(this) + ")";
	}
	
	public String visit( GreaterThan n) { 
		return "(" + n.lhs.accept(this) + " > " + n.rhs.accept(this) + ")";
	}
	
	public String visit( LessThan n) {
		return "(" + n.lhs.accept(this) + " < " + n.rhs.accept(this) + ")";
	}
	
	public String visit( And n) {
		return "(" + n.lhs.accept(this) + " && " + n.rhs.accept(this) + ")";
	}
	
	public String visit( Or n) {
		return "(" + n.lhs.accept(this) + " || " + n.rhs.accept(this) + ")";
	}
	
	public String visit( Neg n) {
		return "-" + n.expr.accept(this);
	}
	
	public String visit( Not n) {
		return "!" + n.expr.accept(this); 
	}

	public String visit(UnaryExpression n) {
		return "";
	}

	public String visit(BinaryExpression n) {
		return "";
	}

	// ##############   Statements   ##############
	
	public String visit( IfThenElse n) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(printInc() + "if (" + n.expr.accept(this) + ") {\n");
		incLevel();
		strBuilder.append(n.then.accept(this));
		decLevel();
		if( n.elze != null ) {
			if (n.elze.accept(this) != "") {
				strBuilder.append(printInc() + "} else {\n");
				incLevel();
				strBuilder.append(n.elze.accept(this));
				decLevel();
			}
		}
		strBuilder.append(printInc() + "}\n");
		return strBuilder.toString();
	}	
	
	public String visit( Print n) {
		return printInc() + "println(\"" + n.msg + "\", " + n.varID + ");\n";
	}
	
	public String visit( Assign n) {
		return printInc() + n.varID + " = " +  n.expr.accept(this) + ";\n";
	}
	
	public String visit( While n) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(printInc() + "while (" + n.expr.accept(this) + ") {\n");
		incLevel();
		strBuilder.append(n.body.accept(this));
		decLevel();
		strBuilder.append( printInc() + "}\n");
		return strBuilder.toString();
	}
	
	public String visit( For n) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append( printInc() + "for (" + n.init.accept(this).replace("\n"," ").replace( "\t" , "") + n.expr.accept(this).replace("\n","") + "; "
				+ n.step.accept(this).replace("\n"," ").replace( "\t" , "" ).replace(";","") + ") {\n");
		incLevel();
		strBuilder.append( n.body.accept(this));
		decLevel();
		strBuilder.append( printInc() + "}\n");
		return strBuilder.toString();
	}
	
	public String visit( Block n) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append( printInc() + "{\n" );
		incLevel();
		for( Statement stat: n.body)
			strBuilder.append(stat.accept(this));
		decLevel();
		strBuilder.append( printInc() + "}\n" );
		return strBuilder.toString();
	}
	
	public String visit( Skip n) {
		return "";
	}
}	