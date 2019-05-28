/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TeatroDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Teatro;

/**
 *
 * @author clauc
 */

@ManagedBean
@SessionScoped
public class TeatroBean implements Serializable {
    
     private Teatro teatro;
    
    public String lista() {
        return "teatro/index.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "/teatro/forms.xhtml";
    }

    public String edita(Integer id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "/teatro/forms.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if (teatro.getId() == null) {
            dao.save(teatro);
            
        } else {
            dao.update(teatro);
            
        }
        return "/index.xhtml";
       
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "/teatro/index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public Teatro getTeatro() {
        return teatro;
    }
    
    /*public List<Editora> getEditoras() throws SQLException {
        EditoraDAO dao = new EditoraDAO();
        return dao.getAll();
    }*/
    
}
