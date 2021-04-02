### How to prepare for coding interview questions? 
1. Implement the common data structures and algorithms from scratch, first by hand and then via a computer. A lot of interview questions require this knowledge, so it's essential that you are very comfortable with them. Derive the time complexity for these algorithms as well.
2. Practice with real interview questions. A book on algorithms or data structures might be useful, but it's often far beyond the knowledge that you need to know. Let interview questions be your guide for what you need to know.
3. Try to solve the problem on your own—really try to solve it. If you read a question and get stuck solving it, that's okay and normal. Questions are designed to be tough. Don't give up, though. Keep working through the problem.
4. Write the code for the algorithm on paper. You've been coding all your life on a computer, and you've gotten used to the many nice things about it: compilers, code completion, and so on. You won't have any of these in an interview, so you had better get used to that fact now. Implement the code the old-fashioned way, down to every last semicolon.
5. Test your code! By hand, that is. No cheating with a computer!
6. Type your code into a computer exactly as is. Rerun both the test cases you tried and some new ones.
7. Start a list of all the mistakes you made, and analyze what types of mistakes you make the most often. Are there specific mistakes?

### Must-Know Data Structures, Algorithms, and Topics

|Data Structures|Algorithms|Concepts|
|----           |----                |----|
|Linked lists	|Breadth-first search|	Bit manipulation|
|Binary trees	|Depth-first search|	Recursion|
|Tries	        |Binary search	|Memorization/dynamic programming|
|Stacks	        |Merge sort	|Memory (stack vs. heap)|
|Queues	        |Quick sort	|Big-O time|
|Dynamically resizing arrays|	Tree insert/find/etc.	
|Hash tables|		
|Heaps		|
|Graphs		|

* For each of the topics, make sure you understand how to implement and use them, and (where applicable) the space and time complexity.
* We must often make a trade-off between time and space, and sometimes we do sacrifice time efficiency to reduce memory usage.
* A recursive algorithm often takes up dramatically more space than an iterative algorithm.

**MEMORY USAGE**
As you're reviewing data structures, remember to practice computing the memory usage of a data structure or an algorithm. Your interviewer might ask you directly how much memory something takes, or you might need to compute this yourself if your problem involves large amounts of data.

**Data structures.** Don't forget to include the pointers to other data. For example, a doubly linked list that holds 1,000 integers will often use about 12KB of memory (4 bytes for the data, 4 bytes for the previous pointer, and 4 bytes for the next pointer). This means that making a singly linked list into a doubly linked list can dramatically increase memory usage.
**Algorithms.** A recursive algorithm often takes up dramatically more space than an iterative algorithm. Consider, for example, an algorithm to compute the jth to last element of a singly linked list. An approach that uses an array to sort each element may be no better than a recursive algorithm—both use O(n) memory! (The best solution involves using two pointers, where one starts off j spaces ahead.)
Many candidates think of their algorithms on only one dimension—time—but it's important to consider the space complexity as well. We must often make a trade-off between time and space, and sometimes we do sacrifice time efficiency to reduce memory usage.

### Coding questions
Interviews are supposed to be difficult. The norm is that you won't know how to solve a question as soon as you hear it. You will struggle through it, get a bit of help from the interviewer (or a lot of help, depending on the difficulty of the question), and arrive at a better solution than what you started with.

When you get a hard question, don't panic. Just start talking aloud about how you would solve it.

The following seven-step approach works well for many problems:

1. **Understand the question.** If there's anything you didn't understand, clarify it here. Pay special attention to any specific details provided in the question, such as that the input is sorted. You need all those details.
2. **Draw an example.** Solving questions in your head is very different; get up to the whiteboard and draw an example. It should be a good example, too. The example should be reasonably large (e.g., if it's a typical array problem, you probably want one with around eight elements) and not a special case. This is actually much easier said than done.
3. **Design a brute force algorithm.** If there's a brute force/naive approach, or even a solution that only partially works, explain it. It's a starting point, and ensures that your interviewer knows that you've gotten at least that far.
4. **Optimize the brute force.** Not always, but very often, there's a path from the brute force to the optimal solution.
5. **Understand the code.** Once you have an optimal algorithm, take a moment to really understand your algorithm. It's well worth it to not dive into code yet.
6. **Implement the code.** If you're comfortable with your process, go ahead and implement it. Don't be afraid to go back to your example, though, if you start to get confused.
7. **Test.** Flawless whiteboard coding is rare. If you find mistakes, that's okay. Analyze why you made the mistake and try to fix it.
And, remember: you're not done until the interviewer says that you're done! This goes for both the algorithm part and the code part. When you come up with an algorithm, start thinking about the problems accompanying it. When you write code, start trying to find bugs. The vast majority of candidates make mistakes.
<details><summary>STEP 1: UNDERSTAND THE QUESTION</summary>
<p>Technical problems are more ambiguous than they might appear, so make sure to ask questions to resolve anything that might be unclear.

Additionally, it's important to make sure that you really remember all those details that the interviewer mentioned. If the interviewer mentioned that the data is sorted, then your optimal algorithm probably depends on that. Or, if the data set has all unique values, this is probably necessary information.
</p>
</details>  
<details><summary>STEP 2: DRAW AN EXAMPLE</summary>
<p>

Consider, for example, a problem to count the number of elements that two sorted and distinct arrays have in common. A typical example that a candidate might come up with is:

A: [1, 3, 8, 9]

B: [3, 4, 5, 10]

This is a bad example for two reasons. First, it's too small. Second, itsn't a special case: the arrays are the same length.

 How is this for an example?

A: [1, 3, 8, 9]

B: [2, 3, 4, 5, 10]

This is a bit better, but itsn't still a special case. The arrays have only one element in common and that element is even at the same index in both arrays.

This is a pretty good example:

A: [1, 5, 9, 13, 14, 20, 21]

B: [1, 9, 10, 11, 13, 14, 15, 16, 21]

This example is fairly large (but not too cumbersome). It has multiple elements in common and they are dispersed throughout the array. We even have two overlapping elements (13 and 14) that are right next to each other.
</p></details>
<details><summary>STEP 3: DESIGN A BRUTE FORCE ALGORITHM</summary>
<p>
As soon as you hear an interview question, try to get a solution out there, even if it's imperfect. You can work with a brute force algorithm to optimize it.

If you're having trouble coming up with an algorithm, remember our approaches to algorithm problems (presented later in this chapter).

Also, when designing your algorithm, don't forget to think about:

1. What are the space and time complexities?
2. What happens if there is a lot of data?
3. Does your design cause other issues? (That is, if you're creating a modified version of a binary search tree, did your design impact the time for insert/find/delete?)
4. If there are other issues, did you make the right trade-offs?
If the interviewer gave you specific data (e.g., mentioned that the data is ages, or in sorted order), have you leveraged that information? There's probably a reason that you're given it.
Even a bad solution is better than no solution. State your bad solution and then state the issues with it.
</p></details>

<details><summary>STEP 4: OPTIMIZE THE BRUTE FORCE</summary>
<p>It often works well to run through the algorithm-by hand with you example and not by writing code. Look for areas to optimize like 1. bottleneck one part of code that taking a long time O(N log N). (2) Unnecessary work searching element on both sides of the tree (3)Duplicate work continously searching for same element </p>
</details>
<details><summary>STEP 5: UNDERSTAND THE CODE</summary>
<p>Run through your algorithm before coding.For example, imagine you're trying to merge two sorted arrays into a new sorted array. Many canditates understand the basic: two pointers, move them through the array, copy the element in order. 

This probably isn't sufficient. You should instead understand it deeply. You need to understand what the variables are, when they update, and why. You should have logic like this formulated before you start coding:

1. Initialize two pointers, p and q, which point to the beginning of A and B, respectively.
2. Initialize k to an index at the start of the result array, R.
Compare the values at p and q.
3. If A[p] is smaller, insert A[p] into R[k]. Increment p and k.
4. If B[q] is smaller, insert B[q] into R[k]. Increment q and k.
Go to step 3.

You don't have to write this out by hand, but you do need to understand it at this level. Trying to skip a step and code before you're totally comfortable will only slow you down.

</p>
</details>
<details><summary>STEP 6: IMPLEMENT THE CODE</summary>
<p>
Don't rush through your code; infact, this will mostl likely hurt you, Just go at a nice, slow pace and remember below advise.

* Use data structures generously.(e.g) finding the minimum age for a group of people, consider defining a data structure to represent a person 
* Modularizing your code first. move discrete steps to a separate function.
* Don't crowd your code `If you feel yourself getting confused while coding, stop and go back to your example. You don't need to code straight through. It's far better that you take a break than write nonsensical code.`
</p>
</details>
<details><summary>STEP 7: TEST</summary>
<p>
It is rare for a candidate to write flawless code. Not testing therefore suggests two problems. First, it leaves bugs in your code. Second, it suggests that you're the type of person who doesn't test their code well.

Therefore, it's very important to test your code.

To discover bugs the fastest, do the following five steps:

1. **Review your code conceptually.** What is the meaning of each line? Does it do what you think it should?
2. **Review error hot spots.** Is there anything in your code that looks funny (e.g., “int n = length − 2”)? Do your boundary conditions look right? What about your base cases (if the code is recursive)?
3. **Test against a small example.** You want your example to create an algorithm to be big, but now you want a small one. An example that's too big will take a long time to run through. This is time-consuming, but it might also cause you to rush the testing and miss serious bugs.
4. **Pinpoint potential issues.** What sorts of test cases would test against specific potential issues? For example, you might sense that there could be a bug with one array that's much shorter than the other; test for this situation specifically.
5. **Test error cases.** Finally, test the true error conditions. What happens on a null string or negative values?
When you find a mistake (which you will), relax. Almost no one writes bug-free code; what's important is how you react to it. Point out the mistake, and carefully analyze why the bug is occurring. Is it really just when you pass in 0, or does it happen in other cases, too?

Bugs are not a big deal (bug-free code is very unusual). The important thing is that you think through how to fix issues you see rather than making a quick and dirty fix. A fix that works for that test case might not work for all test cases, so make sure it's the right one.</p>
</details>

### Four ways to create an algorithm

Algorithm Questions: Four Ways to Create an Algorithm
There's no surefire approach to solving a tricky algorithm problem, but the following approaches can be useful. Keep in mind that the more problems you practice, the easier it will be to identify which approach to use.

Also, remember that the four approaches can be mixed and matched. That is, once you've applied Simplify and Generalize, you may want to implement Pattern Matching next.

<details><summary>APPROACH 1: PATTERN MATCHING</summary>
<p>
Pattern matching means to relate a problem to similar ones, and figure out if you can modify the solution to solve the new problem. This is one reason why practicing lots of problems is important: the more problems you do, the better you get.

Example: A sorted array has been rotated so that the elements might appear in the order 3 4 5 6 7 1 2. How would you find the minimum element?

This question is most similar to the following two well-known problems:

Find the minimum element in an unsorted array.
Find a specific element in an array (e.g., binary search).
Finding the minimum element in an unsorted array isn't a particularly interesting algorithm (you could just iterate through all the elements), nor does it use the information provided (that the array is sorted). It's unlikely to be useful here.

However, binary search is very applicable. You know that the array is sorted but rotated. So it must proceed in an increasing order, then reset and increase again. The minimum element is the reset point.

If you compare the first and middle elements (3 and 6), you know that the range is still increasing. This means that the reset point must be after the 6 (or 3 is the minimum element and the array was never rotated). We can continue to apply the lessons from binary search to pinpoint this reset point, by looking for ranges where LEFT > RIGHT. That is, for a particular point, if LEFT < RIGHT, then the range does not contain the reset. If LEFT > RIGHT, then it does.
</p></details>
<details><summary>APPROACH 2: SIMPLIFY AND GENERALIZE</summary>
<p>
In Simplify and Generalize, we change constraints (data type, size, etc.) to simplify the problem, and then try to solve the simplified problem. Once you have an algorithm for the simplified problem, you can generalize the problem back to its original form. Can you apply the new lessons?

Example: A ransom note can be formed by cutting words out of a magazine to form a new sentence. How would you figure out if a ransom note (string) can be formed from a given magazine (string)?

We can simplify the problem as follows: instead of solving the problem with words, solve it with characters. That is, imagine we are cutting characters out of a magazine to form a ransom note.

We can solve the simplified ransom note problem with characters by simply creating an array and counting the characters. Each spot in the array corresponds to one letter. First, we count the number of times each character in the ransom note appears, and then we go through the magazine to see if we have all of those characters.

When we generalize the algorithm, we do a very similar thing. This time, rather than creating an array with character counts, we create a hash table. Each word maps to the number of times the word appears.
</p></details>
<details><summary>APPROACH 3: BASE CASE AND BUILD</summary>
<p>
Base Case and Build suggests that you solve the algorithm first for a base case (e.g., just one element). Then, try to solve it for elements 1 and 2, assuming that you have the answer for element 1. Then, try to solve it for elements 1, 2, and 3, assuming that you have the answer to elements 1 and 2.

You will notice that Base Case and Build algorithms often lead to natural recursive algorithms.

Example: Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.

Consider the following string: abcdefg

Case “a” → {a}
Case “ab” → {ab, ba}
Case “abc” → ?
This is the first interesting case. If we had the answer to permutations “ab,” how could we generate permutations “abc”? Well, the additional letter is c, so we can just stick c in at every possible point. That is:

merge(c, ab) → cab, acb, abc
merge(c, ba) → cba, bca, bac
We can use a recursive algorithm to solve this problem. First, generate all permutations of a string by chopping off the last character and generating all permutations of s[1…n − 1]. Then, insert s[n] into every location of the permuted string.
</p></details>
<details><summary>APPROACH 4: DATA STRUCTURE BRAINSTORM</summary>
<p>
The Data Structure Brainstorm approach admittedly feels somewhat hacky, but it often works. In this approach, we simply run through a list of data structures and try to apply each one. This approach works because many algorithms are quite straightforward once we find the right data structure.

A good tip-off that you might want to apply Data Structure Brainstorm is that the interviewer hasn't specified a data structure for the data. This means that you'll probably need to come up with a data structure, and that might be the key to the problem.

**Example: You are building a class with two functions: addNumber(n) and getMedian(). The addNumber(n) method will be called periodically by some external function with an integer value. When getMedian() is called, you need to efficiently return the median of all prior numbers. (If you have an odd number of values, the median is the exact middle of the sorted values. If you have an even number of values, the median is the average between the two middle values.) How would you implement these two methods?**

Let's go through the common data structures and see if using one of them would be helpful.

- **Linked list?** Probably not—linked lists tend not to do very well with accessing and sorting numbers.
- **Array?** Maybe, if we kept the elements sorted. But that's probably expensive. Let's hold off on this and return to it if it's needed.
- **Binary tree?** This is possible, since binary trees do fairly well with ordering. In fact, if the binary search tree is perfectly balanced, the top might be the median. But be careful—if there's an even number of elements, the median is actually the average of the middle two elements. The middle two elements can't both be at the top. There might be a workable algorithm, but let's come back to it.
- **Heap?** A heap is really good at basic ordering and keeping track of maxes and mins. This is actually interesting—if you had two heaps, you could keep track of the bigger half and the smaller half of the elements. 

The bigger half is kept in a min heap, such that the smallest element in the bigger half is at the root. The smaller half is kept in a max heap, such that the biggest element of the smaller half is at the root. Now, with these data structures, you have the potential median elements at the roots. If the heaps are no longer the same size, you can quickly rebalance the heaps by popping an element off one heap and pushing it onto the other.

Note that the more problems you do, the more developed your instinct on which data structure to apply will be. Hash tables, trees, tries, and heaps are some of the best data structures to solve problems.
</p></details>