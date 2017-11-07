
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class GUIClass  {
	GUIClass(){
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
			 public void run() {
				 hazGUI(); 
			 }
			   });		
	}
	
	
	void hazGUI() {
		//getContentPane().setLayout(new FlowLayout());
		JFrame window = new JFrame();
		window.setSize(800,800);
		window.setTitle("El Titulo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
		//BUTTON Dia Siguiente------------------------------------------------------------
		
		JButton B_diaSiguiente=new JButton("Dia Siguiente");  
		B_diaSiguiente.setBounds(50,100,200,30);  
	    window.add(B_diaSiguiente);  
	    
	    B_diaSiguiente.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		
	    		if(Main.polo!=null) {
	    			 	    		
		    		//trigger dia siguiente
	    			if(Main.polo.transcurrirUnDia()) {
	    				JOptionPane.showMessageDialog(window, "un dia paso");
	    			}else {
	    				JOptionPane.showMessageDialog(window, "Al dia " + Main.polo.fecha + " el sistema se ha extinguido...");
	    			}
		    		//Main.polo.mostrarDetalles();	
	    		}else {
	    			JOptionPane.showMessageDialog(window, "Polo no existe!!"); 	  
	    		}
	    		    		
	    	        }  
	    	    });
	    
	    
	    
	    JButton B_CreaElPolo=new JButton("CreaElPolo");  
		B_CreaElPolo.setBounds(300,100,200,30);  
	   
	    
	    B_CreaElPolo.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		JOptionPane.showMessageDialog(window, "CreaElPolo"); 
	    		
	    		
	    		//trigger crea polosur
	    		Main.polo = new Polo();
	    		
	    		
	    	        }  
	    	    });
	    
	    
	    
	    //BUTTON B_Busques------------------------------------------------------------
	    JButton B_Busques = new JButton("capturas de buques furtivos");
	  // B_Busques.setBounds(50,200,200,30);  
	     
	    
	    B_Busques.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    		
	    		if(Main.polo!=null) {
	    			//trigger calentamiento
		    		Main.polo.buquesDePesca();
	    		}
	    		
	    		
	    		
	    		
	    		JOptionPane.showMessageDialog(window, " capturas de buques furtivos");  
	    	        }  
	    	    });
	    
	  //BUTTON 10 dias siguiente------------------------------------------------------------
	    JButton B_sig10Dias=new JButton("10 dias");  
	   // B_sig10Dias.setBounds(50,200,200,30);  
	     
	    
	    B_sig10Dias.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    		
	    		if(Main.polo!=null) {	 	    		
	 	    			int i = 0;
			    		while(i<10 & Main.polo.transcurrirUnDia()) 	    		
			    		{
			    			++i;
			    		}
			    		if(i<9) {
			    			JOptionPane.showMessageDialog(window, "Al dia " + Main.polo.fecha + " el sistema se ha extinguido...");
			    		}else {
			    			JOptionPane.showMessageDialog(window, "10 dias pasaron");
			    		}
	    		}else {
	    			JOptionPane.showMessageDialog(window, "Polo no existe!!"); 	  
	    		}	    		
	    	        
	    	}
	    });
	    
	  //BUTTON B_Calentamiento Global------------------------------------------------------------
	    JButton B_Calentamiento=new JButton("B_Calentamiento Global");  
	    //B_Calentamiento.setBounds(50,300,200,30);  
	      
	    
	    B_Calentamiento.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		JOptionPane.showMessageDialog(window, "calentamiento");  
	    		
	    		if(Main.polo!=null) {
	    			//trigger calentamiento
		    		Main.polo.calentamientoGlobal();
	    		}
	    		
	    		
	    	}  
	    });
	    
	    
	  //BUTTON B_Detalles------------------------------------------------------------
	    JButton B_Detalles=new JButton("Mostrar B_Detalles");  
	    //B_Detalles.setBounds(50,400,200,30);  
	    
	    
	    B_Detalles.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    	JOptionPane.showMessageDialog(window, Main.polo.mostrarDetalles()); 	    		
	    	        }  
	    	    });
	    
	    
	  //BUTTON Salida------------------------------------------------------------
	   JButton B_Salida=new JButton("Salida del programa"); 
	   B_Salida.addActionListener(new ActionListener(){  
	   public void actionPerformed(ActionEvent e){  
		   Main.serializePolo();	    	
		   window.dispose();
	   }  
	   });
	   // B_Salida.setBounds(300,50,200,30);  
	    
	    window.add(B_CreaElPolo);  
	    window.add(B_Busques); 
	    window.add(B_sig10Dias); 
	    window.add(B_Calentamiento);
	    window.add(B_Detalles);
	    window.add(B_Salida); 
	    window.setLayout(new GridLayout(3,2));
	}
	
	
	
	}

