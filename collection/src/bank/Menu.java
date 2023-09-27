package bank;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    //format input data
    Scanner mInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, AccountBank> data = new HashMap<>();
    public  void start(){
        data.put(1, new AccountBank(11111, 22222, 1000, 3000));
        data.put(2, new AccountBank(22222, 22222, 1000, 3000));
        data.put(3, new AccountBank(33333, 22222, 1000, 3000));}

    AccountBank accountBank;
    public void login() throws IOException {
        int customerNumber = 0;
        int pinNumber;
        boolean flag = false;
        accountBank=null;
        while (!flag) {
            try {

                System.out.println("input cus num:");
                customerNumber = mInput.nextInt();
                System.out.println("input pin num");
                pinNumber = mInput.nextInt();

                Iterator it = data.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    AccountBank acc = (AccountBank) pair.getValue();
                    if (acc.getCustomerNo()== customerNumber && pinNumber == acc.getPinNum()) {
                        accountBank = acc;
                        getAccType(accountBank);
                        flag = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (flag==false)
            System.out.println("wrong cus num or pin");
        }

    }

    public void createAcc() throws IOException {
        boolean flag=false;int cusNo=0;int pin=0;
        while(!flag){
            try {
                System.out.println("enter customer detail");
                cusNo=mInput.nextInt();
                pin= mInput.nextInt();

                Iterator it=data.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry p= (Map.Entry) it.next();
                    flag=true;
                }
                System.out.println("Already exists account");

            }
            catch (Exception e){
                System.out.println("Invalid choice");
                mInput.next();

            }
            AccountBank newAcc=new AccountBank(cusNo,pin);
            data.put(cusNo,newAcc);
            login();
        }
    }

    public void getAccType(AccountBank acc) {
        boolean flag=false;
        while (!flag){
            try {
                System.out.println("choose your acc type");
                System.out.println("1: Checking acc");
                System.out.println("2. Saving acc");
                System.out.println("3. Exit");
                int ch= mInput.nextInt();
                switch (ch){
                    case 1:
                        getChecking(acc);

                        break;
                    case 2:
                        getSaving(acc);

                        break;
                    case 3:

                        mainMenu();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            catch (Exception e){

            }
        }
    }

    public void getSaving(AccountBank acc) {
    }

    public void getChecking(AccountBank acc) throws IOException {
        boolean flag=false;
        while (!flag){
            System.out.println("checking acc: ");
            System.out.println("1. View balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            int ch= mInput.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Checking acc balance"+ moneyFormat.format(acc.getCheckingBalance()));

                    break;
                case 2:
                    acc.getCheckingWithdrawInput();

                    break;
                case 3:
                    acc.getCheckingDepositInput();

                    break;
                case 4:
                    getTransfer(acc);

                    break;
                case 5:
                    flag=true;
                    getAccType(acc);

                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }

    public void mainMenu() throws IOException {

        boolean flag=false;
        while (!flag){
            try {
                System.out.println("1. Login");
                System.out.println("2. Create account");
                System.out.println("Enter your choice");
                int ch=mInput.nextInt();
                switch (ch){
                    case 1:
                        login();
                        flag=true;
                        break;
                    case 2:
                        createAcc();
                        flag=true;
                        break;
                    default:
                        System.out.println("invalid choice");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private AccountBank checkAcc(int cusNo) {

        Iterator it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry p = (Map.Entry) it.next();
            if (((AccountBank) p.getValue()).getCustomerNo() == cusNo)
                return (AccountBank)p.getValue();

        }return null;
    }
    public void getTransfer(AccountBank acc) throws IOException {
        boolean flag=false;
        AccountBank acc2=null;
        while (!flag) {
            System.out.println("Input Beneficiary Account");
            int cusNo=mInput.nextInt();
            if (checkAcc(cusNo)!=null)
            {
                acc2=checkAcc(cusNo);

                acc2.cal(-acc.getTransferInput());

                getChecking(acc);
                flag=true;
            }
            else System.out.println("Account number not found");
        }
    }
}
