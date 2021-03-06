/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author range
 */
@Entity
@Table(name = "elemento", catalog = "personagemrpg", schema = "")

public class Elemento implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idElemento")
    private Integer idElemento;
    @Column(name = "NomeElemento")
    private String nomeElemento;
     @OneToMany (mappedBy = "elemento")
    private List<Personagem> personagens = new ArrayList<>();
    
    public Elemento() {
    }

    public Elemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        Integer oldIdElemento = this.idElemento;
        this.idElemento = idElemento;
        changeSupport.firePropertyChange("idElemento", oldIdElemento, idElemento);
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        String oldNomeElemento = this.nomeElemento;
        this.nomeElemento = nomeElemento;
        changeSupport.firePropertyChange("nomeElemento", oldNomeElemento, nomeElemento);
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElemento != null ? idElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.idElemento == null && other.idElemento != null) || (this.idElemento != null && !this.idElemento.equals(other.idElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeElemento;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
