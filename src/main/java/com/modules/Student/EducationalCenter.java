package com.modules.Student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modules.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
public class EducationalCenter {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ECname;

    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;


    public EducationalCenter(String ECname , String type, Contact contact) {
        this.ECname = ECname;
        this.type = type;
        this.contact = contact;
    }

}
