package whilelang.ast;

public class LessThan extends BinaryExpression {

	public LessThan(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
