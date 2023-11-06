package modal;

public class Borrow {
    private int id;
    private int bid;
    private int quantity;

    public Borrow(int id, int bid, int quantity) {
        this.id = id;
        this.bid = bid;
        this.quantity = quantity;
    }

    public Borrow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
