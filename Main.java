import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al Sistema de gestión de gimnasio");
        Controlador controlador = new Controlador();
        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Miembro");
            System.out.println("2. Agregar Entrenador");
            System.out.println("3. Agregar Rutina");
            System.out.println("4. Asignar Entrenador");
            System.out.println("5. Asignar Rutina");
            System.out.println("6. Mostrar Datos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nCómo se llama el miembro? ");
                    String nombreMiembro = teclado.next();
                    System.out.print("Cuál es su identificación? ");
                    int identificacionMiembro = teclado.nextInt();
                    for (Miembro miembro : controlador.getMiembros()) {
                        while (miembro.getIdentificacion() == identificacionMiembro) {
                            System.out.println("La identificación ya está en uso.");
                            System.out.print("Cuál es su identificación? ");
                            identificacionMiembro = teclado.nextInt();
                        }
                    }
                    System.out.print("Qué tipo de membresía tiene? (basica o premium): ");
                    String membresiaMiembro = teclado.next().strip().toLowerCase();
                    while (!membresiaMiembro.equals("basica") && !membresiaMiembro.equals("premium")) {
                        System.out.print("Membresía no válida. Ingrese 'basica' o 'premium': ");
                        membresiaMiembro = teclado.next().strip().toLowerCase();
                    }
                    controlador.agregarMiembro(nombreMiembro, identificacionMiembro, null, null, membresiaMiembro);
                    break;
                case 2:
                    System.out.print("\nCómo se llama el entrenador? ");
                    String nombreEntrenador = teclado.next();
                    System.out.print("Cuál es su identificación? ");
                    int identificacionEntrenador = teclado.nextInt();
                    boolean existe = false;
                    for (Entrenador entrenador : controlador.getEntrenadores()) {
                        if (entrenador.getIdentificacion() == identificacionEntrenador) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        controlador.agregarEntrenador(nombreEntrenador, identificacionEntrenador);
                    } else {
                        System.out.println("La identificación ya está en uso.");
                    }
                    break;
                
                case 3:
                    System.out.print("\nCuál es el nombre de la rutina? ");
                    String nombreRutina = teclado.next();
                    System.out.print("Descripcion de la rutina: ");
                    String descripcionRutina = teclado.next();
                    controlador.agregarRutina(nombreRutina, descripcionRutina);
                    break;
                case 4:
                    if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros disponibles.");
                        break;
                    } else if (controlador.getEntrenadores().isEmpty()) {
                        System.out.println("No hay entrenadores disponibles.");
                        break;
                    } else {
                        System.out.print("\nCuál es la identificación del miembro? ");
                        int idMiembro = teclado.nextInt();
                        Miembro miembro = controlador.buscarIdMiembro(idMiembro);
                        if (miembro == null) {
                            System.out.println("Miembro no encontrado.");
                            break;
                    } else if (miembro.getEntrenador() != null) {
                        System.out.println("El miembro ya tiene un entrenador asignado.");
                        break;
                    }
                    System.out.print("¿A cuál entrenador se quiere asignar? ");
                    System.out.println("Entrenadores disponibles:");
                    for (Entrenador entrenador : controlador.getEntrenadores()) {
                        System.out.println("- " + entrenador.getNombre());
                       
                    }   
                    String nombreE = teclado.next();
                    Entrenador entrenador = controlador.buscarNombreEntrenador(nombreE);
                    
                    if (entrenador == null) {
                        System.out.println("Entrenador no encontrado.");
                        break;
                    }
                    controlador.asignarEntrenador(miembro, entrenador);
                    System.out.println("El entrenador se ha asignado exitosamente.");
                    }
                    break;

                case 5:
                    if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros disponibles.");
                        break;
                    } else if (controlador.getRutinas().isEmpty()) {
                        System.out.println("No hay rutinas disponibles.");
                        break;
                    } else {
                        System.out.print("\nCuál es la identificación del miembro? ");
                        int identificacionM = teclado.nextInt();
                        Miembro m = controlador.buscarIdMiembro(identificacionM);
                        if (m == null) {
                            System.out.println("Miembro no encontrado.");
                            break;
                        }
                        if (m.getRutina() != null) {
                            System.out.println("El miembro ya tiene una rutina asignada.");
                            break;
                        }
                        System.out.println("Rutinas disponibles:");
                        for (int i = 1; i <= controlador.getRutinas().size(); i++) {
                            System.out.println(i + ": " + controlador.getRutinas().get(i - 1).getNombre());
                        }
                        System.out.print("¿A cuál rutina se quiere asignar?: ");
                        int opcionRutina = teclado.nextInt();
                        if (opcionRutina < 1 || opcionRutina > controlador.getRutinas().size()) {
                            System.out.println("Opción inválida.");
                            break;
                        }
                        Rutina rutina = controlador.getRutinas().get(opcionRutina-1);
                        if (rutina == null) {
                            System.out.println("Rutina no encontrada.");
                            break;
                        }
                        controlador.asignarRutina(m, rutina);
                        }
                    break;
                case 6:
                    // Miembros:
                    System.out.println("\nMiembros Inscritos:");
                    if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros inscritos.");
                    }
                    else {
                        for (Miembro todoslosmiembros : controlador.getMiembros()) {
                            System.out.println("- " + todoslosmiembros.getNombre() + ", Identificación: " + todoslosmiembros.getIdentificacion() + ", Membresía: " + todoslosmiembros.getMembresia());
                        }
                    }

                    // Entrenadores:
                    System.out.println("\nEntrenadores Disponibles:");

                    if (controlador.getEntrenadores().isEmpty()) {
                        System.out.println("No hay entrenadores disponibles.");
                    } else if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros inscritos.");
                    } else {
                        for (Entrenador entrenador : controlador.getEntrenadores()) {
                            System.out.println("- " + entrenador.getNombre() + ", Identificación: " + entrenador.getIdentificacion());
                        }
                    }

                    // Rutinas 
                    System.out.println("\nRutinas y cantidad de personas inscritas:");
                    if (controlador.getRutinas().isEmpty()) {
                        System.out.println("No hay rutinas disponibles.");
                    }
                    else if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros inscritos.");
                    }
                    else {
                        for (Rutina rutina : controlador.getRutinas()) {
                            if (!rutina.getPersonasInscritas().isEmpty()) {
                                System.out.println("- " + rutina.toString());
                            }
                            else {
                                System.out.println("- " + rutina.toString());
                            }
                        }
                    }

                    // Entrenadores y cantidad de personas asignadas a ellos:
                    System.out.println("\nEntrenadores y cantidad de personas asignadas a ellos: ");
                    if (controlador.getEntrenadores().isEmpty()) {
                        System.out.println("No hay entrenadores disponibles.");
                    }
                    else if (controlador.getMiembros().isEmpty()) {
                        System.out.println("No hay miembros inscritos.");
                    }
                    else {
                        for (Entrenador entrenador : controlador.getEntrenadores()) {
                            if (!entrenador.getAlumnos().isEmpty()) {
                                System.out.println("- " + entrenador.getNombre() + ": Personas Asignadas: " + entrenador.getAlumnos().size());
                            } else {
                                System.out.println("- " + entrenador.getNombre() + ": Personas Asignadas: 0");
                            }
                        }
                    }
                    break;
                case 7: 
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}