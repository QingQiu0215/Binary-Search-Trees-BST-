import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
public class SortTester 
{
	public static void main(String[] args) 
	{
		//create two objects BSTree and AVLTree respectively.
		A3BSTree <Integer> BSTree = new A3BSTree<>();
		A3AVLTree <Integer> AVLTree=new A3AVLTree<>();
        //create some following arrays to be tested.
		int n1 =10;  
		Integer a1 [] = new Integer[n1];		
		for (int i = 0; i < a1.length; i++) 
			a1[i] = i;
		Integer b1 [] = new Integer[n1];
		int j1=a1.length-1;
		for (int i = 0; i < a1.length; i++) 
		{
			b1[i] = j1;j1--;
		}
		
		int n2 =100; 
		Integer a2 [] = new Integer[n2];
		for (int i = 0; i < a2.length; i++) 
			a2[i] = i;
		Integer b2 [] = new Integer[n2];
		int j2=a2.length-1;
		for (int i = 0; i < a2.length; i++) 
		{
			b2[i] = j2;j2--;
		}
		
		int n3 =1000;  
		Integer a3 [] = new Integer[n3];
		for (int i = 0; i < a3.length; i++) 
			a3[i] = i;
		Integer b3 [] = new Integer[n3];
		int j3=a3.length-1;
		for (int i = 0; i < a3.length; i++) 
		{
			b3[i] = j3;j3--;
		}
		
		int n4 =10000; 
		Integer a4 [] = new Integer[n4];
		for (int i = 0; i < a4.length; i++) 
			a4[i] = i;
		Integer b4 [] = new Integer[n4];
		int j4=a4.length-1;
		for (int i = 0; i < a4.length; i++) 
		{
			b4[i] = j4;j4--;
		}
		
		int n5 =100000;  
		Integer a5 [] = new Integer[n5];
		for (int i = 0; i < a5.length; i++) 
			a5[i] = i;
		Integer b5 [] = new Integer[n5];
		int j5=a5.length-1;
		for (int i = 0; i < a5.length; i++) 
		{
			b5[i] = j5;j5--;
		}
		
		int n6 =1000000; 
		Integer a6 [] = new Integer[n6];
		for (int i = 0; i < a6.length; i++) 
			a6[i] = i;
		Integer b6 [] = new Integer[n6];
		int j6=a6.length-1;
		for (int i = 0; i < a6.length; i++) 
		{
			b6[i] = j6;j6--;
		}
		//shuffle all elements in some arrays 
		Collections.shuffle(Arrays.asList(a1));
		Collections.shuffle(Arrays.asList(a2));
		Collections.shuffle(Arrays.asList(a3));
		Collections.shuffle(Arrays.asList(a4));
		Collections.shuffle(Arrays.asList(a5));
		Collections.shuffle(Arrays.asList(a6));
        //get current time of all sortings.
        long timePreForBST1=System.currentTimeMillis();
		TreeSort.sort(BSTree, a1);		
		long timePostForBST1=System.currentTimeMillis();
		long timePreForBST2=System.currentTimeMillis();
		TreeSort.sort(BSTree, a2);		
		long timePostForBST2=System.currentTimeMillis();
		long timePreForBST3=System.currentTimeMillis();
		TreeSort.sort(BSTree, a3);		
		long timePostForBST3=System.currentTimeMillis();
		long timePreForBST4=System.currentTimeMillis();
		TreeSort.sort(BSTree, a4);		
		long timePostForBST4=System.currentTimeMillis();
		long timePreForBST5=System.currentTimeMillis();
		TreeSort.sort(BSTree, a5);		
		long timePostForBST5=System.currentTimeMillis();
		long timePreForBST6=System.currentTimeMillis();
		TreeSort.sort(BSTree, a6);		
		long timePostForBST6=System.currentTimeMillis();
		long timePreForBSTReverse1=System.currentTimeMillis();
		TreeSort.sort(BSTree, b1);		
		long timePostForBSTReverse1=System.currentTimeMillis();
		long timePreForBSTReverse2=System.currentTimeMillis();
		TreeSort.sort(BSTree, b2);		
		long timePostForBSTReverse2=System.currentTimeMillis();
		long timePreForBSTReverse3=System.currentTimeMillis();
		TreeSort.sort(BSTree, b3);		
		long timePostForBSTReverse3=System.currentTimeMillis();
		long timePreForBSTReverse4=System.currentTimeMillis();
		TreeSort.sort(BSTree, b4);		
		long timePostForBSTReverse4=System.currentTimeMillis();
		long timePreForBSTReverse5=System.currentTimeMillis();
		TreeSort.sort(BSTree, b5);		
		long timePostForBSTReverse5=System.currentTimeMillis();
		long timePreForBSTReverse6=System.currentTimeMillis();
		TreeSort.sort(BSTree, b6);		
		long timePostForBSTReverse6=System.currentTimeMillis();
		
		long timePreForAVL1=System.currentTimeMillis();
		TreeSort.sort(a1);
		long timePostForAVL1=System.currentTimeMillis();
		long timePreForAVL2=System.currentTimeMillis();
		TreeSort.sort(a2);
		long timePostForAVL2=System.currentTimeMillis();
		long timePreForAVL3=System.currentTimeMillis();
		TreeSort.sort(a3);
		long timePostForAVL3=System.currentTimeMillis();
		long timePreForAVL4=System.currentTimeMillis();
		TreeSort.sort(a4);
		long timePostForAVL4=System.currentTimeMillis();
		long timePreForAVL5=System.currentTimeMillis();
		TreeSort.sort(a5);
		long timePostForAVL5=System.currentTimeMillis();
		long timePreForAVL6=System.currentTimeMillis();
		TreeSort.sort(a6);
		long timePostForAVL6=System.currentTimeMillis();
		long timePreForAVLReverse1=System.currentTimeMillis();
		TreeSort.sort(b1);
		long timePostForAVLReverse1=System.currentTimeMillis();
		long timePreForAVLReverse2=System.currentTimeMillis();
		TreeSort.sort(b2);
		long timePostForAVLReverse2=System.currentTimeMillis();
		long timePreForAVLReverse3=System.currentTimeMillis();
		TreeSort.sort(b3);
		long timePostForAVLReverse3=System.currentTimeMillis();
		long timePreForAVLReverse4=System.currentTimeMillis();
		TreeSort.sort(b4);
		long timePostForAVLReverse4=System.currentTimeMillis();
		long timePreForAVLReverse5=System.currentTimeMillis();
		TreeSort.sort(b5);
		long timePostForAVLReverse5=System.currentTimeMillis();
		long timePreForAVLReverse6=System.currentTimeMillis();
		TreeSort.sort(b6);
		long timePostForAVLReverse6=System.currentTimeMillis();
		//calculate the time interval for all sortings
		long timeUsedForBST1=timePostForBST1-timePreForBST1;
		long timeUsedForBST2=timePostForBST2-timePreForBST2;
		long timeUsedForBST3=timePostForBST3-timePreForBST3;
		long timeUsedForBST4=timePostForBST4-timePreForBST4;
		long timeUsedForBST5=timePostForBST5-timePreForBST5;
		long timeUsedForBST6=timePostForBST6-timePreForBST6;
		
		long timeUsedForAVL1=timePostForAVL1-timePreForAVL1;
		long timeUsedForAVL2=timePostForAVL2-timePreForAVL2;
		long timeUsedForAVL3=timePostForAVL3-timePreForAVL3;
		long timeUsedForAVL4=timePostForAVL4-timePreForAVL4;
		long timeUsedForAVL5=timePostForAVL5-timePreForAVL5;
		long timeUsedForAVL6=timePostForAVL6-timePreForAVL6;
		
		long timeUsedForBSTReverse1= timePostForBSTReverse1-timePreForBSTReverse1;
		long timeUsedForBSTReverse2= timePostForBSTReverse2-timePreForBSTReverse2;
		long timeUsedForBSTReverse3= timePostForBSTReverse3-timePreForBSTReverse3;
		long timeUsedForBSTReverse4= timePostForBSTReverse4-timePreForBSTReverse4;
		long timeUsedForBSTReverse5= timePostForBSTReverse5-timePreForBSTReverse5;
		long timeUsedForBSTReverse6= timePostForBSTReverse6-timePreForBSTReverse6;
		
		long timeUsedForAVLReverse1= timePostForAVLReverse1-timePreForAVLReverse1;
		long timeUsedForAVLReverse2= timePostForAVLReverse2-timePreForAVLReverse2;
		long timeUsedForAVLReverse3= timePostForAVLReverse3-timePreForAVLReverse3;
		long timeUsedForAVLReverse4= timePostForAVLReverse4-timePreForAVLReverse4;
		long timeUsedForAVLReverse5= timePostForAVLReverse5-timePreForAVLReverse5;
		long timeUsedForAVLReverse6= timePostForAVLReverse6-timePreForAVLReverse6;
		
		//print the table to compare the differences between A3BSTree and A3AVLTree
		System.out.println("N= 10");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST1);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL1);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse1);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse1);
		System.out.println();
		
		System.out.println("N= 100");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST2);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL2);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse2);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse2);
		System.out.println();
		
		System.out.println("N= 1000");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST3);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL3);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse3);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse3);
		System.out.println();
		
		System.out.println("N= 10000");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST4);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL4);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse4);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse4);
		System.out.println();
		
		System.out.println("N= 100000");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST5);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL5);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse5);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse5);
		System.out.println();
		
		System.out.println("N= 1000000");
		System.out.printf("%-20s%d ms%n","BST",timeUsedForBST6);
		System.out.printf("%-20s%d ms%n","AVL",timeUsedForAVL6);
		System.out.printf("%-20s%d ms%n","BST(rev-sorted)",timeUsedForBSTReverse6);
		System.out.printf("%-20s%d ms%n","AVL(rev-sorted)",timeUsedForAVLReverse6);
	}
}

