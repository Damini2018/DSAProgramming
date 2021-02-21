package com.mywork.dsa;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        isValidSudoku(null);
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int isValidSudoku(final String[] A) {
        int a[][]= new int[9][9];
        //int strl=A.size();
        //return strl;

        //inserting elements in 2 array
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c= A[i].charAt(j);
                if(c=='.') continue;
                else a[i][j]=Integer.parseInt(String.valueOf(c));
            }
        }


        //validating
        //vertical validating
        //System.out.println("stared vertical validation ");
        Set<Integer> set = new HashSet<>();
        for(int j=0;j<9;j++){
            set.clear();
            for(int i=0;i<9;i++){
                boolean contains= set.contains(a[i][j]);
                if(contains && a[i][j]!=0) return 0;
                else set.add(a[i][j]);
            }
        }
        ////System.out.println("Completed vertical validation ");
        set.clear();
        //horizontal validating
        for(int i=0;i<9;i++){
            set.clear();
            for(int j=0;j<9;j++){
                boolean contains= set.contains(a[i][j]);
                if(contains && a[i][j]!=0) return 0;
                else set.add(a[i][j]);
            }
        }
        //System.out.println("Completed horizontal validation ");
        set.clear();
        boolean isValid= true;
        //box validation
        int ar[] = {0,3,6};
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                isValid =isValidBox(a,ar[i],ar[j]);
                //if(!isValid){System.out.println("BOX= "+ (i+j) +" is invalid");}
                if(!isValid) return 0;

            }
        }
        //System.out.println("Completed box validation ");
        return 1;
    }

    public static boolean isValidBox(int[][] a, int row,int col){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i+row][j+col]==0) continue;
                boolean contains= set.contains(a[i+row][j+col]);
                if(contains) {
                    ////     System.out.println("BOX= "+ (i+row+col+j) +" is invalid");
                    return false;}
                else set.add(a[i+row][j+col]);
            }
        }
        //System.out.println("Completed box validation = "+ (row+col));
        return true;
    }

}