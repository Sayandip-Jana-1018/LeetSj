# 402. Remove K Digits

🟡 **Medium** · `String` `Stack` `Greedy` `Monotonic Stack`

This documentation details a LeetCode solution for the "Remove K Digits" problem, focusing on its implementation and complexity.

---

## Problem Summary
The problem asks us to find the smallest possible integer that can be obtained by removing exactly `k` digits from a given non-negative integer represented as a string. The resulting number should not have leading zeros, unless the number itself is "0".

See the [full problem on LeetCode](https://leetcode.com/problems/remove-k-digits/).

## Approach & Implementation
The core idea behind this solution is a **Greedy** strategy combined with a **Monotonic Stack**. To obtain the smallest possible number, we want to ensure that smaller digits appear at more significant positions (further to the left).

The algorithm processes the digits of the input number one by one, deciding whether to keep the current digit or to use one of our `k` removals to discard a previously kept (larger) digit.

Here's a step-by-step breakdown of the provided code:

*   **1. Base Case Handling:**
    *   `if(k==num.length()){ return "0"; }`
    *   If `k` is equal to the length of the number, it means all digits are removed. The problem specifies that in this scenario, the result should be "0".

*   **2. Initialization:**
    *   `char[] d = num.toCharArray();`: Converts the input `String num` into a character array for easier processing.
    *   `char[] st = new char[d.length];`: This array will act as our "stack" to build the result. It stores digits that form a candidate for the smallest number.
    *   `int top=-1;`: `top` is the stack pointer, initialized to -1 (empty stack).
    *   `int rem=k;`: `rem` keeps track of the number of digits we still need to remove.

*   **3. Building the Monotonic Stack (Greedy Removal Loop):**
    *   `for(int i=0;i<d.length;i++)`: Iterate through each digit `d[i]` of the input number.
    *   `while(rem>0 && top>=0 && st[top]>d[i])`: This is the crucial greedy step. While we still have removals left (`rem > 0`), the stack is not empty (`top >= 0`), AND the digit at the top of our stack (`st[top]`) is greater than the current digit `d[i]`:
        *   `top--;`: Pop the larger digit from the stack.
        *   `rem--;`: Decrement the count of remaining removals.
        *   The logic here is: if we encounter a digit `d[i]` that is smaller than a digit already in our result (at `st[top]`), we should remove the larger `st[top]` to make way for `d[i]`. This helps ensure the leftmost digits are as small as possible.
    *   `top++; st[top]=d[i];`: After potentially removing larger digits, push the current digit `d[i]` onto the stack. This maintains a non-decreasing order of digits from bottom to top in the stack (a "monotonic stack").

*   **4. Handling Remaining Removals (If Any):**
    *   After the loop, the `st` array will contain `d.length - (k - rem)` digits (effectively, `d.length - k_removed` where `k_removed` is the actual number of digits removed by popping). The total number of digits we *want* in our final result is `d.length - k`.
    *   If `rem > 0` after the loop (meaning we didn't use all `k` removals in the greedy step, perhaps because the remaining digits were already in increasing order, like "12345"), the stack `st` will have `d.length - rem` elements. To remove the remaining `rem` digits and get the smallest number, we must remove them from the end of the stack (least significant positions), as the stack is already non-decreasing.
    *   The later `String.valueOf` call implicitly handles this by only considering the first `d.length - k` elements of the `st` array.

*   **5. Removing Leading Zeros:**
    *   `int start=0;`: `start` will track the beginning index of our final result string.
    *   `while(st[start]=='0' && start<d.length-k-1)`: This loop advances `start` past any leading zeros.
        *   It continues as long as the current digit is '0' AND we are not at the very last digit of what *should be* the final number (e.g., if the desired result is "0", we shouldn't skip the only '0'). `d.length-k` is the total length of the desired final number. `d.length-k-1` is the index of the last character if the desired string has length `d.length-k`. If `start` reaches `d.length-k-1` and `st[start]` is '0', it means the final number is "0", and we should stop.

*   **6. Constructing the Result:**
    *   `return String.valueOf(st,start,d.length-k-start);`
    *   `String.valueOf(char[] data, int offset, int count)` constructs a string from a character array.
    *   `st`: The character array holding our processed digits.
    *   `start`: The starting index after skipping leading zeros.
    *   `d.length-k-start`: The desired length of the final number (total `d.length - k` digits) minus the number of leading zeros skipped (`start`).

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The main loop iterates through each character of the input string `num` once (N operations). Inside the loop, each character is pushed onto the stack once and popped from the stack at most once. Therefore, both push and pop operations combined contribute O(N) time. The final leading zero removal and string construction also take at most O(N) time.
-   **Space:** O(N) - A character array `st` of size N is used to store the intermediate result (acting as a stack). Another character array `d` of size N is used to convert the input string.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 3 ms |
| Memory | 46.2 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/remove-k-digits/)
- [View My Submission](https://leetcode.com/submissions/detail/2114841268/)
