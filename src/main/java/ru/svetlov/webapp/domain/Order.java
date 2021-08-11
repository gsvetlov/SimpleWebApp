package ru.svetlov.webapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderedProduct> contents;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }

    protected Order() {
    }

    public Order(LocalDateTime dateTime, Customer customer) {
        this.dateTime = dateTime;
        this.customer = customer;
        contents = new ArrayList<>();
    }

    public Order(LocalDateTime dateTime, Customer customer, List<OrderedProduct> contents) {
        this.dateTime = dateTime;
        this.customer = customer;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedProduct> getContents() {
        return contents;
    }

    public void setContents(List<OrderedProduct> contents) {
        this.contents = contents;
    }
}
