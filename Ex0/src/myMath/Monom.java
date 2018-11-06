
package myMath;

import java.lang.reflect.Constructor;
import java.util.Spliterator;

import javax.management.RuntimeErrorException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************
	/**
	 * Default constructor
	 */
	public Monom() {
		this.set_coefficient(0);
		this.set_power(0);
	}
	
	
	/**
	 * String constructor
	 * @param str
	 */
	public Monom(String str) { //constructor that get a String and make from it Monom.
		
		str = str.toLowerCase(); //Replaces the capital letters with small ones.
		
		if (!str.contains("x")) { // Check if the given String contains "x". (enters if not found an "x")
			Monom m1 = new Monom(Double.parseDouble(str),0); //Create a Monom with only coefficient(power = 0);
			this.add(m1); //adding the monom.
			return;
		}
		String[] st = str.split("[xX^]"); //if the given String have "x" we split the String from this operators: xX^.
		try {
			if (st[0].length() == 0) { //if there is no number before the "x".
				this.set_coefficient(1); //set the coefficient to be 1.
			}
		} 
		catch (Exception e) { //if there is no st[0]:
			this.set_coefficient(1); //set the coefficient to be 1.
		}
		try {
			if (st[2].length() == 0) {  // st[2] supposed to be the power of the Monom and if there is no number there, do:
				this.set_power(1);  // set the power to be 1.
			}
		} 
		catch (Exception e) {//if there is no st[2];
			this.set_power(1); // set the power to be 1;
		}
		try {
			if (st[0].length() >= 1) { //if there is something before the "x":
				String[] stt = st[0].split("[*]"); //split the thing before the "x" by "" if there is an "*" of course.
				double ans = 1; // new variable that calculates the numbers before the "x" like 2*2*2x = 8x, 44x = 44x.
				for (int i = 0; i < stt.length; i++) {  // new loop the multiply the numbers before the "x" if there is an "*".
					ans = ans * Double.parseDouble(stt[i]);
				}
				this.set_coefficient(ans);  // set the coefficient to be the answer of the numbers before the "x".
			}
		} 
		catch (Exception e) {  //if there is no st[0];
		}
		try {
			if (st[2].length() > 0) { // if there is some numbers in the st[2] that supposed to be the power of the Monom;
				this.set_power(Integer.parseInt(st[2])); //if we have numbers we set the power to be them.	
			}
		} 
		catch (Exception e) { //if there is no st[2]
		}
	}
		
	/**
	 * Get coefficient.
	 * @return coefficient
	 */
	public double get_coefficient(){ 
		return _coefficient;
	}
	
	/**
	 * Get power.
	 * @return Power
	 */
	public int get_power() {
		return _power;
	}
	
	/**
	 * Calculates the function value in a certain x.
	 */
	public double f(double x) { //function the get a double number and return the answer of the specific Monom like: 3X^2 (x = 2) = 3*(2^2) = 12.
		double answer = (get_coefficient())*(Math.pow(x, get_power())); //calculates the Monom with the given number.
		return answer;
	}
	
	/**
	 * A derivative operation of a monom.
	 */
	public void derivative() { //calculates the derivative the Monom like: 2X^2 = (2*2)X^(2-1) = 4X^1
		this._coefficient = get_coefficient() * this.get_power(); //multiply the power with the coefficient.
		this._power = get_power() - 1;  // reduce the power by 1.
	}
	
	/**
	 * Add between two monomers.
	 * @param A
	 */
	public void add(Monom A) { // function that get a Monom and add it to the specific Monom.
		if (this.get_power() == A.get_power()) { //check if the power of the 2 Monoms is the same.
			this._coefficient += A.get_coefficient(); // if the powers are the same we add the coefficient to the specific Monom.
		}
		else {
			System.err.println("Diffrent powers"); //if the powers are diffrent we dont do nothing.
		}
	}
	
	/**
	 * Performs multiplication between two monomers.
	 * @param A
	 */
	public void multiply(Monom A) { //function that multiply 2 Monoms.
		this._coefficient *= A.get_coefficient(); // multiply the 2 coefficient.
		this._power += A.get_power(); // add the 2 powers.
	}
	
	/**
	 * Printing by toString.
	 */
	public String toString() { //function that print a Monom.
		String str = this._coefficient + "X^" + this._power; // print the coefficient and the power of the Monom.
		return str;
	}
	//****************** Private Methods and Data *****************
	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power; 
}
