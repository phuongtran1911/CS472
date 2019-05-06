import javax.servlet.http.*;

public class Quiz {
    private static String[] questions = {
        "3, 1, 4, 1, 5", // pi
        "1, 1, 2, 3, 5", // fibonacci
        "1, 4, 9, 16, 25", // squares
        "2, 3, 5, 7, 11", // primes
        "1, 2, 4, 8, 16" // powers of 2
    };
    
    private static int[] answers = {9, 8, 36, 13, 32};
    
    int score;
    String question;
    int currentQuestion;
    
    public Quiz() {
        score = 0;
        currentQuestion = 0;
    }
    
    public String getCurrentQuestion() {
        return questions[currentQuestion];
    }
    
    public boolean isFinish(){
        return currentQuestion > questions.length - 1;
    }
    
    public String finalResult() {
        if (isFinish()) {
            if (score >= 45 && score <= 50) {
                return "A";
            }
            if (score >= 35 && score <= 44) {
                return "B";
            }
            if (score >= 25 && score <= 34) {
                return "C";
            }
            if (score < 25) {
                return "NC";
            }
        }
        return "NC";
    }
    
    public boolean answer(int aswr){
        int tries = 0;
        boolean result = false;
        if(answers[currentQuestion] !=  aswr && tries < 3){
            tries++;
        }
        if(answers[currentQuestion] ==  aswr && tries == 0){
            score += 10;
            result = true;
        } 
        if(answers[currentQuestion] ==  aswr && tries == 1){
            score += 5;
            result = true;
        } 
        if(answers[currentQuestion] ==  aswr && tries == 2){
            score += 2;
            result = true;
        } 
        currentQuestion++;
        return result;
    }
    
    public int getScore(){
        return score;
    }
    
    public String getHint() {
        switch (currentQuestion) {
            case 0:
                return "pi";
            case 1:
                return "fibonacci";
            case 2:
                return "squares";
            case 3:
                return "primes";
            case 4:
                return "powers of 2";       
        }
        return "";
    }
}