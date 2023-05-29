/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Doctor;
import Model.Patient;
import Model.Person;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author dardar2000
 */
public class PersonJpaController implements Serializable{
    
        public PersonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Patient getPatient(Person person){  
        Patient patient = findPatientByIdPerson(person);
        return patient;
    }
    
    
        public Person findByEmailadress(Person p){
        EntityManager em = getEntityManager();
        List<Person> res = em.createNamedQuery("Person.findByEmailadress").setParameter("emailadress", p.getEmailadress()).getResultList(); //liste de personne
        if (res.isEmpty())
            return null;
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
        }
        
        public Doctor isDoctor(Person p){
        EntityManager em = getEntityManager();
        List<Doctor> res = em.createNamedQuery("Doctor.findByEmailadress").setParameter("emailadress", p.getEmailadress()).getResultList(); //liste de personne
        if (res.isEmpty()){
            System.out.println("je retourne null");
            return null;
        }
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
        }
        public Patient isPatient(Person p){
        EntityManager em = getEntityManager();
        List<Patient> res = em.createNamedQuery("Patient.findByEmailadress").setParameter("idperson", p.getIdperson()).getResultList(); //liste de personne
        if (res.isEmpty())
            return null;
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
        }

    private Person findByIdPerson(Person p) {
        EntityManager em = getEntityManager();
        List<Person> res = em.createNamedQuery("Person.findByIdperson").setParameter("idperson", p.getIdperson()).getResultList(); //liste de personne
        if (res.isEmpty())
            return null;
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
    }
    
    private Patient findPatientByIdPerson(Person p) {
        EntityManager em = getEntityManager();
        List<Patient> res = em.createNamedQuery("Patient.findByIdPerson").setParameter("idperson", p.getIdperson()).getResultList(); //liste de personne
        if (res.isEmpty())
            return null;
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
    }

    public List findPersonEntities() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
