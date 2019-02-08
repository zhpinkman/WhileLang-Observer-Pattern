package whilelang.ast;

public class Modulo extends BinaryExpression {

	public Modulo(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
