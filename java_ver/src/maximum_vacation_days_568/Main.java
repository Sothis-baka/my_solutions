package maximum_vacation_days_568;

/*
    LeetCode wants to give one of its best employees the option to travel among N cities to collect algorithm problems. But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules and restrictions you need to follow.

    Rules and restrictions:

    You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed 0 on Monday.
    The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical), called flights representing the airline status from the city i to the city j. If there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.
    You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once per day and can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of flight time.
    For each city, you can only have restricted vacation days in different weeks, given an N*K matrix called days representing this relationship. For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j.


    You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take during K weeks.
*/
public class Main {
    public static int maxVacationDays(int[][] flights, int[][] days) {
        int[][] cache = new int[days.length][days[0].length];
        return vacationHelper(flights, days, 0, 0, cache);
    }

    private static int vacationHelper(int[][] flights, int[][] days, int city, int day, int[][] cache){
        // Finished
        if(day == days[0].length) return 0;
        // Visited case
        if(cache[city][day] != 0) return cache[city][day];

        int cityNum = days.length, max = 0;
        for(int i=0; i<cityNum; i++){
            if(i == city || flights[city][i] == 1)
                max = Math.max(max, days[i][day] + vacationHelper(flights, days, i, day + 1, cache));
        }
        cache[city][day] = max;
        return max;
    }

    public static void main(String[] args){
        int[][] flights = new int[][]{{0,1,1}, {1,0,1}, {1,1,0}};
        int[][] days = new int[][]{{1,3,1}, {6,0,3}, {3,3,3}};
        System.out.println(maxVacationDays(flights, days));

        flights = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}};
        days = new int[][]{{1,1,1}, {7,7,7}, {7,7,7}};
        System.out.println(maxVacationDays(flights, days));
    }
}
