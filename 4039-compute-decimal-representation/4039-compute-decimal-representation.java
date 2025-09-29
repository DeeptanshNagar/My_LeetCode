class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> res =new ArrayList<>();
        int position =0;
        while(n>0){
            int digit = n%10;
            if(digit!=0){
                res.add(digit*(int)Math.pow(10,position));
            }
            n/=10;
            position++;
        }
        Collections.reverse(res);
         int ans[] =new int[res.size()];
         for(int i=0;i<res.size();i++){
             ans[i] = res.get(i);
         }
        return ans;
    }
}