import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Estudiante {
    private String codigo;
    private String nombre;
    private String apellido;
    private String fecha;
    private String correo;
    private float mate;
    private float lenguaje;
    private float quimica;
    private float fisica;
    private float lectura;
    private float estadistica;
    private String sede;

    public Estudiante(String codigo, String nombre, String apellido, String fecha, String correo, float mate, float lenguaje, float quimica, float fisica, float lectura, float estadistica, String sede) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.correo = correo;
        this.mate = mate;
        this.lenguaje = lenguaje;
        this.quimica = quimica;
        this.fisica = fisica;
        this.lectura = lectura;
        this.estadistica = estadistica;
        this.sede = sede;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public float getMate() {
        return mate;
    }

    public float getLenguaje() {
        return lenguaje;
    }

    public float getQuimica() {
        return quimica;
    }

    public float getFisica() {
        return fisica;
    }

    public float getLectura() {
        return lectura;
    }

    public float getEstadistica() {
        return estadistica;
    }

    public String getSede() {
        return sede;
    }
}

class sede {

}

class examenes {

}

class universidad {

}

class Analisis {

    private List<Float> notas;

    public Analisis(List<Float> notas) {
        this.notas = notas;
    }

    public int calcularPromedio() {
        float suma = 0;
        for (float nota : notas) {
            suma += nota;
        }
        return Math.round(suma / notas.size());
    }

    public int calcularMediana() {
        Collections.sort(notas);
        int n = notas.size();
        if (n % 2 == 0) {
            int medio1 = Math.round(notas.get(n / 2 - 1));
            int medio2 = Math.round(notas.get(n / 2));
            return (medio1 + medio2) / 2;
        } else {
            return Math.round(notas.get(n / 2));
        }
    }

    public int calcularModa() {
        Map<Float, Integer> frecuencias = new HashMap<>();
        int moda = 0;
        int maxFrecuencia = 0;

        for (float nota : notas) {
            int frecuencia = frecuencias.getOrDefault(nota, 0) + 1;
            frecuencias.put(nota, frecuencia);
            if (frecuencia > maxFrecuencia) {
                moda = Math.round(nota);
                maxFrecuencia = frecuencia;
            }
        }

        return moda;
    }

    public int calcularDesviacionEstandar() {
        float sumaDiferenciasCuadradas = 0;
        float promedio = calcularPromedio();
        for (float nota : notas) {
            sumaDiferenciasCuadradas += Math.pow(nota - promedio, 2);
        }
        double desviacion = Math.sqrt(sumaDiferenciasCuadradas / notas.size());
        return (int) Math.round(desviacion);
    }

    public int obtenerNotaMasAlta() {
        return Math.round(Collections.max(notas));
    }

    public int obtenerNotaMasBaja() {
        return Math.round(Collections.min(notas));
    }
    

}

class Guardar {
    String archivo = "bd.csv";

    public void guardarEstudiante(Estudiante estudiante) {
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append(estudiante.getCodigo());
            insertar.append(",");
            insertar.append(estudiante.getNombre());
            insertar.append(",");
            insertar.append(estudiante.getApellido());
            insertar.append(",");
            insertar.append(estudiante.getFecha());
            insertar.append(",");
            insertar.append(estudiante.getCorreo());
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getMate()));
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getLenguaje()));
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getQuimica()));
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getFisica()));
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getLectura()));
            insertar.append(",");
            insertar.append(String.valueOf(estudiante.getEstadistica()));
            insertar.append(",");
            insertar.append(estudiante.getSede());
            insertar.append(",");
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("Datos del estudiante guardados en el archivo CSV exitosamente.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }
}

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Para ingresar un nuevo estudiante, proporciona la siguiente información: \n");
        System.out.print("Codigo: ");
        String codigo = leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Fecha de nacimiento: ");
        String fecha = leer.nextLine();
        System.out.print("Correo: ");
        String correo = leer.nextLine();
        System.out.print("Nota de matematicas: ");
        float mate = Float.parseFloat(leer.nextLine());
        System.out.print("Nota de lenguaje: ");
        float lenguaje = Float.parseFloat(leer.nextLine());
        System.out.print("Nota de quimica: ");
        float quimica = Float.parseFloat(leer.nextLine());
        System.out.print("Nota de fisica: ");
        float fisica = Float.parseFloat(leer.nextLine());
        System.out.print("Nota de lectura: ");
        float lectura = Float.parseFloat(leer.nextLine());
        System.out.print("Nota de estadistica: ");
        float estadistica = Float.parseFloat(leer.nextLine());
        System.out.print("Sede en la que se evaluo: ");
        String sede = leer.nextLine();
        leer.close();

        Estudiante estudiante = new Estudiante(codigo, nombre, apellido, fecha, correo, mate, lenguaje, quimica, fisica, lectura, estadistica, sede);
        Guardar guardar = new Guardar();
        guardar.guardarEstudiante(estudiante);

        List<Float> notas = new ArrayList<>();
        notas.add(85.5f);
        notas.add(90.0f);
        notas.add(78.5f);
        notas.add(92.0f);
        notas.add(88.5f);

        Analisis analisis = new Analisis(notas);

        int promedio = analisis.calcularPromedio();
        int mediana = analisis.calcularMediana();
        int moda = analisis.calcularModa();
        int desviacion = analisis.calcularDesviacionEstandar();
        int alta = analisis.obtenerNotaMasAlta();
        int baja = analisis.obtenerNotaMasBaja();

        System.out.println("Promedio: " + promedio);
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " + moda);
        System.out.println("Desviación Estándar: " + desviacion);
        System.out.println("Nota Más Alta: " + alta);
        System.out.println("Nota Más Baja: " + baja);
    }
    }

