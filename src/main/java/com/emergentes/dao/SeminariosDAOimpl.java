
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import com.emergentes.util.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SeminariosDAOimpl extends ConexionDB implements SeminariosDAO{

    @Override
    public void insert(Seminarios seminarios) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios (titulo, fecha, cupo) VALUES (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminarios.getTitulo());
            ps.setString(2, seminarios.getFecha());
            ps.setInt(3, seminarios.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminarios seminarios) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios  SET titulo=?, fecha=?, cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminarios.getTitulo());
            ps.setString(2, seminarios.getFecha());
            ps.setInt(3, seminarios.getCupo());
            ps.setInt(4, seminarios.getId());
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
            String sql = "DELETE FROM seminarios WHERE id = ? ";
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
    public Seminarios getById(int id) throws Exception {
        Seminarios sem = new Seminarios();
         try {
            this.conectar();
            String sql = "SELECT * FROM seminarios Where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getString("fecha"));
                sem.setCupo(rs.getInt("cupo"));
                
            }
           
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return sem;
    }

    @Override
    public List<Seminarios> getAll() throws Exception {
        List<Seminarios> lista = null;
        try{
           this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM seminarios");

            ResultSet rs =  ps.executeQuery();
            
            lista = new ArrayList<Seminarios>();
            
            while(rs.next()){
                Seminarios sem = new Seminarios();
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getString("fecha"));
                sem.setCupo(rs.getInt("cupo"));
                
                lista.add(sem);
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
    

