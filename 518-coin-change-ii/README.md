# 518. Coin Change II

🟡 **Medium** · `Array` `Dynamic Programming`

## Problem Summary

The problem asks us to calculate the total number of distinct combinations of coins that sum up to a given target `amount`. We are provided with an array of coin denominations, and we can use each coin as many times as needed (unlimited supply). We only care about unique combinations, meaning the order of coins does not matter (e.g., [1, 2] is the same as [2, 1]).

See the [full problem on LeetCode](https://leetcode.com/problems/coin-change-ii/).

## Approach & Implementation

The provided solution uses **Dynamic Programming** to solve this problem. This is a classic variation of the unbounded knapsack problem or the coin change problem where we count combinations.

The core idea is to build up a solution for the target `amount` by leveraging previously calculated solutions for smaller amounts.

Here's a detailed breakdown of the implementation:

*   **Data Structure:**
    *   An integer array `dp` of size `amount + 1` is used.
    *   `dp[i]` will store the number of ways to make change for amount `i` using the coins processed so far.

*   **Initialization:**
    *   `dp[0] = 1;`
        *   This is the base case. There is exactly one way to make an amount of 0: by using no coins. This initialization is crucial because it acts as the starting point for building up solutions for larger amounts. For example, if we have a coin of value `X`, and we want to find ways to make `X`, we can take one `X` coin and combine it with 0 (which has 1 way).

*   **Outer Loop (Iterating through Coins):**
    *   `for (int coin : coins)`:
        *   This loop iterates through each available `coin` denomination one by one.
        *   **Crucial Insight:** Iterating coins in the outer loop ensures that we count combinations, not permutations. When we process a `coin`, we update `dp` values considering this `coin` *in addition to all previously processed coins*. This prevents double-counting combinations (e.g., [1, 2] and [2, 1] are treated as the same combination).

*   **Inner Loop (Iterating through Amounts):**
    *   `for (int i = coin; i <= amount; i++)`:
        *   For each `coin`, this loop iterates through all possible `amounts` from the value of the current `coin` up to the target `amount`.
        *   We start `i` from `coin` because it's only possible to use the current `coin` if the target `amount i` is at least its value.

*   **Recurrence Relation:**
    *   `dp[i] = dp[i] + dp[i - coin];`
        *   This is the heart of the dynamic programming approach. When considering the current `coin` and target `amount i`:
            *   `dp[i]` (the value *before* this update) represents the number of ways to make `amount i` *without* using the current `coin` (i.e., using only coins processed *before* the current `coin` in the outer loop).
            *   `dp[i - coin]` represents the number of ways to make the remaining `amount (i - coin)` using *any* of the coins processed so far (including the current `coin`, potentially multiple times).
            *   By adding `dp[i - coin]` to `dp[i]`, we are combining two possibilities to make `amount i` using the coins processed up to this point:
                1.  **Not using the current `coin`**: The number of ways is `dp[i]` (from before the update with the current `coin`).
                2.  **Using the current `coin` at least once**: If we use the current `coin`, the remaining amount we need to make is `i - coin`. The number of ways to make this remaining amount is `dp[i - coin]`.
        *   This sum gives us the total number of ways to make `amount i` considering the current `coin` and all previous coins.

*   **Final Result:**
    *   `return dp[amount];`
        *   After both loops complete, `dp[amount]` will hold the total number of distinct combinations of coins that sum up to the target `amount`.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(amount * number\_of\_coins)
    -   The outer loop iterates `number_of_coins` times (let's say `N`).
    -   The inner loop iterates up to `amount` times (let's say `M`).
    -   Therefore, the total time complexity is proportional to `N * M`.
-   **Space:** O(amount)
    -   We use a `dp` array of size `amount + 1` to store intermediate results. This array's size directly depends on the `amount`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 5 ms |
| Memory | 42.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/coin-change-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2075001988/)
