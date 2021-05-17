package ca.amir.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_Id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_family")
    private String studentFamily;

    @Column(name = "student_birthdate")
    private String studentBirthdate;

    @Column(name = "student_gender")
    private String studentGender;

    @Column(name = "student_email")
    private String studentEmail;

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public String getStudentFamily() {
        return studentFamily;
    }

    public void setStudentFamily(String family) {
        this.studentFamily = family;
    }

    public String getStudentBirthdate() {
        return studentBirthdate;
    }

    public void setStudentBirthdate(String birthdate) {
        this.studentBirthdate = birthdate;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String gender) {
        this.studentGender = gender;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String email) {
        this.studentEmail = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + studentName + '\'' +
                ", family='" + studentFamily + '\'' +
                ", birthdate='" + studentBirthdate + '\'' +
                ", gender='" + studentGender + '\'' +
                ", email='" + studentEmail + '\'' +
                '}';
    }
}
