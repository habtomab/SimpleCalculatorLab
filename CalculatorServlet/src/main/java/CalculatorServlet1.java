

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<html><head><meta charset='ISO-8859-1'><title>Calculator</title></head><body>");
        out.print("<form method='post'>");
        out.print("<input type='number' size='2' name='n1'/> + ");
        out.print("<input type='number' size='2' name='n2'/> = ");
        out.print("<input type='number' size='2' name='ns'/>  <br/>");
        out.print("<input type='number' size='2' name='n3'/> * ");
        out.print("<input type='number' size='2' name='n4'/> = ");
        out.print("<input type='number' size='2' name='nm'/> <br/><br/>");
        out.print("<input type='submit' name='submit' value='Submit'>");
        out.print("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int num1 = Integer.parseInt(request.getParameter("n1").trim());
        int num2 = Integer.parseInt(request.getParameter("n2").trim());
        int num3 = Integer.parseInt(request.getParameter("n3").trim());
        int num4 = Integer.parseInt(request.getParameter("n4").trim());

        int sum = num1+num2;
        int mult = num3*num4;

        out.print("<html><head><meta charset='ISO-8859-1'><title>Calculator</title></head><body>");
        out.print("<form method='post'>");
        out.print("<input type='number' size='2' name='n1' value='"+num1+"' /> + ");
        out.print("<input type='number' size='2' name='n2' value='"+num2+"' /> = ");
        out.print("<input type='number' size='2' name='ns' value='"+sum+"' />  <br/>");
        out.print("<input type='number' size='2' name='n3' value='"+num3+"' /> * ");
        out.print("<input type='number' size='2' name='n4' value='"+num4+"' /> = ");
        out.print("<input type='number' size='2' name='nm' value='"+mult+"' /> <br/><br/>");
        out.print("<input type='submit' name='submit' value='Submit'>");
        out.print("</form></body></html>");
    }
}