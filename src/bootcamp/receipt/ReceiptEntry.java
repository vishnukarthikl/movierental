package bootcamp.receipt;

import bootcamp.Movie;

public class ReceiptEntry {
    private Movie movie;
    private Double total;

    public ReceiptEntry(Movie movie, Double total) {
        this.movie = movie;
        this.total = total;
    }

    public Movie getMovie() {
        return movie;
    }

    public Double getTotal() {
        return total;
    }
}
