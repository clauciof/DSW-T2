/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PromocaoDAO;
import dao.SiteDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Promocao;
import pojo.Site;

/**
 *
 * @author clauc
 */

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable {
    
    
    private Promocao promocao;
    
    public String lista() {
        return "promocao/index.xhtml";
    }

    public String cadastra() {
        promocao = new Promocao();
        return "promocao/forms.xhtml";
    }

    public String edita(Integer id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "/promocao/forms.xhtml";
    }

    public String salva() {
       PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
            dao.save(promocao);
            
        } else {
            dao.update(promocao);
            
        }
        return "/index.xhtml";
       
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "/promocao/index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
    
}
