
package com.emergentes.controlador;

import com.emergentes.dao.ParticipantesDAO;
import com.emergentes.dao.ParticipantesDAOimpl;
import com.emergentes.modelo.Participantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ParticipantesControlador", urlPatterns = {"/ParticipantesControlador"})
public class ParticipantesControlador extends HttpServlet {

    
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          try{
            Participantes par = new Participantes();
            int id;
            ParticipantesDAO dao = new ParticipantesDAOimpl();
            String action = (request.getParameter("action")!= null) ? request.getParameter("action"): "view";
            
            switch (action){
                case "add":
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frmparticipantes.jsp").forward(request, response);
                break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    par = dao.getById(id);
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frmparticipantes.jsp").forward(request, response);
                break;
                case "delete":
                     id = Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("ParticipantesControlador");
                break;
                case "view":
                    // obtener la lista de registro 
                    List<Participantes> lista = dao.getAll();
                    request.setAttribute("participantes", lista);
                    request.getRequestDispatcher("participantes.jsp").forward(request, response);
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
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        
        
        
        Participantes par  = new Participantes();
        
        par.setId(id);
        par.setApellidos(apellidos);
        par.setNombres(nombres);
        par.setId_seminario(id_seminario);
        par.setConfirmado(confirmado);
        
        ParticipantesDAO dao = new ParticipantesDAOimpl();
        if(id == 0){
            try {
                // nuevo registro

                dao.insert(par);
            } catch (Exception ex) {
                System.out.println("Error al insertar " +ex.getMessage());
            }
        }else {
            try {
                // ediciion
                dao.update(par);
            } catch (Exception ex) {
               System.out.println("Error al editar " +ex.getMessage());
            }
        }
        response.sendRedirect("ParticipantesControlador");
    }
    
}
