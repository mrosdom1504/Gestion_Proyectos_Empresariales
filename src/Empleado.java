import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleado extends Trabajadores {
    static Scanner sc = new Scanner(System.in);
    private String cargo;
    private String puesto_trabajo;

    public Empleado(String cargo, String puesto_trabajo, String nombre, String apellido, String dni, int edad, String direccion, LocalDate fechaIngreso, int sueldoBase) {
        super(nombre, apellido, dni, edad, direccion, fechaIngreso, sueldoBase);
        this.cargo = cargo;
        this.puesto_trabajo = puesto_trabajo;
    }
    public static List<Empleado> listasTrabajadores() {
        List<Empleado> empleados = new ArrayList<>();
        System.out.println("¿Cuantos trabajadores desea ingresar?");
        int contador = sc.nextInt();
        sc.nextLine();
        while (contador > 0) {
            contador--;
            System.out.println("Ingrese el nombre del trabajador:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el apellido del trabajador:");
            String apellido = sc.nextLine();
            System.out.println("Ingrese el DNI del trabajador:");
            String dni = sc.nextLine();
            System.out.println("Ingrese la edad del trabajador:");
            int edad = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            System.out.println("Ingrese la direccion del trabajador:");
            String direccion = sc.nextLine();
            System.out.println("Ingrese la fecha de ingreso del trabajador (YYYY-MM-DD):");
            LocalDate fechaIngresoStr = LocalDate.parse(sc.next());
            System.out.println("Ingrese el sueldo base del trabajador:");
            int sueldoBase = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            System.out.println("Ingrese el cargo del trabajador:");
            String cargo = sc.nextLine();
            System.out.println("Ingrese el puesto de trabajo del trabajador:");
            String puesto_trabajo = sc.nextLine();
            empleados.add(new Empleado(cargo, puesto_trabajo, nombre, apellido, dni, edad, direccion, fechaIngresoStr, sueldoBase));
        }
        return empleados;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(String puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cargo='" + cargo + '\'' +
                ", puesto_trabajo='" + puesto_trabajo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", edad=" + edad +
                ", Direccion='" + Direccion + '\'' +
                ", fecha_Ingreso=" + fecha_Ingreso +
                ", sueldo_base=" + sueldo_base +
                '}';
    }
}