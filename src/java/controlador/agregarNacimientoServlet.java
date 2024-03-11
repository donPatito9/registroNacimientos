/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Nacimiento;
import modelo.RegistroNacimiento;

/**
 *
 * @author Robinson Concha
 */
@WebServlet(name = "agregarNacimientoServlet", urlPatterns = {"/agregarNacimientoServlet"})
public class agregarNacimientoServlet extends HttpServlet {
 private final static Logger LOG = Logger.getLogger(agregarNacimientoServlet.class.getName());
    
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
            out.println("<title>Servlet agregarProductoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregarProductoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
       int id = 0, peso= 0, centro = 0;
       boolean prematuro;
       prematuro =false;
       char sexo;
       sexo ='F';
       ArrayList<String> errores = new ArrayList<String>();
       String respuesta;
       
        response.setContentType("text/html;charset=UTF-8");
        //recibir parámetros
        String idN = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String pesoN = request.getParameter("peso");
        String prematuroN = request.getParameter("prematuro");
        String sexoN = request.getParameter("sexo");
        //String fechaNacimiento = request.getParameter("mensaje");
        //String fechaNacimiento = request.getParameter("fechaNacimiento");
        String centroN = request.getParameter("centro");
       //validar parámetros
        if (idN.isEmpty()) {
            errores.add("Debe ingresar id");
        }
        try {
            id = Integer.parseInt(idN);
        } catch (NumberFormatException e) {
            errores.add("Debe ingresar un valor entero para el id");
        }

        if (nombre.isEmpty()) {
            errores.add("Debe ingresar nombre");
        }

        if (pesoN.isEmpty()) {
            errores.add("Debe ingresar peso");
        }

        try {
            peso = Integer.parseInt(pesoN);
        } catch (NumberFormatException e) {
            errores.add("Debe ingresar un valor entero para el peso");
        }
        
        if (prematuroN.equals("prematuro")){
            errores.add("Seleccionar");
        }
               
        if (centroN.equals("Seleccione")) {
            errores.add("Debe ingresar centro");
        }

        nombre = nombre.toUpperCase();
        
   //logica de negocio
     if (errores.isEmpty()) {
            Nacimiento nac = new Nacimiento();
            nac.setId(id);
            nac.setNombre(nombre);
            nac.setPeso(peso);
            nac.setPrematuro(prematuro);
            nac.setFechaNacimiento(new Date());
            nac.setCentro(centro);

         // agregar mensaje a la session
            HttpSession session = request.getSession();
            RegistroNacimiento registroNac = (RegistroNacimiento) session.getAttribute("registro");
            if (registroNac == null) {
                registroNac = new RegistroNacimiento();
                session.setAttribute("registro", registroNac);
            }
            registroNac.agregarNacimiento(nac);
            // agregar mensaje a la session
           respuesta = "Tu Registro se ingresó exitosamente";
            
            LOG.log(Level.INFO, "Proceso exitoso", request);
            
           } else {
           respuesta = "Tu Registro no se ingresó";
            
            LOG.log(Level.SEVERE, "Proceso NO exitoso");
        }

        //despachar vista
        request.setAttribute("respuesta", respuesta);
        request.setAttribute("error", errores);

        RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
        despachador.forward(request, response);
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
