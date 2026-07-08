# Exercise 7: Financial Forecasting

## 1. Understand Recursive Algorithms

**Recursion**
Recursion is a programming technique where a method calls itself to solve smaller instances of the same problem. A recursive algorithm typically consists of two parts:
1. **Base Case**: A condition that stops the recursion.
2. **Recursive Case**: A reduction of the original problem into a smaller sub-problem, followed by a recursive call.

Recursion can simplify code, especially for problems that have a natural self-similar structure (like tree traversal, generating combinations, or financial compound growth).

## 2. Analysis

**Time Complexity of Recursive Algorithm**
The time complexity of the simple recursive approach for predicting future value is **O(N)**, where N is the number of years. This is because the method makes exactly one recursive call for each year until it reaches the base case (years = 0).

**Optimization**
To optimize recursive solutions and avoid excessive computation (like overlapping subproblems in more complex recursive trees, e.g., Fibonacci sequence), we can use **Memoization**. 
Memoization stores the results of expensive function calls and returns the cached result when the same inputs occur again. 
For this specific linear recursion, memoization can prevent redundant calculations if the function is called multiple times with the same parameters. However, the most optimized approach to avoid recursive overhead (like call stack overflow) is to use an **iterative approach** (O(N) time and O(1) space) or a **direct mathematical formula** (`initialValue * Math.pow(1 + growthRate, years)`), which executes in O(1) time complexity.
