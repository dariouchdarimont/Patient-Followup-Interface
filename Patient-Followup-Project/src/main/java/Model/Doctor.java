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
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByIddoctor", query = "SELECT d FROM Doctor d WHERE d.iddoctor = :iddoctor"),
    @NamedQuery(name = "Doctor.findByIdperson", query = "SELECT d FROM Doctor d WHERE d.idperson = :idperson"),
    @NamedQuery(name = "Doctor.findByInami", query = "SELECT d FROM Doctor d WHERE d.inami = :inami")})

public class Doctor implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Basic(optional = false)
    @Column(name = "inami")
    private String inami;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Person idperson;
    
    public Doctor(){
    }
    
    public Doctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }
    
    public Doctor(Integer iddoctor, String inami) {
        this.iddoctor = iddoctor;
        this.inami = inami;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }
    
    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getInami() {
        return inami;
    }

    public void setInami(String inami) {
        this.inami = inami;
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
        hash += (iddoctor != null ? iddoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.iddoctor == null && other.iddoctor != null) || (this.iddoctor != null && !this.iddoctor.equals(other.iddoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idperson.toString();
    }
}
