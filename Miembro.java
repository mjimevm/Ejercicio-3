public class Miembro{
    private String nombre;
    private int identificacion;
    private Rutina rutina;
    private Entrenador entrenador;
    private String membresia;

    public Miembro(String nombre, int identificacion, Rutina rutina, Entrenador entrenador, String membresia) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.rutina = rutina;
        this.entrenador = entrenador;
        this.membresia = membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }
    public String getMembresia() {
        return membresia;
    }
    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}