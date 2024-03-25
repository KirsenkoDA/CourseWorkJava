package ru.vlsu.ispi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "characteristic_table")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "characteristic_id")
    private Long id;
    @Column(name = "characteristic_name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "characteristics")
    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
