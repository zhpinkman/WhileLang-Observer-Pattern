package whilelang.ast;
 
public abstract class Tree {
	public abstract <R> R accept(Visitor<R> v);          
}