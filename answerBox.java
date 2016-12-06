// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//          
// ****************************************************************

import java.util.Scanner;

public class Square
{
    int[][] square;

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size)
    {
        square = new int[size][size];

        for (int row=0; row < square.length; row++) 
            for (int col=0; col < square.length; col++) 
                square[row][col] = row * 10 + col; 
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row)
    {
        int sum = 0;
        for (int col=0; col < square.length; col++) 
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumCol(int col)
    {
        int sum = 0;
        for (int row=0; row < square[row].length; row++) 
        {
            sum += square[row][col];
        }
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag()
    {
        int sum = 0;
        for (int j=0; j< square.length; j++) 
            sum += square[j][j];    //you can do this because a square's diagonals have the same coordinate points
        return sum;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag()
    {
        int sum = 0;
        for (int j=0; j< square.length; j++) 
            sum += square[j][square.length - 1 - j];
        return sum;
    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean magic() 
    {
        boolean answer = true;
        int sum = sumMainDiag();
        if (sumOtherDiag() != sum) 
        {
            answer = false;
        }
        else 
        {
            for (int col = 0; col < square.length; col++) 
            {
                if (sum != sumCol(col)) 
                {
                    answer = false;
                }
            }for (int row = 0; row < square.length; row++) 
            {
                if (sum != sumRow(row)) 
                {
                    answer = false;
                }
            }
        }
        return answer;
    }

    //--------------------------------------
    //read info into the square from the input stream associated with the 
    //Scanner parameter
    //--------------------------------------
    public void readSquare(Scanner scan)
    {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col ++)
                square[row][col] = scan.nextInt();
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare()
    {
        for (int row=0; row < square.length; row++) 
      { 
         for (int col=0; col < square[row].length; col++) 
            System.out.print (square[row][col] + "\t"); 
         System.out.println(); 
      } 

    }

}
