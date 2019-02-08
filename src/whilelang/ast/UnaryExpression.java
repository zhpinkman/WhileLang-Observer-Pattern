package whilelang.ast;

public class UnaryExpression extends Expression {
    public Expression expr;

    public UnaryExpression(Expression expr) {
        this.expr = expr;
    }

    public <R> R accept(Visitor<R> v) {
        return v.visit(this);
    }
}