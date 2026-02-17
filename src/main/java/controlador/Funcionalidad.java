package controlador;

import vista.VistaPrincipal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vista.VistaPrincipal;
// Importamos las clases de la carpeta persistencias
import persistencias.ComunidadPartido; 
import persistencias.PorcentajesRangoedad;
import persistencias.PartidoRangoEdad;
import java.util.List;

public class Funcionalidad {

    private VistaPrincipal frame;
    private SessionFactory factory;

    public Funcionalidad(VistaPrincipal frame) {
        this.frame = frame;
        
        // Inicializamos la fábrica (lee el hibernate.cfg.xml que veo en tu carpeta resources)
        this.factory = new Configuration().configure().buildSessionFactory();
    }
    
    // Este método "entra" en la carpeta persistencias y trae los datos
    public void obtenerDatosComunidades() {
        Session session = factory.openSession();
        
        try {
            // HQL usa el nombre de la CLASE (ComunidadPartido), no de la tabla
            List<PorcentajesRangoedad> lista = session.createQuery("from PorcentajesRangoedad", PorcentajesRangoedad.class).list();
            
            for (PorcentajesRangoedad cp : lista) {

            	
            	String comunidad = cp.getNombreComunidad();
            	int tramoMenor=cp.getRango19();
            	int tramoMenor2=cp.getRango1017();
                int tramoEdad = cp.getRango1825(); 
                int tramoEdad2 = cp.getRango2640();
                int tramoEdad3 = cp.getRango4165();
                int tramoEdad4 = cp.getRangoMas66();
                int habitantes=(int) Math.ceil((double) cp.getTotalHabitantes() / 100000);
                if(habitantes<100000) {
                	habitantes=5;
                }else {
                	habitantes=(int) Math.ceil((double)habitantes/100000);
                }
                int aleatorio=(int)(Math.random()*101);
                
                for(int i=0;i<habitantes;i++) {
                	if(aleatorio>tramoMenor+tramoMenor2) {
                    	
                    	
                    	
                    	
                    }else {
                    	System.out.println("Voto Excluido Menor de edad");
                    }
                }
                
                
              
            	
            	
            }
        } finally {
            session.close();
        }
    }
}
