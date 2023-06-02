# Algorithms 

## Algorithms complexity

**Why?**
- Compare algorithms
- Predict behavior
- Provability

**Key thing** - consuming resources (time, RAM | Disk space, network, CPU, hardware etc)  
*Cases*: best, average, worst, excepted, every.  
**Big O** - estimate the worst scenario. *Rules*:
  - f(n) steps = O(f(N))
  - g(N) steps followed by f(N) steps ⇒ O(g(N) + f(N))
  - g(N) steps followed by f(N) steps, if f(N) > g(N) ⇒ O(f(N))
  - g(N) for each f(N) ⇒ O(g(N) * f(N))
  - O(C*f(N)) = O(f(N))

![Algorithms complexity](/pictures/complexity.png)

**P vs NP**: P - algorithms with deterministic number of steps, NP - algorithms without deterministic number of steps where you need to make assumptions but the solution if found can be checked for a deterministic time.

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

