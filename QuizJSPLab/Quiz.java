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
    String grade;
    String hint;
    int tries;
    
    public Quiz() {
        score = 0;
        question = questions[0];
        currentQuestion = 0;
        hint = "";
        tries = 0;
    }
    
    public String getQuestion() {
        return questions[currentQuestion];
    }
    
    public int getScore(){
        return score;
    }    
    
    public boolean calculateScore(int answer){
        boolean result = false;
        if (answers[currentQuestion] != answer) {
            tries++;
        }
        if (answers[currentQuestion] ==  answer && tries == 0){
            score += 10;
            result = true;
        } 
        if (answers[currentQuestion] ==  answer && tries == 1){
            score += 5;
            result = true;
        } 
        if(answers[currentQuestion] ==  answer && tries == 2){
            score += 2;
            result = true;
        } 
        if (answers[currentQuestion] ==  answer || tries == 3) {
            currentQuestion++;
            tries = 0;
        }
        return result;
    }
    
    public boolean questionOver() {
        if (tries == 3)
            return true;
        return false;
    }
       
    public boolean quizOver(){
        return currentQuestion > questions.length - 1;
    }
    
    public String getGrade() {
        if (quizOver()) {
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
        return grade;
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
