import java.util.Enumeration;

public class TextStatement extends Statement {
    public String Value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = this.getHeader(aCustomer.getName());

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += this.getFigures(each);
        }
        //add footer lines
        result += this.getFooter(aCustomer);
        return result;
    }    

    private String getHeader(String name) {
        return "Rental Record for " + name + "\n";
    }

    private String getFigures(Rental each) {
        return "\t" + each.getMovie().getTitle()+ "\t" +
            String.valueOf(each.getCharge()) + "\n";
    }

    private String getFooter(Customer aCustomer) {
        return "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n" +
        "You earned " +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        " frequent renter points";

    }
}
