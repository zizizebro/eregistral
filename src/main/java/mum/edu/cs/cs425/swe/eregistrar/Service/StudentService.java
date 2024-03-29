package mum.edu.cs.cs425.swe.eregistrar.Service;

import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface StudentService  {
    public abstract Page<Student> getAllStudents();
    Iterable<Student> getIAllStudents();
    Page<Student> getAllStudentsPaged(int pageNo);
    public abstract Student getStudentById(Long id);
    Student saveStudent(Student student);
    void  deleteStudent(Long studentId);
    Student  findById(Long studentId);
    Page<Student> search(String search,int pageNo);

}
