package mum.edu.cs.cs425.swe.eregistrar.Service;

import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student stud);
    List<Student> allStudent();
    Student findById(Long id);
    Student registr(Student students);

    public abstract Iterable<Student> getAllBooks();
    public abstract Page<Student> getAllBooksPaged(int pageNo);
    public abstract Student saveBook(Student book);
    public abstract Student getBookById(Integer bookId);
    public abstract void deleteBookById(Integer bookId);
    public abstract Optional<Student> findByISBN(String isbn);
}
