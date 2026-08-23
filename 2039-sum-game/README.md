# 2039. Sum Game

🟡 **Medium** · `Math` `String` `Greedy` `Game Theory`

## Problem Summary
The "Sum Game" involves a number represented as a string, divided into two halves of equal length. Some digits are unknown, represented by `'?'`. Two players, Alice and Bob, take turns replacing a `'?'` with a digit from '0' to '9'. Alice goes first. Alice wins if, after all `'?'` are replaced, the sum of digits in the first half is *not* equal to the sum of digits in the second half. Bob wins if the sums *are* equal. Both players play optimally to achieve their winning condition. The problem asks us to determine if Alice wins.

See the [full problem on LeetCode](https://leetcode.com/problems/sum-game/).

## Approach & Implementation

This problem is a classic game theory problem, where players make optimal moves to achieve their goals. The solution cleverly reduces the complex game to a checkable mathematical condition based on the initial sums and counts of question marks in each half.

The core idea is to analyze the difference between the sum of the left half and the sum of the right half. Alice wants to make this difference non-zero, while Bob wants to make it zero.

The implementation uses a straightforward O(N) pass to pre-calculate the necessary information and then applies a constant-time game-theoretic formula.

Here's a step-by-step breakdown:

1.  **Initialization and Pre-computation:**
    *   `int[] sum = {0, 0};`: This array stores the initial sum of known digits for each half. `sum[0]` is for the left half, `sum[1]` for the right half.
    *   `int[] q = {0, 0};`: This array stores the count of `'?'` characters for each half. `q[0]` for the left half, `q[1]` for the right half.
    *   `int n = A.length();`: Stores the total length of the input string.
    *   **Loop through the string:** The code iterates from `i = 0` to `n-1`.
        *   `int j = i / (n >> 1);`: This ingenious line determines which half the current character belongs to. `n >> 1` is equivalent to `n / 2`.
            *   For `i` from `0` to `n/2 - 1`, `i / (n/2)` will be `0`, placing the character in the `0`-th index (left half).
            *   For `i` from `n/2` to `n - 1`, `i / (n/2)` will be `1`, placing the character in the `1`-st index (right half).
        *   **Character processing:**
            *   If `A.charAt(i) == '?'`: Increment the corresponding `'?'` count in `q[j]`.
            *   Else (it's a digit): Convert the character to an integer (`A.charAt(i) - '0'`) and add it to the corresponding sum in `sum[j]`.

2.  **Game Theory Analysis and Winning Condition:**
    After iterating through the string, we have the initial sums (`sum[0]`, `sum[1]`) and question mark counts (`q[0]`, `q[1]`) for both halves. The problem can now be analyzed based on two cases:

    *   **Case 1: Total number of `'?'` is odd.**
        `((q[0] + q[1]) % 2 == 1)`
        If the total number of `'?'` characters is odd, Alice (the first player) will always make the last move. No matter what the current sums are, on her final turn, Alice can replace the last `'?'` with a digit (e.g., '0' or '1' or '9') to ensure that the sums of the two halves become unequal. Therefore, if the total `'?'` count is odd, Alice always wins.

    *   **Case 2: Total number of `'?'` is even.**
        `((q[0] + q[1]) % 2 == 0)`
        If the total number of `'?'` characters is even, Bob (the second player) will make the last move. For Bob to win, he must be able to make the sums of the two halves equal. Alice wins if she can prevent him from doing so.

        This specific type of game has a known mathematical winning condition derived from optimal play. Let:
        *   `S_L = sum[0]` (initial sum of left half)
        *   `S_R = sum[1]` (initial sum of right half)
        *   `Q_L = q[0]` (count of `'?'` in left half)
        *   `Q_R = q[1]` (count of `'?'` in right half)

        Bob can equalize the sums if and only if the initial difference `(S_L - S_R)` can be perfectly balanced by the potential contributions from the question marks. The "neutral" value a '?' contributes is considered to be `4.5` (the average of `0` and `9`). Thus, the effective target difference Bob aims for is `4.5 * (Q_R - Q_L)`. If `S_L - S_R` equals this target, Bob can achieve equality.

        Mathematically, Bob wins if:
        `S_L - S_R = 4.5 * (Q_R - Q_L)`
        Multiplying by 2 to remove the decimal:
        `2 * (S_L - S_R) = 9 * (Q_R - Q_L)`

        The code checks for the inequality (`!=`) of this condition for Alice to win:
        `((sum[0] - sum[1]) << 1) != (q[1] - q[0]) * 9`
        `<< 1` is a bitwise left shift, equivalent to multiplying by 2.
        `q[1] - q[0]` is `Q_R - Q_L`.
        So, this directly translates to `2 * (S_L - S_R) != 9 * (Q_R - Q_L)`.
        If this condition is true (meaning Bob *cannot* balance the sums), Alice wins.

    The final return statement `((q[0] + q[1]) % 2 == 1) || ((sum[0] - sum[1]) << 1) != (q[1] - q[0]) * 9;` correctly combines these two winning conditions for Alice.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The code iterates through the input string `A` once, where `N` is the length of the string. All operations inside the loop and the final conditional check are constant time.
-   **Space:** O(1) - The code uses a few fixed-size integer arrays (`sum` and `q`, each of size 2) and a few integer variables, regardless of the input string's length.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 9 ms |
| Memory | 47 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/sum-game/)
- [View My Submission](https://leetcode.com/submissions/detail/2117802124/)
