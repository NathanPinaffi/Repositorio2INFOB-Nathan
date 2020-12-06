/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author range
 */
@Entity
@Table(name = "personagem", catalog = "personagemrpg", schema = "")
@NamedQueries({
    @NamedQuery(name = "Personagem.findAll", query = "SELECT p FROM Personagem p"),
    @NamedQuery(name = "Personagem.findByIdPersonagem", query = "SELECT p FROM Personagem p WHERE p.idPersonagem = :idPersonagem"),
    @NamedQuery(name = "Personagem.findByNomePersonagem", query = "SELECT p FROM Personagem p WHERE p.nomePersonagem = :nomePersonagem"),
    @NamedQuery(name = "Personagem.findByLvlPersonagem", query = "SELECT p FROM Personagem p WHERE p.lvlPersonagem = :lvlPersonagem"),
    @NamedQuery(name = "Personagem.findByElementoidElemento", query = "SELECT p FROM Personagem p WHERE p.elementoidElemento = :elementoidElemento"),
    @NamedQuery(name = "Personagem.findByArmaidArma", query = "SELECT p FROM Personagem p WHERE p.armaidArma = :armaidArma")})
public class Personagem implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonagem")
    private Integer idPersonagem;
    @Column(name = "NomePersonagem")
    private String nomePersonagem;
    @Column(name = "lvlPersonagem")
    private Integer lvlPersonagem;
    @Column(name = "Elemento_idElemento")
    private Integer elementoidElemento;
    @Column(name = "Arma_idArma")
    private Integer armaidArma;

    public Personagem() {
    }

    public Personagem(Integer idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public Integer getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(Integer idPersonagem) {
        Integer oldIdPersonagem = this.idPersonagem;
        this.idPersonagem = idPersonagem;
        changeSupport.firePropertyChange("idPersonagem", oldIdPersonagem, idPersonagem);
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        String oldNomePersonagem = this.nomePersonagem;
        this.nomePersonagem = nomePersonagem;
        changeSupport.firePropertyChange("nomePersonagem", oldNomePersonagem, nomePersonagem);
    }

    public Integer getLvlPersonagem() {
        return lvlPersonagem;
    }

    public void setLvlPersonagem(Integer lvlPersonagem) {
        Integer oldLvlPersonagem = this.lvlPersonagem;
        this.lvlPersonagem = lvlPersonagem;
        changeSupport.firePropertyChange("lvlPersonagem", oldLvlPersonagem, lvlPersonagem);
    }

    public Integer getElementoidElemento() {
        return elementoidElemento;
    }

    public void setElementoidElemento(Integer elementoidElemento) {
        Integer oldElementoidElemento = this.elementoidElemento;
        this.elementoidElemento = elementoidElemento;
        changeSupport.firePropertyChange("elementoidElemento", oldElementoidElemento, elementoidElemento);
    }

    public Integer getArmaidArma() {
        return armaidArma;
    }

    public void setArmaidArma(Integer armaidArma) {
        Integer oldArmaidArma = this.armaidArma;
        this.armaidArma = armaidArma;
        changeSupport.firePropertyChange("armaidArma", oldArmaidArma, armaidArma);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonagem != null ? idPersonagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personagem)) {
            return false;
        }
        Personagem other = (Personagem) object;
        if ((this.idPersonagem == null && other.idPersonagem != null) || (this.idPersonagem != null && !this.idPersonagem.equals(other.idPersonagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Personagem[ idPersonagem=" + idPersonagem + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
