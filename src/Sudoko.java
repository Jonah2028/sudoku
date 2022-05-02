import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/* for win check make a method to check row and collum also make method to check 3x3 grids
    when checking have an int add up to 45, if what is being checked dosnt add up to 45
    then they didnt win. after checking all rows, collums, and 3x3 grids, if the mega int
    dosnt equal 1215 then the sudoko is wrong*/

public class Sudoko extends PlainDocument implements ActionListener {
    int wins = 0;
    int adsa = 1;
    int set;
    JFrame frame = new JFrame("board");
    JButton reset = new JButton("reset");
    JButton grid[][] = new JButton[9][9];
    JButton numbers[][] = new JButton[3][3];
    JButton check = new JButton("Check");
    JLabel winCount = new JLabel("Wins: "+wins);
    JOptionPane alert = new JOptionPane();
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
        //creates the 9x9 board
        for (int row = 0; row < grid.length; row++) {
            for (int collum = 0; collum < grid[0].length; collum++) {
                grid[collum][row] = new JButton();
                grid[collum][row].addActionListener(this);

                board.add(grid[collum][row]);
            }}
        //creates the number buttons
        click.setLayout(new GridLayout(1,9));
        for (int row = 0; row < numbers.length; row++) {
            for (int collum = 0; collum < numbers[0].length; collum++) {
                numbers[collum][row] = new JButton(String.valueOf(adsa));
                adsa++;
                numbers[collum][row].addActionListener(this);
                click.add(numbers[collum][row]);
            }}
        check.addActionListener(this);
        winBox.setLayout(new GridLayout(1,1));
        winBox.add(winCount);
        bottom.setLayout(new BorderLayout());
        bottom.add(click, BorderLayout.NORTH);
        bottom.add(check, BorderLayout.CENTER);
        bottom.add(reset, BorderLayout.SOUTH);
        frame.add(winBox, BorderLayout.NORTH);
        frame.add(board, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(alert,"To play first click a button with a number on it, that will determine which number will be place in the 9x9 grid above. When you want to place a different number on the board click the button with the number on it. At any time you can place a different number on a square that has a number on it, on the board by clicking on it again","How to Play",JOptionPane.WARNING_MESSAGE);
    }
// make an array for the numbers in the field and check that with code below
    @Override
    public void actionPerformed(ActionEvent e) {
        //testing stuff
        if (e.getSource()==check) {
            for (int row = 0; row < grid.length; row++) {
                for (int collum = 0; collum < grid[0].length; collum++) {
                    String test = grid[collum][row].getText();
                    if (!grid[collum][row].getText().isEmpty()) {
                        System.out.print(test+", ");}}}}
        if (e.getSource()==numbers[0][0]){
            set=1;}
        if (e.getSource()==numbers[1][0]){
            set=2;}
        if (e.getSource()==numbers[2][0]){
            set=3;}
        if (e.getSource()==numbers[0][1]){
            set=4;}
        if (e.getSource()==numbers[1][1]){
            set=5;}
        if (e.getSource()==numbers[2][1]){
            set=6;}
        if (e.getSource()==numbers[0][2]){
            set=7;}
        if (e.getSource()==numbers[1][2]){
            set=8;}
        if (e.getSource()==numbers[2][2]){
            set=9;}
        for (int row = 0; row < grid.length; row++) {
            for (int collum = 0; collum < grid[0].length; collum++) {
                if (e.getSource().equals(grid[collum][row])){
                    grid[collum][row].setText(String.valueOf(set));
                }
            }}
    }
}