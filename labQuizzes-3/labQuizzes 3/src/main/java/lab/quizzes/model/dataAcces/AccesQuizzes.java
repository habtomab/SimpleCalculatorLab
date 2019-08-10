package lab.quizzes.model.dataAcces;

import lab.quizzes.model.entities.Quiz;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccesQuizzes {
  public static String DATA_FILE_QUIZ = "quizzes.csv";
  public List<Quiz> listQuizzes() {

    System.out.println("Loading Quiz file\n");
    List<Quiz> records = new ArrayList<Quiz>();
    try{
      String file_path = this.getClass().getClassLoader().getResource(DATA_FILE_QUIZ).toURI().getPath();
      Scanner scanner = new Scanner(new File(file_path));
      while (scanner.hasNextLine()) {
        String[] g = scanner.nextLine().split(",");
        if(g.length == 3){
          Quiz q = new Quiz(g[0],g[1],g[2]);
          records.add(q);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    return records;
  }


}
