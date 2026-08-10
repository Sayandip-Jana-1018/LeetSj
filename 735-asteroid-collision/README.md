# 735. Asteroid Collision

🟡 **Medium** · `Array` `Stack` `Simulation`

## Problem Summary
The problem involves simulating a collision between asteroids moving in opposite directions. Each asteroid has a size and direction, and when two asteroids collide, the larger one survives. If both asteroids are of the same size, they both get destroyed. The goal is to determine the state of the asteroids after all collisions have occurred. See the [full problem on LeetCode](https://leetcode.com/problems/asteroid-collision/).

## Approach & Implementation
The approach used in the provided code is based on a **Stack** data structure. Here's a step-by-step breakdown of the algorithm:
* The code initializes an empty stack to store the asteroids.
* It then iterates over each asteroid in the input array.
* For each asteroid, it checks if the stack is not empty and the top asteroid on the stack is moving in the opposite direction (i.e., has a positive value) and the current asteroid is moving in the negative direction.
* If the above condition is met, it compares the sizes of the two asteroids:
  + If the top asteroid on the stack is smaller, it gets destroyed (popped from the stack), and the process repeats with the next asteroid on the stack.
  + If the top asteroid on the stack is larger, the current asteroid gets destroyed, and the loop breaks.
  + If both asteroids are of the same size, they both get destroyed (the top asteroid is popped from the stack, and the current asteroid is not added to the stack).
* If the asteroid survives the collision (i.e., the stack is empty or the top asteroid is moving in the same direction), it gets pushed onto the stack.
* Finally, the code creates a result array and fills it with the asteroids remaining on the stack, in the reverse order they were added.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The code iterates over each asteroid in the input array once, and the while loop inside the for loop can also iterate up to n times in the worst case (when all asteroids are moving in opposite directions). However, since each asteroid is pushed and popped from the stack at most once, the total time complexity remains linear.
- **Space:** O(n) - In the worst case, all asteroids might be added to the stack (e.g., when all asteroids are moving in the same direction), resulting in a space complexity of O(n).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 5 ms |
| Memory | 46.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/asteroid-collision/)
- [View My Submission](https://leetcode.com/submissions/detail/2101253533/)
