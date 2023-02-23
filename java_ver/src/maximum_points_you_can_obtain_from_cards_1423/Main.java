package maximum_points_you_can_obtain_from_cards_1423;

/*
    There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
    In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
    Your score is the sum of the points of the cards you have taken.
    Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class Main {
    public int maxScore(int[] cardPoints, int k) {
        // Double pointer
        int length = cardPoints.length, l = 0, r = length - k;

        // Init value
        int sum = 0, max = 0;
        for(int i=r; i<length; i++){
            sum += cardPoints[i];
        }
        max = sum;

        while (r < length){
            sum = sum + cardPoints[l++] - cardPoints[r++];
            // Update
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(new Main().maxScore(new int[10000], 5000));
    }
}
