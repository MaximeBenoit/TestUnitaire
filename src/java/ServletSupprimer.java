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
import metier.Operateur;
import physique.data.OperateurORMService;
import physique.data.PhysiqueDataFactory;

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 *
 * @author Maxime
 */
@WebServlet(name = "ServletSupprimer", urlPatterns = {"/ServletSupprimer"})
public class ServletSupprimer extends HttpServlet {

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
        Operateur o = new Operateur();
        Operateur Osuppr = new Operateur();
        OperateurORMService operateur = PhysiqueDataFactory.getOperateurORMSrv();
        String idOperateur = null;

        idOperateur = request.getParameter("IdOperateurSupprimer");
        try {
            o = operateur.getById(Long.parseLong(idOperateur));
            operateur.removeOperateur(o);
        } catch (Exception ex) {
            Logger.getLogger(ServletSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Osuppr = operateur.getById(Long.parseLong(idOperateur));
        } catch (Exception ex) {
            Logger.getLogger(ServletSupprimer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Osuppr == null){
        out.println("Operateur : "+idOperateur+ " supprimé");
        }else{
            out.println("Operateur non supprimé");
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