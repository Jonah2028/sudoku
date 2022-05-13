import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* for win check make a method to check row and collum also make method to check 3x3 grids
    when checking have an int add up to 45, if what is being checked dosnt add up to 45
    then they didnt win. after checking all rows, collums, and 3x3 grids, if the mega int
    dosnt equal 1215 then the sudoko is wrong*/

public class Sudoko extends PlainDocument implements ActionListener {
    int wins = 0;
    int adsa = 1;
    int set = 1;
    JFrame frame = new JFrame("Sudoko");
    JButton reset = new JButton("reset");
    JButton grid[][] = new JButton[9][9];
    int grid2[][]= new int[9][9];
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
        //creates a 9x9 grid
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
                numbers[0][0].setBackground(Color.CYAN);
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
        JOptionPane.showMessageDialog(alert,"To play first click a button with a number on it, the button will be turned teal,that will determine which number will be place in the 9x9 grid above. When you want to place a different number on the board click the button with the number on it. At any time you can place a different number on a square that has a number on it, on the board by clicking on it again","How to Play",JOptionPane.WARNING_MESSAGE);
    }
//runs when the check button is clicked and checks to see if the player won. check collum, row and 3x3 grids
    public void winCheck() {
        //checking collums
        int collums[] = new int[9];
        int finalCollums = 0;
        for (int i = 0; i < 9; i++) {
            int c = 0;
            for (int collum = 0; collum < 9; collum++) {
                c = c + grid2[i][collum];
            }
            collums[i] = c;
        }
        for (int i = 0; i < 9; i++) {
            finalCollums = finalCollums + collums[i];
        }
        System.out.println("final count for collum: " + finalCollums);
        //checking rows
        int rows[] = new int[9];
        int finalrows = 0;
        for (int i = 0; i < 9; i++) {
            int c = 0;
            for (int row = 0; row < 9; row++) {
                c = c + grid2[row][i];
            }
            rows[i] = c;
        }
        for (int i = 0; i < 9; i++) {
            finalrows = finalrows + rows[i];
        }
        System.out.println("final count for row: " + finalrows);
        //checking 3x3
        int cell[][] = new int[3][3];
        int finalcell = 0;
        for (int collum = 0; collum < cell.length; collum++) {
            int c = 0;
            for (int row = 0; row < cell[0].length; row++) {
                c = c + grid2[row][collum];
                cell[row][collum] = c;
            }
        }
        for (int collum = 0; collum < cell.length; collum++) {
            for (int row = 0; row < cell[0].length; row++) {
                finalcell = finalcell + cell[row][collum];
                System.out.println("final count for cell: " + finalcell + " " +row+","+collum);
            }

        }

    }
// make an array for the numbers in the field and check that with code below
    @Override
    public void actionPerformed(ActionEvent e) {
        //runs wincheck method when check is clicked
        if (e.getSource()==check) {winCheck();}
        //puts numbers on buttons in the 9x9 grid and sets current number being placed to cyan
        if (e.getSource()==numbers[0][0]){
            set=1;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[0][0].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[1][0]){
            set=2;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[1][0].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[2][0]){
            set=3;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[2][0].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[0][1]){
            set=4;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[0][1].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[1][1]){
            set=5;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[1][1].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[2][1]){
            set=6;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[2][1].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[0][2]){
            set=7;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[0][2].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[1][2]){
            set=8;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[1][2].setBackground(Color.CYAN);}
        if (e.getSource()==numbers[2][2]){
            set=9;
            for (int row = 0; row < numbers.length; row++) {
                for (int collum = 0; collum < numbers[0].length; collum++) {
                    numbers[collum][row].setBackground(null);}}
            numbers[2][2].setBackground(Color.CYAN);}
        for (int row = 0; row < grid.length; row++) {
            for (int collum = 0; collum < grid[0].length; collum++) {
                if (e.getSource().equals(grid[collum][row])){
                    grid[collum][row].setText(String.valueOf(set));
                    grid2[collum][row]=set;
                }
            }}
    }
}