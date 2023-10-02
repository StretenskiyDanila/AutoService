package ru.stretenskiy.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num")
    private String carNumber;

    @Column(name = "color")
    private String carColor;

    @Column(name = "mark")
    private String carMark;

    @Column(name = "is_foreign")
    private Integer isForeign;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public Integer getForeign() {
        return isForeign;
    }

    public void setForeign(Integer foreign) {
        isForeign = foreign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car cars = (Car) o;
        return Objects.equals(id, cars.id) && Objects.equals(carNumber, cars.carNumber) && Objects.equals(carColor, cars.carColor) && Objects.equals(carMark, cars.carMark) && Objects.equals(isForeign, cars.isForeign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carNumber, carColor, carMark, isForeign);
    }

    @Override
    public String toString() {
        return "\nCars{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carMark='" + carMark + '\'' +
                ", isForeign=" + isForeign +
                '}';
    }
}
