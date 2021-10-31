package com.hello.problems;

/**
 * Get the max sized rectangle
 */
public class MaxRect {

    public static  void main(String args[]) {
        int input[][] = {{1,1,1,0},
                {1,1,1,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,0,1},
                {1,1,1,1}};
        MaxRect mrs = new MaxRect();
        int maxRectangle = mrs.maximum(input);
        //System.out.println("Max rectangle is of size " + maxRectangle);
        assert maxRectangle == 8;

    }

    public int maximum(int input[][]){
        int temp[] = new int[input[0].length];
        MaxHistogram mh = new MaxHistogram();
        int maxArea = 0;
        int area = 0;
        for(int i=0; i < input.length; i++){
            for(int j=0; j < temp.length; j++){
                if(input[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += input[i][j];
                }
            }
            area = mh.maxHistogram(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

}
