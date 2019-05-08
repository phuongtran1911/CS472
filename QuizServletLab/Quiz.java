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
    int currentQuestion;
    String question;
    
    public Quiz() {
        score = 0;
        question = questions[0];
        currentQuestion = 0;
    }
    
    public String getQuestion() {
        return questions[currentQuestion];
    }
    
    public int getScore(){
        return score;
    }    
    
    public void calculateScore(int answer) {
        if (answers[currentQuestion] ==  answer){
            score++;
        } 
        if (currentQuestion <= questions.length - 1) {
            currentQuestion++;
        }
    }
       
    public boolean quizOver(){
        return currentQuestion > questions.length - 1;
    }
    
}
