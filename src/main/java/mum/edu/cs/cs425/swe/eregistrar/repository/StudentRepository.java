package mum.edu.cs.cs425.swe.eregistrar.repository;

import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Long> {

        Page<Student> findStudentByFirstNameContainsOrLastNameContainsOrMiddleNameContainsOrStudentNoContainsOrInternationalContainsOrderByFirstName(String fn, String ln, String mn, String inter, String stno, Pageable tName) ;

    }
