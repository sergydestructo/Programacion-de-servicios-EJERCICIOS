package ejercicionotasmedias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorNotas {



    public LectorNotas() {

    };

    public List<Alumno> cargarAlumnos(Path directorio) throws IOException {
        List<Alumno> alumnos = new ArrayList<>();

        try (var carpetas = Files.list(directorio)) {
            var iterador = carpetas.iterator();

            while (iterador.hasNext()) {
                Path carpeta = iterador.next();

                if (Files.isDirectory(carpeta)) {
                    Path archivoNotas = carpeta.resolve("notas.txt");

                    Map<String, Double> notas = leerNotas(archivoNotas);

                    String id = carpeta.getFileName().toString();

                    Alumno alumno = new Alumno(id, notas);
                    alumnos.add(alumno);
                }
            }
        }

        return alumnos;
    }

    public Map<String, Double> leerNotas(Path archivo) throws IOException {
        Map<String, Double> notasLeidas = new HashMap();

        List<String> lineas = Files.readAllLines(archivo);

        for (String linea : lineas) {
            String[] partes = linea.trim().split("\\s+");

            String asignatura = "";

            for (int i = 0; i < partes.length - 1; i++) {
                if (i > 0) {
                    asignatura += " ";
                }

                asignatura += partes[i];
            }

            double nota = Double.parseDouble(partes[partes.length - 1]);

            notasLeidas.put(asignatura, nota);
        }

        return notasLeidas;
    }
}
