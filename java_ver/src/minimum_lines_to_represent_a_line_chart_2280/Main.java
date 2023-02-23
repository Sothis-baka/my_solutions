package minimum_lines_to_represent_a_line_chart_2280;

import java.util.Arrays;

/*
    You are given a 2D integer array stockPrices where stockPrices[i] = [dayi, pricei] indicates the price of the stock on day dayi is pricei. A line chart is created from the array by plotting the points on an XY plane with the X-axis representing the day and the Y-axis representing the price and connecting adjacent points. One such example is shown below:
    Return the minimum number of lines needed to represent the line chart.
 */
public class Main {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);

        int length = stockPrices.length, count = 1;
        if(length == 1) return 0;

        int lastI = (stockPrices[1][1] - stockPrices[0][1]), lastJ = (stockPrices[1][0] - stockPrices[0][0]);
        for(int i=2; i<length; i++){
            int curI = (stockPrices[i][1] - stockPrices[i-1][1]), curJ = (stockPrices[i][0] - stockPrices[i-1][0]);
            if(lastI * curJ != lastJ * curI) count++;
            lastI = curI;
            lastJ = curJ;
        }

        return count;
    }
}
