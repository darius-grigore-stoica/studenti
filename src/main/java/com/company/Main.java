package com.company;

import model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.DBStudentRepository;
import repository.ProfesorRepository;
import repository.StudentRepository;
import service.ProfesorService;
import service.StudentService;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(ExempluUtilizareLogger.class);
        logger.info("Aplicația a pornit.");

        try {
            int rezultat = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Eroare: Împărțire la zero!", e);
        } finally {
            logger.warn("Aplicația se va închide.");
        }
    }
}