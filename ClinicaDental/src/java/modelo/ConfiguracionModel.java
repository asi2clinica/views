/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entity.Configuracion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario1
 */
public class ConfiguracionModel {
    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("ClinicaDentalPU");
    EntityManager em;
    
    public ConfiguracionModel() {
        try{
            em=emf.createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void guardarConfig(Configuracion config){        
        try{
            em.getTransaction().begin();
            
            //para guardar
            em.persist(config);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
