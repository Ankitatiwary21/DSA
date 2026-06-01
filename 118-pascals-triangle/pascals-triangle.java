class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer>row=new ArrayList<>();
            for(int k=0;k<=i;k++)
            {
                row.add(1);
            }
            for(int j=1;j<i;j++)
            {
                row.set(j,result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(row);
        }
        return result;
    }
}