package fr.fms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "T_Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contacts")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 50)
    private String category;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "category")
    private Collection<Contact> contacts;
}
