package lab07.model;

import lab07.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static lab07.model.EmloyeeSystem.operation;

class CustomException extends Exception {
    public static final long serialVersionUID = 1L;

    public CustomException(String str) {
        super();
        System.out.println(str);
        operation();
    }
}

public class EmloyeeSystem {
    public static Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public static void addEmployee(String name, int age, int eid) {
        Employee emp = new Employee(name, age, eid);
        map.put(eid, emp);
        operation();
    }
    public static void deleteEmployee(int id) throws CustomException {
        if (map.containsKey(id)){
            map.remove(id);
            System.out.println("Delete success");
        }
        else throw new CustomException("id not found");
        operation();
    }
    public static void searchEmployee(int id) throws CustomException {
        if (map.containsKey(id)){
            System.out.println("Result: "+map.get(id).toString());
        }
        else throw new CustomException("id not found");
        operation();
    }
    public static void listEmployee() {
        System.out.println(map.toString());
    }

    public static void operation()  {
        System.out.println("**Employee management system**");
        System.out.println("1. Add employee");
        System.out.println("2. Delete");
        System.out.println("3. Search");
        System.out.println("4. Employee list");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("enter employee details(name, age, id");
                scanner.nextLine();
                String name = scanner.nextLine();
                int age = scanner.nextInt();
                int eid = scanner.nextInt();
                if (!name.equals("") && age != 0 && eid != 0)
                    addEmployee(name,age,eid);
                break;
            case 2:
                System.out.println("Enter employee id");
                int id=scanner.nextInt();
                try {
                    deleteEmployee(id);
                }
                catch (CustomException e){
                    System.out.println(e);
                }
                break;
            case 3:
                System.out.println("Enter employee id");
                id=scanner.nextInt();
                try {
                    searchEmployee(id);
                }
                catch (CustomException e){
                    System.out.println(e);
                }
                break;
            case 4:
                listEmployee();
                break;
            default:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        operation();
    }
}
