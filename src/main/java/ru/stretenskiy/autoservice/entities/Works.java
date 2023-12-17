package ru.stretenskiy.autoservice.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "works")
public class Works {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_work")
    private Date dateWork;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private Integer master;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Integer service;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Integer car;

    public Works() {
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

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getCar() {
        return car;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Works works = (Works) o;
        return Objects.equals(id, works.id) && Objects.equals(dateWork, works.dateWork) && Objects.equals(master, works.master) && Objects.equals(service, works.service) && Objects.equals(car, works.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateWork, master, service, car);
    }

    @Override
    public String toString() {
        return "Works{" +
                "id=" + id +
                ", dateWork=" + dateWork +
                ", master=" + master +
                ", service=" + service +
                ", car=" + car +
                '}';
    }

}
