import java.util.Random;

public class RandomMethods {
	
	/**
	 * Calculate a random int between 0 end the limit.
	 * @param limit an integer.
	 * @return the random number between 0 and the limit.
	 */
	public static int randomInt(int limit){
		Random r1 = new Random();
		int result = r1.nextInt(limit+1);
		return result;
	}
	
	public static int randomIntInterval(int limitInf, int limitSup){
		Random r1 = new Random();
		int interval = limitSup-limitInf;
		return r1.nextInt(interval+1)+ limitInf;
	}
	
}
