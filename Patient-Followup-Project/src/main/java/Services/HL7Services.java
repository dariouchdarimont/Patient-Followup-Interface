/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Model.Person;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionListener;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author alizh
 */
public class HL7Services {
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("patientfollowup");
    ReceivingApplication<Message> handler;
    
   public ADT_A01 CreateMessage(Person person){
       ADT_A01 adt = null; 
       try {
           adt = new ADT_A01();
           adt.initQuickstart("ADT", "A01", "P"); //segment obligatoire
           // Populate the MSH Segment
           MSH mshSegment = adt.getMSH();
           mshSegment.getSendingApplication().getNamespaceID().setValue("patientfollowup");
           mshSegment.getSequenceNumber().setValue("123"); //id le message qu'on envoie 
           
           // Populate the PID Segment
           PID pid = adt.getPID();
           pid.getPatientName(0).getFamilyName().setValue(person.getFirstname());
           pid.getPatientName(0).getGivenName().setValue(person.getLastname());
       } catch (HL7Exception | IOException ex) { //exceptions liées à hl7
           Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
       }
   
       return adt; //renvoyé le message 
   }
    
   
   public void SendMessage(ADT_A01 adt, String host, int port){ //recup host et port depuis l'interface 
       try {
           //creer connexion vers receiving app (panel) 
           //creer context hapi 
           HapiContext context = new DefaultHapiContext();
           Connection connection = context.newClient(host, port, false);
           
           //initier la connexion 
           // The initiator is used to transmit unsolicited messages
           Initiator initiator = connection.getInitiator();
           try {
               //envoyer le mess et recup la rep
               Message response = initiator.sendAndReceive(adt);
               Parser p = context.getPipeParser(); //afficher la reponse ds le terminal 
               System.out.println(p.encode(response)); //avec encode on recup le string qu'on peut print 
           } catch (LLPException | IOException ex) {
               Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
           }
       } catch (HL7Exception ex) {
           Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }

   //meth pr demarer le serveur 
    public void startServeur() {
       try {
           int port = 50116; // The port to listen on, peu importe tant qu'on l'utilise pas pr autre chose 
           boolean useTls = false; // Should we use TLS/SSL?
           //Creer hapi context et une instance du hl7service 
           HapiContext context = new DefaultHapiContext();
           HL7Service server = context.newServer(port, useTls);
           
           //handler pr process le message 
           ReceivingApplication<Message> handler = new ADTReceiverApplication();
           server.registerApplication("ADT", "A01", handler);
           
           server.registerApplication("ADT", "A02", handler);
           server.registerConnectionListener(new MyConnectionListener());
           
           server.startAndWait();
       } catch (InterruptedException ex) {
           Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   public static class MyConnectionListener implements ConnectionListener {
 
       @Override
       public void connectionReceived(Connection theC) {
          System.out.println("New connection received: " + theC.getRemoteAddress().toString());
       }
 
       @Override
      public void connectionDiscarded(Connection theC) {
          System.out.println("Lost connection from: " + theC.getRemoteAddress().toString());
       }
 
   }
 
   
}
