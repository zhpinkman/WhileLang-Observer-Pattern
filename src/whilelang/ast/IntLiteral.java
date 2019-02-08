package whilelang.ast;

public class IntLiteral extends Expression {
	public int value;
	public IntLiteral( int value) {this.value = value;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}
