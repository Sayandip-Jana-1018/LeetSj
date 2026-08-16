# 2156. Stone Game IX

🟡 **Medium** · `Array` `Math` `Greedy` `Minimax` `Counting` `Game Theory` `Nim Game` `Zero-Sum Game`

## Problem Summary
This problem involves determining the outcome of a game where players take turns removing stones from a pile, with specific rules governing the removal process. The goal is to decide whether a player can win the game, given the initial distribution of stones. See the [full problem on LeetCode](https://leetcode.com/problems/stone-game-ix/).

## Approach & Implementation
The provided code uses a mathematical approach based on the concept of modulo arithmetic and counting. The core idea is to analyze the distribution of stones modulo 3, as the game's rules are based on this modulo operation. Here are the main steps:
* Initialize an array `f` of size 3 to store the counts of stones modulo 3 (i.e., `f[0]` for stones that are multiples of 3, `f[1]` for stones that leave a remainder of 1 when divided by 3, and `f[2]` for stones that leave a remainder of 2 when divided by 3).
* Iterate through the input array `stones` and update the corresponding counts in the `f` array based on the modulo 3 value of each stone.
* Check the parity of `f[0]` (the count of stones that are multiples of 3) using the bitwise AND operator `&`. If `f[0]` is even, the game can be won if and only if both `f[1]` and `f[2]` are non-zero, indicating that there are stones of both types that can be used to make moves.
* If `f[0]` is odd, the game can be won if the absolute difference between `f[1]` and `f[2]` is greater than 2. This condition ensures that one player can force a win by making moves that create an imbalance in the opponent's available stones.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The code iterates through the input array `stones` once, where n is the number of stones. The iteration is the dominant operation, resulting in linear time complexity.
- **Space:** O(1) - The code uses a fixed-size array `f` of size 3 to store the counts of stones modulo 3, regardless of the input size. This results in constant space complexity.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 4 ms |
| Memory | 114.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/stone-game-ix/)
- [View My Submission](https://leetcode.com/submissions/detail/2109146057/)
