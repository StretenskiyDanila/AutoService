package ru.stretenskiy.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "services")
public class Servicing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cost_our", precision = 18, scale = 2)
    private BigInteger costOur;

    @Column(name = "cost_foreign", precision = 18, scale = 2)
    private BigInteger costForeign;

    public Servicing() {
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

    public BigInteger getCostOur() {
        return costOur;
    }

    public void setCostOur(BigInteger costOur) {
        this.costOur = costOur;
    }

    public BigInteger getCostForeign() {
        return costForeign;
    }

    public void setCostForeign(BigInteger costForeign) {
        this.costForeign = costForeign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicing servicing = (Servicing) o;
        return Objects.equals(id, servicing.id) && Objects.equals(name, servicing.name) && Objects.equals(costOur, servicing.costOur) && Objects.equals(costForeign, servicing.costForeign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, costOur, costForeign);
    }

    @Override
    public String toString() {
        return "\nService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costOur=" + costOur +
                ", costForeign=" + costForeign +
                '}';
    }
}
