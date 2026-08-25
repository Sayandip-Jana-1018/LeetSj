# 4080. Smallest Missing Multiple of K

🟢 **Easy** · `Array` `Hash Table`

## Problem Summary
The problem asks us to find the smallest positive integer that is a multiple of a given integer `k` and is *not* present in the input array `nums`. We are looking for the first number in the sequence `k, 2k, 3k, ...` that is absent from `nums`.

For example, if `nums = [2, 4, 8]` and `k = 2`, the multiples of 2 are `2, 4, 6, 8, 10, ...`. From `nums`, we see `2`, `4`, and `8` are present. The smallest multiple of 2 that is missing is `6`.

See the [full problem on LeetCode](https://leetcode.com/problems/smallest-missing-multiple-of-k/).

## Approach & Implementation

The solution utilizes a highly efficient **bitset** to track the presence of multiples of `k`. This approach is particularly effective when the range of multiples to check is relatively small, allowing for constant time lookups and updates.

Here's a detailed breakdown of the code's logic:

1.  **Initialize a Bitset:**
    *   `long[] x = {0L, 0L};`
    *   A `long` in Java is 64 bits. By using an array of two `long`s, `x[0]` and `x[1]`, the code effectively creates a bitset capable of tracking the presence of 128 distinct positive multiples of `k`.
    *   `x[0]` will track the presence of `k, 2k, ..., 64k` (corresponding to bit indices 0-63).
    *   `x[1]` will track `65k, 66k, ..., 128k` (corresponding to bit indices 64-127).
    *   Initially, both `long` values are `0L`, meaning all bits are unset, indicating that no multiples are present yet.

2.  **Populate the Bitset:**
    *   `for (int n : nums)`: The code iterates through each number `n` in the input array `nums`.
    *   `if (n % k == 0)`: It checks if the current number `n` is an exact multiple of `k`. We are only interested in these numbers.
    *   `int i = n / k - 1;`: If `n` is a multiple of `k`, its "multiple index" is calculated.
        *   For `n = k`, `i` becomes `(k / k) - 1 = 0`.
        *   For `n = 2k`, `i` becomes `(2k / k) - 1 = 1`.
        *   This `i` is a 0-indexed value representing which multiple of `k` it is (e.g., `i=0` for the 1st multiple, `i=1` for the 2nd, etc.).
    *   `x[i >> 6] |= 1L << (i & 63);`: This line sets the corresponding bit in the bitset to `1`, marking the multiple as "present."
        *   `i >> 6`: This is equivalent to `i / 64`. It determines which `long` in the `x` array to use: `x[0]` if `i` is between 0 and 63, and `x[1]` if `i` is between 64 and 127.
        *   `i & 63`: This is equivalent to `i % 64`. It calculates the specific bit position (from 0 to 63) within the chosen `long` to set.
        *   `1L << (i & 63)`: Creates a `long` value where only the bit at `(i & 63)` is set to `1`.
        *   `|=`: The bitwise OR assignment sets the target bit in `x[i >> 6]` to `1` without altering any other bits.

3.  **Find the Smallest Missing Multiple:**
    *   After iterating through `nums`, the `x` array now represents which multiples of `k` (up to `128k`) are present. The next step is to find the smallest 0-indexed `i` whose bit is *not* set.
    *   `int z = x[0] == -1L ? 1 : 0;`: This line determines which `long` (`x[0]` or `x[1]`) potentially contains the first missing multiple.
        *   In Java's two's complement representation, `-1L` is a `long` with all 64 bits set to `1`.
        *   If `x[0]` is `-1L`, it means all multiples from `k` to `64k` are present. In this case, we must look in `x[1]` for the first missing multiple, so `z` is set to `1`.
        *   Otherwise (if `x[0]` is not all `1`s), the first missing multiple must be among `k` to `64k`, so `z` is set to `0`.
    *   `Long.numberOfTrailingZeros(++x[z] & -x[z])`: This is a very clever bit manipulation idiom to find the index of the least significant *zero* bit within `x[z]`.
        *   Let `val = x[z]`. We are looking for the position `p` of the rightmost `0` bit. This means bits `0` through `p-1` are all `1`s, and bit `p` is `0`. So, `val` has the pattern `...011...1` (where `0` is at position `p`).
        *   `++x[z]` (incrementing `val` by 1): This operation flips all the trailing `1`s to `0`s and flips the `0` at position `p` to a `1`. So, `val + 1` now has the pattern `...100...0` (where `1` is at position `p`).
        *   `& -x[z]`: The two's complement negation `-Y` for a positive `Y` has the property that `Y & -Y` isolates the least significant *set* bit of `Y`. In our case, `Y` is `++x[z]`. So, `(++x[z]) & (-(++x[z]))` isolates the single `1` bit that was created at position `p` (i.e., it returns `2^p`).
        *   `Long.numberOfTrailingZeros(2^p)`: This Java utility function returns `p`, which is precisely the 0-indexed position of the least significant *zero* bit in the *original* `x[z]` value. This `p` is our `idx_in_long`.
    *   `return (z * 64 + idx_in_long + 1) * k;`: This calculates the final result:
        *   `z * 64`: Accounts for the base offset. If `z` is `1` (meaning `x[0]` was full), it adds 64 to the index, effectively converting `idx_in_long` (which is 0-indexed within `x[1]`) to the overall 0-indexed `i`.
        *   `+ idx_in_long`: Adds the specific bit position found.
        *   `+ 1`: Since `i` was defined as `(n/k - 1)`, we add 1 to convert the 0-indexed missing position back to the 1-indexed multiple number.
        *   `* k`: Finally, multiplies by `k` to get the actual value of the smallest missing multiple.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The code iterates through the `nums` array exactly once. All operations within the loop (modulo, division, bit shifts, bitwise OR) are constant-time operations. The final calculation involving `Long.numberOfTrailingZeros` is also constant time. Therefore, the total time complexity is linear with respect to the number of elements `N` in the `nums` array.
-   **Space:** O(1) - The space used by the `x` array is fixed at two `long` primitives, regardless of the size of the input array `nums`. Thus, the space complexity is constant.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 44.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/smallest-missing-multiple-of-k/)
- [View My Submission](https://leetcode.com/submissions/detail/2119975609/)
