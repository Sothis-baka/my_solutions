package diagonal_traverse_498;

/*
    Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */
public class Main {
    public static int[] findDiagonalOrder(int[][] mat) {
        int height = mat.length, width = mat[0].length;

        // Forward direction
        boolean inDir = true;

        int[] result = new int[height * width];
        for(int i=0, j=0, k=0; k<result.length; k++){
            System.out.printf("i: %d, j: %d\n", i, j);
            result[k] = mat[i][j];
            if(inDir && j==width-1){
                i++;
                inDir = false;
            }else if(!inDir && i==height-1){
                j++;
                inDir = true;
            }else if(!inDir && j==0){
                i++;
                inDir = true;
            }else if(inDir && i==0){
                j++;
                inDir = false;
            }else{
                i += inDir ? -1 : 1;
                j += inDir ? 1 : -1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] result = findDiagonalOrder(new int[][]{{1,2}, {3,4}});
    }
}
