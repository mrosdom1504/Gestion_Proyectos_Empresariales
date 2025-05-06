import java.time.LocalDate;

public class Trabajadores {
    protected String nombre;

    protected String apellido;

    protected String DNI;

    protected int edad;

    protected String Direccion;

    protected LocalDate fecha_Ingreso;

    protected int sueldo_base;

    public Trabajadores(String nombre, String apellido, String dni, int edad, String direccion, LocalDate fechaIngreso, int sueldoBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        DNI = dni;
        this.edad = edad;
        Direccion = direccion;
        fecha_Ingreso = fechaIngreso;
        sueldo_base = sueldoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public LocalDate getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public void setFecha_Ingreso(LocalDate fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }

    public int getSueldo_base() {
        return sueldo_base;
    }

    public void setSueldo_base(int sueldo_base) {
        this.sueldo_base = sueldo_base;
    }

    @Override
    public String toString() {
        return "Trabajadores{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", Edad=" + edad +
                ", Direccion='" + Direccion + '\'' +
                ", Fecha Ingreso=" + fecha_Ingreso +
                ", Sueldo base=" + sueldo_base +
                '}';
    }
}
