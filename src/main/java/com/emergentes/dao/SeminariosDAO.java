
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import java.util.List;


public interface SeminariosDAO {
     public void insert(Seminarios seminarios) throws Exception;
    public void update(Seminarios seminarios) throws Exception;
    public void delete(int id) throws Exception;
    public Seminarios getById(int id) throws Exception;
    public List<Seminarios> getAll() throws Exception;
}
