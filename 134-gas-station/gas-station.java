class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalgas=0,totalcost=0;
        for(int i=0;i<n;i++)
        {
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost)
        {
        return -1;
        }
        int fuelrem=0;
        int start=0;
        for(int i=0;i<n;i++)
        {
            fuelrem+=gas[i]-cost[i];
            if(fuelrem<0)
            {
                start=i+1;
                fuelrem=0;
            }
        }
        return start;
    }

}