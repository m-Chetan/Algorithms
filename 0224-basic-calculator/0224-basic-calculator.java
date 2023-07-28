class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        int sum = 0;
        int sign = 1;
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int number = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    number = number*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                sum += sign*number;
                sign = 1;
            }
            else if(ch == '-'){
                sign *= -1;
            }
            else if(ch == '('){
                stk.push(sum);
                stk.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(ch == ')'){
                sum *= stk.pop();
                sum += stk.pop();
            }
            
        }

        return sum;
    }
    

}