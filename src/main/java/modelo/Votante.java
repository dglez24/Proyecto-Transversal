package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import persistencias.ComunidadPartido;

public class Votante extends Thread {
private int rangoEdad;
private String comunidad;
private int voto;
private String partidoVotado;
public Votante(String comunidad,int rangoEdad) {
	this.comunidad=comunidad;
	this.rangoEdad=rangoEdad;
}
public void run() {
	
	int aleatorio = (int) (Math.random() * 100) + 1;

    // 2. Determinar el voto según el rango de edad
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
    
    // Opcional: imprimir para ver que el hilo está trabajando
    // System.out.println("Hilo de " + comunidad + " (Rango " + rangoEdad + ") votó a: " + partidoVotado);
}
private static synchronized void actualizarVotoSincronizado(String partido, String comunidad, SessionFactory factory) {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();

        // Buscamos la comunidad
        ComunidadPartido cpVotos = session.createQuery(
            "from ComunidadPartido where nombreComunidad = :nom", ComunidadPartido.class)
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
        }
        tx.commit();
    } catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
}
}

