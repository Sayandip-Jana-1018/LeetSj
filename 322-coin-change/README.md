# 322. Coin Change

🟡 **Medium** · `Array` `Dynamic Programming` `Breadth-First Search`

## Problem Summary
The "Coin Change" problem asks us to find the minimum number of coins required to make up a given `amount`, given an array of `coins` of different denominations. We are allowed to use each coin an unlimited number of times. If the target `amount` cannot be formed by any combination of the given coins, the function should return -1.

See the [full problem on LeetCode](https://leetcode.com/problems/coin-change/).

## Approach & Implementation
The provided solution utilizes a **Dynamic Programming** approach to solve the Coin Change problem. It employs a bottom-up strategy, building solutions for smaller amounts first, which are then used to solve larger amounts up to the target.

Here's a detailed breakdown of the implementation:

*   **Data Structure (`dp` array):**
    *   An integer array `dp` of size `amount + 1` is created.
    *   `dp[i]` is designed to store the minimum number of coins needed to make an amount `i`.

*   **Initialization:**
    *   `Arrays.fill(dp, amount + 1);`: All elements of the `dp` array are initially filled with `amount + 1`. This value acts as an indicator for "infinity" or "unreachable." Since the maximum possible number of coins to make `amount` would be `amount` itself (if all coins were 1), `amount + 1` is guaranteed to be larger than any valid minimum coin count. This helps in correctly identifying amounts that cannot be formed.
    *   `dp[0] = 0;`: The base case is set. It takes `0` coins to make an `amount` of `0`.

*   **Dynamic Programming Iteration:**
    *   The outer loop `for (int i = 1; i <= amount; i++)` iterates through all possible amounts from `1` up to the target `amount`. In each iteration `i`, the goal is to calculate `dp[i]`, i.e., the minimum coins for amount `i`.
    *   The inner loop `for (int coin : coins)` iterates through each available coin denomination.
    *   **Conditional Check (`if (i - coin >= 0)`):** This condition ensures that we are only considering coins that can actually be subtracted from the current amount `i` without resulting in a negative amount. In other words, we can only use a `coin` if `i - coin` is a valid amount that could have been formed previously.
    *   **DP Transition (`dp[i] = Math.min(dp[i], dp[i - coin] + 1);`):**
        *   If the condition is met, we consider using the current `coin` to make amount `i`.
        *   If we use `coin`, then the remaining amount `i - coin` must be formed using `dp[i - coin]` coins.
        *   Adding `1` (for the current `coin` we just used) gives us a candidate value for the minimum coins needed to make amount `i`.
        *   `Math.min()` is used because `dp[i]` might already have a value from a previous `coin` consideration. We always want to store the absolute minimum number of coins.

*   **Final Result:**
    *   After the nested loops complete, `dp[amount]` will hold the minimum number of coins required to make the target `amount`.
    *   The final return statement `return dp[amount] > amount ? -1 : dp[amount];` checks if `dp[amount]` is still `amount + 1` (our "infinity" placeholder).
        *   If `dp[amount]` is `amount + 1`, it means the target `amount` could not be formed by any combination of the given coins, so `-1` is returned.
        *   Otherwise, the calculated minimum coin count `dp[amount]` is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(amount * |coins|)
    -   The outer loop runs `amount` times (from 1 to `amount`).
    -   The inner loop iterates through each `coin` in the `coins` array, which has `|coins|` elements.
    -   Inside the loops, operations are constant time.
    -   Therefore, the total time complexity is proportional to `amount` multiplied by the number of coin denominations.
-   **Space:** O(amount)
    -   An integer array `dp` of size `amount + 1` is used to store the intermediate results.
    -   The space required grows linearly with the target `amount`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 15 ms |
| Memory | 46.2 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/coin-change/)
- [View My Submission](https://leetcode.com/submissions/detail/2074889479/)
