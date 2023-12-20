package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "works")
@Getter
@Setter
@NoArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_work")
    private Date dateWork;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToOne
    @JoinColumn(name = "master_id")
    private Master master;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return Objects.equals(id, work.id) && Objects.equals(dateWork, work.dateWork) && Objects.equals(car, work.car) && Objects.equals(service, work.service) && Objects.equals(master, work.master);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateWork, car, service, master);
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", dateWork=" + dateWork +
                ", car=" + car +
                ", service=" + service +
                ", master=" + master +
                '}';
    }

}
