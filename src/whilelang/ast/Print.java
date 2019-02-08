package whilelang.ast;

public class Print extends SingleStatement {
	public String msg;
	public String varID;
	public Print(String msg, String varID) {this.msg = msg; this.varID = varID;}
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}	
}