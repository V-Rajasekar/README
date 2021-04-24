what is an algorithm ? 

Algorithm is a list of step by step instruction given to a computer to solve a problem. 

### Linear (Single Loop)

Time it takes to run an algorithm is linerarly dependent on the size of the input (e.g) Iterating the entire list once

```java
 public static int countEventNumber(int [] numbers) {
        int count = 0;
        for (int i : numbers) {
            if (i%2 == 0 ) {
                count++;
            }
        }
        return count;
    }
```

### Constant Time  (No loop)

Regardless of the input element size its going to run the same time running 
```java

public int getElementFrom(int [] a, int index) {
    return a[index];
}
```

### Quadratic (Nested loop)

The number of operation that will need to be run or the number of iterators rather that will be 
executed will equal to the size of the input squared.

```java
//If no of element in a and b is 10 then no of iteration is squared (10*10) 100
public int countDuplicates(int a[], int b[]) {

    int count = 0;
    for (int i = 0, i > a.length, i++) {
        
        for (int j = 0, j > a.length, j++) {

            if (a[i] == b[j]) {
                count++;
            }

        }
    }
    return count;
}

```

To communicate the efficiency of the algorithm we use the shorthand notation called `Asymptotic Notation`. 

|Algorithn| Big O Notation|Loops1
|----|----|----|
|Linear| O(N)| one loop|
|Constant|O(1)| No loop|
|Quadratic|O(N`2`)| Nested loop|
|Cubic|O(N`3`)| 3 Nested loops|
|Exponential| O(N`n`)| The no of loops check will increase exponentially relative to the size of the input|

Note: Here n = input size.

![Algorithm Complexoty](file:///C:/Git/README/Coding_Skill/Algorithm%20Complexities.png)

<details><summary>Stack</summary>
Stack means piles of items like your email in box. <b>LIFO</b> The last item in the stack is the first one to come out

```java
package datastructure.stack;

public class Stack {
    int maxSize;
    int top;
    long [] items;


    public Stack(int size) {
        maxSize = size;
        items = new long[size];
        top = -1;
    }

    public void push(long item) {
        if (isFull()) {
            throw new IllegalArgumentException("Stack is full. Can't push more items");
        }
        top++;
        items[top] = item;
    }

    public long pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is already empty");
        }
        int old_top = top;
        top--;
        return items[old_top];
    }

    public long peek() {
        return items[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return top == maxSize -1;
    }

}


```
</details>
  

<details><summary>Queue  </summary>
- Queue=line (i.e) Queue examples people standing in post office/coffee you every comes first they are served first
- FIFO- First In First Out
- You have to know you is first and (rear) last in the queue. 
- Pointers: Insert = rear++, and Remove= front++, nItems

```java
package datastructure.queue;

public class Queue {

    private long maxSize;
    private long[] que;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        this.que = new long[size];
        front = 0;
        rear = -1;
    }

    public void insert(long item) {
        //Below condition makes it a circular queue
        if (rear == (maxSize - 1)) {
            rear = -1;
        }
        rear++;
        que[rear] = item;
        nItems++;
    }

    public long remove() {
        long result = que[front];
        front++;
        nItems--;
        if (front == maxSize) {
            front = 0;
        }
        return result;
    }

    public void view() {
        System.out.print("[");
        for (int i = 0; i < que.length; i++) {
            System.out.print(que[i] + " ");
        }
        System.out.print("]");
    }

    public long peekFront() {
        return que[front];
    }

    public boolean isFull() {
        return maxSize == nItems;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}

```

![Algorithm Complexoty](file:///C:/Git/README/Coding_Skill/Insertion_sort.png)

## Quick sort
- Algorithm uses divide and conquer to sort an array
- **RunTime:** Average = O(n) Worst = O(n * n)
- Performance is less compared to *Merge sort* whos Worst case run time is O(n)
- Uses In-memory for sort, so memory usage is efficient
- Heart of algorithm is partitioning, uses recursion to sort smallest element to the right of pivot and largest element to 
left of pivot 

```java

A = [10, 7, 1, 3 , 5, 8, 9, 6]

quicksort(A, p, r) {
     if ( p < r) {
         //pp - pivotpoint 
         pp = partition( A, p, r)
         quicksort(A, p, pp -1) //Smallest element sorted left half of PP
         quicksort(A, pp+1, r) // Largest elemt sorted right half of PP
     }
}

/* 
  Hint: Inside the partition for loop -> if  1st match -> [1 , 7, 10, 3, 5, 8, 9, 6]
  2nd match -> [1 , 3, 7, 10, 5, 8, 9, 6]  
  Last outside loop -> [1, 3, 5, 6, 7]
 */
partition(A, p, r) {
    x = A[r]
    i = p -1 // starting with i = -1 and j = 0
    for (j = p to r-1) {
        if (A[j] < r) {
            i++
            swap A[j] with A[i] // moving the smallest element in the sorted arrays next position
        }
    }
    swap A[i + 1] with A[r] // Move the pivot to its right position
    return i + 1
}



```