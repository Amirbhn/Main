package ca.amir.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "teacherName")
    private String teacherName;

    @Column(name = "teacherEmail")
    private String teacherEmail;
}
