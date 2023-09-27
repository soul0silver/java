package bank;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountBank {
    private int customerNo ;
    private int pinNum;
    private double checkingBalance;
    private double savingBalance;

    Scanner input
            =new Scanner(System.in);

    DecimalFormat moneyFormat= new DecimalFormat();

    public AccountBank(int customerNo, int pinNum, double checkingBalance, double savingBalance) {
        this.customerNo = customerNo;
        this.pinNum = pinNum;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public AccountBank(int customerNo, int pinNum) {
        this.customerNo = customerNo;
        this.pinNum = pinNum;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public int getPinNum() {
        return pinNum;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public void getCheckingWithdrawInput(){
        boolean flag=false;
        while (!flag){
            try {
                System.out.println("Current acc balance: "+moneyFormat.format(checkingBalance));
                System.out.println("Input amount u want to withdraw:");
                double amount= input.nextDouble();
                if (checkingBalance-amount>=0&&amount>0) {
                    cal(amount);

                    System.out.println("Current acc balance: "+moneyFormat.format(getCheckingBalance()));
                    flag=true;

                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice");
            }
        }
    }
    public void getCheckingDepositInput(){
        boolean flag=false;
        while (!flag){
            try {
                System.out.println("Current acc balance: "+moneyFormat.format(checkingBalance));
                System.out.println("Input amount u want to withdraw:");
                double amount= input.nextDouble();
                if (checkingBalance+amount>=0&&amount>0) {
                    cal(-amount);

                    System.out.println("Current acc balance: "+moneyFormat.format(getCheckingBalance()));
                    flag=true;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice");
            }
        }
    }
    public double cal(double amount){
        setCheckingBalance(checkingBalance-=amount);
        return getCheckingBalance();
    }
    public void getSavingDepositInput(){}

    public Scanner getSc() {
        return input;
    }

    public void setSc(Scanner sc) {
        this.input = sc;
    }

    public DecimalFormat getMoneyFormat() {
        return moneyFormat;
    }

    public void setMoneyFormat(DecimalFormat moneyFormat) {
        this.moneyFormat = moneyFormat;
    }

    public double getTransferInput(){
        boolean flag=false;
        while (!flag){
            try {
                System.out.println("Current acc balance: "+moneyFormat.format(checkingBalance));
                System.out.println("Input amount u want to transfer:");
                double amount= input.nextDouble();
                if (checkingBalance-amount>=0&&amount>0) {
                    cal(amount);
                    System.out.println("transfer success");
                    System.out.println("Current acc balance: "+moneyFormat.format(getCheckingBalance()));
                    flag=true;
                    return amount;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice");
            }
        }
        return 0;
    }

}

