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
@Table(name = "arma", catalog = "personagemrpg", schema = "")

public class Arma implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArma")
    private Integer idArma;
    @Column(name = "NomeArma")
    private String nomeArma;
    @Column(name = "lvlArma")
    private Integer lvlArma;
    @Column(name = "TipoArma")
    private String tipoArma;
    @OneToMany (mappedBy = "arma")
    private List<Personagem> personagens = new ArrayList<>();
    
    public Arma() {
    }

    public Arma(Integer idArma) {
        this.idArma = idArma;
    }

    public Integer getIdArma() {
        return idArma;
    }

    public void setIdArma(Integer idArma) {
        Integer oldIdArma = this.idArma;
        this.idArma = idArma;
        changeSupport.firePropertyChange("idArma", oldIdArma, idArma);
    }

    public String getNomeArma() {
        return nomeArma;
    }

    public void setNomeArma(String nomeArma) {
        String oldNomeArma = this.nomeArma;
        this.nomeArma = nomeArma;
        changeSupport.firePropertyChange("nomeArma", oldNomeArma, nomeArma);
    }

    public Integer getLvlArma() {
        return lvlArma;
    }

    public void setLvlArma(Integer lvlArma) {
        Integer oldLvlArma = this.lvlArma;
        this.lvlArma = lvlArma;
        changeSupport.firePropertyChange("lvlArma", oldLvlArma, lvlArma);
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        String oldTipoArma = this.tipoArma;
        this.tipoArma = tipoArma;
        changeSupport.firePropertyChange("tipoArma", oldTipoArma, tipoArma);
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
        hash += (idArma != null ? idArma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arma)) {
            return false;
        }
        Arma other = (Arma) object;
        if ((this.idArma == null && other.idArma != null) || (this.idArma != null && !this.idArma.equals(other.idArma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeArma;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
