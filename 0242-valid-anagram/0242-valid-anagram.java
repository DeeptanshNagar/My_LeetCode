class Solution {
    public boolean isAnagram(String s, String t) {
        char[] st = s.toCharArray();
        Arrays.sort(st);
        String s1 = new String(st);

        char[] st1 = t.toCharArray();
        Arrays.sort(st1);
        String s2 = new String(st1);

        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}