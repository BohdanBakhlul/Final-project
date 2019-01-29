package carsdb;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String creator;
    private String model;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> order_list = new ArrayList<>();

    public void addOrders(Orders Orders) {
        order_list.add(Orders);
    }


    public List<Orders> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<Orders> order_list) {
        this.order_list = order_list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}