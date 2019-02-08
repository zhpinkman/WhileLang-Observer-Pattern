package whilelang.ast;

public class Assign extends SingleStatement {
	public String varID;
	public Expression expr;
	public Assign(String varID, Expression expr) {this.varID = varID; this.expr = expr;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}