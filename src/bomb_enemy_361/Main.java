package bomb_enemy_361;

/*
    Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
    The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
*/
public class Main {
    public static int maxKilledEnemies(char[][] grid) {
        int height = grid.length, width = grid[0].length;
        Integer[][] horizontal = new Integer[height][width];
        Integer[][] vertical = new Integer[height][width];

        // Two direction dp
        for(int i=0; i<height; i++){
            for(int j=0; j<height; j++){
                if(grid[i][j] != 'W'){
                    // Avoid recalculation
                    if(j > 0 && horizontal[i][j-1] != null){
                        horizontal[i][j] = horizontal[i][j-1];
                    }else{
                        // Search horizontally
                        int count = 0, left = j, right = j + 1;
                        while(left >= 0 && grid[i][left] != 'W'){
                            if(grid[i][left--] == 'E'){
                                count++;
                            }
                        }
                        while(right < width && grid[i][right] != 'W'){
                            if(grid[i][right++] == 'E'){
                                count++;
                            }
                        }
                        horizontal[i][j] = count;
                    }

                    // Avoid recalculation
                    if(i > 0 && horizontal[i-1][j] != null){
                        vertical[i][j] = vertical[i-1][j];
                    }else{
                        // Search vertically
                        int count = 0, down = i, up = i + 1;
                        while(down >= 0 && grid[down][j] != 'W'){
                            if(grid[down--][j] == 'E'){
                                count++;
                            }
                        }
                        while(up < height && grid[up][j] != 'W'){
                            if(grid[up++][j] == 'E'){
                                count++;
                            }
                        }
                        vertical[i][j] = count;
                    }
                }
            }
        }


        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == '0'){
                    max = Math.max(max, horizontal[i][j] + vertical[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        char[][] chars = new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };

        System.out.println(maxKilledEnemies(chars));
    }
}