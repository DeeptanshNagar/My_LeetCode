class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int numEmpty = 0;
        int numDrank = 0;
        while (true) {
            if (numBottles == 0) return numDrank;
            numDrank += numBottles;
            numEmpty += numBottles;
            numBottles = 0;
            while (numEmpty >= numExchange) {
                numBottles++;
                numEmpty -= numExchange;
                numExchange++;
            }
        }
    }
}