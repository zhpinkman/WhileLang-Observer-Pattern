package whilelang.ast;

public class GreaterThan extends BinaryExpression {

	public GreaterThan(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}