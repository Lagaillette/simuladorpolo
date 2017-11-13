import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static Polo polo = null;
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		File file = null;
		file = new File("polo.ser");
    	if(file.exists()){
    		deSerializePolo();
    	}
		
		
		
		Polo polo = new Polo();
		GUIClass appWindow = new GUIClass();
		Animal animal = new Bacalao(12);
		if(animal instanceof Pez){
			System.out.println(animal);
		}
		System.out.println(polo.getMorsas().size());
		System.out.println(polo.getNbMorsas());
		System.out.println(animal);
	}
	
	public static void serializePolo(){
		ObjectOutputStream oos = null;
		try {
			
			final FileOutputStream fichier = new FileOutputStream("polo.ser");	
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(polo);
			oos.flush();
		
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
			if (oos != null) {	
			oos.flush();	
			oos.close();	
		}	
		} catch (final IOException ex) {
			
			ex.printStackTrace();
			
		}
		}
	}
	
	public static void deSerializePolo(){
		ObjectInputStream ois = null;
		try {
		      final FileInputStream fichier = new FileInputStream("polo.ser");
		      ois = new ObjectInputStream(fichier);
		      polo = (Polo) ois.readObject();
		      System.out.println("Polo : ");
		     // polo.mostrarDetalles();     CAUSA PROBLEMAS!!!!!
		      
	    } catch (final java.io.IOException e) {
	      e.printStackTrace();
	    } catch (final ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (ois != null) {
	          ois.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }
	}
}
