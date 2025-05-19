package modelo;

/**
 * Representa un videojuego con nombre, género, plataforma y puntuación.
 */
public class Videojuego {
    private String nombre;
    private String genero;
    private String plataforma;
    private int puntuacion; // de 1 a 5

    public Videojuego(String nombre, String genero, String plataforma, int puntuacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    @Override
    public String toString() {
        return nombre + " | Género: " + genero + " | Plataforma: " + plataforma + " | Puntuación: " + puntuacion;
    }
}
