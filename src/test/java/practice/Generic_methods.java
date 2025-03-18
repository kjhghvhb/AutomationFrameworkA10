package practice;

import GenericUilities.JavaUtility;

public class Generic_methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=add(20,30);
		System.out.println(sum);
		int v=add(sum,70);
		System.out.println(v);
		System.out.println(add(100,200));
		
		//multiplication
		
		int prod=Mul(20,30);
		System.out.println(prod);
		int h=Mul(prod,70);
		System.out.println(h);
		System.out.println(Mul(100,200));
		
		JavaUtility j = new JavaUtility();
		System.out.println(j.getSystemDateInFormat());
		
			
	
	}
	
	public static int add(int a,int b)
	{
		int c=a+b;
		return c;
	}
	public static int Mul(int e,int f)
	{
		int g=e*f;
		return g;
	}

}
