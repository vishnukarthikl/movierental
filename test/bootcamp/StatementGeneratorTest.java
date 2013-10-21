package bootcamp;

import bootcamp.formatter.SimpleTextFormatter;
import bootcamp.movies.ChildrenMovieType;
import bootcamp.movies.NewReleaseMovieType;
import bootcamp.movies.RegularMovieType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StatementGeneratorTest {

	private static final int ONE_DAY = 1;
	private static final int TWO_DAYS = 2;
	private static final int THREE_DAYS = 3;
	private static final int FOUR_DAYS = 4;

	private Customer customer;
	private final Movie regular = new Movie("A New Hope", new RegularMovieType());
	private final Movie childrens = new Movie("A Phantom Menace",
			new ChildrenMovieType());
	private final Movie newRelease = new Movie("Revenge of the Sith",
			new NewReleaseMovieType());

	@Before
	public void setUp() {
		customer = new Customer("nhpatt");
	}

	@Test
	public void testStatementOneRegular() throws IOException {
		addRentalOfMovie(regular, TWO_DAYS);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tA New Hope\t2.0\n");
		expectedStatement.append("Amount owed is 2.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
		assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementOneRegularMoreThanTwoDays() throws IOException {
		addRentalOfMovie(regular, THREE_DAYS);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tA New Hope\t3.5\n");
		expectedStatement.append("Amount owed is 3.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
        assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementOneForChildren() throws IOException {
		addRentalOfMovie(childrens, TWO_DAYS);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tA Phantom Menace\t1.5\n");
		expectedStatement.append("Amount owed is 1.5\n");
		expectedStatement.append("You earned 1 frequent renter points");
        assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementOneForChildrenMoreThanThreeDays() throws IOException {
		addRentalOfMovie(childrens, FOUR_DAYS);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tA Phantom Menace\t3.0\n");
		expectedStatement.append("Amount owed is 3.0\n");
		expectedStatement.append("You earned 1 frequent renter points");
        assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementOneRentalNewRelease() throws IOException {
		addRentalOfMovie(newRelease, TWO_DAYS);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tRevenge of the Sith\t6.0\n");
		expectedStatement.append("Amount owed is 6.0\n");
		expectedStatement.append("You earned 2 frequent renter points");
        assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementNoRentals() throws IOException {
		assertEquals(
				"Rental Record for nhpatt\nAmount owed is 0.0\nYou earned 0 frequent renter points",
                new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	@Test
	public void testStatementFourRentals() throws IOException {
		addRentalOfMovie(regular, TWO_DAYS);
		addRentalOfMovie(newRelease, TWO_DAYS);
		addRentalOfMovie(childrens, THREE_DAYS);
		addRentalOfMovie(regular, ONE_DAY);

		final StringBuffer expectedStatement = new StringBuffer();
		expectedStatement.append("Rental Record for nhpatt\n");
		expectedStatement.append("\tA New Hope\t2.0\n");
		expectedStatement.append("\tRevenge of the Sith\t6.0\n");
		expectedStatement.append("\tA Phantom Menace\t1.5\n");
		expectedStatement.append("\tA New Hope\t2.0\n");
		expectedStatement.append("Amount owed is 11.5\n");
		expectedStatement.append("You earned 5 frequent renter points");
        assertEquals(expectedStatement.toString(), new StatementGenerator(new SimpleTextFormatter()).generateFor(customer));
	}

	private void addRentalOfMovie(final Movie movie, final int daysRented) {
		customer.addRental(new Rental(movie, daysRented));
	}

}
