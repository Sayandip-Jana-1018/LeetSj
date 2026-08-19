# 1487. Cinema Seat Allocation

🟡 **Medium** · `Array` `Hash Table` `Greedy` `Bit Manipulation`

## Problem Summary

The problem asks us to determine the maximum number of four-person families that can be seated in a cinema. We are given the total number of rows, `n`, and a list of specific seats that are already reserved. Each row has 10 seats, numbered 1 through 10. A four-person family must be seated in a contiguous block of four available seats. There are three possible blocks within a row that can accommodate a family:
1.  Seats 2, 3, 4, 5
2.  Seats 6, 7, 8, 9
3.  Seats 4, 5, 6, 7 (this block overlaps with both of the above)

We need to maximize the total number of families seated across all rows, keeping in mind that the two non-overlapping groups (2-5 and 6-9) can host two families in a single row. If these are not both available, we might still be able to seat one family in one of these groups, or in the overlapping 4-7 group.

See the [full problem on LeetCode](https://leetcode.com/problems/cinema-seat-allocation/).

## Approach & Implementation

The core idea of the provided solution is to use **Bit Manipulation** to efficiently represent and check the availability of seats within each row, combined with a **Greedy** strategy to maximize family placements. Since `n` (number of rows) can be very large (up to 10^9), but the number of reserved seats is relatively small (up to 10^5), the solution smartly focuses only on the rows that actually have reserved seats.

Here's a detailed breakdown of the implementation:

*   **Step 1: Representing Reserved Seats with Bitmasks**
    *   A `HashMap<Integer, Integer> rowToReserved` is used to store the reservation status for each row. The key is the row number (`int`), and the value is an `int` acting as a bitmask.
    *   The code iterates through the `reservedSeats` array. For each `(row, col)` pair:
        *   `1 << col`: A bitmask is created where only the bit corresponding to the `col` (seat number) is set to 1. For example, `1 << 1` for seat 1, `1 << 2` for seat 2, etc. (Note: standard bit manipulation often uses 0-indexed bits, but here it's implicitly 1-indexed to match seat numbers).
        *   `rowToReserved.getOrDefault(row, 0)`: This retrieves the current bitmask for the given `row`. If no seats have been reserved in this row yet, it defaults to `0`.
        *   `|`: The bitwise OR operator combines the current row's mask with the bit representing the newly reserved seat. This effectively sets the `col`-th bit in the `rowToReserved` map's value, marking that seat as reserved without affecting other bits.

*   **Step 2: Initializing Maximum Families**
    *   `int maxFamilies = n * 2;`
    *   The solution starts by assuming an optimistic scenario: every one of the `n` rows can accommodate two families. This is based on the idea that two non-overlapping blocks (seats 2-5 and 6-9) can theoretically be free in every row. This provides an upper bound, and the count will be adjusted downwards for rows with reservations.

*   **Step 3: Defining Family Seat Blocks with Bitmasks**
    *   Three specific bitmasks are defined to represent the contiguous blocks of four seats suitable for a family:
        *   `int leftMask = 60;` (Binary: `00111100`)
            *   This mask represents seats 2, 3, 4, 5 (`2^2 + 2^3 + 2^4 + 2^5 = 4 + 8 + 16 + 32 = 60`).
        *   `int rightMask = 960;` (Binary: `001111000000`)
            *   This mask represents seats 6, 7, 8, 9 (`2^6 + 2^7 + 2^8 + 2^9 = 64 + 128 + 256 + 512 = 960`).
        *   `int middleMask = 240;` (Binary: `000011110000`)
            *   This mask represents seats 4, 5, 6, 7 (`2^4 + 2^5 + 2^6 + 2^7 = 16 + 32 + 64 + 128 = 240`). This is the overlapping block.

*   **Step 4: Processing Rows with Reservations**
    *   The code then iterates through the `values()` of the `rowToReserved` map. This loop only processes rows that have at least one reserved seat. Rows without any reservations are implicitly handled by the initial `n * 2` calculation.
    *   `maxFamilies -= 2;`: For each row encountered in `rowToReserved` (meaning it has *some* reservation), we pessimistically subtract two families from our `maxFamilies` count. The logic then adds back families based on the actual free seat blocks. This is part of the greedy strategy.
    *   **Checking Block Availability:**
        *   `boolean leftFree = (reservedMask & leftMask) == 0;`
        *   `boolean rightFree = (reservedMask & rightMask) == 0;`
        *   `boolean middleFree = (reservedMask & middleMask) == 0;`
        *   A bitwise AND (`&`) operation checks if any bits set in `reservedMask` (reserved seats) overlap with the bits set in a `specificMask` (a family block). If the result is `0`, it means there are no reserved seats in that particular block, so it's `free`.
    *   **Greedy Family Placement Logic:**
        *   `if (leftFree && rightFree)`: If both the `leftMask` block (seats 2-5) and the `rightMask` block (seats 6-9) are completely free, then two families can be seated in this row. `maxFamilies` is incremented by `2` (restoring the two we subtracted).
        *   `else if (leftFree || rightFree || middleFree)`: If the above condition isn't met (meaning we can't seat two families), this `else if` checks if *any* single family block (2-5, 6-9, or 4-7) is free. If even one block is free, then one family can be seated. `maxFamilies` is incremented by `1` (restoring one family).

*   **Step 5: Return Final Count**
    *   `return maxFamilies;` The final calculated maximum number of families is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

*   **Time:** O(R)
    *   **Populating `rowToReserved`**: Iterating through `reservedSeats` takes O(R) time, where R is the number of reserved seats. HashMap operations (`put`, `getOrDefault`) take O(1) time on average.
    *   **Initializing `maxFamilies`**: O(1).
    *   **Iterating `rowToReserved.values()`**: The number of distinct rows with reservations (`rowToReserved.size()`) is at most `R` and at most `n`. Therefore, this loop runs at most O(min(N, R)) times. Since `R` is typically much smaller than `N` (e.g., `R <= 10^5`, `N <= 10^9`), this is effectively O(R). Inside the loop, all bitwise operations and comparisons are O(1).
    *   **Total**: O(R + min(N, R)) which simplifies to O(R).

*   **Space:** O(min(N, R))
    *   The `rowToReserved` HashMap stores an entry for each row that has at least one reserved seat. The number of such rows can be at most `n` (total rows) and at most `R` (total reserved seats). Therefore, the map will store at most `min(N, R)` entries, each taking O(1) space.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 20 ms |
| Memory | 50.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/cinema-seat-allocation/)
- [View My Submission](https://leetcode.com/submissions/detail/2112333832/)
