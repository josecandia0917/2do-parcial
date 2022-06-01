
package com.emergentes.controlador;

import com.emergentes.dao.SeminariosDAO;
import com.emergentes.dao.SeminariosDAOimpl;
import com.emergentes.modelo.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeminariosControlador", urlPatterns = {"/SeminariosControlador"})
public class SeminariosControlador extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
          try{
            Seminarios sem = new Seminarios();
            int id;
            SeminariosDAO dao = new SeminariosDAOimpl();
            String action = (request.getParameter("action")!= null) ? request.getParameter("action"): "view";
            
            switch (action){
                case "add":
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frmseminarios.jsp").forward(request, response);
                break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frmseminarios.jsp").forward(request, response);
                break;
                case "delete":
                     id = Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("SeminariosControlador");
                break;
                case "view":
                    // obtener la lista de registro 
                    List<Seminarios> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("seminarios.jsp").forward(request, response);
                break;
            }
            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        
        
        Seminarios sem  = new Seminarios();
        
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setFecha(fecha);
        sem.setCupo(cupo);
 
        SeminariosDAO dao = new SeminariosDAOimpl();
        if(id == 0){
            try {
                // nuevo registro

                dao.insert(sem);
            } catch (Exception ex) {
                System.out.println("Error al insertar " +ex.getMessage());
            }
        }else {
            try {
                // ediciion
                dao.update(sem);
            } catch (Exception ex) {
               System.out.println("Error al editar " +ex.getMessage());
            }
        }
        response.sendRedirect("SeminariosControlador");
    }


}
