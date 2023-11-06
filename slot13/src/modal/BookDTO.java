package modal;

public class BookDTO {
    private int code;
    private String name;
    private String auth;
    private int quantity;
    private int borrow;

    public BookDTO(int code, String name, String auth, int quantity, int borrow) {
        this.code = code;
        this.name = name;
        this.auth = auth;
        this.quantity = quantity;
        this.borrow = borrow;
    }

    public BookDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBorrow() {
        return borrow;
    }

    public void setBorrow(int borrow) {
        this.borrow = borrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", auth='" + auth + '\'' +
                ", quantity=" + quantity +
                ", borrow=" + borrow +
                '}';
    }
}

