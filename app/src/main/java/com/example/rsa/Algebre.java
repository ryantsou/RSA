package com.example.rsa;

public class Algebre {

	public static boolean isPremier(int nombre ){
		if(nombre == 1)
			return false;
		else{
			int answer = 2;
			do{
				if(nombre % answer == 0 )
					return false;
				answer++;
			}while(answer < nombre);
		}
		return true;
	}
	public static int pgcd(int a, int b){
		int r = a % b;
		while (r != 0){
			a = b; b = r;
			r = a % r;
		}
		return b;
	}
	public static int[] euclide_etendu(int a, int b){
		int r = a % b, q, x =0, y = 1, xx = 1, yy = 0;
		while(r != 0){
			int temp1 = xx, temp2 = yy;
			q = a / b;
			xx = x - (q * xx);
			yy = y - (q * yy);
			x = temp1; y = temp2;
			a = b; b = r;
			r = a % r;
		}
		return new int[]{b, xx, yy};
	}
	public static int inverse(int a, int n){
		int[] tab = euclide_etendu(a, n);
		if (tab[0] != 1)
			return 0;
		else if(tab[1] < 0)
			return (tab[1] + a);
		else
			return tab[1] ;
	}

	public static long exponention_rapide(long x, long m , long z){
		long solution;
		if(m == 0)
			solution =  1;
		else if (m == 1)
			solution =  x;
		else if(m % 2 == 0)
			solution =  (long) Math.pow(exponention_rapide(x, m/2, z), 2) % z;
		else{ 
			solution = (x * (long) Math.pow(exponention_rapide(x, (m-1) / 2, z), 2)) % z;
		}
		return solution;
		
	}



}

