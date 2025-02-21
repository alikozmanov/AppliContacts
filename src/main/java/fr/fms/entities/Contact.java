package fr.fms.entities;

import jakarta.validation.constraints.NotNull;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "T_Contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 15)
    private String phone;

    @NotNull
    @Size(min = 5, max = 100)
    private String address;

    @NotNull
    @Size(min = 5, max = 100)
    private String familyties;

//    private LocalDate creationDate = LocalDate.now();

    @ManyToOne
    private Category category;
}
