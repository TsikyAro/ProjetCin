package controlleur;

import foncier.Foncier;
import foncier.FoncierLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Operation;
import personne.Cins;
import personne.CinsLocal;
import personne.Olona;
import personne.OlonaLocal;
import personne.Sante;
import personne.SanteLocal;
public class TraitementCode extends HttpServlet {
    
    @EJB
    private OlonaLocal olona;
    @EJB
    private CinsLocal cins;
    @EJB
    private SanteLocal sante; 
    @EJB
    private FoncierLocal foncier;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Olona olona = new Olona();
        String cin = request.getParameter("cin");
        Operation op = new Operation();
        try {
            HttpSession session = request.getSession();
            session.setAttribute("cin",cin);
            Cins cine = cins.getCinbyId(cin.trim());
            Olona personne = olona.getOlonabyId(cine.getIdOlona());
            Sante santes = sante.getSantebyId(cin);
            Operation[] operation = op.getOperationbyId(cin);
            Foncier[] foncies=foncier.selectTerrain(cin);
            request.setAttribute("cin", cin);
            request.setAttribute("Olona", personne);            
            request.setAttribute("sante", santes);
            request.setAttribute("operation", operation);
            request.setAttribute("foncier", foncies);
            
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("Presentation.jsp");
        dispatch.forward(request, response);
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
