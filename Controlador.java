import java.util.ArrayList;


public class Controlador{
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Miembro> miembros;
    private ArrayList<Rutina> rutinas;

    public Controlador() {
        entrenadores = new ArrayList<>();
        miembros = new ArrayList<>();
        rutinas = new ArrayList<>();
    }

    public String agregarMiembro(String nombre, int identificacion, Rutina rutina, Entrenador entrenador, String membresia) {
        Miembro nuevoMiembro = new Miembro(nombre, identificacion, rutina, entrenador, membresia);
        miembros.add(nuevoMiembro);
        return "Miembro agregado correctamente.";
    }

    public String agregarEntrenador(String nombre, int identificacion) {
        Entrenador nuevoEntrenador = new Entrenador(nombre, identificacion);
        entrenadores.add(nuevoEntrenador);
        return "Entrenador agregado correctamente.";
    }

    public String agregarRutina(String nombre, String descripcion) {
        Rutina nuevaRutina = new Rutina(nombre, descripcion);
        rutinas.add(nuevaRutina);
        return "Rutina agregada correctamente.";
    }
    public String asignarRutina(Miembro miembro, Rutina rutina) {
        if (miembro != null && rutina != null) {
            miembro.setRutina(rutina);
            rutina.getPersonasInscritas().add(miembro);
            return "Rutina asignada correctamente.";
        }
        return "Error al asignar rutina.";
    }
    public String asignarEntrenador(Miembro miembro, Entrenador entrenador) {
        if (miembro != null && entrenador != null) {
            miembro.setEntrenador(entrenador);
            entrenador.getAlumnos().add(miembro);
            return "Entrenador asignado correctamente.";
        }
        return "Error al asignar entrenador.";
    }

    public Rutina buscarRutina(String nombre) {
    for (Rutina rutina : rutinas) {
        if (rutina.getNombre().equalsIgnoreCase(nombre)) {
            return rutina;
        }
    }
    return null;
    }

    public Miembro buscarIdMiembro(int id) {
    for (Miembro miembro : miembros) {
        if (miembro.getIdentificacion() == id) {
            return miembro;
            }
        }
    return null;
    }

    public Entrenador buscarNombreEntrenador (String nombre) {
    for (Entrenador entrenador : entrenadores) {
        if (entrenador.getNombre().equalsIgnoreCase(nombre)) {
            return entrenador;
        }
    }
    return null;
    }



    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }
}