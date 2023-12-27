package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
public class Servicing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost_our", precision = 18, scale = 2)
    private BigDecimal costOur;


    @Column(name = "cost_foreign", precision = 18, scale = 2)
    private BigDecimal costForeign;

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
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costOur=" + costOur +
                ", costForeign=" + costForeign +
                '}';
    }

}
