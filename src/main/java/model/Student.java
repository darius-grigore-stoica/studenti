package model;

import java.util.List;

public class Student {
    private String nume;
    private int varsta;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, int varsta, String grupa, List<Integer> note) {
        this.nume = nume;
        this.varsta = varsta;
        this.grupa = grupa;
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    public void setNote(List<Integer> note){
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", grupa='" + grupa + '\'' +
                ", note=" + note +
                '}';
    }
}