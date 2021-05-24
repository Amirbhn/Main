package ca.amir.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacherStudent")
@Data
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
    private String grade;

}
