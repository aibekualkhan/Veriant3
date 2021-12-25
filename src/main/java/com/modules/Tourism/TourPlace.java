package com.modules.Tourism;

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
@AllArgsConstructor
@ToString
public class TourPlace {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeName;

    private String placeType;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;


    public TourPlace(String placeName, String placeType, Contact contact) {
        this.placeName = placeName;
        this.placeType = placeType;
        this.contact = contact;
    }
}
