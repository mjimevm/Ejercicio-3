import java.util.ArrayList;

public class Rutina{
    private String nombre;
    private String descripcion;
    private ArrayList<Miembro> personasInscritas;

    public Rutina(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personasInscritas = new ArrayList<>();
    }
    public ArrayList<Miembro> getPersonasInscritas() {
        return personasInscritas;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Rutina: " +
                "nombre: '" + nombre + '\'' +
                ", descripcion: '" + descripcion + '\'' +
                ", personas inscritas: " + personasInscritas.size();
    }
}