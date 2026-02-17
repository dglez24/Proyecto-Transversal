package controlador;

import vista.VistaPrincipal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Votante;
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
                int tramoEdad = cp.getRango1825(); 
                int tramoEdad2 = cp.getRango2640();
                int tramoEdad3 = cp.getRango4165();
                int tramoEdad4 = cp.getRangoMas66();
                int habitantes=cp.getTotalHabitantes();
                if(habitantes<500000) {
                	lanzarHiloManual(comunidad, 1, 1);
                	lanzarHiloManual(comunidad, 2, 2);
                	lanzarHiloManual(comunidad, 3, 1);
                	lanzarHiloManual(comunidad, 4, 1);
                }else {
                	lanzarHilosPorTramo(comunidad, habitantes, cp.getRango1825(), 1);
                    lanzarHilosPorTramo(comunidad, habitantes, cp.getRango2640(), 2); 
                    lanzarHilosPorTramo(comunidad, habitantes, cp.getRango4165(), 3); 
                    lanzarHilosPorTramo(comunidad, habitantes, cp.getRangoMas66(), 4);
                }
            }
        } finally {
            session.close();
        }
}
private void lanzarHilosPorTramo(String comunidad, long total, int porcentajeTramo, int idRango) {
     
        double habitantesEnTramo = (total * porcentajeTramo) / 100.0;
        int numHilos = (int) Math.ceil(habitantesEnTramo / 100000.0);

        for (int i = 0; i < numHilos; i++) {
            Votante v = new Votante(comunidad, idRango, this.factory);
            v.start();
        }
}
public void lanzarHiloManual(String comunidad, int idRango,int rep) {

    for (int i = 0; i < rep; i++) {
        Votante v = new Votante(comunidad, idRango, this.factory);
        v.start();
    }
}
}

