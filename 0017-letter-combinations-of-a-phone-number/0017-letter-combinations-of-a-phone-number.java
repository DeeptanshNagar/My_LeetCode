class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        String[] map = {
            "",     
            "",     
            "abc",
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };
        return helper("", digits, map);
    }

    private List<String> helper(String p, String up, String[] map) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> result = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (char ch : letters.toCharArray()) {
            result.addAll(helper(p + ch, up.substring(1), map));
        }
        return result;
    }
}
