import java.util.*;
class NumberGuessingGame{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int minRange=1;
        int maxRange=100;
        int maxRounds=3;
        int maxAttempts=5;
        int score=0;
        System.out.println("Guess the Number!");
        System.out.println("You have "+maxAttempts+" attempts to guess the number");
        for(int round=1;round<=maxRounds;round++){
            int target=random.nextInt(maxRange-minRange+1)+minRange;
            System.out.println("Round: "+round);
            for(int attempt=1;attempt<=maxAttempts;attempt++){
                System.out.println("Guess a number between "+minRange+" and "+maxRange+":");
                System.out.println("Attempt: "+attempt);
                int guess=sc.nextInt();
                if(guess==target){
                    System.out.println("Congratulations! Your guess is correct.");
                    score=score+1;
                }
                else if(guess>target){
                    System.out.println("Your guess is greater than the actual number.");
                }
                else{
                    System.out.println("Your guess is less than the actual number.");
                }
            }
            System.out.println("Oops! You have no more attempts.");
            System.out.println("The correct number is: "+target);
        }
        System.out.println("Game over!");
        System.out.println("Your score is: "+score);
    }
}
