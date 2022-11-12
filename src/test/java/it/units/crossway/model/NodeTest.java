package it.units.crossway.model;

import it.units.crossway.exceptions.NullPieceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeTest {
    @Test
    void check_piece_colour(){
        Node node = new Node(1,2);
        NullPieceException a = assertThrows(NullPieceException.class, () -> {node.getColour();});
    }
}
