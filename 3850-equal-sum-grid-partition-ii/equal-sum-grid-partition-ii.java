class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        
        HashMap<Long,Integer> freq = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;

        long totalSum=0;
         
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                freq.put((long)grid[i][j],freq.getOrDefault((long)grid[i][j],0)+1);
                totalSum+=grid[i][j];
            }
        }

 
        HashMap<Long,Integer> freFirst = new HashMap<>();
        HashMap<Long,Integer> secFirst = new HashMap<>(freq);
        long firstHor = 0, secondHor = totalSum;

        
        for(int i=0;i<=m-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                firstHor +=grid[i][j];
                secondHor -=grid[i][j];
                
                freFirst.put((long)grid[i][j] , freFirst.getOrDefault((long)grid[i][j],0)+1);

                long val = grid[i][j];

                secFirst.put(val, secFirst.get(val) - 1);

                if (secFirst.get(val) == 0) {
                    secFirst.remove(val);
                }
            }

            if(firstHor == secondHor){
                return true;
            }
             
            long diff = Math.abs(firstHor-secondHor);

            if(firstHor > secondHor) {
                if(check(0,i,0,n-1,diff,freFirst,grid)) return true;
            } else {
                if(check(i+1,m-1,0,n-1,diff,secFirst,grid)) return true;
            }
        }

 
        HashMap<Long,Integer> freFirst1 = new HashMap<>();
        HashMap<Long,Integer> secFirst1 = new HashMap<>(freq);
        long firstHor1 = 0, secondHor1 = totalSum;

        
        for(int j=0;j<n-1;j++)
        {
            for(int i=0;i<m;i++)
            {
                firstHor1 +=grid[i][j];
                secondHor1 -=grid[i][j]; 

                freFirst1.put((long)grid[i][j] , freFirst1.getOrDefault((long)grid[i][j],0)+1);

                long val = grid[i][j];

                secFirst1.put(val, secFirst1.get(val) - 1);

                if (secFirst1.get(val) == 0) {
                    secFirst1.remove(val);
                }
            }

            if(firstHor1 == secondHor1)
                return true;

            long diff = Math.abs(firstHor1-secondHor1);

            if(firstHor1>secondHor1){
                if(check(0,m-1,0,j,diff,freFirst1,grid)) return true;
            }
            else{
                if(check(0,m-1,j+1,n-1,diff,secFirst1,grid)) return true;
            }
        }

        return false;
    }

    public boolean check(int r , int lr , int c , int lc , long diff,
                         HashMap<Long,Integer> map,int [][]grid)
    {
        int rows = lr-r+1;
        int cols = lc-c+1;

        if(rows * cols ==1)
            return false;

        if(rows == 1)
            return grid[r][c] == diff || grid[r][lc] == diff;

        if(cols == 1)
            return grid[r][c] == diff || grid[lr][c] == diff;

        return map.getOrDefault(diff,0)>0;
    }
}