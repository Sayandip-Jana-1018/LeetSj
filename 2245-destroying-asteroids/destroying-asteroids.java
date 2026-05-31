class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currentMass = mass;
        Arrays.sort(asteroids);
        for(int i=0; i<asteroids.length; i++) {
            if(currentMass >= asteroids[i]) {
                currentMass += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}