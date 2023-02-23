package the_employee_that_worked_on_the_longest_task_2432;

public class Main {
    public int hardestWorker(int n, int[][] logs) {
        int last = 0, maxTime = 0, maxId = -1;

        for (int[] log : logs) {
            int workTime = log[1] - last;

            if (workTime > maxTime || (workTime == maxTime && log[0] < maxId)) {
                maxTime = workTime;
                maxId = log[0];
            }

            last = log[1];
        }

        return maxId;
    }
}
