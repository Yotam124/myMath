package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		Monom m2 = new Monom(3,4);
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
		fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testIteretor() {
		fail("Not yet implemented");
	}

}
