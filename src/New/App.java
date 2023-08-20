package New;

import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
//		Scanner input = new Scanner(System.in);
//				
//		int asc=127;
//		System.out.print("몇칸빙고?\n");
//		int width = input.nextInt();
//		
//		int bingo[][]= new int[width][width];
//		
//		for (int i = 0; i < bingo.length; i++) {
//			for (int j = 0; j < bingo[i].length; j++) {
//				bingo[i][j] = i*width+j+1;
//			}
//		}
//		
//		for (int i = 0; i < bingo.length; i++) {
//			for (int j = 0; j < bingo[i].length; j++) {
//				int randomA = (int)(Math.random()*width);
//				int randomB = (int)(Math.random()*width);
//				
//				int temp = bingo[i][j];
//				bingo[i][j] = bingo[randomA][randomB];
//				bingo[randomA][randomB] = temp;				
//			}			
//		}
//		
//		int bingoCount =0;
//		
//		int sum[]=new int[width*2+2];
//				
//		while (true)
//		{
//			for (int i[]:bingo)
//			{				
//				for (int j:i)
//				{
//					if (j==asc)
//						System.out.print((char)j+"\t");
//					else
//						System.out.print(j+"\t");
//				}
//				System.out.print("\n\n");
//			}
//			
//			System.out.println("bing count : "+bingoCount);
//			
//			if (bingoCount>=3)
//				{
//				System.out.println("종료!!");
//				break;				
//				}
//			
//			int number = input.nextInt();
//			
//			for (int i = 0; i < bingo.length; i++) {
//				for (int j = 0; j < bingo[i].length; j++) {
//				if (bingo[i][j]==number)
//					{
//					bingo[i][j]=asc;
//					}
//				}
//			}	
//			
//			for (int i = 0; i<sum.length;i++)
//			{
//				sum[i]=0;
//			}			
//			for (int i = 0; i <bingo.length; i++){
//				for (int j = 0; j < bingo[i].length; j++) {
//					sum[i]+=bingo[i][j];
//					sum[j+width]+=bingo[i][j];
//					if (i==j) sum[width*2]+=bingo[i][j];
//					if (i+j==width-1) sum[width*2+1]+=bingo[i][j];
//				}				
//			}			
//			bingoCount = 0;
//			for (int i=0; i<sum.length; i++)
//			{
//				if (sum[i]==width*asc) bingoCount++;
//			}			
//			
//		}//end of while		
//		
//		
//	input.close();
	
		int[] a = new int[25];
		for (int i = 0; i < a.length; i++) {
			a[i]=i;
			System.out.println(a[i]);
		}
//		
//		for (int i = 0; i < a.length; i++) {
//			a[i]=i/5;
//			System.out.println(a[i]);
//		}
//		
//		for (int i = 0; i < a.length; i++) {
//			a[i]=i%5;
//			System.out.println(a[i]);
//		}
		
//		for (int i = 0; i < a.length; i++) {
//			if (a[i]%6==0)
//			{
//				a[i]=100;
//			}
//			System.out.println(a[i]);
//		}
		
		for (int i = 0; i < a.length; i++) {
			if (i!=0&&i!=24&&(a[i]%4==0))
			{
				a[i]=100;
			}
			System.out.println(a[i]);
		}
		
		
		char cha = 37;
		System.out.println(cha);
	
		int dou = 1123;
		String strDou = String.valueOf(dou);
		System.out.println(strDou);
		int abc = strDou.length();
		System.out.println(abc);
		
		String dot = "12345";
		double dotstr = Double.parseDouble(dot);
		String dot1 = "234.45";
		double dotstr1 = Double.parseDouble(dot1);			
		System.out.println(dotstr+dotstr1);
		
	}//end of main
	
	
	
}

