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
import java.util.ArrayList;

public class RegistroNacimiento implements Serializable {

    private static ArrayList<Nacimiento> listaNacimientos;
    
    public RegistroNacimiento() {
        listaNacimientos = new ArrayList();
    }
    
    public void agregarNacimiento(Nacimiento nuevoNacimiento) {
        listaNacimientos.add(nuevoNacimiento);
    }

    public ArrayList<Nacimiento> getListaNacimientos() {
        return listaNacimientos;
    }

    public static void eliminarNacimiento(Nacimiento nacimientoEliminar) {
        listaNacimientos.remove(nacimientoEliminar);
    }

    public static Nacimiento buscarNacimiento(int id) {
        Nacimiento nac=null;
        
        for (Nacimiento temp : listaNacimientos) {
            
            if (temp.getId() == id) {
                nac = temp;
                break;
            }
        }
        return nac;
    }
}
