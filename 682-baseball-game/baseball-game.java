class Solution {
    public int calPoints(String[] str) {
        int index = 0;
        int arr[] = new int[str.length];
        for(int i=0;i < arr.length;i++){
            if(str[i].equals("C")){
                arr[index-1] = 0;
                index--;
                System.out.println(arr[i]);
            }
            else if(str[i].equals("D")){
                arr[index] = arr[index-1]*2;
                index++;
                System.out.println(arr[i]);

            }
            else if(str[i].equals("+")){
                arr[index] = arr[index-1] + arr[index-2];
                index++;
                System.out.println(arr[i]);
            }
            else {
                arr[index] += Integer.parseInt(str[i]);
                index++;
                System.out.println(arr[i]);
            }
        }
        int sum = 0;
        for(int i=0;i < arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
}