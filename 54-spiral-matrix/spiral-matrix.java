class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r=0,lr=matrix.length-1;
        int c=0,lc=matrix[0].length-1;
        List<Integer>res=new ArrayList<>();
        while(r<=lr && c<=lc)
        {
            for(int i=c;i<=lc;i++)
            res.add(matrix[r][i]);
            r++;
            for(int i=r;i<=lr;i++)
            res.add(matrix[i][lc]);
            lc--;
            if(r<=lr && c<=lc)
            {
                for(int i=lc;i>=c;i--)
                res.add(matrix[lr][i]);
                lr--;
                for(int i=lr;i>=r;i--)
                res.add(matrix[i][c]);
                c++;
            }

        }   
        return res; }
}