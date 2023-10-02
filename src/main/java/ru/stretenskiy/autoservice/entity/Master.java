package ru.stretenskiy.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Master() {
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
        Master master = (Master) o;
        return Objects.equals(id, master.id) && Objects.equals(name, master.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "\nMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
