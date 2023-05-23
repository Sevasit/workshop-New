/* ระบบ ATM

ระบบสามารถ login เพื่อเข้าใช้งาน แต่ถ้ายังไม่มีเคยมีบัญชีอยู่ ให้ register ก่อน

1. login

2. register

   - มีชื่อ นามสกุล

   - เลขบัญชี Auto // format (AB-1234567)

   - เบอร์โทรศัพน์

   - อีเมล

   - username

   - password




เมื่อ login เข้าไปแล้ว จะมี menu ดังนี้

1. Deposit // ฝากเงิน

2. Withdraw // ถอนเงิน

3. Transfer // โอนเงิน

   - จะต้องโอนเงินไปยังบัญชีที่มีอยู่ในระบบเท่านั้น

4. Deactivate an account // ปิดบัญชี

5. Account // แสดงรายละเอียด

    - ชื่อ

    - นามสกุล

    - เลขบัญชี AB-1234567

    - เบอร์โทร 094-732-7499

    - อีเมล์

    - จำนวนเงิน 1,000.00 บาท

6. logout
*/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.Random;
public class ATM {
    static String currentUser = null;
    static String atmCurrentId = null; 
    static List<HashMap<String,Object>> accounts = new ArrayList<>();
    static boolean isLoggedIn = false;
    
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Object> newUser = new HashMap<>();
        newUser.put("username", "sevasit");
        newUser.put("password", "12345");
        newUser.put("name", "sevasit");
        newUser.put("lastname", "senpradit");
        newUser.put("phone", "09999999");
        newUser.put("email", "new@gmail.com");
        newUser.put("idAtm", "AB-55555");
        newUser.put("money", Float.parseFloat("100000.00"));

        accounts.add(newUser);

        System.out.print("\033[H\033[2J");
        try{
            while (!isLoggedIn) {
                System.out.println("Welcome to the ATM NEW!");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                
                
                switch (choice) {
                    case 1:
                    System.out.print("\033[H\033[2J");
                        isLoggedIn = login(scanner,accounts);
                        break;
                    case 2:
                    System.out.print("\033[H\033[2J");
                        register(scanner,accounts);
                        break;
                    case 3:
                    System.out.print("\033[H\033[2J");
                        System.out.println("Thank you for using the application. Goodbye!");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\033[H\033[2J");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\033[H\033[2J");
                        break;
                }
                
                System.out.println();
            }
        }catch(Exception e){
            System.out.print("\033[H\033[2J");
            System.out.println("Please enter 1-3");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
            runAfterLogout();
        }

        try{
        while (isLoggedIn) {
            System.out.println("Our services!");
            System.out.println("1. Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Deactivate");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                System.out.print("\033[H\033[2J");
                    showAccount(accounts,currentUser);
                    break;
                case 2:
                System.out.print("\033[H\033[2J");
                    deposit(accounts,currentUser,scanner); //Deposit // ฝากเงิน
                    break;
                case 3:
                System.out.print("\033[H\033[2J");
                    withdraw(accounts, currentUser, scanner); //Withdraw // ถอนเงิน
                    break;
                case 4:
                System.out.print("\033[H\033[2J");
                    transfer(accounts, currentUser, scanner); //Transfer // โอนเงิน
                    break;
                case 5:
                System.out.print("\033[H\033[2J");
                    deleteAcc(accounts,currentUser);
                    isLoggedIn = false;
                    runAfterLogout();
                    break;
                case 6:
                System.out.print("\033[H\033[2J");
                    isLoggedIn = false;
                    runAfterLogout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\033[H\033[2J");
                    break;
            }
            
            System.out.println();
        }
    }catch(Exception e){
        System.out.print("\033[H\033[2J");
            System.out.println("Please enter 1-6");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
        logged();
    }
        
        scanner.close();
    }

    /*  1. Deposit // ฝากเงิน

        2. Withdraw // ถอนเงิน

        3. Transfer // โอนเงิน */

        public static void transfer(List<HashMap<String, Object>> accounts,String currentUser, Scanner scanner) throws InterruptedException {
            try{
            System.out.print("Enter your transfer: ");
            Float transfer = Float.parseFloat(scanner.next());
            if(transfer <= 0){
                System.out.println("Your transfer is invalid.");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\033[H\033[2J"); 
                return;
            }
            System.out.print("Enter ATMID: ");
            String atmId = scanner.next();

            if(atmId.equals(atmCurrentId)){
                System.out.println("ATMID is invalid.");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\033[H\033[2J");
                return;
            }

           //เช็คATMID
            for (HashMap<String, Object> userAcc : accounts) {
                if (userAcc.get("idAtm").equals(atmId)) {
                    break;
                }else{
                    System.out.println("ATMID is invalid.");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\033[H\033[2J");
                    return;
                }
            }

            //ลบตัง
            HashMap<String, Object> user = null;
            for (HashMap<String, Object> userAcc : accounts) {
                if (userAcc.get("username").equals(currentUser)) {
                    user = userAcc;
                    float currentMoney = (float) user.get("money");
                    if(currentMoney < transfer){
                        System.out.println("You got no money enough to transfer.");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\033[H\033[2J");
                        return;
                    }
                    if(currentMoney <= 0){
                        System.out.println("Sorry can't transfer.");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\033[H\033[2J");
                        break;
                    }else{
                        float newMoney = currentMoney - transfer;
                        user.put("money", newMoney);
                        System.out.println("Current your money: " + String.format("%,.2f",user.get("money")) + " BATH.");
                        break;
                    }
                    
                }
            }

            //บวกตัง
            HashMap<String, Object> otherUser = null;
            for (HashMap<String, Object> userAcc : accounts) {
                if (userAcc.get("idAtm").equals(atmId)) {
                    otherUser = userAcc;
                    float currentMoney = (float) otherUser.get("money");
                    float newMoney = currentMoney + transfer;
                    otherUser.put("money", newMoney);
                    System.out.println("ATMID:" + atmId + " has money: " + String.format("%,.2f",otherUser.get("money")) + " BATH.");
                    break;
                }
            }

                 System.out.println("Transfer successful!");
                 TimeUnit.SECONDS.sleep(2);
                 System.out.print("\033[H\033[2J");
            }catch(Exception e){
                System.out.println("Should enter number.");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\033[H\033[2J");
                logged();
            }
            
        }

    public static void deposit(List<HashMap<String, Object>> accounts,String currentUser, Scanner scanner) throws InterruptedException {
        try{
        System.out.print("Enter your Deposit: ");
        Float deposit = Float.parseFloat(scanner.next());

        if(deposit <= 0){
            System.out.println("Your deposit is invalid.");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
            return;
        }

        HashMap<String, Object> user = null;
        for (HashMap<String, Object> userAcc : accounts) {
            if (userAcc.get("username").equals(currentUser)) {
                user = userAcc;
                float currentMoney = (float) user.get("money");
                float newMoney = currentMoney + deposit;
                user.put("money", newMoney);
                System.out.println("Current your money: " + String.format("%,.2f",user.get("money")) + " BATH.");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\033[H\033[2J");
                break;
            }
        }
        }catch(Exception e){
            System.out.println("Should enter number.");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
            logged();
        }
        
    }

    public static void withdraw(List<HashMap<String, Object>> accounts,String currentUser, Scanner scanner) throws InterruptedException {
        try{
        System.out.print("Enter your withdraw: ");
        Float withdraw = Float.parseFloat(scanner.next());

        if(withdraw <= 0){
            System.out.println("Your withdraw is invalid.");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
            return;
        }

        HashMap<String, Object> user = null;
        for (HashMap<String, Object> userAcc : accounts) {
            if (userAcc.get("username").equals(currentUser)) {
                user = userAcc;
                float currentMoney = (float) user.get("money");
                if(currentMoney < withdraw){
                    System.out.println("You got no money enough to withdraw.");
                    return;
                }
                if(currentMoney <= 0){
                    System.out.println("Sorry can't withdraw.");
                    break;
                }else{
                    float newMoney = currentMoney - withdraw;
                    user.put("money", newMoney);
                    System.out.println("Current your money: " + String.format("%,.2f",user.get("money")) + " BATH.");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\033[H\033[2J");
                    break;
                }
                
            }
        }
    }catch(Exception e){
        System.out.println("Should enter number.");
        TimeUnit.SECONDS.sleep(2);
        System.out.print("\033[H\033[2J");
        logged();
    }
        
    }

    public static void logged(){
        Scanner scanner = new Scanner(System.in);
        try{
        while (isLoggedIn) {
            System.out.println("Our services!");
            System.out.println("1. Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Deactivate");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                System.out.print("\033[H\033[2J");
                    showAccount(accounts,currentUser);
                    break;
                case 2:
                System.out.print("\033[H\033[2J");
                    deposit(accounts,currentUser,scanner); //Deposit // ฝากเงิน
                    break;
                case 3:
                System.out.print("\033[H\033[2J");
                    withdraw(accounts, currentUser, scanner); //Withdraw // ถอนเงิน
                    break;
                case 4:
                System.out.print("\033[H\033[2J");
                    transfer(accounts, currentUser, scanner); //Transfer // โอนเงิน
                    break;
                case 5:
                System.out.print("\033[H\033[2J");
                    deleteAcc(accounts,currentUser);
                    isLoggedIn = false;
                    runAfterLogout();
                    break;
                case 6:
                System.out.print("\033[H\033[2J");
                    isLoggedIn = false;
                    runAfterLogout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println();
        }
        }catch(Exception e){
            System.out.println("Please enter 1-6");
            logged();
        }
    }

    public static void runAfterLogout() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        try{
        while (!isLoggedIn) {
            System.out.println("Welcome to the ATM NEW!");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                System.out.print("\033[H\033[2J");
                    isLoggedIn = login(scanner,accounts);
                    break;
                case 2:
                System.out.print("\033[H\033[2J");
                    register(scanner,accounts);
                    break;
                case 3:
                System.out.print("\033[H\033[2J");
                    System.out.println("Thank you for using the application. Goodbye!");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\033[H\033[2J");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\033[H\033[2J");
                    break;
            }
            
            System.out.println();
        }
    }catch(Exception e){
            System.out.print("\033[H\033[2J");
            System.out.println("Please enter 1-3");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
        runAfterLogout();
    }
    }

    public static boolean deleteAcc(List<HashMap<String, Object>> accounts,String currentUser) {
        for (HashMap<String, Object> user : accounts) {
            if (user.get("username").equals(currentUser)) {
                accounts.remove(user);
                return true;
            }
        }
        return false;
    }

    public static void showAccount(List<HashMap<String, Object>> accounts,String currentUser) throws InterruptedException {
        HashMap<String, Object> user = null;
        for (HashMap<String, Object> userAcc : accounts) {
            if (userAcc.get("username").equals(currentUser)) {
                user = userAcc;
                break;
            }
        }
        if (user != null) {
            // Display account details
            System.out.println("Account details for username: ");
            System.out.println("name: " + user.get("name"));
            System.out.println("lastname: " + user.get("lastname"));
            System.out.println("idAtm: " + user.get("idAtm"));
            System.out.println("phone: " + user.get("phone"));
            System.out.println("email: " + user.get("email"));
            System.out.println("money: " + String.format("%,.2f",user.get("money")) + " BATH.");
            
            TimeUnit.SECONDS.sleep(5);
            System.out.print("\033[H\033[2J");
        } else {
            System.out.println("User not found.");
        }
    }

    public static boolean login(Scanner scanner, List<HashMap<String, Object>> accounts) throws InterruptedException {
        if(accounts.size() == 0){
            System.out.println("You should register before use my program.");
            return false;
        }
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (HashMap<String, Object> user : accounts) {
            if (user.get("username").equals(username) && user.get("password").equals(password)) {
                atmCurrentId = user.get("idAtm").toString();
            }
        }
        
        for (HashMap<String, Object> user : accounts) {
            if (user.get("username").equals(username) && user.get("password").equals(password)) {
                currentUser = username;
                System.out.println("Logged in successfully! You can now access the ATM.");
                TimeUnit.SECONDS.sleep(1);
                System.out.print("\033[H\033[2J");
                return true;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\033[H\033[2J");
        return false;
    }

    private static void register(Scanner scanner, List<HashMap<String, Object>> accounts) throws InterruptedException {
        System.out.print("Enter a username: ");
        String username = scanner.next();
        for (HashMap<String, Object> user : accounts) {
            if (user.get("username").equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                TimeUnit.SECONDS.sleep(2);
                System.out.print("\033[H\033[2J");
                return;
            }
        }

        System.out.print("Enter a password: ");
        String password = scanner.next();
        System.out.print("Enter a name: ");
        String name = scanner.next();
        System.out.print("Enter a lastname: ");
        String lastname = scanner.next();
        System.out.print("Enter a phone: ");
        String phone = scanner.next();
        System.out.print("Enter a email: ");
        String email = scanner.next();

        // if(username.trim() == "" || password.trim() == "" || name.trim() == "" || lastname.trim() == "" || phone.trim() == "" || email.trim() == ""){
        //     System.out.println("Should enter every fields before register.");
        //     return;
        // }

        HashMap<String, Object> newUser = new HashMap<>();
        newUser.put("username", username.trim());
        newUser.put("password", password.trim());
        newUser.put("name", name.trim());
        newUser.put("lastname", lastname.trim());
        newUser.put("phone", phone.trim());
        newUser.put("email", email.trim());
        newUser.put("idAtm", "AB-" + generateRandomNumber());
        newUser.put("money", Float.valueOf(1000));

        accounts.add(newUser);
        
        System.out.println("Registration successful " + username);
        TimeUnit.SECONDS.sleep(2);
        System.out.print("\033[H\033[2J");
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        return random.nextInt(max - min + 1) + min;
    }
}
