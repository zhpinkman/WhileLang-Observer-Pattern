package whilelang.ast;

public class Times extends BinaryExpression {

	public Times(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
