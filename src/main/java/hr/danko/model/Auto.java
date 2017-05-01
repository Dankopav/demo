package hr.danko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by danko on 4/30/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auto {
    public int id;
    public String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
