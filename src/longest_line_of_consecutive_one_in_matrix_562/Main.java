package longest_line_of_consecutive_one_in_matrix_562;

/*
    Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 */
public class Main {
    static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {1, 1}, {-1, -1}};

    public static int longestLine(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        boolean[][][] cache = new boolean[height][width][4];

        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                for(int k=0; k<4; k++){
                    if(matrix[i][j] == 1) max = Math.max(max, markDir(matrix, i, j, cache, k));
                }
            }
        }

        return max;
    }

    private static int markDir(int[][] matrix, int i, int j, boolean[][][] cache, int dirNo){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0 || cache[i][j][dirNo]) return 0;

        int[] dir = dirs[dirNo];
        return 1 + markDir(matrix, i + dir[0], j + dir[1], cache, dirNo);
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{0,1,1,0}, {0,1,1,0}, {0,0,0,1}};
        System.out.println(longestLine(matrix));
    }
}