import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Proyecto {
    static Scanner sc = new Scanner(System.in);
    private String nombre;

    private String descripcion;

    private List<Empleado> lista_personas;

    private String estado_proyecto;

    private LocalDate fecha_inicio;

    private LocalDate fecha_fin;

    private static List<Proyecto> listaProyectos = new ArrayList<>();

    public Proyecto(String nombre, String descripcion, List<Empleado> lista_personas, String estado_proyecto, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lista_personas = lista_personas;
        this.estado_proyecto = estado_proyecto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        listaProyectos.add(this);
    }

    public static Proyecto crearProyecto() {
        System.out.println("Ingrese el nombre del proyecto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la descripcion del proyecto:");
        String descripcion = sc.nextLine();
        List<Empleado> lista_personas = Empleado.listasTrabajadores();
        System.out.println("Ingrese el estado del proyecto:");
        String estado_proyecto = sc.nextLine();
        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD):");
        LocalDate fecha_inicio = LocalDate.parse(sc.nextLine());
        System.out.println("Ingrese la fecha de fin (YYYY-MM-DD):");
        LocalDate fecha_fin = LocalDate.parse(sc.nextLine());
        return new Proyecto(nombre, descripcion, lista_personas, estado_proyecto, fecha_inicio, fecha_fin);
    }

    public static void eliminarProyecto(String nombreEliminar) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombreEliminar)) {
                listaProyectos.remove(proyecto);
                System.out.println("Proyecto eliminado: " + nombreEliminar);
                return;
            }
        }
        System.out.println("Proyecto no encontrado: " + nombreEliminar);
    }

    public static void modificarProyecto(String nombreModificar) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombreModificar)) {
                System.out.println("Ingrese el nuevo nombre del proyecto:");
                String nuevoNombre = sc.nextLine();
                proyecto.setNombre(nuevoNombre);
                System.out.println("Ingrese la nueva descripcion del proyecto:");
                String nuevaDescripcion = sc.nextLine();
                proyecto.setDescripcion(nuevaDescripcion);
                proyecto.setLista_personas(Empleado.listasTrabajadores());
                System.out.println("Ingrese el nuevo estado del proyecto:");
                String nuevoEstado = sc.nextLine();
                proyecto.setEstado_proyecto(nuevoEstado);
                System.out.println("Ingrese la nueva fecha de inicio (YYYY-MM-DD):");
                LocalDate nuevaFechaInicio = LocalDate.parse(sc.nextLine());
                proyecto.setFecha_inicio(nuevaFechaInicio);
                System.out.println("Ingrese la nueva fecha de fin (YYYY-MM-DD):");
                LocalDate nuevaFechaFin = LocalDate.parse(sc.nextLine());
                proyecto.setFecha_fin(nuevaFechaFin);
                System.out.println("Proyecto modificado: " + nombreModificar);
                return;
            }
        }
        System.out.println("PROYECTO NO ENCONTRADO: " + nombreModificar);
        System.out.println();
    }

    public static void exportarProyectoAJSON(String nombreProyecto) throws IOException {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombreProyecto)) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.enable(SerializationFeature.INDENT_OUTPUT);

                mapper.writeValue(new File("C:\\Users\\Manuel\\Desktop\\Gestion_De_Trabajo_Empresariales\\Gestion_Proyectos\\ProyectoExportados\\" + nombreProyecto + ".json"), listaProyectos);
                System.out.println("Proyecto exportado a JSON: " + nombreProyecto);
                System.out.println("Exportando proyecto: " + nombreProyecto);
                return;
            }
        }
        System.out.println("Proyecto no encontrado: " + nombreProyecto);
    }

    public static List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public static void setListaProyectos(List<Proyecto> listaProyectos) {
        Proyecto.listaProyectos = listaProyectos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Empleado> getLista_personas() {
        return lista_personas;
    }

    public void setLista_personas(List<Empleado> lista_personas) {
        this.lista_personas = lista_personas;
    }

    public String getEstado_proyecto() {
        return estado_proyecto;
    }

    public void setEstado_proyecto(String estado_proyecto) {
        this.estado_proyecto = estado_proyecto;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", lista_personas=" + lista_personas +
                ", estado_proyecto='" + estado_proyecto + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                '}';
    }
}
