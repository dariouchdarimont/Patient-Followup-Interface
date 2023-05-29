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
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



//classe pr process le message 
public class ADTReceiverApplication implements ReceivingApplication<Message>{
    

        /**
       * {@inheritDoc}
      */
        @Override
        public boolean canProcess(Message theIn) {
            return true;
      }
   
        @Override
        public Message processMessage(Message msg, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
          //caster le message en adt a01, tt les types de mess hl7 sont des message (big classe)
          ADT_A01 message = (ADT_A01) msg;
          PID pid = message.getPID(); //recup pid pr avoir acces au different champs 
          Person p = new Person(); //instance de personne et lui donner param qu'on recup ds le message via le pid 
          p.setLastname(pid.getPatientName(0).getFamilyName().getName());
          p.setFirstname(pid.getPatientName(0).getGivenName().getValue());
          p.setDateofbirth(pid.getDateTimeOfBirth().getTimeOfAnEvent().getValueAsDate());
          
          
          //Imprimer les données de la personne reçue         
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("patientfollowup");
          PersonJpaController personCtrl = new PersonJpaController(emf);
          
           System.out.println("message patient reçu : " + p.toString());
            


          //traiter ack pr dire qu'on a bien recu et traiter le message 
          String encodedMessage = new DefaultHapiContext().getPipeParser().encode(msg);
          System.out.println("Received message:\n" + encodedMessage + "\n\n");
         // Now generate a simple acknowledgment message and return it
          try {
         	return msg.generateACK();
          } catch (IOException e) {
              throw new HL7Exception(e);
         }
                  
   }
   
}
