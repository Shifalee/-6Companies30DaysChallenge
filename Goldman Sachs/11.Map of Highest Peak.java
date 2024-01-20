import java.util.*;
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][]result=new int[isWater.length][isWater[0].length];
        Queue<int[]> cells=findWaterCells(isWater,result);
        return bfs(cells,result);
        
    }

    private Queue<int[]> findWaterCells(int[][] isWater,int [][]result){
        Queue<int[]> cells=new LinkedList<>();
        for(int row=0;row<isWater.length;++row){
            for(int column=0;column<isWater[0].length;++column){
                if(isWater[row][column]==1)
                cells.offer(new int[]{row,column});
                else
                result[row][column]=-1;
            }
        }
        return cells;
    }

    private int[][] bfs(Queue<int[]> cells, int[][] result){
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!cells.isEmpty()){
            int[] cell=cells.poll();
            int row=cell[0],column=cell[1];

            for(int[] direction:directions){
                int newRow=row+direction[0],newColumn=column+direction[1];
                if(newRow<0 || newRow>=result.length||newColumn<0|| newColumn>=result[0].length||result[newRow][newColumn]!=-1)
                continue;
                result[newRow][newColumn]=result[row][column]+1;
                cells.offer(new int[]{newRow,newColumn});
            }
        }
        return result;
    }
}