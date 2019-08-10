package lab.quizzes.controllers;

import lab.quizzes.model.entities.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "quizOn", urlPatterns = "/quizOnGoing")
public class QuizOn extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession ses = request.getSession(false);
    Object[][] tQuiz = (Object[][]) ses.getAttribute("tQuiz");
    Integer curQ = (Integer) ses.getAttribute("numQuiz");
    System.out.println("current Quiz : " + curQ);
    Quiz quiz = (Quiz) tQuiz[curQ][0];

    String ans = request.getParameter("answer") == null ? "" : request.getParameter("answer");
    if (ans.equals(quiz.getAnswer())) {
      tQuiz[curQ][1] = 1;
    } else {
      tQuiz[curQ][1] = 2;
    }
    curQ++;
    ses.setAttribute("tQuiz", tQuiz);
    ses.setAttribute("numQuiz", curQ);

//      ses.setAttribute("tQuiz", tQuiz);
//      ses.setAttribute("numQuiz", Integer.valueOf(0));
    if (curQ == tQuiz.length)
      request.getRequestDispatcher("WEB-INF/jsp/quizEnd.jsp").forward(request, response);
    else
      request.getRequestDispatcher("WEB-INF/jsp/quizOn.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("welcome").forward(request, response);
  }
}
