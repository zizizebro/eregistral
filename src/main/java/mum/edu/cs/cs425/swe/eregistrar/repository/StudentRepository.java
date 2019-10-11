package mum.edu.cs.cs425.swe.eregistrar.repository;

import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findBookByStudentNumber(String stunum);

}
