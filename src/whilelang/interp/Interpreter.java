package whilelang.interp;

import whilelang.ast.*;

import java.util.HashMap;
import java.util.Map;

public class Interpreter implements Visitor<Integer>{

	private Map<String, Integer> variables = new HashMap<String, Integer>();

	public Integer visit(Print n) {
		// TODO Implement this!
		try {
			System.out.println(n.msg + new Var(n.varID).accept(this).toString());
		}catch (Exception e){
			System.out.println("Error: Use of undeclared variable");
		}
		return null;
	}

	public Integer visit(Assign n) {
		// TODO Implement this!
		variables.put(n.varID, n.expr.accept(this));
		return null;
	}

	public Integer visit(Skip n) {
		// TODO Implement this!

		return null;
	}

	public Integer visit(Block n) {
		// TODO Implement this!
		for(Statement statement: n.body){
			statement.accept(this);
		}
		return null;
	}

	public Integer visit(IfThenElse n) {
		// TODO Implement this!
		if(n.expr.accept(this) != 0){
			n.then.accept(this);
		}else{
			n.elze.accept(this);
		}
		return null;
	}

	public Integer visit(While n) {
		// TODO Implement this!
		while (n.expr.accept(this) != 0){
			n.body.accept(this);
		}
		return null;
	}

	public Integer visit(For n) {
		// TODO Implement this!
		n.init.accept(this);
		while(n.expr.accept(this) != 0){
			n.body.accept(this);
			n.step.accept(this);
		}
		return null;
	}


	public Integer visit(Var n) {
		// TODO Implement this!
		return variables.get(n.varID);
	}

	public Integer visit(IntLiteral n) {
		// TODO Implement this!
		return n.value;
	}

	public Integer visit(Plus n) {
		// TODO Implement this!
		return n.lhs.accept(this) + n.rhs.accept(this);
	}

	public Integer visit(Minus n) {
		// TODO Implement this!
		return n.lhs.accept(this) - n.rhs.accept(this);
	}

	public Integer visit(Times n) {
		// TODO Implement this!
		return n.lhs.accept(this) * n.rhs.accept(this);
	}

	public Integer visit(Division n) {
		// TODO Implement this!
		return n.lhs.accept(this) / n.rhs.accept(this);
	}

	public Integer visit(Modulo n) {
		// TODO Implement this!
		return n.lhs.accept(this) % n.rhs.accept(this);
	}

	public Integer visit(Equals n) {
		// TODO Implement this!
		return (n.lhs.accept(this) == n.rhs.accept(this)) ? 1 : 0;
	}

	public Integer visit(GreaterThan n) {
		// TODO Implement this!
		return (n.lhs.accept(this) > n.rhs.accept(this)) ? 1 : 0;
	}

	public Integer visit(LessThan n) {
		// TODO Implement this!
		return (n.lhs.accept(this) < n.rhs.accept(this)) ? 1 : 0;
	}

	public Integer visit(And n) {
		// TODO Implement this!
		return (n.lhs.accept(this) * n.rhs.accept(this));
	}

	public Integer visit(Or n) {
		// TODO Implement this!
		return (n.lhs.accept(this) +  n.rhs.accept(this)) - (n.lhs.accept(this) *  n.rhs.accept(this));
	}

	public Integer visit(Neg n) {
		// TODO Implement this!
		return -n.accept(this);
	}

	public Integer visit(Not n) {
		// TODO Implement this!
		if(n.accept(this) == 1){
			return 0;
		}else {
			return 1;
		}
	}

	public Integer visit(UnaryExpression n) {
		// TODO Implement this!
		return n.expr.accept(this);
	}

	public Integer visit(BinaryExpression n) {
		// TODO Implement this!
		System.out.println(n);
		return null;
	}
}