package controlleur;

import devise.CoursDevise;
import devise.CoursDeviseLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Operation;

public class TraitementOperation extends HttpServlet {
     @EJB
    private CoursDeviseLocal Coursdevise ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TraitementOperation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TraitementOperation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        int transaction = Integer.parseInt(request.getParameter("transaction"));
        int devise = Integer.parseInt(request.getParameter("devise"));
        String cinE = request.getParameter("cinE");
        String cinR = request.getParameter("cinR");
        Double montant = Double.parseDouble(request.getParameter("montant"));
        String date = request.getParameter("dates");
        CoursDevise cr = Coursdevise.selectCoursDevise(devise);
        out.println(cr.getIdDevise());
        Operation p = new Operation();
        double volaE = p.Vola(cinE);
        double volaR = p.Vola(cinR);
        double valiny1 = cr.valeurDeviseTV(montant, cr.getValeurEuroTV());
        double valiny2 = cr.valeurDeviseTA(montant, cr.getValeurAriaryTV());
        valiny1= volaR+valiny1;
        out.println("recepteur:" + valiny1);
        volaE = volaE - valiny2; 
        out.println("envoyeur:" + volaE);
        Operation op = new Operation(transaction,valiny1,cinE,cinR,date);
        Operation mandefa = new Operation(transaction,volaE,cinE,cinE,date);
        if(montant<0){
            out.println("Prix Non Valide");
        }else{
            if(volaE > montant){
            op.insertOperation();
            if(volaE < 0){
                 mandefa.setMontant(0);
            }else{
                out.println("Le solde n'est pas suffisant");
            }
            mandefa.insertOperation();
            }else{
                out.println("Le solde n'est pas suffisant");
            }
        }
        
       
        
        out.println("tra:"+transaction+" devise:"+devise+"cinE "+ cinE+" cinR :"+cinR+ "montant: "+montant+" date "+date);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
