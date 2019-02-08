package whilelang.ast;

public class Minus extends BinaryExpression {

	public Minus(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
