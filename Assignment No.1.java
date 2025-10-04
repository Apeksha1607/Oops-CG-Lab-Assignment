import java.util.Scanner;
public class cal 
{
 
	double num1,num2;
	 public double ans;
	 public char op;
	 
	 public void input() 
	 {
		Scanner in=new Scanner(System.in);
	 	System.out.println("Enter numbers:");
	    num1=in.nextDouble();
	    num2=in.nextDouble();
	    System.out.println("Enter the operation:");
	    op=in.next().charAt(0);
	}

	public void calculation()
	{
		switch(op)
		{
		case'+':
			ans=num1+num2;
			System.out.println("Answer is"+ans);
			break;
		case'-':
			ans=num1-num2;
			System.out.println("Answer is"+ans);
			break;
		case'*':
			ans=num1*num2;
			System.out.println("Answer is"+ans);
			break;
		case'/':
			ans=num1/num2;
			System.out.println("Answer is"+ans);
			break;
		default:
			System.out.println("Operation is Invalid");
		}
	}
	public static void main (String arg[]) {
	  	 cal obj=new cal();
		 obj.input();
		 obj.calculation();
	
}
}
