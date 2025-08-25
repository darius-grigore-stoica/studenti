package repository;

import exceptions.DuplicateElement;
import model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBStudentRepository implements IRepository<Student> {

    private JdbcUtils jdbcUtils;
    private Logger logger;

    public DBStudentRepository(Properties props){
        jdbcUtils = new JdbcUtils(props);
        logger = LogManager.getLogger(DBStudentRepository.class);
    }

    @Override
    public void save(Student entity) throws  RuntimeException {
        Connection conn = jdbcUtils.getInstance();
        logger.info("S-a creat conectiunea cu baza de date");
        try (PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student(nume, varsta, grupa) VALUES (?, ?, ?)")){
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.setInt(2, entity.getVarsta());
            preparedStatement.setString(3, entity.getGrupa());
            preparedStatement.execute();
            logger.info("S-a introdus un nou student in DB");
        } catch (RuntimeException | SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student oldEntity, Student newEntity) {

    }

    @Override
    public void delete(Student entity) {
        Connection conn = jdbcUtils.getInstance();
        try (PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM student WHERE nume = ?")){
            preparedStatement.setString(1, entity.getNume());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> studenti = new ArrayList<>();

        Connection conn = jdbcUtils.getInstance();
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM student")){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String nume = rs.getString("nume");
                Integer varsta = rs.getInt("varsta");
                String grupa = rs.getString("grupa");

                Student s = new Student(nume, varsta, grupa, null);
                studenti.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return studenti;
    }


    public List<Integer> getNotePerStudent(Student student){
        List<Integer> note = new ArrayList<>();
        Connection conn = jdbcUtils.getInstance();
        try(PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT valoare, materie, student.nume FROM nota\n" +
                "INNER JOIN student ON nota.studentNota = student.studentID\n" +
                "WHERE student.nume = ?")){
            preparedStatement.setString(1, student.getNume());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Integer nota = rs.getInt("valoare");
                note.add(nota);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        student.setNote(note);
        return note;
    }
}
