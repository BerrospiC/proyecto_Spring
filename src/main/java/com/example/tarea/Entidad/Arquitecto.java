/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tarea.Entidad;

import com.example.tarea.Entidad.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arquitecto {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @Column(nullable=false,length=60)
    private String nombres;
    @Column(nullable=false,length=60)
    private String condicion;
    @Column(nullable=false,length=60)
    private String especialidad;
    @Column(nullable=false,length=60)
    private String tipo;
    @Column(nullable=false)
    private int num_obras;

    public Arquitecto(Long id, String nombres, String condicion, String especialidad, String tipo, int num_obras) {
        this.id = id;
        this.nombres = nombres;
        this.condicion = condicion;
        this.especialidad = especialidad;
        this.tipo = tipo;
        this.num_obras = num_obras;
    }

    public Arquitecto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNum_obras() {
        return num_obras;
    }

    public void setNum_obras(int num_obras) {
        this.num_obras = num_obras;
    }
    
        public double SueldoBase(){
            double sb = 0;
            if(condicion.equals("Estable") && tipo.equals("Obras")){
                sb=4000;
            }
             if(condicion.equals("Estable") && tipo.equals("Vias")){
                sb=6000;
            }

            return sb;
        }

        public double SueldoBase2(){
            double sb=0;

            switch (condicion){
                case"Estable": 
                    if(tipo.equals("Obras")){
                        sb=4000;
                    }
                    else if(tipo.equals("Vias")){
                        sb=6000;
                    };break;
                case"Contratado": 
                    if(tipo.equals("Obras")){
                        sb=2000;
                    }
                    else if(tipo.equals("Vias")){
                        sb=4500;
                    };break;
            }

            return sb;
        }

        public double Bonificacion(){
            double bn=0;

            switch(especialidad){
                case"Estructuras":
                    bn=SueldoBase2()*0.16;break;

                case"Recursos Hidricos":
                    bn=SueldoBase2()*0.18;break;

                case"Ingenieria Vial":
                    bn=SueldoBase2()*0.22;break;
            }

            return bn;

        }

        public double Movilidad(){
           double mv=0;

           if(num_obras<=17){
               mv=300;
           }else{
               mv=600;
           }

           return mv;

        }
        public double SueldoBruto(){
           double sn=0;
           sn=SueldoBase2()+Bonificacion()+Movilidad();

           return sn;
        }
        
        public double Descuento(){
            return AFP()+SNP();
        }
        public double AFP(){
            double afp=0;



            return afp=SueldoBruto()*0.15;
        }

        public double SNP(){
            double snp=0;
            return snp=SueldoBruto()*0.08;

    }
   public double SueldoNeto(){
       double sn=0;
       return sn=SueldoBruto()-AFP()-SNP();
   }  

    @Override
    public String toString() {
        return "Arquitecto{" + "id=" + id + ", nombres=" + nombres + ", condicion=" + condicion + ", especialidad=" + especialidad + ", tipo=" + tipo + ", num_obras=" + num_obras + '}';
    }

    
    
}
