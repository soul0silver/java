package modal;

public class Book {
    private int code;
    private String name;
    private String auth;
    private int quantity;

    public Book() {
    }

    public Book(int code, String name, String auth, int quantity) {
        this.code = code;
        this.name = name;
        this.auth = auth;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "code=" + code +
                ", name='" + name + '\'' +
                ", auth='" + auth + '\'' +
                ", quantity=" + quantity +
                '\n';
    }
}
