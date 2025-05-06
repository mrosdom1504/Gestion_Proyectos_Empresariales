import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        // MENU:
        try {
            int opcion;
            boolean siSigue = true;
            while (siSigue) {
                System.out.println("Bienvenido al Gestor de Proyectos");
                System.out.println("1. Crear Proyecto");
                System.out.println("2. Eliminar Proyecto");
                System.out.println("3. Modificar Proyecto");
                System.out.println("4. Listar Proyectos");
                System.out.println("5. Exportar Proyecto a JSON");
                System.out.println("6. Salir");
                opcion = sc.nextInt();
                sc.nextLine();// Limpiar el buffer
                switch (opcion) {

                    //1. CREAR PROYECTO:
                    case 1:
                        Proyecto.crearProyecto();
                        break;

                    //2. ELIMINAR PROYECTO:
                    case 2:
                        System.out.println("Escriba el nombre del proyecto a eliminar:");
                        String nombreEliminar = sc.nextLine();
                        Proyecto.eliminarProyecto(nombreEliminar);
                        break;

                    //3. MODIFICAR PROYECTO:
                    case 3:
                        System.out.println("Escriba el nombre del proyecto a modificar:");
                        String nombreModificar = sc.nextLine();
                        Proyecto.modificarProyecto(nombreModificar);
                        break;

                    //4. LISTAR PROYECTO:
                    case 4:
                        System.out.println("Lista de Proyectos:");
                        System.out.println(Proyecto.getListaProyectos());
                        break;

                    //5. EXPORTAR PROYECTO A JSON:
                    case 5:
                        System.out.println("Escriba el nombre del proyecto a exportar:");
                        String nombreExportar = sc.nextLine();
                        Proyecto.exportarProyectoAJSON(nombreExportar);
                        break;

                    //6. SALIR DEL PROGRAMA:
                    case 6:
                        System.out.println("Saliendo...");
                        siSigue = false;
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
        }
    }
}