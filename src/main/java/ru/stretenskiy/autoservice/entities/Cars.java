package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num", length = 20)
    private String number;

    @Column(length = 20)
    private String color;

    @Column(length = 20)
    private String mark;

    @Column(name = "is_foreign", precision = 1)
    private Integer isForeign;

    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(Integer isForeign) {
        this.isForeign = isForeign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(id, cars.id) && Objects.equals(number, cars.number) && Objects.equals(color, cars.color) && Objects.equals(mark, cars.mark) && Objects.equals(isForeign, cars.isForeign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, color, mark, isForeign);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", mark='" + mark + '\'' +
                ", isForeign=" + isForeign +
                '}';
    }

}
