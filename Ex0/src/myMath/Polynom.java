package myMath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	// ********** add your code below ***********
	
	private Comparator<Monom> comp = new Monom_Comperator();
	private ArrayList<Monom> pol;
	
	
	/**
	 * Default constructor. 
	 */
	public Polynom() { //Default constructor.
		pol = new ArrayList<Monom>();
	}
	
	/**
	 * String constructor.
	 * @param str
	 */
	public Polynom(String str) { //String constructor.
		str = str.toLowerCase(); //Replaces the capital letters with small ones.
		
		pol = new ArrayList<Monom>(); // Define new ArrayList.
		String[] st = str.split("[+]"); //Remove all the char "+" from the str and push it to array.
		
		for (int i = 0; i < st.length; i++) { //running throw the array
			if (st[i].contains("-")) { //if the cell in the i position contains "-".
				String temp = st[i].substring(0, 1); //temp = first char.
				if (!temp.equals("-")) { //Checking if the "-" is located at the beginning.
					String[] stnew = st[i].split("[-]"); //if "-" is not at the beginning, split the "-" and push it to array. 
					String s1 = stnew[0]; //take first cell.
					Monom m1 = new Monom(s1); //Create a monom with the first cell values.
					this.add(m1); //adding the monom.
				}
				String[] stnew = st[i].split("[-]"); //if "-" is at the beginning, split the "-" and push it to array.
				for (int j = 1; j < stnew.length; j++) { //running throw the array.
					String s2 = stnew[j]; //take the monom with "-" at the beginning, starting from the second index (first index contains "").
					if (s2.charAt(0) == 'x'){ //if there is only x without coefficient.
						Monom m2 = new Monom("-1*"+s2);; //Create a monom and saves the "-" before the "x". it will not work if it will be -2x only -x.
						this.add(m2); //adding the Monom.
					}
					else { //if there is coefficient for x.
						Monom m2 = new Monom("-"+s2);
						this.add(m2);	
					}
				}
			}
			else { //if the cell in the i position not contains "-".
				String s1 = st[i]; //Create a positive regular Monom.
				Monom m1 = new Monom(s1);
				this.add(m1);  //adding the Monom.
			}
			
		}
	}
	
	/**
	 * Copy constructor.
	 * @param p
	 */
	public Polynom(Polynom_able p) { //Copy constructor.
		Iterator<Monom> iter = p.iteretor();
		pol = new ArrayList<Monom>();
		while (iter.hasNext()) {
			Monom temp = iter.next();
			pol.add(temp);
		}
	}
	
	/**
	 *Printing by toString.
	 */
	@Override
	public String toString() { //toString
		return "" + pol + "";
	}
	
	/**
	 * Add between two polynomials.
	 */
	public void add(Polynom_able p1) { 
		Iterator<Monom> iter = p1.iteretor();
		while (iter.hasNext()) {
			Monom temp = iter.next();
			this.add(temp);
		}
		
	}
	
	/**
	 * Add a monom to polynom.
	 */
	public void add(Monom m1) {  //function that get a Monom and add it to the specific polynom.
		if (m1.get_coefficient() == 0) {  //if the coefficient = 0.
			return; //finish the function without do nothing.
		}
		Iterator<Monom> iter = pol.iterator(); //Iterator that can help go through all the Monoms.
		while (iter.hasNext()) {  // a loop that will finish when if there is no Monom left in the Iterator. - check if we can add the given Monom to a specific Monom is the polynom.
			Monom temp = iter.next(); // Monom variable that will take the current Monom in the Iterator.
			if (temp.get_power() == m1.get_power()) { // check if the powers are the same.
				 temp.add(m1); 
				 return;
			}
		}
		pol.add(m1); //adding the Monom to the Monom.
		this.pol.sort(comp);
	}
	
	/**
	 * Performs subtraction between two polynomials
	 */
	public void substract(Polynom_able p1) { 
		
		Iterator<Monom> iter = p1.iteretor();
		while (iter.hasNext()) {
			Monom temp = iter.next();
			Monom temp1 = new Monom(-temp.get_coefficient(), temp.get_power());
			this.add(temp1);
		}
	}
	
	/**
	 * Performs multiplication between two polynomials.
	 */
	public void multiply(Polynom_able p1) { //function that get a polynom and multiply it with the other polynom.
		Polynom multP = new Polynom(); //Define a new polynom.
		Iterator<Monom> pol = this.iteretor();
		while (pol.hasNext()) { 
			Iterator<Monom>  p = p1.iteretor();
			Monom firstP = pol.next();  // Monom variable that will take the current Monom in the Iterator.
			pol.remove(); // remove the current Monom from the polynom.
			while (p.hasNext()) { 
				Monom temp = new Monom(firstP.get_coefficient(), firstP.get_power()); // make a new Monom with the same values like the currnt Monom.
				Monom secP = p.next(); // Monom variable that will take the current Monom in the Iterator.(p1)
				temp.multiply(secP); // multiply the 2 Monoms.
				multP.add(temp); //add the answer of multiply to the new polynom that we Define in the start.
			}
		}
		this.add(multP); //adding the Define polynom to the original polynom.
	}
	
	/**
	 * Checks equality between two polynomials.
	 */
	public boolean equals (Polynom_able p1) {  // function that check if the 2 polynoms are equals.
		this.pol.sort(comp); // make a sort to the polynom.
		Polynom p1Copy = new Polynom(); //Define a new polynom.
		Iterator<Monom>  p = p1.iteretor();
		while (p.hasNext()) {
			p1Copy.add(p.next()); // adding the Monoms from p1 to the Define polynom.
		}
		p1Copy.pol.sort(comp); // make a sort to the polynom.
		if (this.pol.size() != p1Copy.pol.size()) { //checking if the size of the 2 polynoms is the same.
			return false;
		}
		Iterator<Monom> p1Iter = p1Copy.iteretor();
		Iterator<Monom> pol = this.iteretor();
		
		boolean flag = true;
		while (pol.hasNext() && flag) {  // a loop the will end if there is no Monoms in "pol" or 1 Monom in "pol" not equals to the Monom in the "p1Iter".
			Monom firstP = pol.next(); // variable with the same values like the currnt Monom in "pol" polynom.
			Monom secP = p1Iter.next(); // variable with the same values like the currnt Monom in "p1Iter" polynom.
			if (firstP.get_coefficient() == secP.get_coefficient() && firstP.get_power() == secP.get_power()) { // checking if the 2 Monoms are equals.
				flag = true;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * Checks whether the polynomial is equal to zero
	 */
	public boolean isZero() { // function that check if all the Monoms in the polynom are 0;
		Iterator<Monom> iter = pol.iterator();
		while (iter.hasNext()) {
			if (iter.next().get_coefficient() != 0) { // check if the current Monom not 0.
				return false;
			}
		}
		return true;
	}
	
	/**
	 * assuming (f(x0)*f(x1)<=0, returns f(x2) such that:
	 * (i) x0<=x2<=x2 & (ii) |f(x2)|<eps
	 */
	public double root(double x0, double x1, double eps) {
		
		for (double i=x0 ; i<=x1 ; i+=0.0001) {
			if (Math.abs(this.f(i)) < eps) {
				return this.f(i);
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Copying the polynomial
	 */
	public Polynom_able copy() { // function that copying the current polynom.
		Iterator<Monom> iter = pol.iterator();
		Polynom polcopy = new Polynom();  //Define a new polynom.
		while (iter.hasNext()) {
			Monom temp = iter.next();// Monom variable that will take the current Monom in the Iterator.
			polcopy.add(temp); // add the Monom to the new polynom
		}
		
		return polcopy; // return the new copy polynom.
	}
	
	/**
	 * A derivative operation of a polynomial
	 */
	public Polynom_able derivative() { // function that do derivative to all the Monoms in the polynom.
		Iterator<Monom> iter = pol.iterator();
		Polynom polder = new Polynom();  //Define a new polynom.
		while (iter.hasNext()) {
			Monom temp = iter.next(); // Monom variable that will take the current Monom in the Iterator.
			temp.derivative(); // do derivative to the current Monom.
			polder.add(temp); // add the derivative to the new polynom
		}
		return polder; // return the derivative of the polynom.
	}
	
	/**
	 * Calculates the function area in the data ranges x0 and x1.
	 * there is a maximum deviation of the answer (eps).
	 */
	public double area(double x0,double x1, double eps) {
		
		double ans = 0;
		double area = 0;
		for (double i=x0 ; i<=x1 ; i+=eps) {
			ans = this.f(i);
			area += ans*eps;
			ans = 0;
		}
		return Math.abs(area);
	}
	
	public double f(double x) { // function that get a double number and put it in "x" in the polynom, and calculates the answer.
		Iterator<Monom> iter = pol.iterator();
		double ans = 0; // variable that keep the answer.
		while (iter.hasNext()) {
			Monom temp = iter.next(); // Monom variable that will take the current Monom in the Iterator.
			Monom integral = new Monom(temp.get_coefficient() , temp.get_power());  // Monom variable that get the values of the current Monom.
			ans += (integral.f(x)); // calculates the answer of the current Monom.
		}
		return ans;
		
	}
	
	public Iterator<Monom> iteretor(){
		Iterator<Monom> iter = this.pol.iterator();
		return iter;
		}
}
