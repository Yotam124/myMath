package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	// ******** add your code below *********

	
	public int compare(Monom a, Monom b) {
		if (a.get_power() > b.get_power()) {
			return 1;
		}
		else if (a.get_power() < b.get_power()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
