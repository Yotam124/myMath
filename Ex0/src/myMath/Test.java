package myMath;

import java.nio.channels.Pipe;

public class Test {

	public static void main(String[] args) {
	

		///////////////////////////// Monom-Test /////////////////////////////
		
		//Creating Monoms and printing them.
		System.out.println("///////////// Monom-Test /////////////");
		Monom a1 = new Monom(2,3);
		Monom a2 = new Monom(a1);
		Monom a3 = new Monom();
		Monom a4 = new Monom("2X^4");
		Monom a5 = new Monom(5,3);
		Monom a6 = new Monom(3,2);
		
		System.out.println("a1: "+a1);
		System.out.println("a2: "+a2);
		System.out.println("a3: "+a3);
		System.out.println("a4: "+a4);
		System.out.println("a5: "+a5);
		System.out.println("a6: "+a6);
		
		//Checks the functions.
		int x1=10;
		System.out.println("f("+x1+")=" + a1 + " = " + a1.f(x1));
		a4.derivative();
		System.out.println("derivative: a4: f'(x)="+a4);
		a1.add(a5);
		System.out.println("Add: a3+a1 =  "+ a1);
		a5.multiply(a6);
		System.out.println("Multiply: a4*a5: " + a5);
		
		
		
		System.out.println();
		///////////////////////////// Polynom-Test /////////////////////////////
		
		//Creating Monoms, Polynoms and printing them.
		System.out.println("///////////// Polynom-Test /////////////");
		Monom b1 = new Monom(2,3);
		Monom b2 = new Monom(3,4);
		Monom b3 = new Monom("4X^5");
	
		Polynom p1 = new Polynom();
		Polynom p2 = new Polynom("2x^3-3X^4+4*X^5");
		Polynom p3 = new Polynom();
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		Polynom p4 = new Polynom(p2);
		Polynom p5 = new Polynom("4x^5-5X^6");
		Polynom p6 = new Polynom("7x^5+6X^7");
		Polynom p7 = new Polynom("3x^4+5X^7");
		Polynom p8 = new Polynom("5x^5-7X^7");
		Polynom p9 = new Polynom("2x^3+3X^4+4X^5");
		Polynom p10 = new Polynom("3x^3-3X^2");
		Polynom p11 = new Polynom("2x-x^2+4");
		
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
		System.out.println("p4: "+p4);
		System.out.println("p5: "+p5);
		System.out.println("p6: "+p6);
		System.out.println("p7: "+p7);
		System.out.println("p8: "+p8);
		System.out.println("p9: "+p9);
		System.out.println("p10: "+p10);
		System.out.println("p11: "+p11);
		
		System.out.println();
		
		//Checks the functions.
		p2.add(p3);
		System.out.println("Add: p2+a3 =  " + p2);
		p5.substract(p6);
		System.out.println("Substract: p5-p6 = " + p5);
		p7.multiply(p8);
		System.out.println("Multiply: p7*p8 = " + p7);
		System.out.println("Equals: p3=p9? : " + p3.equals(p9));
		System.out.println("Equals: p3=p8? : " + p3.equals(p8));
		System.out.println("isZero: p1=0? : " + p1.isZero());
		System.out.println("isZero: p2=0? : " + p2.isZero());
		System.out.println("area: p10.area = " + p10.area(1, 3, 0.0001));
		System.out.println("root: p10.root = " + p10.root(-1, 4, 0.01));
		System.out.println("derivative:  p10: f'(x)="+p10.derivative());
		int x2=3;
		System.out.println("f("+x2+")=" + p11 + " = " + p11.f(x2));
		
		
		Polynom l = new Polynom("x");
		System.out.println(l.area(-1, 1, 0.01));
		
		
		
	}
}
