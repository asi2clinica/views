/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import entity.CatPermiso;
import entity.CatTiposRol;
import entity.RolUsuario;
import entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Developer
 */
public class UsuariosModel {

    static EntityManagerFactory emf=Persistence.createEntityManagerFactory("ClinicaDentalPU");
    EntityManager em;
    
    public UsuariosModel() {
        try{
            em=emf.createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //**********************Tipos de Roles de Usuarios*************************************
    
    public void guardarRoleUserType(CatTiposRol catalogoTiposRol){        
        try{
            em.getTransaction().begin();
            em.persist(catalogoTiposRol);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editarRoleUserType(CatTiposRol catalogoTiposRol){        
        try{
            em.getTransaction().begin();
            em.merge(catalogoTiposRol);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminarRoleUserType(CatTiposRol catalogoTiposRol){        
        try{
            em.getTransaction().begin();
            em.remove(catalogoTiposRol);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //**********************Roles de Usuarios*************************************
    
    public void guardarRoleUser(RolUsuario rolUsuario){
        try{
            em.getTransaction().begin();
            em.persist(rolUsuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editarRoleUser(RolUsuario rolUsuario){
        try{
            em.getTransaction().begin();
            em.merge(rolUsuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminarRoleUser(RolUsuario rolUsuario){
        try{
            em.getTransaction().begin();
            em.remove(rolUsuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //**********************Permisos de Usuarios*************************************
    
    public void guardarPermisoUsuario(CatPermiso permiso){
        try{
            em.getTransaction().begin();
            em.persist(permiso);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editarPermisoUsuario(CatPermiso permiso){
        try{
            em.getTransaction().begin();
            em.merge(permiso);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminarPermisoUsuario(CatPermiso permiso){
        try{
            em.getTransaction().begin();
            em.remove(permiso);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //**********************Permisos de Usuarios*************************************
    
    public void guardarUsuario(Usuario usuario){
        try{
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editarUsuario(Usuario usuario){
        try{
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminarUsuario(Usuario usuario){
        try{
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
