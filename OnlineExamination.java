import java.util.*;
class OnlineExamination{
    private static Scanner sc=new Scanner(System.in);
    private static String username;
    private static String password;
    public static void main(String args[]){

        boolean isLoggedIn=login();
        if(isLoggedIn){
            updateProfileAndPassword();
            selectingAnswersForMcqs();
            timerAndAutoSubmit();
            closingSessionAndLogout();
        }
        else{
            System.out.println("Login Failed!");
        }
    }
    private static boolean login(){
        System.out.println("Online Examination");
        System.out.println("Enter username: ");
        username=sc.nextLine();
        System.out.println("Enter password: ");
        password=sc.nextLine();
        if(username.equals("name")&&password.equals("password")){
            System.out.println("Login Successful!");
            return true;
        }
        else{
            System.out.println("Invalid username or password");
            return false;
        }
    }
    private static void updateProfileAndPassword(){
        System.out.println("Enter your new username: ");
        username=sc.nextLine();
        System.out.println("Enter your new password: ");
        password=sc.nextLine();
        System.out.println("Profile and Password updated successfully!");
    }
    private static void selectingAnswersForMcqs(){
        System.out.println("Select answers for the following MCQ's");
        System.out.println("Question 1: What is the capital of India?");
        System.out.println("A. New Delhi");
        System.out.println("B. Mumbai");
        System.out.println("C. Hyderabad");
        System.out.println("D. Tamil Nadu");
        System.out.println("Choose the correct option");
        String answer=sc.nextLine();
        
        if(answer.equalsIgnoreCase("A")){
            System.out.println("Correct answer!");
        }
        else{
            System.out.println("Wrong answer!");
        }
        
        System.out.println("Question 2: Who is the prime minister of India?");
        System.out.println("A. Manmohan Singh");
        System.out.println("B. Obama");
        System.out.println("C. Narendra Modi");
        System.out.println("D. Ram Nath Kovind");
        System.out.println("Choose the correct option");
        answer=sc.nextLine();
        
        if(answer.equalsIgnoreCase("C")){
            System.out.println("Correct answer!");
        }
        else{
            System.out.println("Wrong answer!");
        }
    }
    private static void timerAndAutoSubmit(){
        System.out.println("Timer Started! Auto submit after 1 minute");
        try{
            Thread.sleep(1*60*1000);
        }
        catch(InterruptedException i){
            i.printStackTrace();
        }
        System.out.println("Time up! Your answers have been automatically submitted.");
    }
    private static void closingSessionAndLogout(){
        System.out.println("Logged out successfully!");
    }
}
