/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ali
 */
public interface IServiceMatiere <T> {
     void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
     boolean update(T t) throws SQLException;
    List<T> readAll() throws SQLException; 
     T rechercheMatiereParid_(int id_matiere);
    
    
}
