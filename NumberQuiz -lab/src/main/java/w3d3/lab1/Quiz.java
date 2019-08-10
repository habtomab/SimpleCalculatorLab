package w3d3.lab1;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Quiz {

    private Hashtable<String, Integer> questions;
    private int score;
    private int quizIndex;

    public Quiz() {
        questions = new Hashtable<String, Integer>();
        questions.put("[3, 1, 4, 1, 5, ? ]", 9);
        questions.put("[1, 1, 2, 3, 5, ? ]", 8);
        questions.put("[1, 4, 9, 16, 25, ? ]", 36);
        questions.put("[2, 3, 5, 7, 11, ? ]", 13);
        questions.put("[1, 2, 4, 8, 16, ? ]", 32);
    }

    public int getNumCorrect() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public int getQuizIndex() {
        return quizIndex;
    }

    public void increaseQuizIndex() {
        quizIndex++;
    }

    public String getCurrentQuestion() {
        if (quizIndex >= questions.size()) {
            return "";
        } else {
            List keys = new ArrayList(questions.keySet());
            return keys.get(quizIndex).toString();
        }
    }

    public int getCurrentAnswr() {
        if (quizIndex >= questions.size()) {
            return -1;
        } else {
            List keys = new ArrayList(questions.values());
            return Integer.parseInt(keys.get(quizIndex).toString());
        }
    }
}