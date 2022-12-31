import java.util.ArrayList;
import java.util.Scanner;

class bankaccount {
    static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("Enter Your Name : ");
        ATM.name = sc.nextLine();
        System.out.println("Enter Your UserName : ");
        String user = sc.nextLine();
        System.out.println("Enter Password :");
        String pass = sc.nextLine();
        System.out.println("Enter Your Account Number : ");
        ATM.accountNumber = sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY ! ");
        System.out.println("--------------------------------------------------");
        ATM.prompt();
        while (true) {
            display(ATM.name);
            int choice = sc.nextInt();
            if (choice == 1) {
                login(user, pass);
                break;
            } else {
                if (choice == 2) {
                    System.exit(0);
                } else {
                    System.out.println("Bad Value ! Enter Again !  ");
                }
            }
        }
    }

    static void display(String name) {
    }

    static void login(String user, String pass) {
    }
}

class transaction {
    static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("Enter Amount to Withdraw : ");
        int wcash = sc.nextInt();
        if (wcash <= ATM.balnce) {
            ATM.balnce = ATM.balnce - wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount RS " + wcash + " /- Withdraw Successfully ");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("Insufficient Balance to Withdraw the Case ");
            System.out.println("----------------------------------------------");
        }
        ATM.prompt();
    }

    static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("Enter Amount to Deposit : ");
        int dcash = sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add("Deposit");
        System.out.println("Amount RS. " + dcash + " /- Deposit Successfully ");
        System.out.println("-------------------------------------------------");
        ATM.prompt();
    }

    static void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Receiving Body : ");
        String s = sc.nextLine();
        System.out.println("Enter the Account Number of the Receiving Body ");
        long num = sc.nextInt();
        System.out.println("Enter the Amount to be Transferred :  ");
        int tcash = sc.nextInt();
        if (tcash <= ATM.balnce) {
            ATM.balnce = ATM.balnce - tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Transferred");
            System.out.println("Amount RS. " + tcash + " /- transferred Successfully");
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Insufficient Balance to Transfer the Cash ");
            System.out.println("------------------------------------------");
        }
    }

    class check {
    }

    static void checkBalance() {
        System.out.println("----------------------------------------------------------");
        System.out.println("The Available Balance in the Bank Account : ");
        ATM.showBalance();
        System.out.println("-----------------------------------------------------------");
        ATM.prompt();
    }

    class his {
        static void transactionHistory() {
            System.out.println("------------------------------------------------------------");
            System.out.println("Transaction History : ");
            int k = 0;
            if (ATM.balnce > 0) {
                for (int i = 0; i < (ATM.history.size() / 2); i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(ATM.history.get(k) + " ");
                        k++;
                    }
                    System.out.println("------------------------------------------------------");
                }
            } else {
                System.out.println("Your Account is Empty ! ");
            }
            ATM.prompt();
        }
    }
}

public class ATM {
    public static String name;
    public static int balnce = 0;
    public static String accountNumber;
    public static ArrayList<String> history = new ArrayList<String>();

    static void updatebalance(int dcash) {
        balnce = balnce + dcash;
    }

    static void showBalance() {
        System.out.println(balnce);
    }

    public static void homepage() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println(" WELCOME TO ATM INTERFACE ");
        System.out.println("-------------------------------------------");
        System.out.println("select Option : ");
        System.out.println(" 1. Register ");
        System.out.println(" 2. Exit ");
        System.out.println(" Enter Choice ");
        int choice = sc.nextInt();
        if (choice == 1) {
            bankaccount.register();
        } else {
            if (choice == 2) {
                System.exit(0);
            } else {
                System.out.println("Select a Value Only from the Given Option : ");
                homepage();
            }
        }
    }

    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" WELCOME " + ATM.name + " ! TO ATM SYSTEM ");
        System.out.println("--------------------------------------------");
        System.out.println(" Select Option : ");
        System.out.println(" 1. WITHDRAW ");
        System.out.println(" 2. DEPOSIT ");
        System.out.println(" 3. TRANSFER ");
        System.out.println(" 4. CHECK BALANCE");
        System.out.println(" 5. TRANSACTION HISTORY ");
        System.out.println(" 6. EXIT ");
        System.out.println(" Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                transaction.checkBalance();
            case 5:
                transaction.his.transactionHistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        {
            homepage();
        }
    }
}
