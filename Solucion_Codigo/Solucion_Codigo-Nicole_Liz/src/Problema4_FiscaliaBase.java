import java.util.ArrayList;
import java.util.List;

class Persona {
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion; // "acusado", "testigo", "víctima", etc.
    private boolean colaboracion; // Indica si la persona ha decidido colaborar

    public Persona(String nombre, int edad, String ocupacion, String nivelImplicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.colaboracion = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getNivelImplicacion() {
        return nivelImplicacion;
    }

    public boolean isColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(boolean colaboracion) {
        this.colaboracion = colaboracion;
    }

    public String verificarReduccionPena(double sentenciaEnAnios, double danioEconomico) {
        if ("acusado".equalsIgnoreCase(nivelImplicacion)) {
            if (colaboracion) {
                if (sentenciaEnAnios < 1) {
                    double fianza = danioEconomico * 0.5;
                    return "El acusado puede pagar una fianza de $" + fianza + " por colaborar.";
                } else {
                    return "El acusado puede acogerse a reducción de pena por colaborar.";
                }
            }
        }
        return "El acusado no ha colaborado o no aplica para reducción de pena.";
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ocupacion='" + ocupacion + '\'' +
                ", nivelImplicacion='" + nivelImplicacion + '\'' +
                ", colaboracion=" + colaboracion +
                '}';
    }
}

class CasoCorrupcion {
    private String nombre;
    private int fechaInicio; // Número de días desde un punto de referencia fijo
    private String estado; // "Iniciado", "Alerta", "Urgente"
    private String detallesAdicionales;
    private List<Persona> personasImplicadas;

    public CasoCorrupcion(String nombre, int fechaInicio, String detallesAdicionales) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = "Iniciado";
        this.detallesAdicionales = detallesAdicionales;
        this.personasImplicadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }
        public List<Persona> getPersonasImplicadas() {
        return personasImplicadas;
    }

    public void agregarPersonaImplicada(Persona persona) {
        personasImplicadas.add(persona);
    }

    public void actualizarEstado(int diaActual) {
        int diasTranscurridos = diaActual - fechaInicio;
        if (diasTranscurridos > 14) {
            estado = "Urgente";
        } else if (diasTranscurridos > 7) {
            estado = "Alerta";
        } else {
            estado = "Iniciado";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CasoCorrupcion{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", estado='").append(estado).append('\'');
        sb.append(", detallesAdicionales='").append(detallesAdicionales).append('\'');
        sb.append(", personasImplicadas=").append(personasImplicadas);
        sb.append('}');
        return sb.toString();
    }
}
