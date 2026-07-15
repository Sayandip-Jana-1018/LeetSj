class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*n + n;
        return gcd(sumOdd, sumEven);
    }
    private int gcd(int sO, int sE) {
        if(sE == 0) return sO;
        return gcd(sE, sO % sE);
    }
}