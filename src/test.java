import java.util.Random;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
		Random r1 = new Random();
		for(int i=0; i<20 ; i++)
			System.out.println(RandomMethods.randomIntInterval(2,4));
	}
}
