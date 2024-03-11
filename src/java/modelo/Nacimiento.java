/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 696
 */
import java.io.Serializable;
import java.util.Date;

public class Nacimiento implements Serializable{
    private int id;
    private String nombre;
    private int peso;
   
    private boolean prematuro;
    private char sexo='F';
    private Date fechaNacimiento;
    private int centro=0;

    public Nacimiento() {
    }

    public Nacimiento(int id, String nombre, int peso, boolean prematuro, char sexo, Date fechaNacimiento, int centro) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        
        this.prematuro = prematuro;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.centro = centro;
    }

    public Nacimiento(int id, String nombre, int peso, String prematuro, String sexo, String fechaNacimiento, int centro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    

    public boolean isPrematuro() {
        return prematuro;
    }

    public void setPrematuro(boolean prematuro) {
        this.prematuro = prematuro;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
  
    public int getCentro() {
        return centro;
    }

    public void setCentro(int centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "Nacimiento{" + "id=" + id + ", nombre=" + nombre + ", peso=" + peso + ", prematuro=" + prematuro + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", centro=" + centro + '}';
    }


}
