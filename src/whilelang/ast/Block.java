package whilelang.ast;

import java.util.List;

public class Block extends Statement {
	public List<Statement> body;
	public Block(List<Statement> body) {this.body = body;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
}