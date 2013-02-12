KissingNumberProblem
====================

A small approach to the Kissing number problem

The class KissingNumberProblem.java contains the function kissTest.
It's first argument is the Dimension of the testing it's second argument the number of spheres.
For those who don't know the Kissing number problem: http://en.wikipedia.org/wiki/Kissing_number_problem

It's not possible to proof values with this algorithm, but we can find lower limits and guesses.


Solutions of the project
========================

Calculation times o a 32-bit singlecore, Intel pentium M 1.73 GHz, 1.5 GB SD-RAM

1 dimension, 2 spheres:
KissingNumber(1) = 2

2 dimensions, 5 spheres: 2 seconds
2 dimensions, 6 spheres: 6 seconds
KissingNumber(2) = 6

3 dimensions, 11 spheres: 18 seconds
3 dimensions, 12 spheres: 14 seconds
KissingNumber(3) = 12

4 dimensions, 19 spheres: 45 seconds
4 dimensions, 20 spheres: 1 minute 58 seconds
4 dimensions, 21 spheres:
4 dimensions, 22 spheres:
4 dimensions, 23 spheres:
4 dimensions, 24 spheres:
KissingNumber(4) = 24
