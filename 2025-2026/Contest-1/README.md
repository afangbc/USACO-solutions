# USACO SILVER 2025-2026 CONTEST 1

**Problem 1: Lineup Queries**

This is a relatively straightforward problem and is the easiest one out of the three (though the implementation is tricky). For query 1, An element x makes its first move at time 2*x, and moves inwards until it reaches time 0. Therefore, use simulation to track the location. Whenever it reaches position 0, send it to position t/2. Query 2 is trickier, because you need to track when the element at x goes back to time 0. Basically, we travel backward through time until it reaches position t at time t/2. To speed this up, we can use a "safety net". Essentially, formulate a distance that when we travel, it never overestimates the amount so that we never pass position t/2 at time t. This may underestimate by 1 or 2, but we can simply just use quick increments to solve this. Use recursion to find the answer.

The key ideas are to think of properties of the problem, including that the position shifts by 1 and that we can speed up processes.

**Problem 2: Mooclear Reactor**

**Problem 3: Sliding Window Summation**

Oh my goodness. This problem made me want to jump out of a window. Anyways, the solution is as follows: notice that in consecutive sliding windows, there are two elements that are included in one of the two windows. If the modulo of the two windows are the same, these elements are the same, otherwise, they are different. Therefore, notice we can calculate whether i, i+K, i+2K... are all reliant on eachother. Therefore, whatever is in the first K values is what decides the whole string. 

Using this mentality, think of the minimum case first. For each of the first K values, there are some values that match and some values that differ in i, i+K, i+2K... from i. Therefore, greedily at first choose the one that is best (ex. if more elements differ, make i equal to 1). However, this may not follow the initial constraint, where the first K elements need to be mod r[0]. Therefore, we need to switch one of these values. Choose the one that has the least effect when switching, in other words, the one with the minimum difference from same and different values. Now, you have the answer.

The important part of this problem is the implementation and the noticing that the fact that i, i+K, i+2K all rely on eachother. After this, everything else isn't too bad. For implementation, using xors can be convienient rather than modulo 2.
