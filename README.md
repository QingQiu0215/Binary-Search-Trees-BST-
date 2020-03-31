# Binary-Search-Trees-BST

The purpose of the programming questions in this assignment is to evaluate two implementations of
binary search trees in terms of their performance for different insertion and deletion operations. The
trees will then be tested to implement a TreeSort sorting algorithm.
Binary Search Trees (BST) are data structures that store “items” (such as numbers, names etc.) in
memory. They allow fast lookup, addition and removal of items, and can be used to implement
either dynamic sets of items, or lookup tables that allow finding an item by its key.
The Tree interface provides three methods to add and remove elements to and from the tree. It
also provides an iterator that visits the elements in-order, as well as a function height that simply
returns the height of the tree. Note that the speed of these operations may strongly depend on the
implementation.
In this assignment, you will have to write two implementations of Tree interface (provided), one
that uses regular (possibly unbalanced) Binary Search Trees1, and one that uses balanced
AVL Trees2. After that, you will have to test the performance of TreeSort3 when using your
implementations. For your convenience, some starting code is provided. Note that it either does not
implement some features or implements them improperly.
Question 1:
Implement the necessary methods in the two implementations (called A3BSTree and
A3AVLTree) of Tree interface:
public void add(E e);
public void addAll (Collection<? extends E> c);
public boolean remove(Object o);
public Iterator<E> iterator();
public int height();
public int size();
The classes should use generics. The AVL add and remove operation should keep the tree
balanced. It should also be possible to have duplicate items in the trees (something that binary search
trees normally do not allow); think about how you can work around it.
You are free to implement any private or protected methods and classes as you see needed.
However, you may not have any public methods other than the ones mentioned (or the ones present
in the interface or its super classes).
Question 2
Name your class TreeSort.
The class should have the following methods:
public static <E> void sort( E[] a);
public static <E> void sort(Tree <E> tree, E[] a);
See the comments in the code provided to determine their behavior.
Question 3:
Name your class SortTester
Take both of your tree implementations and compare them when used to implement a TreeSort
sorting algorithm.
For numbers N = {10, 100, 1000, 10000, 100000, 1000000}
a) Starting with unsorted arrays of N, measure how long it takes to sort such an array using regular
BSTs and balanced AVL trees.
b) Starting with reverse-sorted arrays of N, measure how long it takes to sort such an array using
regular BSTs and balanced AVL trees.
Produce the following table (the timing values below are just an illustration and do not relate to any
real measurements):
N = 10:
BST 213 ms
AVL 432 ms
BST(rev-sorted) 543 ms
AVL(rev-sorted) 876 ms
N = 100:
…
N = 1000:
…
<repeat for all values of N>
Save the result of your program execution in a file testrun.txt and submit it together with your
other files.
