
package com.emergentes.dao;


import com.emergentes.modelo.Participantes;
import java.util.List;

public interface ParticipantesDAO {
    public void insert(Participantes participantes) throws Exception;
    public void update(Participantes participantes) throws Exception;
    public void delete(int id) throws Exception;
    public Participantes getById(int id) throws Exception;
    public List<Participantes> getAll() throws Exception;
}
