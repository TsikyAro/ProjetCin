/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import foncier.Propriete;
import foncier.ProprieteLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AfficheMap extends HttpServlet {
    @EJB
     private ProprieteLocal propriete;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String cin = (String)session.getAttribute("cin");
        int idTerrain = Integer.parseInt(request.getParameter("idTerrain"));
        Propriete[] prop = propriete.selectPropriete(cin,idTerrain);
        request.setAttribute("propriete",prop);
        out.println(prop.length);
        
         RequestDispatcher dispatch = request.getRequestDispatcher("Map.jsp");
        dispatch.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
