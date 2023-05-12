/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Patient;
import Model.Person;
import Model.Treatment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author sarah
 */
public class PatientJpaController implements Serializable {

    private final EntityManagerFactory emf;
    
    public PatientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Patient patient){
        if(patient.getTreatmentList()==null){
            patient.setTreatmentList(new ArrayList<Treatment>());
        }
        EntityManager em = null;
         try {
            em = getEntityManager();
            em.getTransaction().begin();
            Person idperson = patient.getIdperson();
            if (idperson != null) {
                idperson = em.getReference(idperson.getClass(), idperson.getIdperson());
                patient.setIdperson(idperson);
            }
            List<Treatment> attachedTreatmentList = new ArrayList<Treatment>();
            for (Treatment treatmentListTreatmentToAttach : patient.getTreatmentList()) {
                treatmentListTreatmentToAttach = em.getReference(treatmentListTreatmentToAttach.getClass(), treatmentListTreatmentToAttach.getIdtreatment());
                attachedTreatmentList.add(treatmentListTreatmentToAttach);
            }
            patient.setTreatmentList(attachedTreatmentList);
            em.persist(patient);
            if (idperson != null) {
                idperson.getPatientList().add(patient);
                idperson = em.merge(idperson);
            }
            
            // a compléter
            
            em.getTransaction().commit();
            } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
