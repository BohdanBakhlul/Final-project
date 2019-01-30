package carsdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specs {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String body;

    private String color;

    private Integer engine_size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEngine_size() {
        return engine_size;
    }

    public void setEngine_size(Integer engine_size) {
        this.engine_size = engine_size;
    }


}