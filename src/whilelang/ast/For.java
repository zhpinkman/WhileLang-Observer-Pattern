package whilelang.ast;

public class For extends Statement {
	public SingleStatement init;
	public Expression expr;
	public SingleStatement step;
	public Statement body;
	public For(SingleStatement init, Expression expr, SingleStatement step, Statement body) {
		this.init = init;
		this.expr = expr;
		this.step = step;
		this.body = body;
	}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}