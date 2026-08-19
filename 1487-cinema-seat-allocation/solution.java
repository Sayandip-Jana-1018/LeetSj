import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowToReserved = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rowToReserved.put(row, rowToReserved.getOrDefault(row, 0) | (1 << col));
        }
        
        int maxFamilies = n * 2;
        
        int leftMask = 60;   
        int rightMask = 960; 
        int middleMask = 240;
        
        for (int reservedMask : rowToReserved.values()) {
            
            maxFamilies -= 2; 
            
            boolean leftFree = (reservedMask & leftMask) == 0;
            boolean rightFree = (reservedMask & rightMask) == 0;
            boolean middleFree = (reservedMask & middleMask) == 0;
            
            if (leftFree && rightFree) {
                maxFamilies += 2;
            } else if (leftFree || rightFree || middleFree) {
                maxFamilies += 1;
            }
        }
        
        return maxFamilies;
    }
}