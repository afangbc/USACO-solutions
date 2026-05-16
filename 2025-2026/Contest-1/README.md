# USACO SILVER 2025-2026 CONTEST 1

**Problem 1: Lineup Queries**

**Problem 2: Mooclear Reactor**

**Problem 3: Sliding Window Summation**

Oh my goodness. This problem made me want to jump out of a window. Anyways, the solution is as follows: notice that in consecutive sliding windows, there are two elements that are included in one of the two windows. If the modulo of the two windows are the same, these elements are the same, otherwise, they are different. Therefore, notice we can calculate whether i, i+K, i+2K... are all reliant on eachother. Therefore, whatever is in the first K values is what decides the whole string. 

Using this mentality, think of the minimum case first. For each of the first K values, there are some values that match and some values that differ in i, i+K, i+2K... from i. Therefore, greedily at first choose the one that is best (ex. if more elements differ, make i equal to 1). However, this may not follow the initial constraint, where the first K elements need to be mod r[0]. Therefore, we need to switch one of these values. Choose the one that has the least effect when switching, in other words, the one with the minimum difference from same and different values. Now, you have the answer.

The important part of this problem is the implementation and the noticing that the fact that i, i+K, i+2K all rely on eachother. After this, everything else isn't too bad. For implementation, using xors can be convienient rather than modulo 2.
