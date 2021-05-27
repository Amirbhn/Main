package ca.amir.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher_course")
@Data
public class TeacherCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_course_id")
    private int teacherCourseId;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
