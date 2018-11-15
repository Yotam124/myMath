package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPolynom {

	
	@Test
	void testPolynom() {
		Polynom p = new Polynom();
		if (p.isZero() == false) {
			fail("The polynomial should be equal to 0 because it does not contain any monomers");
		}
	}

	@Test
	void testPolynomString() {
		Polynom p1 = new Polynom("2x^3-3x^4+4x^5");
		Polynom p2 = new Polynom();
		Monom m1 = new Monom(2,3);
		Monom m2 = new Monom(-3,4);
		Monom m3 = new Monom(4,5);
		p2.add(m1);
		p2.add(m2);
		p2.add(m3);
		if (p1.equals(p2) == false) {
			fail("There is a problem with the string constructor");
		}
	}

	@Test
	void testPolynomPolynom_able() {
		Polynom p1 = new Polynom("3x^3+3x^4-2x^2");
		Polynom p2 = new Polynom(p1);
		if (p1.equals(p2) == false) {
			fail("There is a problem with the copy constructor");
		}
	}

	@Test
	void testAddPolynom_able() {
		Polynom p1 = new Polynom("2x^3+3x^4");
		Polynom p2 = new Polynom("4x^5+5x^6");
		double x = 2;
		double p1Ans = p1.f(x);
		double p2Ans = p2.f(x);
		p1.add(p2);
		double ans = p1.f(x);
		if (ans != p1Ans+p2Ans) {
			fail("There is a problem with the add polynom function");
		}	
	}

	@Test
	void testAddMonom() {
		Polynom p1 = new Polynom("2x^3+3x^4");
		Monom m1 = new Monom("4x^5");
		double x = 2;
		double p1Ans = p1.f(x);
		double m1Ans = m1.f(x);
		p1.add(m1);
		double ans = p1.f(x);
		if (ans != p1Ans+m1Ans) {
			fail("There is a problem with the add Monom function");	
		}
		
	}

	@Test
	void testSubstract() {
		Polynom p1 = new Polynom("2x^3+3x^4");
		Polynom p2 = new Polynom("4x^5+5x^6");
		double x = 2;
		double p1Ans = p1.f(x);
		double p2Ans = p2.f(x);
		p1.substract(p2);
		double ans = p1.f(x);
		if (ans != p1Ans-p2Ans) {
			fail("There is a problem with the Substract function");
		}
	}

	@Test
	void testMultiply() {
		Polynom p1 = new Polynom("2x^1+3x^2");
		Polynom p2 = new Polynom("4x^2+2x^3");
		double x = 2;
		double p1Ans = p1.f(x);
		double p2Ans = p2.f(x);
		p1.multiply(p2);
		double ans = p1.f(x);
		if (ans != p1Ans * p2Ans) {
			fail("There is a problem with the Multiply function");
		}
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom p1 = new Polynom("2x^1+3x^2");
		Polynom p2 = new Polynom("2x^1+3x^2");
		if (p1.equals(p2) == false) {
			fail("There is a problem with the Equals function");
		}
	}

	@Test
	void testIsZero() {
		Polynom p1 = new Polynom("0x^1+0x^2");
		if (p1.isZero() == false) {
			fail("There is a problem with the IsZero function");
		}
	}

	@Test
	void testRoot() {
		Polynom p1 = new Polynom("x");
		if (p1.root(-2, 3, 0.1) > 0.1) {
			fail("Problem with the root function");
		}
		
	}

	@Test
	void testCopy() {
		Polynom p1 = new Polynom("2x^1+3x^2");
		Polynom_able p2 = new Polynom();
		p2 = p1.copy();
		if (p2.equals(p1) == false) {
			fail("There is a problem with the Copy function");
		}
	}

	@Test
	void testDerivative() {
		Polynom p1 = new Polynom("2x^1+3x^2");
		Polynom p2 = new Polynom();
		Monom m1 = new Monom("2x^1");
		Monom m2 = new Monom("3x^2");
		m1.derivative();
		m2.derivative();
		p2.add(m1);
		p2.add(m2);
		p1.derivative();
		if (p1.equals(p2) == false) {
			fail("There is a problem with the Derivative function");
		}
	}

	@Test
	void testArea() {
		Polynom p = new Polynom("x");
		double areaCheck = p.area(0, 2, 0.1);
		if (areaCheck >= 2.1 || areaCheck <= 1.9) {
		fail("Not the Correct area for this polynom");
		}
	}

	@Test
	void testF() {
		Polynom p1 = new Polynom("2x^1+3x^2");
		Monom m1 = new Monom("2x^1");
		Monom m2 = new Monom("3x^2");
		double ansp1 = 0,ansm = 0,x = 2;
		ansm = m1.f(x) + m2.f(x);
		ansp1 = p1.f(x);
		if (ansp1 != ansm) {
			fail("There is a problem with the F function");
		}
	}

	@Test
	void testIteretor() {
		Polynom p = new Polynom("2x^1+3x^2");
		Iterator<Monom> iter = p1.iteretor();
		Polynom p2 = new Polynom();
		while(iter.hasNext()) {
			p2.add(iter.next());
		}
		if (p1.equals(p2) == false) {
			
		}
	}

}