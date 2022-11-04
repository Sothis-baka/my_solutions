package design_skiplist_1206;

import java.util.Random;

public class Skiplist {
    final static int DEPTH = 16;
    Random roll;

    static class Node{
        int val;
        Node[] children;

        Node(int val){
            this.val = val;
            this.children = new Node[DEPTH];
        }
    }

    Node start, end;

    public Skiplist() {
        this.start = new Node(Integer.MIN_VALUE);
        this.end = new Node(Integer.MAX_VALUE);

        for(int i=0; i<DEPTH; i++){
            this.start.children[i] = this.end;
        }

        this.roll = new Random();
    }

    public boolean search(int target) {
        Node pt = findSmallerAtBottom(target);
        // See whether the next node at bottom has target value
        return pt.children[0].val == target;
    }

    public void add(int num) {
        Node pt = findSmallerAtBottom(num);

        Node newNode = new Node(num);
        int curDepth = 0;
        while (curDepth < DEPTH){
            if(pt.children[curDepth] != null && (curDepth == 0 || roll.nextBoolean())){
                insertAtDepth(pt, newNode, curDepth);
                curDepth++;
            }else break;
        }
    }

    public boolean erase(int num) {
        Node pt = findSmallerAtBottom(num);

        // Doesn't exist
        if(pt.children[0] == null || pt.children[0].val != num) return false;

        for(int i=0; i<DEPTH; i++){
            if(pt.children[i] != null && pt.children[i].val == num){
                // delete target at curDepth
                pt.children[i] = pt.children[i].children[i];
            }
        }

        return true;
    }


    private Node findSmallerAtBottom(int val){
        Node pt = start;
        int curDepth = 3;
        while (curDepth >= 0){
            while (pt.children[curDepth].val < val){
                pt = pt.children[curDepth];
            }
            if(curDepth != 0) curDepth--;
            else break;
        }

        return pt;
    }

    private void insertAtDepth(Node prev, Node newNode, int depth){
        newNode.children[depth] = prev.children[depth];
        prev.children[depth] = newNode;
    }

    public static void main(String[] args){
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.search(0); // return False
        skiplist.add(4);
        skiplist.search(1); // return True
        skiplist.erase(0);  // return False, 0 is not in skiplist.
        skiplist.erase(1);  // return True
        skiplist.search(1); // return False, 1 has already been erased.
    }
}
