import java.util.Scanner;

class Estudiante {
    private String nombre;
    private int edad;
    private Materia materia;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public boolean verificarAprobacion() {
        if (materia == null) {
            System.out.println("El estudiante no tiene una materia asignada.");
            return false;
        }

        double sumaCalificaciones = materia.getAcd() + materia.getApe() + materia.getAa();
        double porcentaje = (sumaCalificaciones / 10.0) * 100;

        if (porcentaje >= 70) {
            System.out.println("El estudiante ha aprobado la materia.");
            return true;
        } else {
            System.out.println("El estudiante no ha aprobado la materia.");
            System.out.println("Debe rendir un examen de recuperación.");
            return false;
        }
    }

    public void rendirExamenRecuperacion(double notaRecuperacion) {
        double sumaCalificaciones = materia.getAcd() + materia.getApe() + materia.getAa();
        double nuevaNota = notaRecuperacion + (sumaCalificaciones * 0.6);

        if (nuevaNota >= 7) {
            System.out.println("El estudiante ha aprobado la materia después del examen de recuperación.");
        } else {
            System.out.println("El estudiante no ha aprobado la materia después del examen de recuperación.");
        }
    }
}

class Materia {
    private String nombre;
    private double acd;
    private double ape;
    private double aa;

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAcd() {
        return acd;
    }

    public double getApe() {
        return ape;
    }

    public double getAa() {
        return aa;
    }
}