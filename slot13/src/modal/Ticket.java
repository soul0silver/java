package modal;

public class Ticket {
    private int id;
    private String dateBorrow;
    private String des;
    private String datReturn;
    private boolean status;

    public Ticket() {
    }

    public Ticket(int id, String dateBorrow, String des, String datReturn,boolean status) {
        this.id = id;
        this.dateBorrow = dateBorrow;
        this.des = des;
        this.datReturn = datReturn;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDatReturn() {
        return datReturn;
    }

    public void setDatReturn(String datReturn) {
        this.datReturn = datReturn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
