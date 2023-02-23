package design_snake_game_353;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
    The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
    You are given a list of food’s positions in row-column order. When a snake eats the food, its length and the game’s score both increase by 1.
    Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
    When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 */
public class SnakeGame {
    int[][] board;
    LinkedList<int[]> foodList;
    LinkedList<int[]> snake;

    SnakeGame(int width, int height, int[][] food){
        this.board = new int[height][width];
        board[0][0] = 1;
        this.snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});
        foodList = new LinkedList<>();
        foodList.addAll(Arrays.asList(food));
        refreshFood();
    }

    void refreshFood(){
        while(!foodList.isEmpty()){
            int[] foo = foodList.removeFirst();
            if(board[foo[0]][foo[1]] != 1){
                board[foo[0]][foo[1]] = 2;
                break;
            }
        }
    }

    int move(String op){
        int[] start = this.snake.getLast();
        int[] newStart = new int[]{start[0], start[1]};
        switch (op) {
            case "U" -> newStart[0]--;
            case "R" -> newStart[1]++;
            case "D" -> newStart[0]++;
            case "L" -> newStart[1]--;
        }
        if(newStart[0] < 0 || newStart[0] == board.length || newStart[1] < 0 || newStart[1] == board[0].length){
            // Game end;
            return -1;
        }
        if(board[newStart[0]][newStart[1]] == 2){
            this.snake.offer(newStart);
            board[newStart[0]][newStart[1]] = 1;

            refreshFood();
            return 2;
        }

        int[] end = this.snake.removeFirst();
        board[end[0]][end[1]] = 0;
        if(board[newStart[0]][newStart[1]] == 1){
            return -1;
        }
        this.snake.offer(newStart);
        board[newStart[0]][newStart[1]] = 1;
        return 1;
    }

    public static void main(String[] args){
        SnakeGame snake = new SnakeGame(3, 2, new int[][]{{1,2}, {0,1}});

        System.out.println(snake.move("R"));
        System.out.println(snake.move("D"));
        System.out.println(snake.move("R"));
        System.out.println(snake.move("U"));
        System.out.println(snake.move("L"));
        System.out.println(snake.move("U"));
    }
}
