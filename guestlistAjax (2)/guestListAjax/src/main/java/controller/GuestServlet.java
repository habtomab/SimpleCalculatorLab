
package controller;

import app.Guest;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author levi
 */
@WebServlet(name = "guestServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("guests.jsp");
        view.forward(request, response);;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /* retrieve or create session here as needed */
        HttpSession sess = request.getSession();// we are creating session object related to the specific request
        List<Guest> guestList = (List<Guest>) sess.getAttribute("guestList");
        if (guestList == null) {
            guestList = new ArrayList<Guest>();
            sess = request.getSession();
            sess.setAttribute("guestList", guestList);
        }

        /* get  input */
        String firstInput = request.getParameter("first");
        String lastInput = request.getParameter("last");
        Guest guest=new Guest (firstInput,lastInput);
         //guestList.add(new Guest(firstInput, lastInput));
         guestList.add(guest);
        // sess.setAttribute("guestList",guestList);
         System.out.println(new Gson().toJson(guest));



        String JSONguests;
        JSONguests = new Gson().toJson(guestList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JSONguests);        
    }



}
