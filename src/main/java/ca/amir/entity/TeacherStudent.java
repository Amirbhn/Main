package ca.amir.entity;


import javax.persistence.*;

@Entity
@Table(name = "teacherStudent")
public class TeacherStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherStudentId")
    private int teacherStudentId;

    @ManyToOne
    @JoinColumn(name = "teacherId", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)

    private Student student;

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
}
