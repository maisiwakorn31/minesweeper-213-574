package com.lab;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Minesweeper initMineField() {
        
        Minesweeper game = new Minesweeper(9, 9);
        /*game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);        
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);
        game.setMineCell(randomNum, randomNum);*/
        for (int i = 0 ; i < 10 ; i++){
            int RandomRow = (int)(Math.random() * 9);
            int RandomCol = (int)(Math.random() * 9);
            game.setMineCell(RandomRow, RandomCol);
        }

        return game;
    }
    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        System.out.println("Menu");
        System.out.println("1 : Basic");
        System.out.println("2 : Star");
        System.out.println("3 : Dimond");
        System.out.println("4 : Random");
        System.out.println("5 : Exit");
        int menu = sc.nextInt();

        if(menu < 1 || menu > 5) {
            System.out.println("Only 1 - 5");
            continue;
        }
        
        switch (menu) {
            case 1:
            Minesweeper Basic = initMineFieldFromFile("minefield/minefield01.txt");
            Basic.displayField();
                break;
            case 2:
            Minesweeper Star = initMineFieldFromFile("minefield/Star.txt");
            Star.displayField();
                break;
            case 3:
            Minesweeper Dimond = initMineFieldFromFile("minefield/Dimond.txt");
            Dimond.displayField();   
                break;
            case 4:
            Minesweeper Random = initMineField();
            Random.displayField();
                break;
             case 5:
            System.out.println("Exiting...");
            return;

}
        // Task 3: Implement a menu to select the mine field template
        // Design the menu by yourself.
                
        //Minesweeper game = initMineField();
        //Minesweeper game = initMineFieldFromFile("minefield/minefield01.txt");
        //game.displayField();
        }
        
    }
    
    }

