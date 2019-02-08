package whilelang.ast;

/* Skip represents empty statement. 
 * It is useful e.g. as "else" block of and if-then-else statement
 */
public class Skip extends SingleStatement {
	public Skip() {};
	public <R> R accept(Visitor<R> v) {
		return v.visit(this);
	}
};