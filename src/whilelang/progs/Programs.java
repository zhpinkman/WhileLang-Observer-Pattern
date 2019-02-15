package whilelang.progs;

import java.util.*;

import whilelang.ast.*;

import javax.swing.plaf.nimbus.State;

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



	public static Statement sample = new Block( new ArrayList<Statement>( Arrays.asList(
			new Assign("f", new IntLiteral(8)),
			new While(new GreaterThan(new Var("f"), new IntLiteral(2)),
			new Block(new ArrayList<Statement>(Arrays.asList(
				new Print("f = ", "f"),
				new Assign("f", new Minus(new Var("f"), new IntLiteral(1)))
			)))),
			new Print("final f is ", "f"),
			new Print("final f is f", "f"))));

	public static Statement sample1 = new Block(new ArrayList<Statement>(Arrays.asList(
			new Assign("b", new IntLiteral(1)),
			new Assign("c", new IntLiteral(2)),
			new Assign("d", new IntLiteral(1)),
			new Assign("a",
					new Or(new And(new Minus(new Times(new IntLiteral(2), new Var("b")), new Var("c")),
							new Plus(new Var("d"), new Not(new Var("c")))),
							new Modulo(new Var("d"), new Var("c")))),
			new IfThenElse(new Equals(new Var("a"), new IntLiteral(2)),
					new Print("a", "a"), new Skip()),
			new Print("we all are freshmen , so a is ", "a"))));

	public static Statement sample2 = new Block(new ArrayList<Statement>(Arrays.asList(
			new Assign("i", new IntLiteral(0)),
			new For(new Assign("a", new IntLiteral(0)),
					new Or(new GreaterThan(new Var("a"), new IntLiteral(-5)), new Equals(new Var("a"), new IntLiteral(-5))),
					new Assign("a", new Minus(new Var("a"), new IntLiteral(1))),
					new Block(new ArrayList<Statement>(Arrays.asList(
							new Assign("i", new Plus(new Var("i"), new IntLiteral(1))),
							new Print("viva while and a is ", "a"))))),
			new Print("i is ", "i"))));
}