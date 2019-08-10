package lab.quizzes.console;

import lab.quizzes.model.dataAcces.AccesQuizzes;
import lab.quizzes.model.entities.Quiz;

import java.util.List;
import java.util.Scanner;

public class QuizConsole {
  public static final String ANSI_RESET  = "\u001B[0m";
  public static final String ANSI_RED    = "\u001B[31m";
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static Integer score=0;
  public static void main(String[] args) {
      AccesQuizzes accesQuizzes = new AccesQuizzes();
      List<Quiz> quizList = accesQuizzes.listQuizzes();
      writeConsole("Start The Quiz:\n");

      quizList.forEach(a->{
        writeConsole(a.getQuestion());writeConsole("\t"+a.getChoises());
        String ans = getConsoleInput("\t\t\tYour answer : ").next();
        if(ans.trim().equals(a.getAnswer().trim())){
          score++;
          writeConsole(ANSI_GREEN+"\t\t That is correct! ");
          writeConsole(ANSI_GREEN+"\t\t Your score is : "+score);
        }else {
          writeConsole(ANSI_RED+"\t\t That is incorrect! ");
          writeConsole(ANSI_RESET+"\t\t Your score is : "+score);
        }
        writeConsole(ANSI_RESET+"\n");
      });
    writeConsole("\n\n\t\t Your final score is : "+score+"/"+quizList.size());
      //writeConsole(i);
  }

  public static  void writeConsole(Object message){
    System.out.println(message);
  }
  /**
   * Function getting input from console
   *
   * @return Scanner
   */
  public static Scanner getConsoleInput(String prompt){
    System.out.print(prompt);
    return new Scanner(System.in);
  }
}
