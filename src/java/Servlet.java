/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Montre;
import physique.data.MontreORMService;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author Maxime
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Montre m = new Montre();
        MontreORMService montre = PhysiqueDataFactory.getMontreORMSrv();
        String idRapport = null;
        try {
            idRapport = request.getParameter("IdRapport");
            m = montre.getById(Long.parseLong(idRapport));
        } catch (Exception ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (m == null) {
            out.println("Erreur fichier null");
        } else {
            out.println("Fabricant : " + m.getFabricant() + "<br>");
            out.println("Nom client : " + m.getProprietaire().getNom() + "<br>");
            out.println("Prenom client : " + m.getProprietaire().getPrenom()+ "<br>");
            out.println("ID client : " +m.getProprietaire().getId()+ "<br>");
            out.println("ID montre : " +m.getId()+ "<br>");
            out.println("ID rapport : " +m.getRapport().getId()+ "<br>");
            out.println("Date de modification : " +m.getRapport().getDateUpdate()+ "<br>");
            out.println("Defaut : " +m.getRapport().getDefaut()+ "<br>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
