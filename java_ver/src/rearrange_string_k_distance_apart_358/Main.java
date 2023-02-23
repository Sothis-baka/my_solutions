package rearrange_string_k_distance_apart_358;

import java.util.*;

/*
    Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
    All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 */
public class Main {
    public static String rearrangeString(String str, int k) {
        int length = str.length();
        int[] cache = new int[26];

        for(int i=0; i<length; i++){
            cache[str.charAt(i) - 'a']++;
        }

        Queue<Pair> queue = new PriorityQueue<>(
                (a, b) -> a.count == b.count ? a.ch - b.ch : b.count - a.count
        );

        for(int i=0; i<26; i++){
            if(cache[i] != 0){
                queue.offer(new Pair((char)(i + 'a'), cache[i]));
            }
        }

        StringBuilder strBd = new StringBuilder();
        while(!queue.isEmpty()){
            int count = Math.min(queue.size(), k);
            Stack<Pair> saver = new Stack<>();
            for(int i=0; i<count; i++){
                Pair cur = queue.poll();
                cur.count--;
                strBd.append(cur.ch);
                // Discard the char when all used
                if(cur.count != 0){
                    if(count < k){
                        // Will reuse with in k letters
                        return "";
                    }
                    saver.push(cur);
                }

            }
            queue.addAll(saver);
        }

        return strBd.toString();
    }

    static class Pair{
        char ch;
        int count;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public static void main(String[] args){
        System.out.println(rearrangeString("aabbcc", 3));
        System.out.println(rearrangeString("aaabc", 3));
        System.out.println(rearrangeString("aaadbbcc", 2));
        System.out.println(rearrangeString("aaabbbcccdefg", 3));
        System.out.println(rearrangeString("aaabbbcccdefg", 4));
    }
}
