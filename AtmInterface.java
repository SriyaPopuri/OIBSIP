import java.util.*;
class User{
    private String userId;
    private String pin;
    
    public User(String userId,String pin){
        this.userId=userId;
        this.pin=pin;
    }
    public String getUserId(){
        return userId;
    }
    public String getPin(){
        return pin;
    }
}
class Transaction{
    private String transactionId;
    private Date date;
    private String type;
    private Double amount;
    public Transaction(String transactionId, Date date, String type, Double amount){
        this.transactionId=transactionId;
        this.date=date;
        this.type=type;
        this.amount=amount;
    }
    public String getTransactionId(){
        return transactionId;
    }
    public Date getDate(){
        return date;
    }
    public String getType(){
        return type;
    }
    public Double getAmount(){
        return amount;
    }
}
class BankAccount{
    private String accountNumber;
    private Double balance;
    private List<Transaction> transactionHistory;
    public BankAccount(String accountNumber){
        this.accountNumber=accountNumber;
        this.balance=0.0;
        this.transactionHistory=new ArrayList<>();
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public Double getBalance(){
        return balance;
    }
    public List<Transaction> getTransactionHistory(){
        return transactionHistory;
    }
    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), new Date(), "Deposit", amount);
        transactionHistory.add(transaction);
        System.out.println("Amount deposited successfully.");
    } 
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction(UUID.randomUUID().toString(), new Date(), "Withdraw", amount);
            transactionHistory.add(transaction);
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void transfer(double amount, BankAccount receiverAccount) {
        if (balance >= amount) {
            balance -= amount;
            receiverAccount.deposit(amount);
            Transaction transaction = new Transaction(UUID.randomUUID().toString(), new Date(), "Transfer", amount);
            transactionHistory.add(transaction);
            System.out.println("Amount transferred successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
class AtmInterface{
    public static Scanner sc=new Scanner(System.in);
    private static User currentUser;
    private static BankAccount currentAccount;
    public static void main(String args[]){
        boolean isLoggedIn=false;
        System.out.println("Welcome to the ATM!");
        while(!isLoggedIn){
            System.out.print("Enter User Id:");
            String userId=sc.nextLine();
            System.out.print("Enter PIN:");
            String pin=sc.nextLine();
            isLoggedIn=authenticateUser(userId,pin);
            if(!isLoggedIn){
                System.out.println("Invalid UserID or pin. Please try again");
            }
        }
        System.out.println("ATM Menu:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        
        boolean quit=false;
        while(!quit){
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            
            switch(choice){
                case 1: 
                    showTransactionHistory();
                    break;
                case 2: 
                    performWithdrawal();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    quit=true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
        System.out.println("Thankyou!");
    }
    
    private static boolean authenticateUser(String userId,String pin){
        if(userId.equals("12345")&&pin.equals("1234") || userId.equals("45678")&&pin.equals("4567")){
            currentUser=new User(userId,pin);
            currentAccount=new BankAccount("987654321");
            return true;
        }
        return false;
    }
    
    public static void showTransactionHistory(){
        List <Transaction> transactionHistory=currentAccount.getTransactionHistory();
        if(transactionHistory.isEmpty())
            System.out.println("No transactions found");
        else{
            System.out.println("Transaction History:");
            for(Transaction transaction:transactionHistory){
                System.out.println("Transaction ID: "+transaction.getTransactionId());
                System.out.println("Date: "+transaction.getDate());
                System.out.println("Amount: "+transaction.getAmount());
                System.out.println("Type: "+transaction.getType());
            }
        }
    }
    private static void performWithdrawal(){
        System.out.println("Enter amount to withdraw: ");
        double amount=sc.nextDouble();
        sc.nextLine();
        currentAccount.withdraw(amount);
    }
    private static void performDeposit(){
        System.out.println("Enter amount to deposit: ");
        double amount=sc.nextDouble();
        sc.nextLine();
        currentAccount.deposit(amount);
    }
    private static void performTransfer(){
        System.out.println("Enter recepient's account number: ");
        String recepientAccountNumber=sc.nextLine();
        System.out.println("Enter amount to transfer: ");
        double amount=sc.nextDouble();
        sc.nextLine();
        BankAccount recepientAccount=new BankAccount(recepientAccountNumber);
        currentAccount.transfer(amount, recepientAccount);
    }   
}
