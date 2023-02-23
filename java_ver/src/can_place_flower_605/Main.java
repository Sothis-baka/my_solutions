package can_place_flower_605;

public class Main {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        int prev = -1;
        for(int i=0; i<length; i++){
            if(flowerbed[i] == 0 && (i==0 || (flowerbed[i-1]==0 && prev != i-1))){
                n--;
                prev = i;
            }

            if(flowerbed[i] == 1 && i!=0 && prev == i-1) n++;
        }

        return n <= 0;
    }
}
