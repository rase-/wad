/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonykovanen
 */
@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {

    private Queue<Viesti> viestit = new LinkedList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean kirjautunut = tarkistaKirjautuminen(request, response);
        if (kirjautunut) {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("viestit", viestit);
            request.setAttribute("contextPath", request.getContextPath());
            RequestDispatcher disp = request.getRequestDispatcher("Chat.jsp");
            disp.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        tarkistaKirjautuminen(request, response);
        String tunnus = "" + request.getSession().getAttribute("tunnus");
        String viesti = " " + request.getParameter("viesti");
        if (viestit.size() <= 10) {
            viestit.add(new Viesti(tunnus, viesti));
        } else {
            viestit.poll();
            viestit.add(new Viesti(tunnus, viesti));
        }
        response.sendRedirect(request.getRequestURI());
    }

    private boolean tarkistaKirjautuminen(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("tunnus") == null) {
            response.sendRedirect("" + request.getContextPath() + "/Login");
            return false;
        }
        return true;
    }
}