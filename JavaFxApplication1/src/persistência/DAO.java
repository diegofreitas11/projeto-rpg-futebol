/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistência;

import java.util.List;

/**
 *
 * @author diegofreitas
 */
public interface DAO<T> {
    
    public List<T> listarTodos();
    
}
