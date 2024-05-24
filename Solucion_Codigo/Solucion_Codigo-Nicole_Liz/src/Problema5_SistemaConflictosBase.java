import java.util.ArrayList;
import java.util.List;

 class Evento {
    private String nombre;
    private int fecha; // NÃºmero de dÃ­as desde un punto de referencia fijo
    private String ubicacion;
    private String descripcion;
    private String tipo; // "batalla", "tratado de paz", "reuniÃ³n diplomÃ¡tica", etc.
    private boolean usoArmasNucleares;
    private int bajas;

    public Evento(String nombre, int fecha, String ubicacion, String descripcion, String tipo, boolean usoArmasNucleares, int bajas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.usoArmasNucleares = usoArmasNucleares;
        this.bajas = bajas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isUsoArmasNucleares() {
        return usoArmasNucleares;
    }

    public int getBajas() {
        return bajas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", ubicacion='" + ubicacion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", usoArmasNucleares=" + usoArmasNucleares +
                ", bajas=" + bajas +
                '}';
    }
}

class Conflicto {
    private String nombre;
    private List<String> paisesInvolucrados;
    private int fechaInicio; // NÃºmero de dÃ­as desde un punto de referencia fijo
    private String estado; // "Activo", "En paz", "Guerra mundial"
    private String detallesAdicionales;
    private List<Evento> eventos;
    private static final int TOTAL_PAISES = 195; // NÃºmero total de paÃ­ses en el mundo
    private List<String> paisesDesarrollados; // Lista de paÃ­ses desarrollados

    public Conflicto(String nombre, int fechaInicio, String detallesAdicionales, List<String> paisesInvolucrados) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = "Activo";
        this.detallesAdicionales = detallesAdicionales;
        this.paisesInvolucrados = paisesInvolucrados;
        this.eventos = new ArrayList<>();
        this.paisesDesarrollados = List.of("EE.UU.", "Reino Unido", "Alemania", "Francia", "JapÃ³n", "CanadÃ¡", "Italia"); // Ejemplo de paÃ­ses desarrollados
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

    public List<String> getPaisesInvolucrados() {
        return paisesInvolucrados;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        evaluarEstadoConflicto();
    }

    private void evaluarEstadoConflicto() {
        int numeroPaisesBatalla = 0;
        int numeroPaisesDesarrolladosBatalla = 0;
        for (Evento evento : eventos) {
            if (evento.getTipo().equalsIgnoreCase("batalla")) {
                numeroPaisesBatalla++;
                if (paisesDesarrollados.contains(evento.getUbicacion()) && evento.isUsoArmasNucleares()) {
                    estado = "Guerra mundial";
                    return;
                }
                if (paisesDesarrollados.contains(evento.getUbicacion())) {
                    numeroPaisesDesarrolladosBatalla++;
                }
                if (evento.getBajas() >= (50 / 100.0) * obtenerPoblacionPais(evento.getUbicacion())) {
                    convocarReunionUrgenteONU();
                }
            }
        }
        if (numeroPaisesBatalla > (0.5 * TOTAL_PAISES)) {
            estado = "Guerra mundial";
        } else if (numeroPaisesBatalla >= (0.3 * TOTAL_PAISES) && numeroPaisesBatalla <= (0.5 * TOTAL_PAISES)) {
            convocarReunionUrgenteONU();
        }
    }

    private void convocarReunionUrgenteONU() {
        System.out.println("Convocatoria urgente a la ONU por eventos de batalla.");
    }

    private int obtenerPoblacionPais(String pais) {
        // Supongamos un mÃ©todo que devuelve la poblaciÃ³n de un paÃ­s
        // Por simplicidad, se retorna un valor ficticio. En una implementaciÃ³n real, se consultarÃ­a una base de datos o servicio externo.
        return 10000000; // Ejemplo de poblaciÃ³n
    }

    @Override
    public String toString() {
        return "Conflicto{" +
                "nombre='" + nombre + '\'' +
                ", paisesInvolucrados=" + paisesInvolucrados +
                ", fechaInicio=" + fechaInicio +
                ", estado='" + estado + '\'' +
                ", detallesAdicionales='" + detallesAdicionales + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
