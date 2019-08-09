import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/SimpleCalculator")//name = "SimpleCalculator", value =
public class SimpleCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String txtnum1 = request.getParameter("txtnum1");
        String txtnum2 = request.getParameter("txtnum2");
        String txtnum3 = request.getParameter("txtnum3");
        String txtnum4 = request.getParameter("txtnum4");

        double num1 = 0, num2 = 0, num3 = 0, num4 = 0, sum = 0, mul = 1;
        if (txtnum1 != "") {
            num1 = Double.parseDouble(txtnum1);
        }
        if (txtnum2 != "") {
            num2 = Double.parseDouble(txtnum2);
        }

        if (txtnum3 != "") {
            num3 = Double.parseDouble(txtnum3);
        }

        if (txtnum4 != "") {
            num4 = Double.parseDouble(txtnum4);
        }
        sum = num1 + num2;
        mul = num3 * num4;

        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body><form method=\"post\" action=\"calc\">\n" +
                "    <input type=\"text\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\" name=\"txtnum1\" value=\" " + txtnum1 + "\"/>+ <input type=\"text\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\" name=\"txtnum2\" value=\"" + txtnum2 + "\"/>=<input type=\"text\" name=\"txtSum\" value=\"" + sum + "\" /><br/>\n" +
                "\n" +
                "    <input type=\"text\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\" name=\"txtnum3\" value=\"" + txtnum3 + "\"> * <input type=\"text\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\" name=\"txtnum4\" value=\"" + txtnum4 + "\"/>=<input type=\"text\" name=\"txtMul\" value=\"" + mul + "\"/><br/>\n" +
                "    <input type=\"submit\" value=\"submit\"/>\n" +
                "</form></body>\n" +
                "</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body><form method=\"post\" action=\"calc\">\n" +
                "    <input type=\"text\" name=\"txtnum1\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\"/>+ <input type=\"text\" name=\"txtnum2\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\"/>=<input type=\"text\" name=\"txtSum\"/><br/>\n" +
                "\n" +
                "    <input type=\"text\" name=\"txtnum3\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\"> * <input type=\"text\" name=\"txtnum4\" pattern=\"\\d+(\\.\\d{1,2})?\" step=\"0.01\"\n" +
                "           title=\"This should be a number with up to 2 decimal places.\"/>=<input type=\"text\" name=\"txtMul\"/><br/>\n" +
                "    <input type=\"submit\" value=\"submit\"/>\n" +
                "</form></body>\n" +
                "</html>");
    }

}
