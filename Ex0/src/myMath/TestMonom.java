package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMonom {
	
	@Test
	public void testMonom() {
		Monom m = new Monom();
		if (m.get_coefficient() != 0 && m.get_power() == 0) {
			fail("Coefficient and Power are not equal to 0");
		}
	}
	
	@Test
	public void testMonomMonom() { 
		Monom ot = new Monom();
		Monom m = new Monom(ot);
		if (m.get_coefficient() != ot.get_coefficient() && m.get_power() != ot.get_power()) {
			fail("Coefficient and Power are not equal to the Copyed Monom (ot)");
		}
	}
	
	@Test
	public void testMonomDoubleInt() {
		int a = 1;
		int b = 2;
		Monom m = new Monom(a,b);
		if (m.get_coefficient() != a && m.get_power() != b) {
			fail("The coefficient and power are not equal to the parameters entered for the constructor");
		}
	}
	
	@Test
	public void testMonomString() {
		Monom m = new Monom("2x^6");
		if (m.get_coefficient() != 2 && m.get_power() != 6) {
			fail("The coefficient and power are not equal to the parameters entered for the constructor");
		}
	}
	
	@Test
	public void testMonomStringSyntax() {
		try {
		Monom m = new Monom("2xx^6");
		fail("Invalid syntax");
		} catch (Exception e) {
			System.out.println("Good");
		}
	}
	
	@Test
	public void testF() {
		int a = 2;
		int b = 4;
		double x = 3;
		Monom m = new Monom(a,b);
		double ans = m.get_coefficient()*Math.pow(x,b);
		if (m.f(x) != ans) {
			fail("There is a problem with the function f(double x)");
		}
	}
	
	@Test
	public void testDerivative() {
		int a = 2;
		int b = 4;
		int aDer = 0;
		int bDer = 0;
		Monom m = new Monom(a,b);
		m.derivative();
		if (b>0) {
			aDer = a*b;
			bDer = b-1;
			if (aDer != m.get_coefficient() && bDer != m.get_power()) {
				fail("There is a problem with the derivative function");
			}
		}
		else {
			if (m.get_coefficient() != 0 && m.get_power() != 0) {
				fail("There is a problem with the derivative function");
			}
		}
	}
	
	@Test
	public void testAdd() {
		double a1 = 2, a2 = 3;
		int b1 = 4, b2 = 4;
		Monom m1 = new Monom(a1,b1);
		Monom m2 = new Monom(a2,b2);
		m1.add(m2);
		if (b1 == b2) {
			double aAns = a1 + a2;
			if (m1.get_coefficient() != aAns) {
				fail("There is a problem with the add function, the powers was equal but still there was no add between the coefficients");
			}
		}
		else {
			if (m1.get_coefficient() != a1 || m2.get_coefficient() != a2 || m1.get_power() != b1 || m2.get_power() != b2) {
				fail("There is a problem with the add function, the powers are not equal but still at least one of the monoms has been modified ");
			}
		}
	}
	
	@Test
	public void testMultiply() {
		double a1 = 2, a2 = 3;
		int b1 = 4, b2 = 4;
		Monom m1 = new Monom(a1,b1);
		Monom m2 = new Monom(a2,b2);
		m1.multiply(m2);
		double aAns = a1 * a2;
		int bAns = b1 + b2;
		if (m1.get_coefficient() != aAns || m1.get_power() != bAns) {
			fail("There is a problem with the add function, the powers was equal but still there was no add between the coefficients");
		}
	}

}
