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
    int grid2[][] = new int[9][9];
    JButton numbers[][] = new JButton[3][3];
    JButton check = new JButton("Check");
    JLabel winCount = new JLabel("Wins: " + wins);
    JOptionPane alert = new JOptionPane();
    JOptionPane winMessage = new JOptionPane();
    Container board = new Container();
    Container winBox = new Container();
    Container click = new Container();
    Container bottom = new Container();

    public static void main(String[] args) {
        new Sudoko();
    }

    public Sudoko() {
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        board.setLayout(new GridLayout(9, 9));
        //creates a 9x9 grid
        for (int row = 0; row < grid.length; row++) {
            for (int collum = 0; collum < grid[0].length; collum++) {
                grid[collum][row] = new JButton();
                grid[collum][row].addActionListener(this);
                board.add(grid[collum][row]);}}
        //creates the number buttons
        click.setLayout(new GridLayout(1, 9));
        for (int row = 0; row < numbers.length; row++) {
            for (int collum = 0; collum < numbers[0].length; collum++) {
                numbers[collum][row] = new JButton(String.valueOf(adsa));
                adsa++;
                numbers[collum][row].addActionListener(this);
                numbers[0][0].setBackground(Color.CYAN);
                click.add(numbers[collum][row]);}}
        //changes the odd number grids to grey
        for (int collum = 0; collum < grid2.length; collum=collum+6) {
            for (int row = 0; row < grid2[0].length; row=row+6) {
                int test[][]=new int[3+collum][3+row];
                for (int collum2 = collum; collum2 < test.length; collum2++) {
                    for (int row2 = row; row2 < test[0].length; row2++) {
                        grid[collum2][row2].setBackground(Color.GRAY);}}}}
        int test2[][]=new int[6][6];
        for (int collum = 3; collum < test2.length ; collum++) {
            for (int row = 3; row < test2[0].length; row++) {
                grid[collum][row].setBackground(Color.GRAY);}}
        //makes the board
        check.addActionListener(this);
        reset.addActionListener(this);
        winBox.setLayout(new GridLayout(1, 1));
        winBox.add(winCount);
        bottom.setLayout(new BorderLayout());
        bottom.add(click, BorderLayout.NORTH);
        bottom.add(check, BorderLayout.CENTER);
        bottom.add(reset, BorderLayout.SOUTH);
        frame.add(winBox, BorderLayout.NORTH);
        frame.add(board, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(alert, "To play first click a button with a number on it, the button will be turned teal,that will determine which number will be place in the 9x9 grid above. When you want to place a different number on the board click the button with the number on it. At any time you can place a different number on a square that has a number on it, on the board by clicking on it again", "How to Play", JOptionPane.WARNING_MESSAGE);
    }
    //runs when the check button is clicked and checks to see if the player won. check collum, row and 3x3 grids
    public void winCheck() {
        //checking collums
        int numCollum=0;
        int collumWin = 0;
        int collums[] = new int[9];
        for (int i = 0; i < 9; i++) {
            int c = 0;
            int finalCollums = 0;
            for (int collum = 0; collum < 9; collum++) {
                c = c + grid2[i][collum];
            }
            finalCollums = c;
            if (finalCollums!=0) {
                System.out.println("final count for collum" + numCollum + ": " + finalCollums);
            }
            numCollum++;
        }
        for (int collumCheck = 0; collumCheck < 9; collumCheck++) {
            if (collums[collumCheck] == 45) {collumWin++;}}

        //checking rows'
        int numRows=1;
        int rowWin = 0;
        int rows[] = new int[9];
        for (int i = 0; i < 9; i++) {
            int finalrows = 0;
            int c = 0;
            for (int row = 0; row < 9; row++) {
                c = c + grid2[row][i];
            }
            finalrows = c;
            if (finalrows!=0) {
                System.out.println("final count for row" + numRows + ": " + finalrows);
            }
            numRows++;
        }
        for (int rowCheck = 0; rowCheck < 9; rowCheck++) {
            if (rows[rowCheck] == 45) {rowCheck++;}}

        //checking 3x3 grids
        //make the checker check all 3 grids in the first row then move down and repeat
        //it checks row by row and checks all the grids in one collom and adds that to a total when
        //it moves down a row it stops counting the row above but counts the row below it
        int numcell = 1;
        int cellcount[][] = new int[3][3];
        int cellWin = 0;
        for (int collumCheck = 0; collumCheck < grid2.length; collumCheck = collumCheck + 3) {
            for (int rowCheck = 0; rowCheck < grid2[0].length; rowCheck = rowCheck + 3) {
                int cell[][] = new int[3 + collumCheck][3 + rowCheck];
                int finalcell = 0;
                int c = 0;
                for (int collum = collumCheck; collum < cell.length; collum++) {
                    for (int row = rowCheck; row < cell[0].length; row++) {
                        c = c + grid2[row][collum];

                    }
                }
                finalcell = finalcell + c;
                if (finalcell != 0) {
                    System.out.println("final count for cell " + numcell + ": " + finalcell);
                }
                numcell++;
            }
        }
        for (int collumCheck = 0; collumCheck < cellcount.length; collumCheck++) {
            for (int rowCheck = 0; rowCheck < cellcount[0].length; rowCheck++) {
                if (cellcount[rowCheck][collumCheck] == 45) {
                    cellWin++;
                }
            }
        }
        if (collumWin == 9 && rowWin == 9) {
            wins++;
            JOptionPane.showMessageDialog(winMessage, "You win!!", "Win mesage", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public void reseter(){
        for (int collum = 0; collum < grid.length; collum++) {
            for (int row = 0; row < grid[0].length; row++) {
                grid[collum][row].setText(" ");
                grid2[collum][row]=0;
            }
        }
        set=1;
        for (int row = 0; row < numbers.length; row++) {
            for (int collum = 0; collum < numbers[0].length; collum++) {
                numbers[collum][row].setBackground(null);}}
        numbers[0][0].setBackground(Color.CYAN);
    }

// make an array for the numbers in the field and check that with code below
    @Override
    public void actionPerformed(ActionEvent e) {
        //runs wincheck method when check is clicked
        if (e.getSource()==check) {winCheck();}
        //runs the reset methof when reset is clicked
        if (e.getSource()==reset) {reseter();}
        //sets the set int and sets current number being placed to cyan
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
        //sets a button in the grid to the value of set
        for (int row = 0; row < grid.length; row++) {
            for (int collum = 0; collum < grid[0].length; collum++) {
                if (e.getSource().equals(grid[collum][row])){
                    grid[collum][row].setText(String.valueOf(set));
                    grid2[collum][row]=set;
                }}}}}