import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ParseException {
        Map<String, Product> products = new HashMap<>();
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



        //task a
        initializeProducts(products);
        //End task a
        //task b
        System.out.println("Order for “Mike Tyson” at “2023-08-08 11:30:00”");
        Order order=new Order();
        order.setCustomerName("Mike Tyson");
        order.setTransactionTime("2023-08-08 11:30:00");
        //add 5 tomato
        System.out.println("add 5 tomatoes");
        boolean time1= order.addProduct(products.get("Tomato"),5);
        if (time1==true) {
            System.out.println("Success");
            products.get("Tomato").setQuantity(products.get("Tomato").getQuantity()-5);
            System.out.println("Total cost:" + order.cost());System.out.println();
        }
        else {
            System.out.println("fail");
            System.out.println();
        }

        //add 2 iphone
        System.out.println("add 2 iphones");
        boolean time2= order.addProduct(products.get("IPhone"),2);
        if (time2==true) {
            System.out.println("Success");
            products.get("IPhone").setQuantity(products.get("IPhone").getQuantity()-5);
            System.out.println("Total cost:" + order.cost());
            System.out.println();
        }
        else {
            System.out.println("fail");
            System.out.println();
        }

        // add 4 football
        System.out.println("add 4 footballs:");
        boolean time3= order.addProduct(products.get("Football"),4);
        if (time3==true) {
            System.out.println("Success");
            products.get("Football").setQuantity(products.get("Football").getQuantity()-4);
            System.out.println("Total cost:" + order.cost());System.out.println();
        }
        else {
            System.out.println("fail");
            System.out.println();
        }
        //Print all the information of the order
        System.out.println(order);
        System.out.println();
        //End task b
        //task c
        System.out.println("Delivery order for “Chris Evans” at “2023-08-09 13:14:00”");
        DeliveryOrder deliveryOrder=new DeliveryOrder();
        deliveryOrder.setCustomerName("Chris Evans");
        deliveryOrder.setTransactionTime("2023-08-09 13:14:00");
        deliveryOrder.setAddress("123 Cau Giay");
        //add 3 Zara shirts
        System.out.println("add 3 Zara shirts:");
        boolean time4= deliveryOrder.addProduct(products.get("Zara shirt"),4);
        if (time4==true) {
            System.out.println("Success");
            products.get("Zara shirt").setQuantity(products.get("Zara shirt").getQuantity()-4);
            System.out.println("Total cost:" + deliveryOrder.cost());System.out.println();
        }
        else {
            System.out.println("fail");
            System.out.println();
        }
        //Add 3 Iphone
        System.out.println("add 3 IPhone:");
        boolean time5= deliveryOrder.addProduct(products.get("IPhone"),3);
        if (time5==true) {
            System.out.println("Success");
            products.get("IPhone").setQuantity(products.get("IPhone").getQuantity()-3);
            System.out.println("Total cost:" + deliveryOrder.cost());System.out.println();
        }
        else {
            System.out.println("fail");
            System.out.println();
        }
        //Print all the information of the Delivery order
        System.out.println(deliveryOrder);
        //End task c
    }

    public static void initializeProducts(Map<String,Product> products) {

        products.put("Tomato", new Product("F523", "Tomato", "Food", 1.5, 589));
        products.put("Zara shirt", new Product("A763", "Zara shirt ", "Appearance", 12.0, 90));
        products.put("Kitchen table", new Product("H320", "Kitchen table", "Household", 299.0 , 13));
        products.put("IPhone", new Product("E092", "IPhone", "Electronic", 1000.0  , 4));
        products.put("Football", new Product("S108 ", "Football", "Sport", 19.9   , 2));
    }


}
