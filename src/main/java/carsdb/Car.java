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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Specs> spec_list = new ArrayList<>();



    public void addSpecs(Specs Specs) {
        spec_list.add(Specs);
    }


    public List<Specs> getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(List<Specs> spec_list) {
        this.spec_list = spec_list;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carcreator> carcreatorList = new ArrayList<>();



    public void addCreator(Carcreator Carcreator) {
        carcreatorList.add(Carcreator);
    }


    public List<Carcreator> getCarcreatorList() {
        return carcreatorList;
    }

    public void setCarcreatorList(List<Carcreator> carcreatorList) {
        this.carcreatorList = carcreatorList;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveryList = new ArrayList<>();



    public void addDeliveries(Delivery Delivery) { deliveryList.add(Delivery);
    }


    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
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