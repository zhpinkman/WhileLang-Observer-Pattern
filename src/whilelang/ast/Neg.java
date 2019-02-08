package whilelang.ast;

public class Neg extends UnaryExpression {

	public Neg(Expression expr) {
		super(expr);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
