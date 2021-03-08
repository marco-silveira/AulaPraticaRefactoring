import java.util.Enumeration;

public abstract class Statement {
    protected abstract String getHeader(String name);
    protected abstract String getFigures(Rental aRental);
    protected abstract String getFooter(Customer aCustomer);

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = this.getHeader(aCustomer.getName());

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += this.getFigures(each);
        }
        //add footer lines
        result += this.getFooter(aCustomer);
        return result; 
    }
}