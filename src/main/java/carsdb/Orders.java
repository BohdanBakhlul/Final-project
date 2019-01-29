package carsdb;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String city;

    private String comments;

    private Integer amount;

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