package whilelang.ast;

public class And extends BinaryExpression {
	public And(Expression lhs, Expression rhs) {super( lhs , rhs );}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
