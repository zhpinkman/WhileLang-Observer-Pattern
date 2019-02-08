package whilelang.ast;

public class Var extends Expression {
	public String varID;
	public Var(String varID) {this.varID = varID;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}