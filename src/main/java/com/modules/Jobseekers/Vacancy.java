package com.modules.Jobseekers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modules.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Vacancy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobName;
    private String specialization;
    private BigDecimal salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;


    public Vacancy(String jobName, String specialization, double salary, Contact contact) {
        this.jobName = jobName;
        this.specialization = specialization;
        this.salary  = BigDecimal.valueOf(BigDecimal.valueOf(salary).setScale(2, RoundingMode.HALF_UP).floatValue());
        this.contact = contact;
    }
}
