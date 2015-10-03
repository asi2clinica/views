/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entity.Cita;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Usuario1
 */
public class CitaModel {
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("ClinicaDentalPU");
    EntityManager em;
    
    public CitaModel() {
        try{
            em=emf.createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void guardarCita(Cita cita){        
        try{
            em.getTransaction().begin();
            
            //para guardar
            em.persist(cita);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
