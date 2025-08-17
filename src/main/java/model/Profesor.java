package model;

import java.util.List;

public class Profesor {
    private String nume;
    private List<String> clase;
    private String materie;

    public Profesor(String nume, String materie, List<String> clase) {
        this.nume = nume;
        this.materie = materie;
        this.clase = clase;
    }

    public String getNume() {
        return nume;
    }

    public List<String> getClase() {
        return clase;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + nume + '\'' +
                ", clase=" + clase +
                '}';
    }
}
