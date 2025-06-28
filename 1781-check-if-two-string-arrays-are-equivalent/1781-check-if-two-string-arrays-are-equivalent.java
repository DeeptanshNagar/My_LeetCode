class Solution {
    public boolean arrayStringsAreEqual(String[] wordArray1, String[] wordArray2) {
        String concatenatedWord1 = String.join("", wordArray1);
        String concatenatedWord2 = String.join("", wordArray2);
        return concatenatedWord1.equals(concatenatedWord2);
    }
}