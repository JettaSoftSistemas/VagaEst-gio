package Exercicios02;

public class Fibonacci {
	private int n1;
	private int n2;
	
	public Fibonacci() {
		this.n1=0;
		this.n2=1;
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}

	public void sequenceFibonacci(int v){
		System.out.print(n1);
		for (int i = 0; i < v; i++) {
			System.out.print(" "+n2);
			n2=n1+n2;
			n1=n2-n1;
		}
	}
	
	
}
