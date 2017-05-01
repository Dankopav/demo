package hr.danko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by danko on 4/30/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    public String type;
    public Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
