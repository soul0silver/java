package modal;

public class TicketDetails {
    private int id;
    private int bid;
    private int tid;
    private int quantity;

    public TicketDetails(int id, int bid, int tid, int quantity) {
        this.id = id;
        this.bid = bid;
        this.tid = tid;
        this.quantity = quantity;
    }

    public TicketDetails() {
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", bid:" + bid +
                ", tid:" + tid +
                ", quantity:" + quantity ;
    }
}
