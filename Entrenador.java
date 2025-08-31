
import java.util.ArrayList;
import java.util.List;

public class Entrenador{
    private String nombre;
    private int identificacion;
    private ArrayList<Miembro> alumnos;

    public Entrenador(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public List<Miembro> getAlumnos() {
        return alumnos;
    }
}