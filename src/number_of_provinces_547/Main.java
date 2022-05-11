package number_of_provinces_547;

public class Main {
    public int findCircleNum(int[][] isConnected) {
        int count = isConnected.length;
        boolean[] visited = new boolean[count];

        int provinceCount = 0;
        for(int i=0; i<count; i++){
            if(!visited[i]){
                mark(isConnected, visited, i, count);
                provinceCount++;
            }

        }

        return provinceCount;
    }

    private void mark(int[][] isConnected, boolean[] visited, int i, int count){
        if(visited[i]) return;

        visited[i] = true;
        for(int j=0; j<count; j++){
            if(isConnected[i][j] == 1){
                mark(isConnected, visited, j, count);
            }
        }
    }
}
