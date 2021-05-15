package ca.amir.entity;

import javax.persistence.*;

@Entity
@Table(name = "studentCourse")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentCourseId")
    private int studentCourseId;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(name = "grade")
    private int grade;

    public StudentCourse() {
    }

    public int getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(int studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
