package ca.amir.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_teacher_course")
@Data
public class StudentTeacherCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_teacher_course_id")
    private int studentTeacherCourseId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_course_id", nullable = false)
    private TeacherCourse teacherCourse;

    @Column(name = "grade")
    private Double grade;

}
