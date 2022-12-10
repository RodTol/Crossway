package it.units.crossway.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    Node node;
    Piece piece;

    @BeforeEach
    @DisplayName("Node tests")
    void setup() {
        piece =new Piece(Color.BLACK);
        node = new Node();
    }

    @Test
    @DisplayName("Reflexivity")
    void reflexivity(){
        assertEquals(node, node);
    }

    @Test
    @DisplayName("Equal test")
    void otherObjectEqualsVertex(){
        assertNotEquals(node, piece);
    }

    @Test
    @DisplayName("Equal vertices")
    void equalVertices(){
        assertEquals(node, new Node());
    }


    @Test
    @DisplayName("Empty node is empty")
    void emptyNodeIsEmpty() {
        assertTrue(node.isNodeEmpty());
    }

    @Test
    @DisplayName("Full node is not empty")
    void fullNodeIsNotEmpty() {
        node.setPiece(piece);
        assertFalse(node.isNodeEmpty());
    }
}
