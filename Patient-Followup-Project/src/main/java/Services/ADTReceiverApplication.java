/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Controller.PersonJpaController;
import Model.Person;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.message.ORM_O01;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author alizh
 */
public class ADTReceiverApplication implements ReceivingApplication<Message>{
    Person person = new Person();
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("patientfollowup");
    PersonJpaController personCtrl = new PersonJpaController(emfac);

        /**
       * {@inheritDoc}
      */
        @Override
        public boolean canProcess(Message theIn) {
            return true;
      }
   
        @Override
        public Message processMessage(Message msg, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
          ADT_A01 message = (ADT_A01) msg;
          PID pid = message.getPID(); //recup pid pr avoir acces au different champs 
          Person p = new Person(); //instance de personne et lui donner param qu'on recup ds le message via le pid 
          p.setLastname(pid.getPatientName(0).getFamilyName().getValue());
          p.setFirstname(pid.getPatientName(0).getGivenName().getValue());
          System.out.println("this person= "+ person.getFirstname());
          

          //traiter ack 
          String encodedMessage = new DefaultHapiContext().getPipeParser().encode(msg);
          //
          System.out.println("Received message:\n" + encodedMessage + "\n\n");
        try {
            // Now generate a simple acknowledgment message and return it
            return msg.generateACK(); /**  Person person = new Person();
             * person.setFirstname(msg.getPID().getName());
             * person.setDateofbirth(msg.getPID().getDateOfBirth());
             * PersonJpaController controller = new PersonJpaController(null);
             * List list = controller.findDuplicate();
             * if (person!=list){
             * EntityListModel<Patient> model = new EntityListModel(patients);
             * }**/
            
            /**  Person person = new Person();
             * person.setFirstname(msg.getPID().getName());
             * person.setDateofbirth(msg.getPID().getDateOfBirth());
             * PersonJpaController controller = new PersonJpaController(null);
             * List list = controller.findDuplicate();
             * if (person!=list){
             * EntityListModel<Patient> model = new EntityListModel(patients);
             * }**/
        } catch (IOException ex) {
            Logger.getLogger(ADTReceiverApplication.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
          
        }
        public Person getPerson(){
            System.out.println("this getperson= "+ person.getFirstname());
            return person;
            
        }
   
}
