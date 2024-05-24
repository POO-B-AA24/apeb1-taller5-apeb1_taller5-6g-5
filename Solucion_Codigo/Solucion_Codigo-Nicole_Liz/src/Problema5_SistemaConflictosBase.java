import java.util.ArrayList;
import java.util.List;

 class Evento {
    private String nombre;
    private int fecha; // NÃºmero de dÃas desde un punto de referencia fijo
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
    private int fechaInicio; // NÃºmero de dÃas desde un punto de referencia fijo
    private String estado; // "Activo", "En paz", "Guerra mundial"
    private String detallesAdicionales;
    private List<Evento> eventos;
    private static final int TOTAL_PAISES = 195; // NÃºmero total de paÃses en el mundo
    private List<String> paisesDesarrollados; // Lista de paÃses desarrollados

    public Conflicto(String nombre, int fechaInicio, String detallesAdicionales, List<String> paisesInvolucrados) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estado = "Activo";
        this.detallesAdicionales = detallesAdicionales;
        this.paisesInvolucrados = paisesInvolucrados;
        this.eventos = new ArrayList<>();
        this.paisesDesarrollados = List.of("EE.UU.", "Reino Unido", "Alemania", "Francia", "JapÃ³n", "CanadÃ¡", "Italia"); // Ejemplo de paÃses desarrollados
    }

    public String getNombre() {
        return nombre;
    }
}
