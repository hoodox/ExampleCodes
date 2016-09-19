package com.hoodox.knapsack;

/**

 ** Java Program to Implement Knapsack Algorithm

 **/

import java.util.Scanner;

/** Class Knapsack **/

public class knapsack2 {

	public void solve(int[] wt, int[] val, int W, int N)

	{

		int NEGATIVE_INFINITY = Integer.MIN_VALUE;

		int[][] m = new int[N + 1][W + 1];

		int[][] sol = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++)

		{

			for (int j = 0; j <= W; j++)

			{

				int m1 = m[i - 1][j];

				int m2 = NEGATIVE_INFINITY;

				if (j >= wt[i])

					m2 = m[i - 1][j - wt[i]] + val[i];

				/** select max of m1, m2 **/

				m[i][j] = Math.max(m1, m2);

				sol[i][j] = m2 > m1 ? 1 : 0;

			}

		}

		/** make list of what all items to finally select **/

		int[] selected = new int[N + 1];

		for (int n = N, w = W; n > 0; n--)

		{

			if (sol[n][w] != 0)

			{

				selected[n] = 1;

				w = w - wt[n];

			}

			else

				selected[n] = 0;

		}

		/** Print finally selected items **/

		System.out.println("\nItems selected : ");

		for (int i = 1; i < N + 1; i++)

			if (selected[i] == 1)

				System.out.print(i + " ");

		System.out.println();

	}

	/** Main function **/

	public static void main(String[] args)

	{

		Scanner scan = new Scanner(System.in);

		System.out.println("Knapsack Algorithm Test\n");

		/** Make an object of Knapsack class **/

		knapsack2 ks = new knapsack2();

		/*
		 * System.out.println("Enter number of elements ");
		 * 
		 * int n = scan.nextInt();
		 * 
		 * 
		 * 
		 * int[] wt = new int[n + 1];
		 * 
		 * int[] val = new int[n + 1];
		 * 
		 * 
		 * 
		 * System.out.println("\nEnter weight for "+ n +" elements");
		 * 
		 * for (int i = 1; i <= n; i++)
		 * 
		 * wt[i] = scan.nextInt();
		 * 
		 * System.out.println("\nEnter value for "+ n +" elements");
		 * 
		 * for (int i = 1; i <= n; i++)
		 * 
		 * val[i] = scan.nextInt();
		 * 
		 * 
		 * 
		 * System.out.println("\nEnter knapsack weight ");
		 * 
		 * int W = scan.nextInt();
		 */

		// int[] wt = new int[n + 1];
		// wt[1] = 102;
		// wt[2] = 50;
		// wt[3] = 80;
		// wt[4] = 300;
		//
		//
		// int[] val = new int[n + 1];
		// val[1] = 100;
		// val[2] = 98;
		// val[3] = 49;
		// val[4] = 10;

		int val[] = { 0, 100, 98, 49, 10 };

		int wt[] = { 0, 102, 50, 80, 300 };

		int W = 300;
		int n = val.length - 1;

		ks.solve(wt, val, W, n);

	}

}
