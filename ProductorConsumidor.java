/* Productor genera productos (cáctus) y los deja disponible 
 * Consumidor los consume.
 * sincronizar con wait / notify:
	el consumidor no trate de consumir si no hay productor
	el productor no produzca hasta que no se haya consumido el producto. */

public class User implements Runnable {
	private boolean user; 
	private static int product = 20;
	private Object lock1 = new Object(); 
	private Object lock2 = new Object();
	
	public User(boolean user){
		this.user = user;
	}
	
	private void consume(){
		synchronized(lock1){
			if(product > 0) {
				product--;
				System.out.println("Un cliente ha comprado un cáctus. Ahora quedan "+product);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				e.printStackTrace();			}
			}/*else{
				lock1.notifyAll();
				try {
					lock1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();			}
			}*/
		}
	}

	private void produce(){
		synchronized(lock2){
			if(product ==0){
				product = 20;
				System.out.println("Se han acabado los cáctus.");
				System.out.println("El productor está trayendo nuevos productos... \n\n");
				System.out.println("El productor ha traído 20 cáctus nuevos! ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();			}
			/*	lock2.notifyAll();
				try {
					lock2.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();			}*/
			}
		}
	}

	@Override
	public void run() {
		while(true){
			if (user==true){
				consume();
			}else{
				produce();	
			}
		}
		
	}

	public static void main(String[]args) throws Exception{
		
		System.out.println("Bienvenido a la feria de los cáctus. \n\n");
		System.out.println("Quedan 20 cáctus disponibles. ");
		
		Thread[] hilos = new Thread[5]; 
		
		for(int i=0; i<4; i++){
			Runnable u = new User(true);
			hilos[i] = new Thread(u);
			hilos[i].start();
		}
		
		Runnable p = new User(false);
		hilos[4] = new Thread(p);
		hilos[4].start();
		
		for(int i=0; i<5; i++){
			hilos[i].join();
		}


	}

}
