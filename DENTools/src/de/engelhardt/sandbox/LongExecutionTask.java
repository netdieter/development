/**
 * 
 */
package de.engelhardt.sandbox;

/**
 * @author dieter
 *
 */
public class LongExecutionTask extends Thread {

	private int i;
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
		i = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while (i < 100){
				sleep(500L);
				System.out.println("LongExecutionTask counter:" +i );
				i++;
			}
			System.out.println("LongExecutionTask END" );
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
