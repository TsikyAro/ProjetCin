package controlleur;

import devise.CoursDeviseLocal;
import devise.Devise;
import devise.DeviseLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Transactions;
public class AffichageTransaction extends HttpServlet {
    @EJB
    private DeviseLocal devise ;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AffichageTransaction</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AffichageTransaction at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String cin = (String)session.getAttribute("cin");
        Transactions trans = new Transactions();
        Transactions[] tran = trans.tableauTransaction();
        Devise[] devs = devise.selectDevise();
        request.setAttribute("transaction",tran);
        request.setAttribute("cin",cin);
        request.setAttribute("devise",devs);
        out.println(cin);
        RequestDispatcher dispatch = request.getRequestDispatcher("InsertionOperation.jsp");
        dispatch.forward(request, response);
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
