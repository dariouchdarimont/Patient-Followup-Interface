/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarah
 */

@Entity
@Table(name = "drug")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drug.findAll", query = "SELECT d FROM Drug d"),
    @NamedQuery(name = "Drug.findByIddrug", query = "SELECT d FROM Drug d WHERE d.iddrug = :iddrug"),
    @NamedQuery(name = "Drug.findByName", query = "SELECT d FROM Drug d WHERE d.name = :name"),
    @NamedQuery(name = "Drug.findByPosology", query = "SELECT d FROM Drug d WHERE d.posology = :posology")})

public class Drug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddrug")
    private Integer iddrug;
    @Column(name="name")
    private String name;
    @Column(name="posology")
    private String posology;
    
    
    public Drug(){
        
    }
    
    public Drug(Integer iddrug) {
        this.iddrug = iddrug;
    }
    
    public Integer getIddrug() {
        return iddrug;
    }
    
    public void setIddrug(Integer iddrug) {
        this.iddrug = iddrug;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPosology(){
        return posology;
    }
    
    public void SetPosology(String posology){
        this.posology = posology;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddrug != null ? iddrug.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        if ((this.iddrug == null && other.iddrug != null) || (this.iddrug != null && !this.iddrug.equals(other.iddrug))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
