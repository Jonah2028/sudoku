import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* for win check make a method to check row and collum also make method to check 3x3 grids
    when checking have an int add up to 45, if what is being checked dosnt add up to 45
    then they didnt win. after checking all rows, collums, and 3x3 grids, if the mega int
    dosnt equal 1215 then the sudoko is wrong*/

public class Sudoko implements ActionListener {
    int wins = 0;
    int adsa = 1;
    JFrame frame = new JFrame("board");
    JButton reset = new JButton("reset");
    JTextField number[][] = new JTextField[9][9];
    JButton numbers[][] = new JButton[3][3];
    JLabel winCount = new JLabel("Wins: "+wins);
    Container board=new Container();
    Container winBox = new Container();
    Container click = new Container();
    Container bottom = new Container();

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
            }}
        click.setLayout(new GridLayout(1,9));
        for (int row = 0; row < numbers.length; row++) {
            for (int collum = 0; collum < numbers[0].length; collum++) {
                numbers[collum][row] = new JButton(String.valueOf(adsa));
                adsa++;
                click.add(numbers[collum][row]);
            }}
        winBox.setLayout(new GridLayout(1,1));
        winBox.add(winCount);
        bottom.setLayout(new BorderLayout());
        bottom.add(click, BorderLayout.NORTH);
        bottom.add(reset, BorderLayout.SOUTH);
        frame.add(winBox, BorderLayout.NORTH);
        frame.add(board, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
// make an array for the numbers in the field and check that with code below
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int row = 0; row < number.length; row++) {
            for (int collum = 0; collum < number[0].length; collum++) {
                String test = numbers[collum][row].getText();
            }}
    }
}