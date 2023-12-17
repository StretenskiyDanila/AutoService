package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(name = "cost_our", precision = 18, scale = 2)
    private BigInteger costOur;

    @Column(name = "cost_foreign", precision = 18, scale = 2)
    private BigInteger costForeign;

    public Services() {
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
        Services services = (Services) o;
        return Objects.equals(id, services.id) && Objects.equals(name, services.name) && Objects.equals(costOur, services.costOur) && Objects.equals(costForeign, services.costForeign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, costOur, costForeign);
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costOur=" + costOur +
                ", costForeign=" + costForeign +
                '}';
    }

}
