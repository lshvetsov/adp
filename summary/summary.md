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

## Stack

![img.png](pictures/stack.png)

- *LIFO* - last-in, first-out
- operations:
  - push - add an element to the top
  - pop - remove an element from the top
  - peek - get an element from the top without removing
  - isEmpty
  - isFull

## Queue

![img.png](pictures/queue.png)

- *FIFO* - first in, first out
- operations
  - enqueue (offer) - add an element to the bottom, **O(1)**
  - dequeue (poll) - withdraw an element from the top, **O(1)**
  - peek - get an element from the top **O(1)**
  - isEmpty
  - isFull
- types:
  - *circular queue* - better memory utilization: when the rear index reach the end of the array, we can use free slots in the beginning
  - *priority queue* - all elements have their priority and are processed regarding this priority. 
  - *dequeue* - insertion and removal can be performed from both sides. 


