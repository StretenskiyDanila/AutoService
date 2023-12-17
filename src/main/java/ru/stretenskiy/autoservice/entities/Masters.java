package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "masters")
public class Masters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    public Masters() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Masters masters = (Masters) o;
        return Objects.equals(id, masters.id) && Objects.equals(name, masters.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Masters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
