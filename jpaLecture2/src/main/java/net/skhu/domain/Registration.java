package net.skhu.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude={"student","course"})
@EqualsAndHashCode(exclude={"student","course"})
@Entity
@Table(name = "register")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Integer grade; //nullable 필드이기 때문에 int는 적합하지 않음
    Date createDate;

    @ManyToOne
    @JoinColumn(name = "studentId")
    Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;
    
}
