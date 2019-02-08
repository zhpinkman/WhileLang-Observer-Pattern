package whilelang.progs;

import java.util.*;

import whilelang.ast.*;

public class Programs {
	
	public static Statement squares = new Block( new ArrayList<Statement>( Arrays.asList(
			new Assign("i", new IntLiteral(0)),
			new Assign("j", new IntLiteral(1)),
			new While( new LessThan(new Var("i"), new IntLiteral(10)), 
				new Block(new ArrayList<Statement>(Arrays.asList(
					new Print("", "j"),
					new Assign("i", new Plus(new Var("i"), new IntLiteral(1))),
					new Assign("j", new Plus(new Var("j"), 
							new Plus(new Times(new IntLiteral(2), new Var("i")), new IntLiteral(1))))
	)))))));
	
	public static Statement collatz = new Block( new ArrayList<Statement>( Arrays.asList(
			new Assign("x", new IntLiteral(13)),
			new While(new GreaterThan(new Var("x"), new IntLiteral(1)), 
				new Block( new ArrayList<Statement>( Arrays.asList(
			        new Print("x=", "x"),
			        new IfThenElse( new Equals( new Modulo( new Var("x"), new IntLiteral(2)), new IntLiteral(0)),
			        new Assign("x", new Division( new Var("x"), new IntLiteral(2))),
			        new Assign("x", new Plus( new Times(new IntLiteral(3), new Var("x")), new IntLiteral(1))))
	)))))));
	
	public static Statement sums = new Block( new ArrayList<Statement>( Arrays.asList(			        
			new Assign("sum", new IntLiteral(0)),
			new For(new Assign("i", new IntLiteral(1)),
				new LessThan( new Var("i"), new IntLiteral(100)),
				new Assign("i", new Plus( new Var("i"), new IntLiteral(1))),
				new IfThenElse( new Equals( new Modulo( new Var("i"), new IntLiteral(2)), new IntLiteral(0)),
					new Assign( "sum", new Plus( new Var("sum"), new Var("i"))),
					new Skip())),
			new Print("sum: ", "sum"))));

}