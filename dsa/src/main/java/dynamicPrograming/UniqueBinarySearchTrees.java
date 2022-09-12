package dynamicPrograming;

public class UniqueBinarySearchTrees {
    public static void main(String[] args){
        System.out.println(numTrees(3));
    }
    public static int numTrees(int n) {
        //dp cache
        int [] numTree = new int [n+1];
        //base codiion for nodes with 0 and 1
        numTree[0]=1;
        numTree[1]=1;
        for(int nodes=2 ; nodes<n+1 ; nodes++){
            int total=0;
            for(int root=1 ; root<nodes+1 ; root++){
                int left=root-1;
                int right=nodes-root;
                total+=numTree[left]*numTree[right];
            }
            numTree[nodes]=total;
        }
        return numTree[n];
    }
}
