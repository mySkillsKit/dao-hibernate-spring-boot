package ru.netology.daohibernatespringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
   // @Min(0)
    private int age;

    @Column(name = "phone_number", nullable = false)
    //    @Column(columnDefinition = "varchar(50) default 'Номер не указан'")
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving;

}
