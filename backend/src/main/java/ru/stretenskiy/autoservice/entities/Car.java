package ru.stretenskiy.autoservice.entities;

import javax.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num")
    private String number;

    @Column(name = "color")
    private String color;

    @Column(name = "mark")
    private String mark;

    @Column(name = "is_foreign", precision = 1)
    private Integer isForeign;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(number, car.number) && Objects.equals(color, car.color) && Objects.equals(mark, car.mark) && Objects.equals(isForeign, car.isForeign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, color, mark, isForeign);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", mark='" + mark + '\'' +
                ", isForeign=" + isForeign +
                '}';
    }

}
