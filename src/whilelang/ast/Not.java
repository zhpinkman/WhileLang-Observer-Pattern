package whilelang.ast;

public class Not extends UnaryExpression {

	public Not(Expression expr) {
		super(expr);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}