package Battleship;
import java.util.Scanner;
public class Battleship {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int taula[][]=new int[10][10],disparoLetra=0,disparoNumero=0,contMenu=0,numBarcos=0;
		while(contMenu==0) {
			System.out.println("--------------------");
			System.out.println("-----BATTLESHIP-----");
			System.out.println("--------------------\n");
			System.out.println("1. Fácil");
			System.out.println("2. Normal");
			System.out.println("3. Dificil");
			System.out.println("4. Personalizado");
			System.out.println("Salir\n");
			System.out.println("Elige opción");
			int triar=sc.nextInt();
			switch(triar) {
			case 1:
				int intentos1=50;
				numBarcos=1;
				inserixPortavions(taula,numBarcos);
				inserixAcorazado(taula,numBarcos);
				inserixVaixells(taula,numBarcos);
				inserixLlanxa(taula,numBarcos);
				while(intentos1>0) {										
					tableroOculto(taula);
					System.out.println("Tienes "+intentos1+" intentos");
					tablero(taula);
					disparo(disparoLetra,disparoNumero,taula,intentos1);
					intentos1--;
				}
				
				
			case 2:
				int intento=30;
				numBarcos=2;
				inserixPortavions(taula,numBarcos);
				inserixAcorazado(taula,numBarcos);
				inserixVaixells(taula,numBarcos);
				inserixLlanxa(taula,numBarcos);
				while(intento>0) {										
					tableroOculto(taula);
					System.out.println("Tienes "+intento+" intentos");
					tablero(taula);
					disparo(disparoLetra,disparoNumero,taula,intento);
					intento--;
				}
				
			case 3:
				int intentos3=10;
				numBarcos=3;
				inserixPortavions(taula,numBarcos);
				inserixAcorazado(taula,numBarcos);
				inserixVaixells(taula,numBarcos);
				inserixLlanxa(taula,numBarcos);
				while(intentos3>0) {										
					tableroOculto(taula);
					System.out.println("Tienes "+intentos3+" intentos");
					tablero(taula);
					disparo(disparoLetra,disparoNumero,taula,intentos3);
					intentos3--;
				}
				
			case 4:				
				int x=0,y=0;
				System.out.println("Escribe las dimensiones del mapa (MIN 5x5 y MAX 20x20)");
				System.out.println("Eje x será:");
				x=sc.nextInt();
				System.out.println("Eje y será");
				y=sc.nextInt();
				int taula2[][]=new int[x][];
				System.out.println("Escribe cuantos intentos quieres");
				int intentos4=sc.nextInt();
				numBarcos=4;
				inserixPortavions(taula2,numBarcos);
				inserixAcorazado(taula2,numBarcos);
				inserixVaixells(taula2,numBarcos);
				inserixLlanxa(taula2,numBarcos);
				while(intentos4>0) {										
					tableroOculto(taula2);
					System.out.println("Tienes "+intentos4+" intentos");
					tablero(taula2);
					disparo(disparoLetra,disparoNumero,taula2,intentos4);
					intentos4--;
					
				}
				
			case 5:
				contMenu=2;
																			
			}
			
			System.out.println("El joc ha finalitzat");
			
			
				
			
		}
		
		
		
		
	}
	
	public static void disparo(int num1,int num2,int taula[][],int intento) {
		num1=coordenadaIntroLetra(num1);
		num2=coordenadaIntroNum(num2);
		
		for(int i=0;i<taula.length;i++) {
			for(int j=0;j<taula[i].length;j++) {
				if(taula[i][j]==1) {
					if(taula[i][j]==taula[num1][num2]) {
						taula[i][j]=2;
					}
									
				}												
				else if(taula[i][j]==4) {
					if(taula[i][j]==taula[num1][num2]) {
						taula[i][j]=2;
					}
					
				}
				else if(taula[i][j]==5) {
					if(taula[i][j]==taula[num1][num2]) {
						taula[i][j]=2;
					}
					
				}
				else if(taula[i][j]==6) {
					if(taula[i][j]==taula[num1][num2]) {
						taula[i][j]=2;
					}
					
				}														
			}
			
		}	
		if(taula[num1][num2]!=1 && taula[num1][num2]!=2 && taula[num1][num2]!=4 && taula[num1][num2]!=5 && taula[num1][num2]!=6) {
			taula[num1][num2]=3;
		}
			
	}
	
	
	
	public static void tablero(int taula[][]) {
		char letrasFila='A';
		int numeroColumna=1;
		System.out.print("   ");
		for(int cont=0;cont<taula.length;cont++) {
			System.out.print(" "+numeroColumna+" ");
			numeroColumna++;
		}
		System.out.println(" ");				
		for(int i=0;i<taula.length;i++) {
			System.out.print(" "+letrasFila+" ");
			letrasFila++;
			for(int j=0;j<taula[i].length;j++) {
				if(taula[i][j]==2) {
					System.out.print(" X ");
				}else if(taula[i][j]==3) {
					System.out.print(" A ");
				}
				else {
					System.out.print(" - ");
				}
				
				
				
											
			}
			
			System.out.println(" ");
		}
		
		
	}

	
	public static void tableroOculto(int taula[][]) {
		for (int i=0;i<taula.length;i++) {
			for(int j=0;j<taula[i].length;j++) {
				if (taula[i][j]==1) {
					System.out.print(" L ");
				}else if(taula[i][j]==2) {
					System.out.print(" T ");
				}else if(taula[i][j]==3) {
					System.out.print(" A ");
				}else if(taula[i][j]==4) {
					System.out.print(" B ");
				}else if (taula[i][j]==5) {
					System.out.print(" Z ");
				}else if (taula[i][j]==6) {
					System.out.print(" P ");
				}
				
				else {
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}
	}
	
	public static int coordenadaIntroLetra(int num1 ) {
		Scanner sc=new Scanner(System.in);
		int paraLetra;
		System.out.println("Escribe una letra MAYÚSCULA ");
		char letra=sc.next().charAt(0);
		num1=letraNumero(letra);
		
		return num1;
	}
	
	
	public static int letraNumero(char letra) {
			int num1=0;
			if (letra=='A') {
				num1=0;						
			}
			if(letra=='B') {
				num1=1;
			}
			if(letra=='C') {
				num1=2;
			}
			if(letra=='D') {
				num1=3;
			}
			if(letra=='E') {
				num1=4;
			}
			if(letra=='F') {
				num1=5;
			}
			if(letra=='G') {
				num1=6;
			}
			if(letra=='H') {
				num1=7;
			}
			if(letra=='I') {
				num1=8;
			}
			if(letra=='J') {
				num1=9;
			}
			if (letra=='K') {
				num1=10;
			}
			if (letra=='L') {
				num1=11;
			}
			if (letra=='M') {
				num1=12;
			}
			if (letra=='N') {
				num1=13;
			}
			if(letra=='O') {
				num1=14;
			}
			if(letra=='P') {
				num1=15;
			}
			if(letra=='Q') {
				num1=16;
			}
			if(letra=='R') {
				num1=17;
			}
			if(letra=='S') {
				num1=18;
			}
			if(letra=='T') {
				num1=19;
			}
			return num1;
		}
	
	public static void inserixLlanxa(int tableroLleno[][],int numBarco) {
		Scanner sc=new Scanner(System.in);
		int cont=0,num=0;
		if (numBarco==1) {
			num=5;
		}
		if (numBarco==2) {
			num=2;
		}
		if (numBarco==3) {
			num=1;
		}
		if (numBarco==4) {
			System.out.println("Escribe cuantas Lanchas quieres");
			num=sc.nextInt();
		}
		while(cont<num) {
			int num1=(int)((Math.random())*(9+1));
			int num2=(int)((Math.random())*(9+1));			
			
			while(tableroLleno[num1][num2]==4 || tableroLleno[num1][num2]==5 || tableroLleno[num1][num2]==6 || tableroLleno[num1][num2]==1) {				
			num1=(int)((Math.random())*(9+1));
			num2=(int)((Math.random())*(9+1));
																		
			}
			tableroLleno[num1][num2]=1;
			cont++;
		}
	}

	public static void inserixVaixells(int tablero[][],int numBarcos) {
		Scanner sc=new Scanner(System.in);
		int cont1=0,num=0;
		if (numBarcos==1) {
			num=3;
		}
		if (numBarcos==2) {
			num=1;
		}
		if (numBarcos==3) {
			num=1;
		}
		if (numBarcos==4) {
			System.out.println("Escoge cuantos Barcos quieres");
			num=sc.nextInt();
		}
		
		while(cont1<num) {
			int num1=(int)((Math.random())*(5+1));
			int num2=(int)((Math.random())*(9+1)),cont3=0,cont4=0;
			cont3=num1+2;
			cont4=num1+1;
			
			
			while(tablero[num1][num2]==6 || tablero[cont4][num2]==6 || tablero[cont3][num2]==6 || tablero[num1][num2]==5 || tablero[cont4][num2]==5 || tablero[cont3][num2]==5 || tablero[num1][num2]==4 || tablero[cont4][num2]==4 || tablero[cont3][num2]==4) {
				 num1=(int)((Math.random())*(5+1));
				 num2=(int)((Math.random())*(9+1));
				 cont3=num1+2;
			}
			
			for (int cont2=0;cont2<3;cont2++) {
				tablero[num1][num2]=4;
				num1++;
			}
			cont1++;
		}
		
		
	}
	
	public static void inserixAcorazado(int tablero[][],int numBarcos) {
		Scanner sc=new Scanner(System.in);
		int num=0;
		if (numBarcos==1) {
			num=1;
		}
		if (numBarcos==2) {
			num=1;
		}
		if (numBarcos==3) {
			num=0;
		}
		if (numBarcos==4) {
			System.out.println("Escoge cuantos acorazados quieres");
			num=sc.nextInt();
		}
		
		while (0<num) {
		int num1=(int)((Math.random())*(9+1));
		int num2=(int)((Math.random())*(5+1)),cont1=0,cont2=0,cont3=0,cont4=0;
		cont1=num2+2;
		cont2=num2+3;
		cont4=num2+1;
		while(tablero[num1][num2]==6 || tablero[num1][cont4]==6 || tablero[num1][cont1]==6 || tablero[num1][cont2]==6 || tablero[num1][num2]==4 || tablero[num1][cont4]==4 || tablero[num1][cont1]==4 || tablero[num1][cont2]==4 ) {
		
			num1=(int)((Math.random())*(9+1));
			num2=(int)((Math.random())*(5+1));
			cont1=num2+2;
			cont2=num2+3;
			cont3=0;
		}
		
			for(int cont=0;cont<4;cont++) {
			 tablero[num1][num2]=5;
			 num2++;
			}
			cont3=2;
			num--;
		}
		
		 
		
	}
	
	public static void inserixPortavions(int tablero[][],int numBarcos) {
		Scanner sc=new Scanner(System.in);
		int num=0;
		if (numBarcos==1) {
			num=1;
		}
		if (numBarcos==2) {
			num=1;
		}
		if (numBarcos==3) {
			num=0;
		}
		if (numBarcos==4) {
			System.out.println("Escoge cuantos Portaaviones quieres");
			num=sc.nextInt();
		}
		
		while(0<num) {
		int num1=(int)((Math.random())*(4+1));
		int num2=(int)((Math.random())*(9+1));
		for(int cont=0;cont<5;cont++) {
			tablero[num1++][num2]=6;
		}
		num--;
		}
		
	}
	
	public static int coordenadaIntroNum(int num1) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número");
		num1=sc.nextInt();
		num1--;
		return num1;
	}
	
	
}


	
