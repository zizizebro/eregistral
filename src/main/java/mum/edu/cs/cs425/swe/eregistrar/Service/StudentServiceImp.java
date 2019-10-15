package mum.edu.cs.cs425.swe.eregistrar.Service;


import mum.edu.cs.cs425.swe.eregistrar.modell.Student;
import mum.edu.cs.cs425.swe.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class StudentServiceImp  implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Page<Student> getAllStudents() {
        return (Page<Student>) studentRepository.findAll();
    }

    @Override
    public Iterable<Student> getIAllStudents() {
        return  null;
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 10, Sort.by("lastName")));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.delete(studentRepository.getOne(studentId));

    }


    @Override
    public Student findById(Long studentId) {
        Student stu = studentRepository.getOne((Long)studentId);
        return stu;
    }

    @Override
    public Page<Student> search(String search, int pageNo) {
        Page<Student> students  =studentRepository.findStudentByFirstNameContainsOrLastNameContainsOrMiddleNameContainsOrStudentNoContainsOrInternationalContainsOrderByFirstName(search,search,search,search,search, PageRequest.of(pageNo, 10, Sort.by("firstName")));
        return students;
    }



}


