package ie.tudublin;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board; //the current board
    boolean[][] next; //the next board
    
    private int size; //the size of the board
    PApplet p; 

    float cellWidth; 

    public boolean getCell(int row, int col) //get the value of a cell
    {
        if (row >= 0 && row < size && col >= 0 && col < size) //if row and col are within the board
        {
            return board[row][col]; //return the value of the cell
        }
        else
        {
            return false;
        }
    }

    public int countCells(int row, int col) //count the number of neighbours
    {
        int count = 0 ;
        for(int i = -1 ; i <= 1 ; i ++) //loop through the 3x3 grid
        {
            for (int j = -1 ; j <= 1 ; j ++) 
            {
                if (! (i == 0 && j == 0)) //if the cell is not the one we are checking
                {
                    if (getCell(row + i, col + j)) //if the cell is alive
                    {
                        count ++;  //add 1 to the count
                    }
                }
            }
        } 
        return count;
    }

    public void applyRules() //apply the rules of the game
    {
        for(int row = 0 ; row < size ; row ++) //loop through the board
        {
            for (int col = 0 ; col < size ; col ++) 
            {
                int count = countCells(row, col); //count the number of neighbours
                if (board[row][col]) //if the cell is alive
                {
                    if (count == 2 || count == 3) //if the cell is alive and has 2 or 3 neighbours
                    {
                        next[row][col] = true; //the cell stays alive
                    }
                    else
                    {
                        next[row][col] = false; //the cell dies
                    }
                    
                }
                else
                {
                    if (count == 3) //if the cell is dead and has 3 neighbours
                    {
                        next[row][col] = true; //the cell comes to life
                    }
                    else
                    {
                        next[row][col] = false; //the cell stays dead
                    }
                }

                // < 2 > 3 dies
                // 2-3 survices
                // dead with 3 neighboiurs comes to life
            }
        }
        //swap the boards
        boolean[][] temp = board; 
        board = next; 
        next = temp; 
    }

    public LifeBoard(int size, PApplet p) //constructor
    {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
        cellWidth = p.width / (float) size;
    }

    public void randomise() //randomise the board
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public void render() //render the board
    {
        for(int row = 0 ; row < size ; row ++)
        {
            p.stroke(255);
            for (int col = 0 ; col < size ; col ++)
            {
                float x = col * cellWidth;
                float y = row * cellWidth;

                if (board[row][col])
                {
                    p.fill(0, 255, 0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);
            }
        }
    }


    public int getSize() { //getters and setters
        return size;
    }

    public void setSize(int size) { //getters and setters
        this.size = size;
    } 
    
}
