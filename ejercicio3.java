import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class estudiante {
    Scanner leer = new Scanner(System.in);
    System.out.print("Para ingresar un nuevo estudiante de la siguiente informacion ");
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

    public estudiante(String codigo, String nombre, String apellido, String fecha, String correo, float mate, float lenguaje, float quimica, float fisica, float lectura, float estadistica, String sede) {
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
    }

class sede {

}

class examenes {

}

class universidad {

}

class analisis {

}

class guardar {
    String archivo = "bd.csv";
    public static void guardare(String archivo, estudiante estudiante) {
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append(estudiante.getcodigo());
            insertar.append(",");
            insertar.append(estudiante.getnombre());
            insertar.append(",");
            insertar.append(estudiante.getapellido());
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
   
}
