package modal;

public class Ticket {
    private int id;
    private String dateBorrow;
    private String des;
    private String datReturn;
    private boolean status;
    private int sid;
    public Ticket() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Ticket(int id, String dateBorrow, String des, String datReturn, boolean status, int sid) {
        this.id = id;
        this.dateBorrow = dateBorrow;
        this.des = des;
        this.datReturn = datReturn;
        this.status = status;
        this.sid = sid;
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

    @Override
    public String toString() {
        return "id:" + id +'\n'+
                "dateBorrow:" + dateBorrow + '\n' +
                "des:" + des + '\n' +
                "datReturn:" + datReturn + '\n' +
                "status:" + status ;
    }
}
