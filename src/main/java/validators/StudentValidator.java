package validators;

import exceptions.AgeException;
import exceptions.GrupaException;
import model.Student;

public class StudentValidator {
    public static void validate(Student entity) throws AgeException, GrupaException {
        if (entity.getVarsta() < 18)
            throw new AgeException("Varsta trebuie sa fie minim 18");
        if (!entity.getGrupa().matches("^\\d{3}$"))
            throw new GrupaException("Grupa trebuie sa fie formata din exact 3 cifre");
    }
}
