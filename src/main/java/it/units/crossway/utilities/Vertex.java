package it.units.crossway.utilities;

import it.units.crossway.model.Piece;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Vertex {
    Piece value;

    public Vertex(Piece piece){
        this.value = piece;
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
}
