package controlleur;

import foncier.Parsel;
import foncier.ParselLocal;
import foncier.Propriete;
import foncier.ProprieteLocal;
import foncier.Terrain;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class InsertionPropriete extends HttpServlet {
     @EJB
     private ParselLocal parsel;
     @EJB
     private ProprieteLocal propriete;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertionPropriete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertionPropriete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//    Session
        HttpSession session = request.getSession();
        Terrain terrain = (Terrain)session.getAttribute("terrain");
        String cin = (String)session.getAttribute("cin");

//getdonnes Afffichage
        double longitude1 = Double.parseDouble( request.getParameter("longitude1"));
        double latitude1 = Double.parseDouble( request.getParameter("latitude1"));
        
        double longitude2 = Double.parseDouble( request.getParameter("longitude2"));
        double latitude2 = Double.parseDouble( request.getParameter("latitude2"));
        
         double longitude3 = Double.parseDouble( request.getParameter("longitude3"));
        double latitude3 = Double.parseDouble( request.getParameter("latitude3"));
        out.println("idParsel:"+terrain.getIdTerrain()+" cin: "+cin+" long:"+longitude1+" latitude:"+latitude1);

//        insertion propriete
        Propriete propr = new Propriete(cin,longitude1,latitude1,terrain.getIdTerrain());
        propr.insertPropriete();
        propr = new Propriete(cin,longitude2,latitude2,terrain.getIdTerrain());
        propr.insertPropriete();
        propr = new Propriete(cin,longitude3,latitude3,terrain.getIdTerrain());
        propr.insertPropriete();
        
//        select propriete
        Propriete[] prop = propriete.selectPropriete(cin,terrain.getIdTerrain());
        request.setAttribute("propriete",prop);
        out.println(prop.length);
        
//dispach
        RequestDispatcher dispatch = request.getRequestDispatcher("Map.jsp");
        dispatch.forward(request, response);
        processRequest(request, response);
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
