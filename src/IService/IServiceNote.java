/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IService;

import Entite.Tab;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ali
 */
public interface IServiceNote <T> {
     void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
    boolean update(int t,float n) throws SQLException;
    List<T> readAll() throws SQLException; 
        List<T> readAll2(String e) throws SQLException; 
     T rechercheNoteParid_eleve(int id_eleve);
    
    
}
