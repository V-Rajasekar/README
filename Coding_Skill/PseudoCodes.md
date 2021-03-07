## Binary Search

```algorithm
Index       p          q            r
Input A = [12, 23, 34, 45, 56, 78, 100]

Output X return the index position of the searched value. if you doesn't find it return -1
Prerequest: Sorted Array
1) set p to 0 and set r to n, 
2) while ( p <= r>) do the following
     A. set q to [(p+r)/2]
     B. if A[q] == x then return q
     C. if A[q] > x,  then set r to q -1
        else set p to q +1
3) Return -1

```

## Linear search

``` algorithm

Procedure: RECURSIVE-LINEAR-SEARCH (A,i,x): 
Inputs: Same as linear search but with added parameter i.
Outputs:  The index of an element matching x in the subarray from A[i] Through A[n], or -1 if x is not found in the array.
1) if i > n, then return -1
2) Else if A[i] == x, then return i
3) Else return RECURSIVE-LINEAR-SEARCH(A, i+1, x)

```