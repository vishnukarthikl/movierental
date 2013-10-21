package bootcamp.movies;

public class RegularMovieType extends MovieType {

    public static final double PER_RENTAL_CHARGE = 2;
    public static final int PENALTY_AFTER_DAYS = 2;
    public static final double PENALTY_RATE = 1.5;

    @Override
    protected double getPerRentalCharge() {
        return PER_RENTAL_CHARGE;
    }

    @Override
    protected int getPenaltyAfterDays() {
        return PENALTY_AFTER_DAYS;
    }

    @Override
    protected double getPenaltyRate() {
        return PENALTY_RATE;
    }
}
