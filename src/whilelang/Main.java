package whilelang;

import whilelang.ast.Tree;
import whilelang.ast.TreePrinter;
import whilelang.ast.Visitor;
import whilelang.interp.*;
import whilelang.progs.Programs;

import java.io.IOException;

class Main {
	
    public static void main(String args[]) throws IOException {
    	// pretty print
        Visitor<String> tp = new TreePrinter();
    	System.out.println("############## Program Squares: ##############");
    	System.out.println(Programs.squares.accept(tp));
    	System.out.println("############## Program Collatz: ##############");
    	System.out.println(Programs.collatz.accept(tp));
    	System.out.println("############## Program Sums: ##############");
    	System.out.println(Programs.sums.accept(tp));
    	System.out.println("############## Program Sums After Simplification: ##############");
    	Visitor<Tree> ts = new TreeSimplifier();
    	System.out.println(Programs.sums.accept(ts).accept(tp));
    	// interpret
    	Visitor<Integer> ip = new Interpreter();
//    	Programs.squares.accept(ip);
//    	Programs.collatz.accept(ip);
//    	Programs.sums.accept(ip);

    	// samples
//		System.out.println("############## Sample programs: ##############");
//		System.out.println("############## Sample: ##############");
//		System.out.println(Programs.sample.accept(tp));
//		System.out.println("############## Sample1: ##############");
//		System.out.println(Programs.sample1.accept(tp));
//		System.out.println("############## Sample2: ##############");
//		System.out.println(Programs.sample2.accept(tp));
//		System.out.println(Programs.sampleFayyaz.accept(tp));
		// interpret
//		Programs.sample.accept(ip);
//		Programs.sample1.accept(ip);
//		Programs.sample2.accept(ip);
//		Programs.sampleFayyaz.accept(ip);
    }
}