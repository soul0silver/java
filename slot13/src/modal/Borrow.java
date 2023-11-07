package modal;

public class Borrow {
    private int bid;
    private int quantity;

    public Borrow( int bid, int quantity) {
        this.bid = bid;
        this.quantity = quantity;
    }

    public Borrow() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
