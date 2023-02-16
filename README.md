# Fractional Knapsack Problem
The fractional knapsack problem is also one of the techniques which are used to solve the knapsack problem. 
In fractional knapsack, the items are broken in order to maximize the profit. 
The problem in which we break the item is known as a Fractional knapsack problem.
## Algorithm
1. Create a array of **N** size and store profit by weight values inside the array.
2. Store array element as key and their respective index in **MultiMap**. We are using multimap for tackling same key(same profit by weight value) problem in Hashmap.
3. Sort the profit by weight array in reverse order.
4. Take whole object(i.e 1) till we get given weight exceeds remaining weight.
4. Take fraction of object from given weight from object so that remaining weight becomes zero and store it in another array.
5. Calculate total profit by multiplying array elements with respective profit.

# Job Scheduling Problem
Job scheduling is a scheduling problem for numerous jobs with given deadlines to maximize profit 
Here, our main objective is to find the sequence of jobs that maximize completion within the **deadline**. The Job Scheduling Algorithm is a **greedy algorithm** based popular problem that has wide implementations in real-world scenarios.
## Algorithm
1. First, sort the jobs in the decreasing order of their profits.
2. Then find the highest deadline among all deadlines.
3. Next, assign time slots to individual job ids.
4. Check if the maximum possible time slot for the job, i.e., its deadline, is assigned to another job or not. If it is not filled yet, assign the slot to the current job id. 
Otherwise, search for any empty time slot less than the deadline of the current job. If such a slot is found, assign it to the current job id and move to the next job id.
