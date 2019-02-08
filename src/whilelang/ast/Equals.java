package whilelang.ast;

public class Equals extends BinaryExpression {

	public Equals(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
