class Solution {
    public int calPoints(String[] str) {
        int index = 0;
        int arr[] = new int[str.length];
        for(int i=0; i<str.length; i++){
            if(str[i].equals("+")){
                arr[index] = arr[index-1] + arr[index-2];
                index++;
            }                
            else if(str[i].equals("C")){
                index--;
            }
            else if(str[i].equals("D")){
                arr[index] = arr[index - 1] * 2;
                index++;
            } else {
                arr[index] = Integer.parseInt(str[i]);
                index++;
            }
        }
        int sum = 0;
        for(int i=0; i<index; i++){
            sum += arr[i];
        }
        return sum;
    }
}