package lab.quizzes.controllers;

import lab.quizzes.model.dataAcces.AccesQuizzes;
import lab.quizzes.model.entities.Quiz;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "welcome", urlPatterns = "/welcome")
public class Welcome extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AccesQuizzes instance = new AccesQuizzes();
    List<Quiz> quizList = instance.listQuizzes();
    Object[][] tQuiz = new Object[quizList.size()][2];
    int i = 0;
    for (Quiz e : quizList) {
      tQuiz[i][0] = e;
      tQuiz[i][1] = 0;
      i++;

      System.out.println(i+" : "+e.toString());
    }

    HttpSession ses = request.getSession(true);
    ses.setAttribute("tQuiz", tQuiz);
    ses.setAttribute("numQuiz", Integer.valueOf(0));
    ses.setAttribute("firstName", request.getParameter("FirstName"));
    ses.setAttribute("lastName", request.getParameter("LastName"));

    request.getRequestDispatcher("WEB-INF/jsp/quizOn.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
  }
}
