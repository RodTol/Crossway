package it.units.crossway.utilities;

import it.units.crossway.model.Coordinates;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Vertex {
    private Coordinates value;

    public Vertex(Coordinates value){
        this.value = value;
    }


    public Coordinates getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Vertex)){
            return false;
        }
        if (obj == this){
            return true;
        }
        Vertex o = (Vertex) obj;
        return new EqualsBuilder()
                .append(value, o.value)
                .isEquals();
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
