package mum.edu.cs.cs425.swe.eregistrar.modell;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Student_id")

    private Long id;
    @Column(name ="student_Number", nullable = false)
    private  int studentNumber;
    @Column(name ="first_Name", nullable = false)
    private String firstName;
    @Column(name ="middle_Name", nullable = false)
    private String middleName;
    @Column(name ="last_Name", nullable = false)
    private String laastName;
    @Column(name ="middle_Name", nullable = false)
    private Double gpa;
    @Column(name ="middle_Name", nullable = false)
    private LocalDate enrollmentDate;
    @Column(name ="middle_Name", nullable = false)
    private boolean isinternational;

    public Student(){

    }
    public Student(int studentNumber, String firstName, String middleName, String laastName, Double gpa,
                   LocalDate enrollmentDate, boolean isinternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.laastName = laastName;
        this.gpa = gpa;
        this.enrollmentDate = enrollmentDate;
        this.isinternational = isinternational;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLaastName() {
        return laastName;
    }

    public void setLaastName(String laastName) {
        this.laastName = laastName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean isIsinternational() {
        return isinternational;
    }

    public void setIsinternational(boolean isinternational) {
        this.isinternational = isinternational;
    }
}
