package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import persistencias.ComunidadPartido;
import persistencias.PartidoRangoEdad;

public class Votante extends Thread {
private int rangoEdad;
private String comunidad;
private int voto;
private SessionFactory factory;
private String  partidoVotado;
public Votante(String comunidad,int rangoEdad, SessionFactory factory) {
	this.comunidad=comunidad;
	this.rangoEdad=rangoEdad;
	this.factory = factory;
	}
public void run() {
	
	int aleatorio = (int) (Math.random() * 100) + 1;

    switch (rangoEdad) {
        case 1: // 18 a 25 años
            if (aleatorio <= 30) partidoVotado = "X";
            else if (aleatorio <= 50) partidoVotado = "Y";
            else if (aleatorio <= 70) partidoVotado = "W";
            else partidoVotado = "Z";
            break;

        case 2: // 26 a 40 años
            if (aleatorio <= 20) partidoVotado = "X";
            else if (aleatorio <= 55) partidoVotado = "Y";
            else if (aleatorio <= 85) partidoVotado = "W";
            else partidoVotado = "Z";
            break;

        case 3: // 41 a 65 años
            if (aleatorio <= 10) partidoVotado = "X";
            else if (aleatorio <= 55) partidoVotado = "Y";
            else if (aleatorio <= 90) partidoVotado = "W";
            else partidoVotado = "Z";
            break;

        case 4: // Más de 65 años
            if (aleatorio <= 25) partidoVotado = "X";
            else if (aleatorio <= 60) partidoVotado = "Y";
            else if (aleatorio <= 95) partidoVotado = "W";
            else partidoVotado = "Z";
            break;
           
    }
        actualizarVotoSincronizado(partidoVotado, comunidad,rangoEdad, this.factory);
}
private static synchronized void actualizarVotoSincronizado(String partido, String comunidad,int rango, SessionFactory factory) {
	Session session = factory.openSession();
    Transaction tx = null;
    try {
    	tx = session.beginTransaction();

        
        ComunidadPartido cpVotos = session.createQuery(
            "from ComunidadPartido where comunidadAutonoma = :nom", ComunidadPartido.class)
            .setParameter("nom", comunidad)
            .uniqueResult();

        if (cpVotos != null) {
            switch (partido) {
                case "X": cpVotos.setVotosx(cpVotos.getVotosx() + 1); break;
                case "Y": cpVotos.setVotosy(cpVotos.getVotosy() + 1); break;
                case "W": cpVotos.setVotosw(cpVotos.getVotosw() + 1); break;
                case "Z": cpVotos.setVotosz(cpVotos.getVotosz() + 1); break;
            }
            session.update(cpVotos);
            
            
            String nombrePartidoDB = "Partido" + partido; 

            PartidoRangoEdad pre = session.createQuery(
                "from PartidoRangoEdad where comunidadPartido.id = :cpId and partido = :part", 
                PartidoRangoEdad.class)
                .setParameter("cpId", cpVotos.getId())
                .setParameter("part", nombrePartidoDB) 
                .uniqueResult();

            if (pre != null) {
                if (rango == 1) pre.setRango1(pre.getRango1() + 1);
                else if (rango == 2) pre.setRango2(pre.getRango2() + 1);
                else if (rango == 3) pre.setRango3(pre.getRango3() + 1);
                else if (rango == 4) pre.setRango4(pre.getRango4() + 1);
                
                session.update(pre);
            }
        tx.commit();
        } 
    }catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

}
}
