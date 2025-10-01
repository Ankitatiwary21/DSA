class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank=numBottles;
        while(numBottles>=numExchange)
        {
            int exchanged=numBottles/numExchange;
            int extraEmpty=numBottles%numExchange; 
            drank+=exchanged;
            numBottles=exchanged+extraEmpty;
        }
        return drank;
    }
}