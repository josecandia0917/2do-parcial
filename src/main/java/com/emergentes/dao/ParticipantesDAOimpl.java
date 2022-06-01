
package com.emergentes.dao;

import com.emergentes.modelo.Participantes;
import com.emergentes.util.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ParticipantesDAOimpl extends ConexionDB implements ParticipantesDAO{

    @Override
    public void insert(Participantes participantes) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO participantes (apellidos, nombres, id_seminario, confirmado) VALUES (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participantes.getApellidos());
            ps.setString(2, participantes.getNombres());
            ps.setInt(3, participantes.getId_seminario());
            ps.setInt(4, participantes.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Participantes participantes) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE participantes  SET apellidos=?, nombres=?, id_seminario=?, confirmado=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participantes.getApellidos());
            ps.setString(2, participantes.getNombres());
            ps.setInt(3, participantes.getId_seminario());
            ps.setInt(4, participantes.getConfirmado());
            ps.setInt(5, participantes.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM participantes WHERE id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Participantes getById(int id) throws Exception {
        Participantes par = new Participantes();
         try {
            this.conectar();
            String sql = "SELECT * FROM participantes Where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
                
            }
           
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return par;
    }

    @Override
    public List<Participantes> getAll() throws Exception {
         List<Participantes> lista = null;
        try{
           this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM participantes");

            ResultSet rs =  ps.executeQuery();
            
            lista = new ArrayList<Participantes>();
            
            while(rs.next()){
                Participantes par = new Participantes();
                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
                
                lista.add(par);
            }
            rs.close();
            ps.close();
           
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    }

