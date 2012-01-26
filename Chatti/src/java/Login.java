/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tonykovanen
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
////        PrintWriter out = response.getWriter();
////        try {
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet Login</title>");  
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<strong>Käyttäjätunnus</strong><br />");
////            out.println("<form method=\"POST\">");
////            out.println("<input type=\"text\" name=\"tunnus\" /><input type=\"submit\" value=\"kirjaudu\" />");
////            out.println("</form>");
////            out.println("</html>");
////             
////        } finally {            
////            out.close();
////        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = request.getRequestDispatcher("Login.jsp");
        disp.forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tunnus = request.getParameter("tunnus");

        if (tunnus != null && tunnus.length() > 3 && tunnus.length() < 9) {
            HttpSession session = request.getSession();
            session.setAttribute("tunnus", tunnus);


            // ohjaa osoitteeseen request.getContextPath() + "/Chat"
            //   missä "/Chat" on Chat-servletin kuuntelema polku

            // lähetä tiedot vastaukseen ja palaa metodikutsusta

            response.sendRedirect("" + request.getContextPath() + "/Chat");
            response.flushBuffer();
            return;
        }
        response.sendRedirect(request.getRequestURI());
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
