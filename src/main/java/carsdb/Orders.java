package carsdb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String city;

    private String comments;

    private Integer amount;

//    @OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
//    private List<Delivery> delivery_list = new ArrayList<>();
//
//    public void addDelivery(Delivery Delivery) {
//        delivery_list.add(Delivery);
//    }
//
//
//    public List<Delivery> getDelivery_list() {
//        return delivery_list;
//    }
//
//    public void setDelivery_list(List<Delivery> delivery_list) {
//        this.delivery_list = delivery_list;
//    }

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Delivery> delivery_list = new ArrayList<>();
//
//
//
//    public void addDelivery(Delivery Delivery) {
//        delivery_list.add(Delivery);
//    }
//
//
//    public List<Delivery> getDelivery_list() {
//        return delivery_list;
//    }
//
//    public void setDelivery_list(List<Delivery> delivery_list) {
//        this.delivery_list = delivery_list;
//    }

//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}