package ca.amir.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Data
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

}
