package whilelang.ast;

public class While extends Statement {
	public Expression expr;
	public Statement body;
	public While(Expression expr, Statement body) {this.expr = expr; this.body = body;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}