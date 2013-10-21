package bootcamp;

import bootcamp.movies.MovieType;

public class Movie {

	private final String title;
    private final MovieType movieType;

	public Movie(final String title, final MovieType movieType) {
		this.title = title;
        this.movieType = movieType;
    }

	public String getTitle() {
		return title;
	}

    public MovieType getMovieType() {
        return movieType;
    }
}
