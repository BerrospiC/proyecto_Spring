/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tarea.Servicio;

import com.example.tarea.Servicio.*;
import com.example.tarea.Entidad.Arquitecto;
import com.example.tarea.Repositorio.ArquitectoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CESAR
 */
@Service
public class ArquitectoServicio {
   @Autowired
     private ArquitectoRepositorio arquitectoRepositorio;
    public List<Arquitecto> listAll(String palabraClave){
       // if(palabraClave !=null){
        //    return arquitectoRepositorio.findAll(palabraClave);
      //  }
        return arquitectoRepositorio.findAll();
        
    }
    
    public void save(Arquitecto arquitecto){
       arquitectoRepositorio.save(arquitecto);
    }
    public Arquitecto get(Long id){
        return arquitectoRepositorio.findById(id).get();
    }
    public void delete(Long id){
        arquitectoRepositorio.deleteById(id);
    }
}
