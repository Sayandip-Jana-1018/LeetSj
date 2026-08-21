class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        char[] d = num.toCharArray();
        char[] st = new char[d.length];
        int top=-1;
        int rem=k;
        for(int i=0;i<d.length;i++){
            while(rem>0 && top>=0 && st[top]>d[i]){
                top--;
                rem--;
            }
            top++;
            st[top]=d[i];
        }
        int start=0;
        while(st[start]=='0' && start<d.length-k-1){
            start++;
        }
        return String.valueOf(st,start,d.length-k-start);
    }
}