import java.util.ArrayList;
import java.util.List;
class Departamento {
    private String nombre;
    private int numeroEmpleados;
    private double produccionAnual;
    private String categoria;

    public Departamento(String nombre, int numeroEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numeroEmpleados = numeroEmpleados;
        this.produccionAnual = produccionAnual;
        this.categoria = determinarCategoria();
    }

    private String determinarCategoria() {
        if (numeroEmpleados > 20 && produccionAnual > 1000000) {
            return "A";
        } else if (numeroEmpleados >= 20 && produccionAnual >= 1000000) {
            return "B";
        } else if (numeroEmpleados >= 10 && produccionAnual >= 500000) {
            return "C";
        } else {
            return "No CategorÃa";
        }
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", numeroEmpleados=" + numeroEmpleados +
                ", produccionAnual=" + produccionAnual +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public double getProduccionAnual() {
        return produccionAnual;
    }

    public String getCategoria() {
        return categoria;
    }
}

class Empresa {
    private String nombre;
    private String ruc;
    private String direccion;
    private List<Departamento> departamentos;

    public Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void mostrarDepartamentos() {
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
