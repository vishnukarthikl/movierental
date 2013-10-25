package bootcamp;

import bootcamp.formatter.Formatter;
import bootcamp.receipt.Receipt;

import java.io.IOException;

public class StatementGenerator {
    private final Formatter formatter;

    public StatementGenerator(Formatter formatter) {
        this.formatter = formatter;
    }

    public String generateFor(Customer customer) throws IOException {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Receipt receipt = new Receipt(customer);
        for (final Rental each : customer.getRentals()) {
            double thisAmount = each.getCharge();
            frequentRenterPoints += each.getFrequentRenterPoints();
            receipt.addEntry(each.getMovie(), thisAmount);
            totalAmount += thisAmount;
        }
        receipt.addTotal(totalAmount, frequentRenterPoints);
        return formatter.format(receipt);
    }
}
