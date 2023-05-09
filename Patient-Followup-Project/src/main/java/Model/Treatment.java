/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarah
 */
@Entity
@Table(name = "treatment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treatment.findAll", query = "SELECT t FROM Treatment t"),
    @NamedQuery(name = "Treatment.findByIdtreatment", query = "SELECT t FROM Treatment t WHERE t.idtreatment = :idtreatment"),
    @NamedQuery(name = "Treatment.findBySideeffect", query = "SELECT t FROM Treatment t WHERE t.sideeffect = :sideeffect")})

public class Treatment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtreatment")
    private Integer idtreatment;
    
    @Column(name = "sideeffect")
    private String sideeffect;
    
    private List<Drug> drugList;
    //@OneToMany(mappedBy = "idtreatment")
    
    //private Patient idpatient;
    
    public Treatment(){
        
    }
    
    public Treatment(Integer idtreatment){
        this.idtreatment = idtreatment;
    }
    
    public Integer getIdtreatment(){
        return idtreatment;
    }
    
    public void setIdtreatment(Integer idtreatment) {
        this.idtreatment = idtreatment;
    }
    
    public String getSideeffect(){
        return sideeffect;
    }
    
    public void setSideeffect(String sideeffect) {
        this.sideeffect = sideeffect;
    }
    
    public List<Drug> getDrugList(){
        return drugList;
    }
    
    public void setDrugtList(List<Drug> drugList) {
        this.drugList = drugList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtreatment != null ? idtreatment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.idtreatment == null && other.idtreatment != null) || (this.idtreatment != null && !this.idtreatment.equals(other.idtreatment))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return idtreatment.toString();
    }
}
