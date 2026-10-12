package ejercicionotasmedias;
import java.util.Map;
import java.util.HashMap;


public class Alumno {
    private String id;
    private Map<String, Double> notas;

    public Alumno(String id, Map<String, Double> notas) {
        this.id = id;
        this.notas = notas;
    }

    public double calcularMedia() {
        double suma = 0;

        for (double nota : notas.values()) {
            suma += nota;
        }

        return suma / notas.size();
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", notas=" + notas +
                '}';
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    public String getId() {
        return id;
    }
}
