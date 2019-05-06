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
    
    public Quiz() {
        score = 0;
        question = questions[0];
    }
    
    public static String getQuestion(HttpSession pres) {
        if (pres == null) {
            return questions[0];
        }
        String preq = (String) pres.getAttribute("question");
        for (int i = 0; i < questions.length - 1; i++) {
            if (preq.equals(questions[i])) {
                return questions[i + 1];
            }
        }
        return null;
    }
      
    public static int getPreScore(HttpSession pres) {
        if (pres == null) {
            return 0;
        } else {
            return (int) pres.getAttribute("score");
        }
    }

    public static int calculateScore(HttpSession pres, int answer) {
        int preScore = 0;
        for (int i = 0; i < 5; i++) {
            if (getQuestion(pres).equals(questions[i]) && answer == answers[i]) {
                preScore = getPreScore(pres);
                return preScore++;
            }
        }
        return getPreScore(pres); 
    }
}
