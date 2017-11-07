import java.util.ArrayList;
import java.util.Iterator;

public class Polo{

	public int fecha;
	
	public float temperaturaAgua;
	
	public ArrayList<Animal> animales = new ArrayList<Animal>();
	
	//el numero de krill que hay en el polo(en million)
	public int krill;
	
	public Polo(){
		
		this.fecha = 1;
		
		this.temperaturaAgua = 4;
		
		int nbPeces = RandomMethods.randomIntInterval(7000, 8000);
		
		for(int i=0; i < nbPeces; i++){
			int typoPez = RandomMethods.randomIntInterval(1, 3);
			int masaMuscular = RandomMethods.randomIntInterval(55, 70);
			if(typoPez == 1){
				this.animales.add(new Bacalao(masaMuscular));
			}else{
				if(typoPez == 2){
					this.animales.add(new Raya(masaMuscular));
				}else{
					this.animales.add(new MerluzaNegra(masaMuscular));
				}
			}
			
		}
		
		int nbOsosPolares = RandomMethods.randomIntInterval(22, 28);
		for(int i=0; i < nbOsosPolares; i++){
			int masaMuscular = RandomMethods.randomIntInterval(40, 55);
			this.animales.add(new OsoPolar(masaMuscular));
		}
		
		int nbMorsas = RandomMethods.randomIntInterval(42, 48);
		for(int i=0; i < nbMorsas; i++){
			int masaMuscular = RandomMethods.randomIntInterval(30, 42);
			this.animales.add(new Morsa(masaMuscular));
		}
		
		int nbFocas = RandomMethods.randomIntInterval(260, 290);
		for(int i=0; i < nbFocas; i++){
			int masaMuscular = RandomMethods.randomIntInterval(25, 32);
			this.animales.add(new Foca(masaMuscular));
		}
		
		int nbEsquimales = RandomMethods.randomIntInterval(12, 14);
		for(int i=0; i < nbEsquimales; i++){
			int masaMuscular = RandomMethods.randomIntInterval(35, 48);
			this.animales.add(new Esquimal(masaMuscular));
		}
		
		this.krill = RandomMethods.randomIntInterval(65, 75) * 1000;
		
		
	}
	
	public boolean transcurrirUnDia(){
		if(this.animales.size()!=0) {
		this.fecha += 1;
		//hacemos el cambiamento de la temperatura
		this.cambiamentoTemperatura();
		//hacemos la reproduccion de los krilles
		this.ReproduccionKrilles();
		
		this.diaPeces();
		this.diaOsosPolares();
		this.diaFocas();
		this.diaMorsas();
		this.diaEsquimales();
		if(this.animales.size() == 0){
			System.out.println("en este dia " + this.fecha + ", el ecosistema se extinga..");
			return false;
		}
		return true;
		}
		else
		return false;
		
		
		/**
		this.fecha += 1;
		
		// inicializacion de los animales muertos en el dia
		int pecesMuertos = 0;
		int morsasMuertos = 0;
		int ososMuertos = 0;
		int focasMuertos = 0;
		int esquimalesMuertos = 0;
		
		//hacemos el cambiamento de la temperatura
		this.cambiamentoTemperatura();
		//hacemos la reproduccion de los krilles
		this.ReproduccionKrilles();
		//creamos el iterator de la lista de animales
		Iterator it = animales.iterator();
		while(it.hasNext()){
			//cogemos el animal de la lista
			Animal animal = (Animal) it.next();
			
			//verificamos el typo de animal que es
			if( animal instanceof Pez){
				ArrayList comida = animal.comer();
				if((int) comida.get(0) <= this.krill){
					this.krill -= (int) comida.get(0);
				}else{
					it.remove();
				}	
			}
			
			if( animal instanceof OsoPolar){
				ArrayList comida = animal.comer();
				if((int) comida.get(0) <= getNbPeces()){
					if((int) comida.get(1) <= getNbFocas()){
						pecesMuertos += (int) comida.get(0);
						focasMuertos += (int) comida.get(1);
					}else{
						it.remove();
					}
				}else{
					it.remove();
				}
			}
			
			if( animal instanceof Foca){
				ArrayList comida = animal.comer();
				if((int) comida.get(0) <= getNbPeces()){
					pecesMuertos += (int) comida.get(0);
				}else{
					it.remove();
				}
			}
			if( animal instanceof Morsa){
				ArrayList comida = animal.comer();
				if((int) comida.get(0) <= getNbOsosPolares()){
					if((int) comida.get(1) <= getNbFocas()){
						ososMuertos += (int) comida.get(0);
						focasMuertos += (int) comida.get(1);
						
					}else{
						it.remove();
					}
				}else{
					it.remove();
				}
			}
			if( animal instanceof Esquimal){
				ArrayList comida = animal.comer();
				if((int) comida.get(0) <= getNbPeces()){
					if((int) comida.get(1) <= getNbFocas()){
						pecesMuertos += (int) comida.get(0);
						focasMuertos += (int) comida.get(1);
					}else{
						it.remove();
					}
				}else{
					it.remove();
				}
				
			}
		}
		this.eliminarPeces(pecesMuertos);
		this.eliminarEsquimales(esquimalesMuertos);
		this.eliminarFocas(focasMuertos);
		this.eliminarMorsas(morsasMuertos);
		this.eliminarOsosPolares(ososMuertos);
		
		Iterator it2 = this.animales.iterator();
		ArrayList listAnimales = new ArrayList();
		while(it2.hasNext()){
			Animal animal = (Animal) it2.next();
			if(animal.reproducir()){
				if(animal instanceof Pez){
					listAnimales.add(new Pez(animal, this.fecha));
				}
				if(animal instanceof Morsa){
					listAnimales.add(new Morsa(animal, this.fecha));
				}
				if(animal instanceof Foca){
					listAnimales.add(new Foca(animal, this.fecha));
				}
				if(animal instanceof Esquimal){
					listAnimales.add(new Esquimal(animal, this.fecha));
				}
				if(animal instanceof OsoPolar){
					listAnimales.add(new OsoPolar(animal, this.fecha));
				}
				
			}
			if(!animal.morrir()){
				listAnimales.add(animal);
			}
		}
		
		this.animales = listAnimales;
		
		**/
	}
		
	
	public void transcurrirDiezDia(){
		for(int i=0; i<10; i++){
			this.transcurrirUnDia();
		}
	}
	
	public void diaPeces(){
		ArrayList animales = getPeces();
		Iterator it = animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			ArrayList comida = animal.comer();
			if((int) comida.get(0) <= this.krill){
				this.krill -= (int) comida.get(0);
			}else{
				this.animales.remove(animal);
			}	
			if(animal.reproducir()){
				this.animales.add(new Pez(animal, this.fecha));
			}
			if(animal.morrir()){
				this.animales.remove(animal);
			}
		}
	}
	
	public void diaOsosPolares(){
		ArrayList animales = getOsosPolares();
		Iterator it = animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			ArrayList comida = animal.comer();
			if((int) comida.get(0) <= getNbPeces() && (int) comida.get(1) <= getNbFocas()){
				this.eliminarPeces((int) comida.get(0));
				this.eliminarFocas((int) comida.get(1));			
			}else{
				this.animales.remove(animal);
			}
			if(animal.reproducir()){
				this.animales.add(new OsoPolar(animal, this.fecha));
			}
			if(animal.morrir()){
				this.animales.remove(animal);
			}
		}
	}
	
	public void diaFocas(){
		ArrayList animales = getFocas();
		Iterator it = animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			ArrayList comida = animal.comer();
			if((int) comida.get(0) <= getNbPeces()){
				this.eliminarPeces((int) comida.get(0));
			}else{
				this.animales.remove(animal);
			}
			if(animal.reproducir()){
				this.animales.add(new Foca(animal, this.fecha));
			}
			if(animal.morrir()){
				this.animales.remove(animal);
			}
		}
	}
	
	public void diaMorsas(){
		ArrayList animales = getMorsas();
		Iterator it = animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			ArrayList comida = animal.comer();
			if((int) comida.get(0) <= getNbOsosPolares() && (int) comida.get(1) <= getNbFocas()){
				this.eliminarOsosPolares((int) comida.get(0));
				this.eliminarFocas((int) comida.get(1));
			}else{
				this.animales.remove(animal);
			}
			if(animal.reproducir()){
				this.animales.add(new Morsa(animal, this.fecha));
			}
			if(animal.morrir()){
				this.animales.remove(animal);
			}
		}
	}
	
	public void diaEsquimales(){
		ArrayList animales = getEsquimales();
		Iterator it = animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			ArrayList comida = animal.comer();
			if((int) comida.get(0) <= getNbPeces() && (int) comida.get(1) <= getNbFocas()){
				this.eliminarPeces((int) comida.get(0));
				this.eliminarFocas((int) comida.get(1));
			}else{
				this.animales.remove(animal);
			}
			if(animal.reproducir()){
				this.animales.add(new Esquimal(animal, this.fecha));
			}
			if(animal.morrir()){
				this.animales.remove(animal);
			}
		}
	}
	/**
	 * Permite hacer el cambiamento de temperatura diaria
	 */
	public void cambiamentoTemperatura(){
		if(this.temperaturaAgua < 5.5){
			if(this.temperaturaAgua >= 5){
				int probabilidad = RandomMethods.randomInt(100);
				if(probabilidad <= 45){
					this.temperaturaAgua += 0.2;
				}else{
					this.temperaturaAgua -= 0.2;		
				}
			}else{
				if(this.temperaturaAgua > 3){
					int probabilidad = RandomMethods.randomInt(100);
					if(probabilidad <= 65){
						this.temperaturaAgua += 0.2;
					}else{
						if(probabilidad <= 95){
							this.temperaturaAgua -= 0.2;
						}
					}
				}else{
					int probabilidad = RandomMethods.randomInt(100);
					if(probabilidad <= 55){
						this.temperaturaAgua += 0.2;
					}else{
						this.temperaturaAgua -= 0.2;		
					}
				}
			}
		}
	}
	
	/**
	 * permite cambiar el numero de Krilles en el polo
	 */
	public void ReproduccionKrilles(){
		if(this.temperaturaAgua < 5.5){
			if(this.temperaturaAgua >= 5){
				this.krill += 12;
			}else{
				if(this.temperaturaAgua >= 4){
					this.krill += 22;
				}else{
					if(this.temperaturaAgua >= 3){
						this.krill += 18;
					}
				}
			}
		}
	}
	
	public void eliminarPeces(int nbPeces){
		for(int i=0; i<nbPeces; i++){
			Animal animalAEliminar = getPezMasDebil();
			this.animales.remove(animalAEliminar);
		}
	}
	
	public void eliminarOsosPolares(int nbOsosPolares){
		for(int i=0; i<nbOsosPolares; i++){
			Animal animalAEliminar = getOsoPolarMasDebil();
			this.animales.remove(animalAEliminar);
		}
	}
	
	public void eliminarMorsas(int nbMorsas){
		for(int i=0; i<nbMorsas; i++){
			Animal animalAEliminar = getMorsaMasDebil();
			this.animales.remove(animalAEliminar);
		}
	}
	
	public void eliminarFocas(int nbFocas){
		for(int i=0; i<nbFocas; i++){
			Animal animalAEliminar = getFocaMasDebil();
			this.animales.remove(animalAEliminar);
		}
	}
	
	public void eliminarEsquimales(int nbEsquimales){
		for(int i=0; i<nbEsquimales; i++){
			Animal animalAEliminar = getEsquimalMasDebil();
			this.animales.remove(animalAEliminar);
		}
	}
	
	public Animal getPezMasDebil(){
		Iterator it = animales.iterator();
		int masaMuscular = 100;
		Animal result = null;
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Pez){
				if(animal.getMasaMuscular() < masaMuscular){
					result = animal;
				}
			}
			
		}
		return result;
	}
	
	public Animal getOsoPolarMasDebil(){
		Iterator it = animales.iterator();
		int masaMuscular = 100;
		Animal result = null;
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof OsoPolar){
				if(animal.getMasaMuscular() < masaMuscular){
					result = animal;
				}
			}
			
		}
		return result;
	}
	
	public Animal getMorsaMasDebil(){
		Iterator it = animales.iterator();
		int masaMuscular = 100;
		Animal result = null;
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Morsa){
				if(animal.getMasaMuscular() < masaMuscular){
					result = animal;
				}
			}
			
		}
		return result;
	}
	
	public Animal getFocaMasDebil(){
		Iterator it = animales.iterator();
		int masaMuscular = 100;
		Animal result = null;
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Foca){
				if(animal.getMasaMuscular() < masaMuscular){
					result = animal;
				}
			}
			
		}
		return result;
	}
	
	public Animal getEsquimalMasDebil(){
		Iterator it = animales.iterator();
		int masaMuscular = 100;
		Animal result = null;
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Esquimal){
				if(animal.getMasaMuscular() < masaMuscular){
					result = animal;
				}
			}
			
		}
		return result;
	}
	
	/**
	 * permite matar los oso et morsas con el buton buquesDePesca
	 */
	public void buquesDePesca(){
		int numeroOsosAMatar = getNbOsosPolares() / 15 ;
		int numeroMorsasAMatar = getNbOsosPolares() / 20 ;
		this.eliminarOsosPolares((int) numeroOsosAMatar);
		this.eliminarMorsas((int) numeroMorsasAMatar);
	}
	
	/**
	 * Permite aumentar la temperatura del agua de 2 grados
	 */
	public void calentamientoGlobal(){
		this.temperaturaAgua += 2;
	}
	
	public String mostrarDetalles(){
		String result = "";
		result += "dia : " + this.fecha + "\n";
		result +="temperatura del agua : " + this.temperaturaAgua+ "\n";
		result +="numero de peces : " + this.getNbPeces()+ "\n";
		result +="numero de Bacalaos : " + this.getNbBacalaos()+ "\n";
		result +="numero de Rayas : " + this.getNbRayas()+ "\n";
		result +="numero de Merluzas negras : " + this.getNbMerluzasNegras()+ "\n";
		result +="numero de Osos Polares: " + this.getNbOsosPolares()+ "\n";
		result +="numero de Esquimales : " + this.getNbEsquimales()+ "\n";
		result +="numero de Morsas : " + this.getNbMorsas()+ "\n";
		result +="numero de Focas : " + this.getNbFocas()+ "\n";
		result +="numero de Krill : " + this.krill+ "\n";
		return result;
	}

	public ArrayList getBacalaos(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Bacalao){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbBacalaos(){
		return getBacalaos().size();
	}
	
	public ArrayList getRayas(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Raya){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbRayas(){
		return getRayas().size();
	}
	
	public ArrayList getMerluzasNegras(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof MerluzaNegra){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbMerluzasNegras(){
		return getMerluzasNegras().size();
	}
	
	
	public ArrayList getPeces(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Pez){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbPeces() {
		return getPeces().size();
	}
	
	public ArrayList getOsosPolares(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof OsoPolar){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbOsosPolares() {
		return getOsosPolares().size();
	}
	
	public ArrayList getMorsas(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Morsa){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbMorsas() {
		return getMorsas().size();
	}

	public ArrayList getFocas(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Foca){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbFocas() {
		return getFocas().size();
	}


	public ArrayList getEsquimales(){
		ArrayList<Animal> result = new ArrayList<Animal>();
		Iterator it = this.animales.iterator();
		while(it.hasNext()){
			Animal animal = (Animal) it.next();
			if(animal instanceof Esquimal){
				result.add(animal);
			}
		}
		return result;
	}
	
	public int getNbEsquimales() {
		return getEsquimales().size();
	}
	
}
