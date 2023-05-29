/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.exceptions.NonexistentEntityException;
import Model.Patient;
import Model.Person;
import Model.Treatment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    public Patient findByIdperson(Person p) { //je cherche un patient avec une personne (avec son id)
        EntityManager em = getEntityManager();
        List<Patient> res = em.createNamedQuery("Patient.findByIdperson").setParameter("idperson", p.getIdperson()).getResultList(); //liste de patient avec cet idperson
        if (res.isEmpty()) {
            return null;
        }
        return res.get(0); //renvoie 1er pers de la liste si duplicata 
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
    public void edit(Patient patient) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            patient = em.merge(patient);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = patient.getIdpatient();
                if (findPatient(id) == null) {
                    throw new NonexistentEntityException("The treatment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patient patient;
            try {
                patient = em.getReference(Patient.class, id);
                patient.getIdpatient();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The treatment with id " + id + " no longer exists.", enfe);
            }
            em.remove(patient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private Object findPatient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }
    public List<Patient> findPatientEntities() {
        return findPatientEntities(true, -1, -1);
    }

    public List<Patient> findPatientEntities(int maxResults, int firstResult) {
        return findPatientEntities(false, maxResults, firstResult);
    }
    
    private List<Patient> findPatientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Treatment.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public int getTreatmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Patient> rt = cq.from(Patient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
