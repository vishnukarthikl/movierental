package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String name;
	private final List<Rental> rentals = new ArrayList<Rental>();

	public Customer(final String name) {
		this.name = name;

	}

	public void addRental(final Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

    public List<Rental> getRentals() {
        return rentals;
    }
}
