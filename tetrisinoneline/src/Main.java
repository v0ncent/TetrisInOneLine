import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(
                new JFrame("tetris"),
                new Color[] {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red}, // tetraminoColors
                new Color[12][24], // well
                new Point(), // pieceOrigin
                0, // currentPiece
                0, // rotation
                new ArrayList<Integer>(), // next pieces
                0 // score

        ).peek(
                (frame) -> {
                    if (frame instanceof JFrame) {
                        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                }
        ).peek(
                (frame) -> {
                    if (frame instanceof JFrame) {
                        ((JFrame) frame).setSize(12*26+10, 26*23+25);
                    }
                }
        ).findFirst().ifPresent(
                (frame) -> {
                    if (frame instanceof JFrame) {
                        ((JFrame) frame).setVisible(true);
                    }
                }
        );
    }
}