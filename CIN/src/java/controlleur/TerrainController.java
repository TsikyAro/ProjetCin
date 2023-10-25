/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import devise.DeviseLocal;
import foncier.ActeVente;
import foncier.Terrain;
import foncier.TerrainLocal;
import foncier.TypeTerrain;
import foncier.TypeTerrainLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tsiky Aro
 */
public class TerrainController extends HttpServlet {
    @EJB
    private TypeTerrainLocal type; 
    @EJB
    private TerrainLocal terrain; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TerrainController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TerrainController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        TypeTerrain[] types = type.selectTerrain();
        out.println(types.length);
        request.setAttribute("type", types);
        RequestDispatcher dispatch = request.getRequestDispatcher("InsertionTerrain.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cin = (String)session.getAttribute("cin");
        PrintWriter out = response.getWriter();
        int type = Integer.parseInt(request.getParameter("type"));
        String localisation = request.getParameter("localisation");
        double prix = Double.parseDouble(request.getParameter("prix"));
        double superficie = Double.parseDouble(request.getParameter("superficie"));
        Terrain terre = new Terrain(localisation,superficie);
        Date date = Date.valueOf(request.getParameter("date"));
        terre.insertTerrain();
        terre = terrain.selectLastTerrain();
        session.setAttribute("terrain", terre);
        ActeVente acte = new ActeVente(cin,terre.getIdTerrain(),type,date,prix);
        out.println("type: "+type+" locatisation:"+localisation+" prix:"+prix+" superficie: "+superficie+"date:"+date+"terrain:"+terre.getIdTerrain());
        acte.insertActeVente();
        RequestDispatcher dispatch = request.getRequestDispatcher("InsertionPropriete.jsp");
        dispatch.forward(request, response);
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
