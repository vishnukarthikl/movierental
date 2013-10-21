package bootcamp.receipt;

import bootcamp.Customer;
import bootcamp.Movie;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private Customer customer;
    private List<ReceiptEntry> receiptEntries = new ArrayList<>();
    private double total;
    private int frequentRenterPoints;


    public Receipt(Customer customer) {
        this.customer = customer;
    }

    public void addEntry(Movie movie, double amount) {
        receiptEntries.add(new ReceiptEntry(movie, amount));
    }

    public void addTotal(double total, int frequentRenterPoints) {
        this.total = total;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ReceiptEntry> getReceiptEntries() {
        return receiptEntries;
    }

    public double getTotal() {
        return total;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
