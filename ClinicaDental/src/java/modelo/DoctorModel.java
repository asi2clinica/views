/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entity.Doctor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario1
 */
public class DoctorModel {
    
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("ClinicaDentalPU");
    EntityManager em;
    
    public DoctorModel() {
        try{
            em=emf.createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void guardarDoctor(Doctor doctor){        
        try{
            em.getTransaction().begin();
            
            //para guardar
            em.persist(doctor);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
