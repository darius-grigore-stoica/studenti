package com.company;

import exceptions.AgeException;
import exceptions.DuplicateElement;
import exceptions.GrupaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.DBStudentRepository;
import repository.ProfesorRepository;
import service.ProfesorService;
import service.StudentService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Aplicația a pornit.");

        Properties props = new Properties();
        try {
            props.load(new FileReader("bd.config"));
            logger.info("S-au incarcat proprietatile bazei de date");
            DBStudentRepository repo = new DBStudentRepository(props);
            StudentService studentService = new StudentService(repo);

            try {
                studentService.addStudent("Robert", 20, "325", new ArrayList<>());
            } catch (RuntimeException | GrupaException | AgeException e) {
                logger.error(e.getMessage());
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        ProfesorRepository profesorRepository = new ProfesorRepository();
        ProfesorService profesorService = new ProfesorService(profesorRepository);

        try {
            profesorService.addProfesor("Popescu", "Matematica", new ArrayList<>());
        } catch (DuplicateElement e){
            System.out.println(e.getMessage());
        }
    }
}