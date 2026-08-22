# 3918. Check Divisibility by Digit Sum and Product

🟢 **Easy** · `Math`

## Problem Summary
The problem asks us to determine if a given positive integer `n` is perfectly divisible by a specific value. This value is calculated by first finding the sum of all its digits and the product of all its digits. Then, we sum these two results (the digit sum and the digit product). Finally, we check if the original integer `n` is divisible by this combined sum.
See the [full problem on LeetCode](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/).

## Approach & Implementation
The core technique used in this solution is **Digit Extraction and Processing**. This pattern involves iteratively extracting the last digit of a number and performing operations on it, then removing that digit until the number becomes zero.

Here's a detailed breakdown of the implementation:

*   **Initialization:**
    *   `int num = n;`: A copy of the original number `n` is stored in `num`. This is crucial because we need `n` later for the final divisibility check, while `num` will be modified (reduced) during the digit extraction process.
    *   `int sum = 0;`: A variable `sum` is initialized to `0`. This will accumulate the sum of all digits of `n`.
    *   `int prod = 1;`: A variable `prod` is initialized to `1`. This will accumulate the product of all digits of `n`. It's initialized to `1` because multiplying by `0` (if initialized to `0`) would make the product always `0`, regardless of other digits.

*   **Digit Extraction Loop:**
    *   `while(num > 0)`: This loop continues as long as `num` has at least one digit remaining (i.e., it's a positive number).
    *   `sum += num % 10;`:
        *   `num % 10` calculates the remainder when `num` is divided by `10`. This effectively extracts the last (rightmost) digit of `num`.
        *   This extracted digit is then added to the `sum` variable.
    *   `prod *= num % 10;`:
        *   The same extracted last digit (`num % 10`) is multiplied with the current value of `prod`. This updates `prod` to include the current digit.
    *   `num /= 10;`:
        *   `num / 10` performs integer division, effectively removing the last digit from `num`. For example, if `num` was `123`, it becomes `12`. This prepares `num` for the next iteration to extract the new last digit.

*   **Final Divisibility Check:**
    *   `return n % (sum + prod) == 0;`:
        *   After the loop finishes, `sum` holds the total sum of digits of the original `n`, and `prod` holds the total product of digits of the original `n`.
        *   The expression `(sum + prod)` calculates the combined value that `n` needs to be divisible by.
        *   `n % (sum + prod)` checks if `n` has a remainder of `0` when divided by this combined value.
        *   The method returns `true` if it is divisible, and `false` otherwise.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(log N) - The `while` loop iterates once for each digit in the input number `n`. The number of digits in an integer `n` is proportional to `log10(n)`. Thus, the time complexity grows logarithmically with the value of `n`.
-   **Space:** O(1) - The algorithm uses a fixed number of variables (`num`, `sum`, `prod`) regardless of the magnitude of the input integer `n`. No auxiliary data structures are used that scale with `n`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 42.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)
- [View My Submission](https://leetcode.com/submissions/detail/2115672129/)
