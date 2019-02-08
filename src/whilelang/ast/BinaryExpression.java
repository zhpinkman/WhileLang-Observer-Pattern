package whilelang.ast;

public class BinaryExpression extends Expression {
    public Expression lhs;
    public Expression rhs;

    public BinaryExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public <R> R accept(Visitor<R> v) {
        return v.visit(this);
    }
}