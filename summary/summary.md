# Table of content

[//]: # (TODO Add)

# Links

- [Programiz course](https://www.programiz.com/dsa/algorithm)
- [Algorithms and data structures in JS](https://github.com/trekhleb/javascript-algorithms)
- Data structures in Habr: 
  - [Article 1](https://habr.com/ru/companies/netologyru/articles/334914/)
  - [Article 2](https://habr.com/ru/articles/128457/)

# Algorithms 

In computer programming terms, an algorithm is a set of well-defined instructions to solve a particular problem. It takes a set of input(s) and produces the desired output.

- input and output should be defined precisely, 
- each step in the algorithm should be clear and unambiguous, 
- algorithms should be most effective among many ways to solve a problem.
- algorithm should be generic (for usage with any programming language)

## Algorithms complexity

**Asymptotic analysis** is measure of how performance has changed with the change of the input size. 

**Why?**
- Compare algorithms
- Predict behavior
- Provability

**Key thing** - consuming resources (time, RAM | Disk space, network, CPU, hardware etc)  

**Cases**: best, average, worst, excepted, every.

**Measures** 
- Big O notation - the worse case
- Omega notation - the best case
- Theta notation - the average case

### Big O
  - f(n) steps = O(f(N))
  - g(N) steps followed by f(N) steps ⇒ O(g(N) + f(N))
  - g(N) steps followed by f(N) steps, if f(N) > g(N) ⇒ O(f(N))
  - g(N) for each f(N) ⇒ O(g(N) * f(N))
  - O(C*f(N)) = O(f(N))

![Algorithms complexity](/pictures/complexity.png)

### Masters theorem
For estimation of recurrence relations.

![img.png](pictures/masters.png)

### Divide and Conquer Algorithms

1. *Divide*: Divide the given problem into sub-problems (using recursion).
2. *Conquer*: Solve the smaller sub-problems recursively. If the subproblem is small enough, then solve it directly.
3. *Combine*: Combine the solutions of the sub-problems.

Complexity according to the [Masters theorem](#Masters-theorem): **O(n log n)**

*Pros*:
- usually  memory-safe,
- suitable for multithreaded programs

Don't store the result of any sub-problem for future referencing (in difference with dynamic algorithms)

### P vs NP

P - algorithms with deterministic number of steps, []
NP - algorithms without deterministic number of steps where you need to make assumptions but the solution if found can be checked for a deterministic time.

## Numerical algorithms 

### Random numbers
- PRNG - *pseudorandom number generators* (having know the algorithms & (initial stage | sequence of numbers), the next numbers can be predicted)
- CRNG - *cryptographic random number generators* (hard to predict the sequence of numbers)
- TRNG - *true random number generators* (use random fluctuations to generate numbers, very slow)

### Linear Congruential generators
Generator of a linear sequence of numbers.   
`X<sub>(n+1)</sub> = X<sub>n</sub> * A + B (mod M)`

### Randomizing arrays
Basically, swapping two elements randomly. 
Probabilities: 
- not being picked by (k-1): `(N-(k-1))/N`
- being picked for position k: `1/N`  
Usage
- randomize an array
- pick random values without duplication
- pick N of M

### GDC & LCM

**GCD** - greatest common division (the greatest number on which both A and B can be divided). Use *Euclid's algorithm* (complexity = O(log(n))).  
**LCM** - least common multiple (the lowest number that can be divided on A and B)
```bash
LCM = (A,B) / GDC(A,B)
# trick: divide A on GDC
LCM = (A / GDC(A,B)) * B 
```

### Primes

**Prime factorization** is a process of splitting a number into prime multipliers. Algorithm = check all numbers from 2 to a square root of the input. 

# Data structures

Data structure is a storage that is used to store and organize data. It is a way of arranging data on a computer so that it can be accessed and updated efficiently.

- **linear** (array, linked list, stack, queue)
  - complexity increase proportionally to data set size
  - pretty simple, but less efficient in memory consumption
  - can be traversed by one pass
- **non-linear** (graph, tree):
  - keep the same level of complexity with increasing amount of data
  - more complex, but more efficient in memory consumption,
  - can't be traversed by one pass

## Linear

### Stack

![img.png](pictures/stack.png)

*LIFO* - last-in, first-out

Operations:
  - push - add an element to the top
  - pop - remove an element from the top
  - peek - get an element from the top without removing
  - isEmpty
  - isFull

| Space | Search | Insertion | Deletion | 
|:-----:|:------:|:---------:|:--------:|
| O(n)  | 	O(n)  |   O(1)    |   O(1)   | 


### Queue

![img.png](pictures/queue.png)

*FIFO* - first in, first out

Operations
  - enqueue (offer) - add an element to the bottom, **O(1)**
  - dequeue (poll) - withdraw an element from the top, **O(1)**
  - peek - get an element from the top **O(1)**
  - isEmpty
  - isFull

Types:
  - *circular queue* - better memory utilization: when the rear index reach the end of the array, we can use free slots in the beginning
  - *priority queue* - all elements have their priority and are processed regarding this priority (implementation based on LinkedList, BinaryHeap, or BinaryTree)
  - *dequeue* - insertion and removal can be performed from both sides. 

| Space | Search | Insertion | Deletion | 
|:-----:|:------:|:---------:|:--------:|
| O(n)  | 	O(n)  |   O(1)    |   O(1)   | 


### LinkedList

Linear data structure that includes a series of connected nodes, where each node stores the data and the address of the next node.

![LinkedList.png](pictures/linked-list.png)

**Types**
- singly - each node points to the next one
- doubly - two pointers in each node: to the previous and the consequent elements
- circular - last elements has a reference to the first one

**Operations**
- traverse - go through all nodes of the list
- insert
- delete
- search - find a node
- sort

| Space | Search/Traverse | Insertion | Deletion |
|:-----:|:---------------:|:---------:|:--------:|
| O(n)  |      O(n)       |   O(1)    |   O(1)   | 

## Tree

Data structure consisting of *nodes* (key | value + a pointer to the next node) and *edges* (links between nodes). 

**Terminology**:
- *root* - the top node, 
- *leaf* - node without a pointer to the next node,
- *internal node* - node with a pointer to the next node,
- *height of the node* - number of edges from a node to the deepest leaf (bottom)
- *depth of the node* - number of edges from a node to the root (up)
- *height of the tree* - number of edges from a node to the root to the deepest leaf
- *degree of node* - number of branches the node have
- *forest* - several disjoint trees. 

### Heap

Complete *binary tree* that satisfy to one of the *heap properties*:
- *max heap property* - a node is always greater than its children and the root is maximum
- *min heap property* - a node is always smaller than its children and the root is minimum

![Max heap](pictures/max-heap.png)

Operations:
- heapify - create a heap from a linear structure | restructure it
- insert - add an element (node) and heapify
- delete - delete an element and heapify
- peek (max/min) - get the root
- extract (max/min) - poll the root and heapify 

| Peek | Search | Insertion | Deletion  | Space |
|:----:|:------:|:---------:|:---------:|:-----:|
| O(1) | 	O(n)  | O(log(n)) | O(log(n)) | O(n)  |




## Other

## Hash Table

Data structure that store elements in key-value pairs: *key* - indexes of values, *values* - associated data stored in e.g. array. 

![HashTable.png](pictures/hash-table.png)

*Hash function* is used to calculate a key. 
The key feature of the hash function is the ability to avoid *collisions* (situations when the hash function generate the same keys for different values).

**Collision resolving**
- chaining (LinkedList connected to a index)
- open addressing (calculating a new index)
  - linear probing - set the value in adjacent slots 
  - quadratic probing - slots increase quadratic (not linear)
  - double hashing - calculate hash one more time

**Good hashing functions**
- division - ```k mod m``` (k - key, m - size of a table)
- multiplication
- universal - index is chosen independent from keys. 

| Space | Search* | Insertion* | Deletion* |
|:-----:|:-------:|:----------:|:---------:|
| O(n)  |  O(1)   |    O(1)    |   O(1)    | 

<sup>*</sup> Search, Insertion and deletion operations can be O(n) when:
- using bad hashing function (all pair are in the same index slot). 
- hash table is full and we need to re-structure it. 