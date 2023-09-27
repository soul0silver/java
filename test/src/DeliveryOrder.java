public class DeliveryOrder extends Order{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DeliveryOrder() {
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +super.toString() +
                "address='" + address + '\'' +
                '}';
    }
}
