package dynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args){
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        res.add(new ArrayList<>(row));
        for(int i=1 ;i <numRows ; i++){
            row.add(0,0);
            row.add(0);
            List<Integer> curRow = new ArrayList<Integer>();
            for(int j =1 ; j<row.size() ; j++){
                curRow.add(row.get(j-1)+row.get(j));
            }
            res.add(new ArrayList<>(curRow));
            row=curRow;
        }
        return res;
    }
}
