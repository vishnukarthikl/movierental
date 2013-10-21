package bootcamp.movies;

public abstract class MovieType {

    public static final int DEFAULT_RENTERPOINTS_PER_RENTAL = 1;

    protected abstract double getPerRentalCharge();
    protected abstract int getPenaltyAfterDays();
    protected abstract double getPenaltyRate();

    public double calculateCharge(int rentedDays) {
        double amount = getPerRentalCharge();
        if (rentedDays > getPenaltyAfterDays()) {
            amount += (rentedDays - getPenaltyAfterDays()) * getPenaltyRate();
        }
        return amount;
    }

    public int calculateFrequentRenterPoints(int rentedDays) {
        return DEFAULT_RENTERPOINTS_PER_RENTAL;
    }
}
