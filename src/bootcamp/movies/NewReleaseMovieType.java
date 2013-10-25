package bootcamp.movies;

public class NewReleaseMovieType extends MovieType {
    public static final double RENTAL_RATE = 3;

    @Override
    public int calculateFrequentRenterPoints(int rentedDays) {
        return super.calculateFrequentRenterPoints(rentedDays) + (rentedDays > 1 ? 1 : 0);
    }

    @Override
    protected double getPerRentalCharge() {
        return 0;
    }

    @Override
    protected int getPenaltyAfterDays() {
        return 0;
    }

    @Override
    protected double getPenaltyRate() {
        return RENTAL_RATE;
    }
}
