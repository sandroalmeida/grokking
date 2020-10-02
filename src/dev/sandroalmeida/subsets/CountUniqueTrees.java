package dev.sandroalmeida.subsets;

public class CountUniqueTrees {

    public int countTrees(int n){
        if(n <= 1) return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
