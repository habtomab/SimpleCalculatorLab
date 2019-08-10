package w3d3.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NumberQuizServlet", value = "/Lab03")

public class NumberQuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Quiz quiz = (Quiz) request.getSession().getAttribute("sessQuiz");
        String answer = request.getParameter("txtAnswer");
        PrintWriter out = response.getWriter();
        boolean error = true;

        if (answer != null && answer != "" && quiz.getCurrentAnswr() == Integer.parseInt(answer)) {
            error = false;
            quiz.increaseQuizIndex();
            quiz.increaseScore();
        }

        if (quiz.getCurrentQuestion() != "") {
            genQuizPage(quiz, out, quiz.getCurrentQuestion(), error, answer);
        } else {
            genQuizOverPage(out);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Quiz quiz = new Quiz();
        request.getSession().setAttribute("sessQuiz", quiz);
        PrintWriter out = response.getWriter();

        genQuizPage(quiz, out, quiz.getCurrentQuestion(), false, null);
    }

    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {

        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='number' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
        out.print("<head >");
        out.print("<title>NumberQuiz is over</title> ");
        out.print("</head> ");
        out.print("<body> ");
        out.print("<p style='color:red'>The number quiz is over!</p>" +
                " <form method='get'><input type='submit' name='btnStart' value='Start Again!' />" +
                "</form></body> ");
        out.print("</html> ");
    }
}
