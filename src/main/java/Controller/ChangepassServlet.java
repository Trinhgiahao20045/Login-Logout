/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Changepass", urlPatterns = {"/Changepass"})
public class ChangepassServlet extends HttpServlet {  
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
       String oldpasss= request.getParameter("olpass");
       String newpasss=request.getParameter("newpass");
       String confirmpasss=request.getParameter("confirmpass");
       
       if(!newpass.equals(confirmpasss))
       {
           request.setAttribute("error","Mat khau moi va mat khau xac nhan khong dung");
           request.getRequestDispatcher("changepass.jsp").forward(request,response);
       }
       
       
       HttpSession session = request.getSession();
       String username=(String) Session.getAttribute("username");
       
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        TaiKhoan tk= tkDAO.checklogin(username, oldpasss);

        if(tk!=null){
        tk.setMatkhau(newpasss);
        tkDAO.changepass(tk);
        request.getRequestDispatcher("home.jsp").forward(request,response);// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    }else
        {
            request.setAttribute("error","mat khau cu khong dung");
            request.setRequestDispatcher("changepass.jsp").forward(reuqest,response);
        }
}
