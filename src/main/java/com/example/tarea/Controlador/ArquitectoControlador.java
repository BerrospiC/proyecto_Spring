/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tarea.Controlador;

import com.example.tarea.Controlador.*;
import com.example.tarea.Entidad.Arquitecto;
import com.example.tarea.Servicio.ArquitectoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArquitectoControlador {
   @Autowired
   private ArquitectoServicio arquitectoServicio;
   
   @RequestMapping("/")
    public String verPaginaDeInicio(Model modelo,@Param("palabraClave")String palabraClave){
        
        List<Arquitecto> listaArquitecto=arquitectoServicio.listAll(palabraClave);
        
        modelo.addAttribute("listaArquitecto",listaArquitecto);
        modelo.addAttribute("palabraClave",palabraClave);
        
        return "index";
        
         }
    
        @RequestMapping("/nuevo")
        public String MostrarFormulariodeMostrarArquitecto(Model modelo){
        Arquitecto arquitecto = new Arquitecto();
        modelo.addAttribute("arquitecto",arquitecto);
        return "nuevo_arquitecto";
   
}
        
        @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String GuardarProducto(@ModelAttribute("producto")Arquitecto arquitecto){
        arquitectoServicio.save(arquitecto);
        return "redirect:/";
    }
    
}



