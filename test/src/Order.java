import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String customerName;
    private Date transactionTime;
    private ArrayList<LineItem> lineItems = new ArrayList<>();
    DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Order() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getTransactionTime() {
        return transactionTime ;
    }

    public void setTransactionTime(String transactionTime) throws ParseException {
        this.transactionTime = targetFormat.parse(transactionTime);
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\n' +
                ", transactionTime=" + targetFormat.format(transactionTime) + '\n' +
                ", lineItems=" + lineItems +
                '}';
    }

    public double cost() {
        double amount = 0;
        for (LineItem i : lineItems) {
            amount += i.cost();
        }
        return amount;
    }

    public boolean addProduct(Product product, int quantity) {
        if (quantity <= product.getQuantity()) {
            lineItems.add(new LineItem(product, quantity));

            return true;
        }
        return false;

    }
}
