/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.SiteDAO;
import dao.TeatroDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Site;
import pojo.Teatro;

/**
 *
 * @author clauc
 */

@ManagedBean
@SessionScoped
public class SiteBean implements Serializable {
    
    
    private Site site;
    
    public String lista() {
        return "site/index.xhtml";
    }

    public String cadastra() {
        site = new Site();
        return "site/forms.xhtml";
    }

    public String edita(Integer id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "/site/forms.xhtml";
    }

    public String salva() {
       SiteDAO dao = new SiteDAO();
        if (site.getId() == null) {
            dao.save(site);
            
        } else {
            dao.update(site);
            
        }
        return "/index.xhtml";
       
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "/site/index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }
    
}
