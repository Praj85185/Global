import java.util.Scanner;
import java.util.Arrays;
public class App_Divisibility{
	public static void main(String[]args){
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the divident number :");
	int n=in.nextInt();
	int count=0;
	System.out.println();
	System.out.println("Enter the divisor number :");
	int div=in.nextInt();
	System.out.println();
	//while(count<10){
	switch(div){
		case 1:
		System.out.println("The given number is divisible by 1");
		count++;
		break;
		case 2:
		case2(n);
		break;
		case 3:
		case3(n);
		break;
		case 4:
		String str=String.valueOf(n);
		String str2=str.substring(str.length()-2, str.length());
		int n4=Integer.parseInt(str2);
		if(n4%4==0){
			System.out.println("The given number is divisible by 4");
		}
		else{
			System.out.println("The given number is not divisible by 4");
		}
		break;
		case 5:
		int rem5;
		rem5=n%10;
		if(rem5==0||rem5==5){
			System.out.println("The given number is divisible by 5");
		}
		else{
			System.out.println("The given number is not divisible by 5");
		}
		break;
		case 6:
		case2(n);
		case3(n);
		//
		break;
		case 8:
		String str8=String.valueOf(n);
		String str7=str8.substring(str8.length()-3, str8.length());
		int n8=Integer.parseInt(str7);
		if(n8%8==0){
			System.out.println("The given number is divisible by 8");
		}
		else{
			System.out.println("The given number is not divisible by 8");
		}
		break;
		case 9:
		int sum9=0;
		int rem9;
		while(n>0){
			rem9=n%10;
			sum9+=rem9;
			n/=10;
		}
		if(sum9%9==0){
			System.out.println("The given number is divisible by 9");
		}
		else{
			System.out.println("The given number is not divisible by 9");
		}
		break;
		case 10:
		int rem10=n%10;
		if(rem10==0){
			System.out.println("The given number is divisible by 10");
		}
		else{
			System.out.println("The given number is not divisible by 10");
		}
		break;
		default:
		System.out.println("Your request will be processed in the future !!!");
	}
	//
	//
	}
	static void case3(int n){
	int rem3;
	int sum3=0;
	while(n>0){
			rem3=n%10;
			sum3+=rem3;
			n/=10;
		}
		if(sum3%3==0){
			System.out.println("The given number is divisible by 3");
		}
		else{
			System.out.println("The given number is not divisible by 3");
		}
	}  
	static void case2(int n){
	int rem=n%10;
		if(rem%2==0){
			System.out.println("The given number is divisible by 2");
		}
		else{
			System.out.println("The given number is not divisible by 2");
		}	
	}
}