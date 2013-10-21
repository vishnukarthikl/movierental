package bootcamp.formatter;

import bootcamp.receipt.Receipt;
import bootcamp.receipt.ReceiptEntry;

public class SimpleTextFormatter implements Formatter {

    @Override
    public String format(Receipt receipt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rental Record for ").append(receipt.getCustomer().getName()).append("\n");
        for (ReceiptEntry receiptEntry : receipt.getReceiptEntries()) {
            stringBuilder.append("\t").append(receiptEntry.getMovie().getTitle()).append("\t").append(String.valueOf(receiptEntry.getTotal())).append("\n");
        }
        stringBuilder.append("Amount owed is ").append(String.valueOf(receipt.getTotal())).append("\n");
        stringBuilder.append("You earned ").append(String.valueOf(receipt.getFrequentRenterPoints())).append(" frequent renter points");
        return stringBuilder.toString();
    }

}
