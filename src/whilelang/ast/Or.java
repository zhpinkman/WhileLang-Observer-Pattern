package whilelang.ast;

public class Or extends BinaryExpression {

	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}