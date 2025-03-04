package com.lab;

import java.util.Scanner;
import java.io.InputStream;

public class Minesweeper {
    static char SAFE_CELL = '.';
    static char MINE_CELL = 'X' ;
    static int IS_SAFE = 0;
    static int IS_MINE = 1;
    int fieldX, fieldY;
    int[][] cells;
    String fieldFileName;

    public Minesweeper(String fieldFile) {
        this.fieldFileName = fieldFile;
        initFromFile(fieldFileName);
    }

    public Minesweeper(int fieldX, int fieldY) {
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.cells = new int[fieldX][fieldY];
        for (int i=0; i<fieldX; i++) {
            for (int j=0; j<fieldY; j++) {
                cells[i][j] = IS_SAFE;
            }
        }
    }

    void displayField() {
        // Task 1: Display the mine field to terminal
        for (int i = 0 ; i < fieldX ; i++){
            for (int j = 0 ; j < fieldY ; j++){
                if(cells[i][j] == IS_MINE){
                    System.out.print(MINE_CELL);
                }else{
                    System.out.print(SAFE_CELL);
                }
            }
            System.out.println();
        }
    }
    void setMineCell(int x, int y) {
        cells[x][y] = IS_MINE;
    }

    void initFromFile(String mineFieldFile) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(mineFieldFile);
        
        
        // Task 2: Using `java.util.Scanner` to load mine field from the input stream named, `is`
        if (is == null) {
            System.out.println("File not found: " + mineFieldFile);
            return;
        }
        
        Scanner scanner = new Scanner(is);
        
        
        if (scanner.hasNextLine()) {
            fieldX = Integer.parseInt(scanner.nextLine().trim());  
        }
        
        if (scanner.hasNextLine()) {
            fieldY = Integer.parseInt(scanner.nextLine().trim());  
        }
    
        
        cells = new int[fieldX][fieldY];
        
        
        int row = 0;
        while (scanner.hasNextLine() && row < fieldX) {
            String line = scanner.nextLine().trim();
            for (int col = 0; col < line.length() && col < fieldY; col++) {
                
                if (line.charAt(col) == 'X') {
                    cells[row][col] = IS_MINE;  
                } else {
                    cells[row][col] = IS_SAFE;  
                }
            }
            row++;
        }
        
        
        scanner.close();

    }
}