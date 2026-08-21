# 402. Remove K Digits

🟡 **Medium** · `String` `Stack` `Greedy` `Monotonic Stack`

## Problem Summary

The problem asks us to take a non-negative integer, given as a string `num`, and remove exactly `k` digits from it. Our goal is to form the smallest possible new number after these removals. The resulting number should not have leading zeros, unless the number itself is "0".

See the [full problem on LeetCode](https://leetcode.com/problems/remove-k-digits/).

## Approach & Implementation

This problem is a classic application of a **Greedy** strategy combined with a **Monotonic Stack**. The core idea is to build the resulting number digit by digit, always trying to ensure that smaller digits appear as early as possible. A monotonic stack is perfectly suited for this, as it allows us to easily "look back" and decide if a previously chosen digit should be replaced by a smaller current digit.

Here's a detailed breakdown of the code's logic:

*   **1. Initialize a Monotonic Stack**:
    *   A `Stack<Character> stack = new Stack<>();` is initialized. This stack will store characters (digits) in a generally increasing order from bottom to top. Our goal is to build the smallest number, which means we want to keep smaller digits and remove larger ones that appear earlier and can be "replaced" by a smaller digit later.

*   **2. Iterate Through Digits and Build the Monotonic Sequence**:
    *   `for (char digit : num.toCharArray())`: The code iterates through each character (digit) of the input string `num`.
    *   `while (!stack.isEmpty() && k > 0 && stack.peek() > digit)`: This is the crucial greedy step. For the current `digit`:
        *   If the stack is not empty (meaning there's a previous digit to compare with),
        *   `k > 0` (meaning we still have removals available),
        *   AND the digit at the `stack.peek()` (the most recently added digit) is *greater* than the `current digit`, then:
            *   `stack.pop()`: We remove the larger digit from the stack. This is a greedy choice because replacing a larger digit with a smaller one at an earlier position will always result in a smaller overall number.
            *   `k--`: We decrement `k` as one removal has been performed.
    *   `stack.push(digit)`: After potentially removing larger preceding digits, the current `digit` is pushed onto the stack. This ensures that the stack attempts to maintain a non-decreasing order (from bottom to top).

*   **3. Handle Remaining `k` Removals**:
    *   `while (k > 0 && !stack.isEmpty())`: After processing all digits from `num`, if `k` is still greater than 0, it means we weren't able to use all `k` removals by finding larger digits to replace. In this scenario, the remaining `k` digits to remove must be the largest ones currently in the stack. Due to the monotonic property, these will always be at the top (end) of the stack.
    *   `stack.pop()`: Remove the top digit.
    *   `k--`: Decrement `k`. This loop continues until `k` becomes 0 or the stack is empty.

*   **4. Construct the Resulting String**:
    *   `StringBuilder sb = new StringBuilder();`: A `StringBuilder` is used for efficient string construction.
    *   `while (!stack.isEmpty()) { sb.append(stack.pop()); }`: All remaining digits are popped from the stack and appended to the `StringBuilder`.
    *   `sb.reverse();`: Since digits were popped in reverse order of their appearance in the number, the `StringBuilder` content is reversed to get the correct sequence.

*   **5. Remove Leading Zeros**:
    *   `while (sb.length() > 0 && sb.charAt(0) == '0') { sb.deleteCharAt(0); }`: This loop handles the requirement to remove leading zeros. It repeatedly deletes the first character if it's '0' and the string is not empty.

*   **6. Handle Edge Case of Empty Result**:
    *   `return sb.length() > 0 ? sb.toString() : "0";`: Finally, if the `StringBuilder` is empty after all operations (which can happen if all digits were removed, e.g., "10" and `k=2`), the result should be "0". Otherwise, the constructed string is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(N) - Where N is the number of digits in the input string `num`.
    *   The initial `for` loop iterates `N` times. Inside the loop, each digit is pushed onto the stack once and popped at most once over the entire execution. This makes the `while` loop within the `for` loop effectively amortized O(1) per digit.
    *   The subsequent `while` loops (for remaining `k`, building the string, and removing leading zeros) iterate at most `N` times in total.
    *   Therefore, the overall time complexity is linear with respect to the input string length.

-   **Space:** O(N) - Where N is the number of digits in the input string `num`.
    *   The `Stack` can hold up to `N` characters in the worst case (e.g., if the input is "12345" and `k=0`, all digits will be pushed).
    *   The `StringBuilder` can also store up to `N` characters.
    *   Thus, the auxiliary space used scales linearly with the input size.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 27 ms |
| Memory | 47.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/remove-k-digits/)
- [View My Submission](https://leetcode.com/submissions/detail/2114841063/)
