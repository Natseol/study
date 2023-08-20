package New;

import java.util.Scanner;

public class New {
	
	public static void main(String[] args){
		
//		for (int i=1; i<=5;i++)
//		{
//			for (int j=1;j<i;j++)
//				{
//					System.out.print("   ");
//				}
//			for (int k=i;k<=5;k++)
//				{
//					System.out.print(" * ");
//				}
//			System.out.println();					
//		}
//		System.out.println();
//	
//	
//		for (int i=1; i<=5;i++)
//		{
//			for (int j=1;j<=5-i;j++)
//			{
//				System.out.print("   ");
//			}
//			for (int k=6-i;k<=5;k++)
//			{
//				System.out.print(" * ");
//			}
//			System.out.println();
//		}
//		
//		int m=5;
//		for (int i = 1 ; i <= 10 ; i++)
//		{
//			m--;
//			int h=Math.abs(m);
//			for (int j=1;j<h+1;j++)
//			{
//				System.out.print(" ");
//			}
//			for (int k=h;k<m+i;k++)
//			{
//				System.out.print("* ");
//			}
//			for (int l=1;l<=h+1;l++)
//			{
//				System.out.print(" ");				
//			}
//			System.out.println();
//		}
//	}
	
		Scanner inputScan = new Scanner(System.in);
		int input = inputScan.nextInt();		
		int random =(int)(Math.random()*3)+1;
		
			
		int mod = (input-random)%3 ;
		
		System.out.printf("%d\n",random);
		
		switch (mod)
		{
		case 0:
			System.out.println("비김");
			break;
		case 1:
			System.out.println("짐");
			break;
		case 2:
			System.out.println("이김");
			break;
		}
		
		
		inputScan.close();
	
		for(int i =1 ; i<=5;i++)
		{
			for(int k =5;i<k;k--) {
				System.out.print(" ");				
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
}


