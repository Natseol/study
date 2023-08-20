package Calculator;

import java.util.Scanner;

class Calculate {
	double num1;
	double num2;
	char sign;
	
	static double Cal(double a, char c, double b){
		double result=0;
		if (c == '*') {	
		result = a*b; 
		}	
		else if (c == '+') {	
		result = a+b; 
		}	
		else if (c == '-') {	
		result = a-b; 
		}	
		else if (c == '/') {	
		result = a/b; 
		}

	return result;
	}
	
	void CalMulDiv()
	{
		if (sign=='*') {		
		num1 *= num2;
		}
		else if (sign=='/') {		
		num1 /= num2;
		}
		num2=1;
		sign = '*';		
	}
	
	void CalAddSub()
	{
		if (sign=='+') {		
		num1 += num2;
		}
		else if (sign=='-') {		
		num1 -= num2;		
		}
		else if (sign=='*') {		
		num1 *= num2;
		}
		else if (sign=='/') {		
		num1 /= num2;
		}		
		sign = '*';	
		num2=1;				
	}	
}

public class Calculator {

	public static void main(String[] args) {
		
		Scanner inputScan = new Scanner(System.in);
		String input = inputScan.nextLine();
		char[] inputArr = input.toCharArray();//한 문자씩 저장
		//*:42 +:43 -:45 /:47
				
		String[] numStr = input.split("\\+|\\-|\\*|\\/|\\(|\\)");
		int emptyStr=0;
		for (String i : numStr)
		{
//			System.out.print(i+"|");
			if (i.isEmpty())
			{
				emptyStr++;
			}
		}//기호가 연속해서 오는 경우 확인
		System.out.println();
		
		int count=0;
		double[] num = new double[numStr.length-emptyStr];		
		for (int i = 0; i < numStr.length; i++) {
			if (!numStr[i].isEmpty())
			{
				num[count]=Double.parseDouble(numStr[i]);
				count++;
			}
		}//숫자 배열 생성
		
//		for (double i : num)
//		{
//			System.out.print(i+" ");
//		}
//		System.out.println();
		
		int signCount = 0;		
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i]==42||inputArr[i]==43||inputArr[i]==45||inputArr[i]==47) {
				signCount++;
			}
		}//사칙연산 기호 갯수 확인
		
		int parCount = 0;		
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i]==40||inputArr[i]==41) {
				parCount++;
			}
		}//괄호 갯수 확인
		
		System.out.println("기호 갯수 : "+signCount);
		System.out.println("괄호 갯수 : "+parCount);
				
		count=0;
		int[][] sign = new int[2][signCount];
		
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i]==42)
			{
				sign[0][count]=i;
				sign[1][count]=42;
				count++;
			}
			else if (inputArr[i]==43)
			{
				sign[0][count]=i;
				sign[1][count]=43;
				count++;
			}
			else if (inputArr[i]==45)
			{
				sign[0][count]=i;
				sign[1][count]=45;
				count++;
			}
			else if (inputArr[i]==47)
			{
				sign[0][count]=i;
				sign[1][count]=47;
				count++;
			}				
		}//기호를 배열로 저장, 0행엔 index, 1행엔 아스키코드
		
		System.out.print("\n기호 인덱스 ");
		for (int j = 0 ; j<sign[0].length;j++) {
			System.out.print(sign[0][j]+" ");
		}
		System.out.print("\n기호 아스키코드 ");
		for (int j = 0 ; j<sign[1].length;j++) {
			System.out.print((char)sign[1][j]+" ");
		}
		
		count=0;
		int[][] par = new int[2][parCount];
		
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i]==40)
			{
				par[0][count]=i;
				par[1][count]=40;
				count++;
			}
			else if (inputArr[i]==41)
			{
				par[0][count]=i;
				par[1][count]=41;
				count++;
			}		
		}//괄호를 배열로 저장, 0행엔 index, 1행엔 아스키코드
		
		System.out.print("\n괄호 인덱스 ");
		for (int j = 0 ; j<par[0].length;j++) {
			System.out.print(par[0][j]+" ");
		}
		System.out.print("\n괄호 아스키코드 ");
		for (int j = 0 ; j<par[1].length;j++) {
			System.out.print((char)par[1][j]+" ");
		}		
		
		System.out.println();
		System.out.println();
		
		Calculate cal = new Calculate();
		
		int startIndex=0;
		int endIndex=0;
		for (int len =0;len<par[0].length;len++)
		{
			if (par[1][len]==41)
			{
				endIndex=par[0][len];
				par[1][len]=0;
				while (true)
				{					
					len--;
					if (par[1][len]==40)
					{
						startIndex=par[0][len];
						par[1][len]=0;
						break;
					}
				}
				System.out.println(endIndex);
				System.out.println(startIndex);
				
				for (int i = signCount-1; i>=0;i--)
				{
					if (sign[0][i]>startIndex&&sign[0][i]<endIndex)
					{
						if (sign[1][i]==42||sign[1][i]==47)				
						{
							cal.num1=num[i];
							cal.num2=num[i+1];
							cal.sign=(char)sign[1][i];				
							cal.CalMulDiv();
							num[i]=cal.num1;
							num[i+1]=cal.num2;
							sign[1][i]=cal.sign;
						}
					}//인덱스 확인후 계산
				}//곱셈,나눗셈 먼저
				
				System.out.print("곱셈 먼저 계산 ");
				for (int i = 0;i< num.length-1;i++)
				{
					System.out.print(num[i]+" "+(char)sign[1][i]+" ");
				}
				System.out.print(num[num.length-1]);
				
				for (int i = signCount-1; i>=0;i--)
				{
					if (sign[0][i]>startIndex&&sign[0][i]<endIndex)
					{
					cal.num1=num[i];
					cal.num2=num[i+1];
					cal.sign=(char)sign[1][i];				
					cal.CalAddSub();
					num[i]=cal.num1;
					num[i+1]=cal.num2;
					sign[1][i]=cal.sign;
					}//인덱스 확인 후 계산
				}//덧셈, 뺄셈
				
				System.out.println();
				System.out.print("덧셈 뺄셈 계산 ");
				for (int i = 0;i< num.length-1;i++)
				{
					System.out.print(num[i]+" "+(char)sign[1][i]+" ");
				}
				System.out.print(num[num.length-1]);	
				
//				for (int i = 0; i<signCount;i++)
//				{
//					if (sign[0][i]>startIndex&&sign[0][i]<endIndex)
//					{
//						if (num[i+1]==0)
//						{
//							num[i+1]=1;
//							sign[1][i]='*';
//						}
//					}//인덱스 확인 후 변환
//				}//변환
//				
//				System.out.println();
//				System.out.print("변환 계산 확인 ");
//				for (int i = 0;i< num.length-1;i++)
//				{
//					System.out.print(num[i]+" "+(char)sign[1][i]+" ");
//				}
//				System.out.print(num[num.length-1]);	
				
				//괄호 안 계산
				System.out.println();
				
			}						
			
		}//괄호 인덱스 찾기
		
		for (int i = signCount-1; i>=0;i--)
		{
			if (sign[1][i]==42||sign[1][i]==47)				
			{
				cal.num1=num[i];
				cal.num2=num[i+1];
				cal.sign=(char)sign[1][i];				
				cal.CalMulDiv();
				num[i]=cal.num1;
				num[i+1]=cal.num2;
				sign[1][i]=cal.sign;
			}
		}//곱셈,나눗셈 먼저
		
		System.out.println();
		System.out.print("곱셈 먼저 계산 ");
		for (int i = 0;i< num.length-1;i++)
		{
			System.out.print(num[i]+" "+(char)sign[1][i]+" ");
		}
		System.out.print(num[num.length-1]);	
		
//		for (int i = 0; i<signCount;i++)
//		{
//			cal.num1=num[i];
//			cal.num2=num[i+1];
//			cal.sign=(char)sign[1][i];				
//			cal.CalAddSub();
//			num[i]=cal.num1;
//			num[i+1]=cal.num2;
//			sign[1][i]=cal.sign;			
//		}//덧셈, 뺄셈
//		
//		System.out.println();
//		System.out.print("덧셈 뺄셈 계산 ");
//		for (int i = 0;i< num.length-1;i++)
//		{
//			System.out.print(num[i]+" "+(char)sign[1][i]+" ");
//		}
//		System.out.print(num[num.length-1]);	
		
		double result=num[0];
		for (int i = 1 ; i<num.length;i++)
			if (num[i]!=1&&sign[1][i-1]!='-')
			{
				result +=num[i];
			}
			else if (num[i]!=1&&sign[1][i-1]=='-')
			{
				result -=num[i];
			}
		
//		double result=num[0];
//		for (int i = 0 ; i<signCount;i++)
//		{
//			if (sign[1][i]==42)
//			{
//				result *= num[i+1];
//			}
//			else if (sign[1][i]==43)
//			{
//				result += num[i+1];
//			}
//			else if (sign[1][i]==45)
//			{
//				result -= num[i+1];
//			}
//			else if (sign[1][i]==47)
//			{
//				result /= num[i+1];
//			}
//		}//계산
	
		
		System.out.println();
		System.out.println("계산 결과 : "+result);
		
	}//end of main

}
