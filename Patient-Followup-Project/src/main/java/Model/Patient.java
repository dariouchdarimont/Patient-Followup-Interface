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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sarah
 */

@Entity
@Table(name="Patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdpatient", query = "SELECT p FROM Patient p WHERE p.idpatient = :idpatient"),
    @NamedQuery(name = "Patient.findByIdperson", query = "SELECT p FROM Patient p WHERE p.idperson = :idperson")})

public class Patient implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Idpatient")
    private Integer idpatient;
    @JoinColumn(name = "Idperson", referencedColumnName = "Idpatient")
    @ManyToOne(optional = false)
    
    private Person idperson;
    private List<Treatment> treatmentList;
    
    public Patient() {
    }
    
    public Patient(Integer idpatient) {
        this.idpatient = idpatient;
    }
    
    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }
    
    @XmlTransient
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }
    
    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }
    
    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpatient != null ? idpatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idpatient == null && other.idpatient != null) || (this.idpatient != null && !this.idpatient.equals(other.idpatient))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return idperson.toString();
    }
    
    
    
}
