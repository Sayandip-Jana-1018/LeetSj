# 3626. Smallest Divisible Digit Product I

🟢 **Easy** · `Math` `Enumeration`

## Problem Summary
The problem requires finding the smallest number that is one more than the input number and has a digit product divisible by a given number. This involves checking each subsequent number's digit product until a match is found. See the [full problem on LeetCode](https://leetcode.com/problems/smallest-divisible-digit-product-i/).

## Approach & Implementation
The provided code utilizes a simple iterative approach, which can be classified as a form of **Brute Force Enumeration**. Here's a step-by-step breakdown of how it works:
* The algorithm starts with the input number `n` and enters an infinite loop, which will break once the condition is met.
* Inside the loop, it calculates the product of the digits of the current number `n`.
* To calculate the digit product, it uses a while loop to extract each digit from `n` (by taking `n % 10`) and multiplies the current product by this digit.
* After calculating the digit product, it checks if the product is divisible by `t` by using the modulus operator (`prod % t == 0`).
* If the product is divisible by `t`, the loop breaks, and the function returns the current number `n`.
* If the product is not divisible by `t`, the loop increments `n` by 1 and repeats the process.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(t * number of digits in n) - The time complexity is estimated as such because in the worst-case scenario, the algorithm might need to check every number up to `t` times the number of digits in `n`. However, the actual time complexity may vary depending on the input values of `n` and `t`.
- **Space:** O(1) - The space complexity is constant because the algorithm only uses a fixed amount of space to store the variables `n`, `num`, and `prod`, regardless of the input size.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 42.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/smallest-divisible-digit-product-i/)
- [View My Submission](https://leetcode.com/submissions/detail/2096301352/)
