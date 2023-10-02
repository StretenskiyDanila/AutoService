package ru.stretenskiy.autoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_work")
    private Date dateWork;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Master master;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Servicing servicing;

    public Work() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateWork() {
        return dateWork;
    }

    public void setDateWork(Date dateWork) {
        this.dateWork = dateWork;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Servicing getService() {
        return servicing;
    }

    public void setService(Servicing servicing) {
        this.servicing = servicing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return Objects.equals(id, work.id) && Objects.equals(dateWork, work.dateWork) && Objects.equals(master, work.master) && Objects.equals(car, work.car) && Objects.equals(servicing, work.servicing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateWork, master, car, servicing);
    }

    @Override
    public String toString() {
        return "\nWork{" +
                "id=" + id +
                ", dateWork=" + dateWork +
                ", master=" + master.getId() +
                ", car=" + car.getId() +
                ", service=" + servicing.getId() +
                '}';
    }
}
