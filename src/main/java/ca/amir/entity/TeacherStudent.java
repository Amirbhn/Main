package ca.amir.entity;


import javax.persistence.*;

@Entity
@Table(name = "teacherStudent")
public class TeacherStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_student_id")
    private int teacherStudentId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity=Teacher.class)
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity=Student.class)
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    @Column(name = "grade")
    private int grade;


    public TeacherStudent() {
    }

    public int getTeacherStudentId() {
        return teacherStudentId;
    }

    public void setTeacherStudentId(int teacherStudentId) {
        this.teacherStudentId = teacherStudentId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
