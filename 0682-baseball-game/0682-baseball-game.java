class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> points = new Stack<>();
        for(String s : operations){
            if(s.equals("C")){
                points.pop();
            }
            else if(s.equals("D")){
                points.push(points.peek()*2);
            }
            else if(s.equals("+")){
                int last =points.pop();
                int slast = points.peek();

                points.push(last);
                points.push(last+slast);
            }else{
                points.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for(int p: points){
            sum+=p;
        }
        return sum;

    }
}