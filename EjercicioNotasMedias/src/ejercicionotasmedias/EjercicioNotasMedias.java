/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicionotasmedias;


import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioNotasMedias {

    public static void main(String[] args) {
        LectorNotas lector = new LectorNotas();
        Map<String, Double> sumaNotas = new HashMap<>();
        Map<String, Integer> cantidadAlumnos = new HashMap<>();


        try {
            List<Alumno> alumnos = lector.cargarAlumnos(Path.of("notasAlumnos"));

            for (Alumno alumno : alumnos) {
                System.out.println("NOTA MEDIA DEL ALUMNO: " + alumno.getId());
                System.out.println(alumno.calcularMedia());

                System.out.println("");

                for (Map.Entry<String,Double> nota : alumno.getNotas().entrySet()) {
                    String modulo = nota.getKey();
                    double valor = nota.getValue();

                    sumaNotas.put(modulo, sumaNotas.getOrDefault(modulo, 0.0) + valor);

                    cantidadAlumnos.put(modulo, cantidadAlumnos.getOrDefault(modulo, 0) + 1);
                };

            }

            System.out.println("NOTA MEDIA DE LA CLASE POR MODULO: ");

            for (String modulo : sumaNotas.keySet()) {
                double media = sumaNotas.get(modulo) / cantidadAlumnos.get(modulo);
                System.out.println(modulo + ": " + media);
            }
        } catch (IOException e) {
            System.out.println("Error al leer los archivos");
        }

        

    }
    
}
