package test;

import java.util.*;

class SomarDoisNumeros
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		int x, y, soma;
		
		System.out.println("Digite um número:");
		x = sc.nextInt();
		
		System.out.println("Digite outro número:");
		y = sc.nextInt();
		
		soma = x + y;
		
		System.out.println("Soma: " + soma);
	}	
}