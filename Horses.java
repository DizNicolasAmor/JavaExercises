
/*
Thread Exercise. It is a horse race, where each horse is a thread.

Ejercicio de Threads. Es una carrera de caballos, donde cada caballo es un hilo. 
*/

import java.util.Scanner; 

public class Horses extends Thread{

 private String name;
 private int count;
 
 public Horses(String name){
  this.name=name;
 }

 public void run(){
	 for(int i=0; i<=100; i++){
			count++;
			try {
       Thread.sleep((int)(Math.random()*600));
			}catch(InterruptedException e){
				e.printStackTrace();
      }
			System.out.println(name+" - "+count);
	 }		
 } 

 public static void main(String[]args){
  
  int n; 
  Scanner s = new Scanner(System.in);
  
  System.out.println("Bienvenido a la carrera de 100 metros. ");
  System.out.println("¿Cuántos caballos quieres que corran? ");
  n = s.nextInt();
	  
  Thread[] horse = new Horses[n];
	
  System.out.println("La carrera comienza: \n\n");
  
  for(int i=0; i<n; i++){
   horse[i] = new Horses("Horse Nº"+(i+1));
   horse[i].start();
  }

  try {
   for(int i=0;i<n;i++){
    horse[i].join();
   }
  }catch(Exception e){
   System.out.println(e);
  }

  System.out.println("\n\nLa carrera ha finalizado. \n\n"); 
  
  }  //main
}  //class 
