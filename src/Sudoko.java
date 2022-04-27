import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sudoko {
    int wins = 0;
    JFrame frame = new JFrame("board");
    JButton reset = new JButton("reset");
    JTextField number[][] = new JTextField[9][9];

    JLabel winCount = new JLabel("Wins: "+wins);
    Container board=new Container();
    Container winBox = new Container();
    Container resetBox = new Container();

    public static void main(String[] args) {
        new Sudoko();
    }
    public Sudoko(){
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        board.setLayout(new GridLayout(9,9));
        for (int row = 0; row < number.length; row++) {
            for (int collum = 0; collum < number[0].length; collum++) {
                number[collum][row] = new JTextField();
                board.add(number[collum][row]);
            }
        }
        winBox.setLayout(new GridLayout(1,1));
        winBox.add(winCount);
        resetBox.setLayout(new GridLayout(1,1));
        resetBox.add(reset);
        frame.add(winBox, BorderLayout.NORTH);
        frame.add(board, BorderLayout.CENTER);
        frame.add(resetBox, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}