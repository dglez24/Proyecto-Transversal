package controlador;

import vista.VistaPrincipal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import modelo.Votante;
import vista.VistaPrincipal;
import persistencias.ComunidadPartido; 
import persistencias.PorcentajesRangoedad;
import persistencias.PartidoRangoEdad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Funcionalidad  implements ActionListener{

    private VistaPrincipal frame;
    private SessionFactory factory;
    public Funcionalidad(VistaPrincipal frame) {
        this.frame = frame;
        this.frame.BtnSimular.addActionListener(this);
        this.frame.BtnAndalucia.addActionListener(this);
        this.frame.BtnAragon.addActionListener(this);
        this.frame.BtnAsturias.addActionListener(this);
        this.frame.BtnBaleares.addActionListener(this);
        this.frame.BtnCanarias.addActionListener(this);
        this.frame.BtnCantabria.addActionListener(this);
        this.frame.BtnCastillaLeon.addActionListener(this);
        this.frame.BtnCatalunia.addActionListener(this);
        this.frame.BtnCeuta.addActionListener(this);
        this.frame.BtnComValenciana.addActionListener(this);
        this.frame.BtnExtremadura.addActionListener(this);
        this.frame.BtnGalicia.addActionListener(this);
        this.frame.BtnLaMancha.addActionListener(this);
        this.frame.BtnLaRioja.addActionListener(this);
        this.frame.BtnMadrid.addActionListener(this);
        this.frame.BtnMelilla.addActionListener(this);
        this.frame.BtnMurcia.addActionListener(this);
        this.frame.BtnNavarra.addActionListener(this);
        this.frame.BtnPaisVasco.addActionListener(this);
        this.factory = new Configuration().configure().buildSessionFactory();
        }
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == frame.BtnSimular) {
    		reiniciarContadores(factory);
            obtenerDatosComunidades();
            long temp=System.currentTimeMillis()+1000;
            while(temp>System.currentTimeMillis()){
            	System.out.println("Simulando votaciones...");
            }
            long[] totales = obtenerTotalesGenerales(factory);
            long maxVotos = 0;
            String ganador = "";
            
         int votosEmitidos = (int)(totales[0] + totales[1] + totales[2] + totales[3]);

         if (votosEmitidos > 0) {
             frame.BarraX.setMaximum(votosEmitidos);
             frame.BarraY.setMaximum(votosEmitidos);
             frame.BarraW.setMaximum(votosEmitidos);
             frame.BarraZ.setMaximum(votosEmitidos);
         }
            frame.BarraX.setValue((int) totales[0]);
            frame.BarraY.setValue((int) totales[1]);
            frame.BarraW.setValue((int) totales[2]);
            frame.BarraZ.setValue((int) totales[3]);
            
            if (totales[0] > maxVotos) { maxVotos = totales[0]; ganador = "Partido X"; }
            if (totales[1] > maxVotos) { maxVotos = totales[1]; ganador = "Partido Y"; }
            if (totales[2] > maxVotos) { maxVotos = totales[2]; ganador = "Partido W"; }
            if (totales[3] > maxVotos) { maxVotos = totales[3]; ganador = "Partido Z"; }
            
            frame.LblPartidoGanador.setText(ganador);
            frame.GaliciaAzul.setVisible(true);

            List<String> ganadores = obtenerSoloGanadores(factory);
            for (int i = 0; i < ganadores.size(); i++) {
                String letra = ganadores.get(i);
                
                    cambiarColorComunidad(frame, i, letra);
                
            }
    	}
    }
    

public void obtenerDatosComunidades() {
        Session session = factory.openSession();
        
        try {
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
public void lanzarHiloManual(String comunidad, int idRango,int rep) {

    for (int i = 0; i < rep; i++) {
        Votante v = new Votante(comunidad, idRango, this.factory);
        v.start();
    }
}
public void lanzarVotante(String comunidad, int cantidad, int idRango) {
    for (int i = 0; i < cantidad; i++) {
        Votante v = new Votante(comunidad, idRango, this.factory);
        v.start();
    }
}
public void lanzarHilosPorTramo(String comunidad, long total, int porcentaje, int idRango) {
    int numHilos = (int) Math.ceil((total * porcentaje / 100.0) / 100000.0);
    lanzarVotante(comunidad, numHilos, idRango);
}
private static void reiniciarContadores(SessionFactory factory) {
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    try {
        // 1. Ponemos a 0 los votos generales por partido
        session.createNativeQuery("UPDATE COMUNIDAD_PARTIDO SET VOTOSX=0, VOTOSY=0, VOTOSW=0, VOTOSZ=0").executeUpdate();
        
        // 2. Ponemos a 0 todos los rangos de edad
        session.createNativeQuery("UPDATE PARTIDO_RANGO_EDAD SET RANGO1=0, RANGO2=0, RANGO3=0, RANGO4=0").executeUpdate();
        
        tx.commit();
 
    } catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
}
public long[] obtenerTotalesGenerales(SessionFactory factory) {
    Session session = factory.openSession();
    // Sumamos todas las columnas de votos de todas las comunidades
    Object[] result = (Object[]) session.createQuery(
        "select sum(votosx), sum(votosy), sum(votosw), sum(votosz) from ComunidadPartido")
        .uniqueResult();
    
    session.close();
    
    // Convertimos los resultados a long (manejando posibles nulls iniciales)
    return new long[] {
        result[0] != null ? (long) result[0] : 0,
        result[1] != null ? (long) result[1] : 0,
        result[2] != null ? (long) result[2] : 0,
        result[3] != null ? (long) result[3] : 0
    };
}
public void actualizarColoresMapa(SessionFactory factory, VistaPrincipal frame) {
    Session session = factory.openSession();
    try {
        // 1. Obtenemos todas las comunidades
        List<ComunidadPartido> listaComunidades = session.createQuery("from ComunidadPartido", ComunidadPartido.class).list();

        for (ComunidadPartido cp : listaComunidades) {
            String comunidad = cp.getComunidadAutonoma();
            
            // 2. Determinamos cuál es el partido con más votos
            int votosX = cp.getVotosx();
            int votosY = cp.getVotosy();
            int votosW = cp.getVotosw();
            int votosZ = cp.getVotosz();

            String partidoGanador = "";
            int maxVotos = -1;

            if (votosX > maxVotos) { maxVotos = votosX; partidoGanador = "X"; }
            if (votosY > maxVotos) { maxVotos = votosY; partidoGanador = "Y"; }
            if (votosW > maxVotos) { maxVotos = votosW; partidoGanador = "W"; }
            if (votosZ > maxVotos) { maxVotos = votosZ; partidoGanador = "Z"; }

            // 3. Si no hay votos todavía (todos 0), no pintamos nada
            if (maxVotos <= 0) continue;

            // 4. Actualizamos la visibilidad en la UI (Llamada al método de abajo)
        }
    } finally {
        session.close();
    }
}
private void cambiarColorComunidad(VistaPrincipal frame, int indice, String partido) {
    setEstadoColores(frame, indice, false);

    switch (indice) {
    case 0: // Andalucía
        if (partido.equals("X")) frame.AndaLuciaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.AndaLuciaAzul.setVisible(true);
        else if (partido.equals("W")) frame.AndaLuciaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.AndaLuciaMorado.setVisible(true);
        break;

    case 1: // Aragon
        if (partido.equals("X")) frame.AragonVerde.setVisible(true);
        else if (partido.equals("Y")) frame.AragonAzul.setVisible(true);
        else if (partido.equals("W")) frame.AragonRojo.setVisible(true);
        else if (partido.equals("Z")) frame.AragonMorado.setVisible(true);
        break;

    case 2: // Castilla la Mancha
        if (partido.equals("X")) frame.LaManchaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.LaManchaAzul.setVisible(true);
        else if (partido.equals("W")) frame.LaManchaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.LaManchaMorado.setVisible(true);
        break;

    case 3: // Madrid
        if (partido.equals("X")) frame.MadridVerde.setVisible(true);
        else if (partido.equals("Y")) frame.MadridAzul.setVisible(true);
        else if (partido.equals("W")) frame.MadridRojo.setVisible(true);
        else if (partido.equals("Z")) frame.MadridMorado.setVisible(true);
        break;

    case 4: // Extremadura
        if (partido.equals("X")) frame.ExtremaduraVerde.setVisible(true);
        else if (partido.equals("Y")) frame.ExtremaduraAzul.setVisible(true);
        else if (partido.equals("W")) frame.ExtremaduraRojo.setVisible(true);
        else if (partido.equals("Z")) frame.ExtremaduraMorado.setVisible(true);
        break;

    case 5: // Murcia
        if (partido.equals("X")) frame.MurciaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.MurciaAzul.setVisible(true);
        else if (partido.equals("W")) frame.MurciaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.MurciaMorado.setVisible(true);
        break;

    case 6: // Comunidad Valenciana
        if (partido.equals("X")) frame.ComValencianaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.ComValencianaAzul.setVisible(true);
        else if (partido.equals("W")) frame.ComValencianaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.ComValencianaMorado.setVisible(true);
        break;

    case 7: // Cataluña
        if (partido.equals("X")) frame.CataluniaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.CataluniaAzul.setVisible(true);
        else if (partido.equals("W")) frame.CataluniaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.CataluniaMorado.setVisible(true);
        break;

    case 8: // Castilla y Leon
        if (partido.equals("X")) frame.CastillaLeonVerde.setVisible(true);
        else if (partido.equals("Y")) frame.CastillaLeonAzul.setVisible(true);
        else if (partido.equals("W")) frame.CastillaLeonRojo.setVisible(true);
        else if (partido.equals("Z")) frame.CastillaLeonMorado.setVisible(true);
        break;

    case 9: // Navarra
        if (partido.equals("X")) frame.NavarraVerde.setVisible(true);
        else if (partido.equals("Y")) frame.NavarraAzul.setVisible(true);
        else if (partido.equals("W")) frame.NavarraRojo.setVisible(true);
        else if (partido.equals("Z")) frame.NavarraMorado.setVisible(true);
        break;

    case 10: // País Vasco
        if (partido.equals("X")) frame.PaisVascoVerde.setVisible(true);
        else if (partido.equals("Y")) frame.PaisVascoAzul.setVisible(true);
        else if (partido.equals("W")) frame.PaisVascoRojo.setVisible(true);
        else if (partido.equals("Z")) frame.PaisVascoMorado.setVisible(true);
        break;

    case 11: // La Rioja
        if (partido.equals("X")) frame.LaRiojaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.LaRiojaAzul.setVisible(true);
        else if (partido.equals("W")) frame.LaRiojaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.LaRiojaMorado.setVisible(true);
        break;

    case 12: // Cantabria
        if (partido.equals("X")) frame.CantabriaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.CantabriaAzul.setVisible(true);
        else if (partido.equals("W")) frame.CantabriaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.CantabriaMorado.setVisible(true);
        break;

    case 13: // Asturias
        if (partido.equals("X")) frame.AsturiasVerde.setVisible(true);
        else if (partido.equals("Y")) frame.AsturiasAzul.setVisible(true);
        else if (partido.equals("W")) frame.AsturiasRojo.setVisible(true);
        else if (partido.equals("Z")) frame.AsturiasMorado.setVisible(true);
        break;

    case 14: // Galicia
        if (partido.equals("X")) frame.GaliciaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.GaliciaAzul.setVisible(true);
        else if (partido.equals("W")) frame.GaliciaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.GaliciaMorado.setVisible(true);
        break;

    case 15: // Baleares
        if (partido.equals("X")) frame.BalearesVerde.setVisible(true);
        else if (partido.equals("Y")) frame.BalearesAzul.setVisible(true);
        else if (partido.equals("W")) frame.BalearesRojo.setVisible(true);
        else if (partido.equals("Z")) frame.BalearesMorado.setVisible(true);
        break;

    case 16: // Canarias
        if (partido.equals("X")) frame.CanariasVerde.setVisible(true);
        else if (partido.equals("Y")) frame.CanariasAzul.setVisible(true);
        else if (partido.equals("W")) frame.CanariasRojo.setVisible(true);
        else if (partido.equals("Z")) frame.CanariasMorado.setVisible(true);
        break;

    case 17: // Ceuta
        if (partido.equals("X")) frame.CeutaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.CeutaAzul.setVisible(true);
        else if (partido.equals("W")) frame.CeutaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.CeutaMorado.setVisible(true);
        break;

    case 18: // Melilla
        if (partido.equals("X")) frame.MelillaVerde.setVisible(true);
        else if (partido.equals("Y")) frame.MelillaAzul.setVisible(true);
        else if (partido.equals("W")) frame.MelillaRojo.setVisible(true);
        else if (partido.equals("Z")) frame.MelillaMorado.setVisible(true);
        break;
}
            
}
private void setEstadoColores(VistaPrincipal frame, int indice, boolean estado) {
	switch (indice) {
    case 0: // Andalucía
        frame.AndaLuciaVerde.setVisible(estado);
        frame.AndaLuciaAzul.setVisible(estado);
        frame.AndaLuciaRojo.setVisible(estado);
        frame.AndaLuciaMorado.setVisible(estado);
        break;
    case 1: // Aragon
        frame.AragonVerde.setVisible(estado);
        frame.AragonAzul.setVisible(estado);
        frame.AragonRojo.setVisible(estado);
        frame.AragonMorado.setVisible(estado);
        break;
    case 2: // Castilla la Mancha
        frame.LaManchaVerde.setVisible(estado);
        frame.LaManchaAzul.setVisible(estado);
        frame.LaManchaRojo.setVisible(estado);
        frame.LaManchaMorado.setVisible(estado);
        break;
    case 3: // Madrid
        frame.MadridVerde.setVisible(estado);
        frame.MadridAzul.setVisible(estado);
        frame.MadridRojo.setVisible(estado);
        frame.MadridMorado.setVisible(estado);
        break;
    case 4: // Extremadura
        frame.ExtremaduraVerde.setVisible(estado);
        frame.ExtremaduraAzul.setVisible(estado);
        frame.ExtremaduraRojo.setVisible(estado);
        frame.ExtremaduraMorado.setVisible(estado);
        break;
    case 5: // Murcia
        frame.MurciaVerde.setVisible(estado);
        frame.MurciaAzul.setVisible(estado);
        frame.MurciaRojo.setVisible(estado);
        frame.MurciaMorado.setVisible(estado);
        break;
    case 6: // Comunidad Valenciana
        frame.ComValencianaVerde.setVisible(estado);
        frame.ComValencianaAzul.setVisible(estado);
        frame.ComValencianaRojo.setVisible(estado);
        frame.ComValencianaMorado.setVisible(estado);
        break;
    case 7: // Cataluña
        frame.CataluniaVerde.setVisible(estado);
        frame.CataluniaAzul.setVisible(estado);
        frame.CataluniaRojo.setVisible(estado);
        frame.CataluniaMorado.setVisible(estado);
        break;
    case 8: // Castilla y Leon
        frame.CastillaLeonVerde.setVisible(estado);
        frame.CastillaLeonAzul.setVisible(estado);
        frame.CastillaLeonRojo.setVisible(estado);
        frame.CastillaLeonMorado.setVisible(estado);
        break;
    case 9: // Navarra
        frame.NavarraVerde.setVisible(estado);
        frame.NavarraAzul.setVisible(estado);
        frame.NavarraRojo.setVisible(estado);
        frame.NavarraMorado.setVisible(estado);
        break;
    case 10: // País Vasco
        frame.PaisVascoVerde.setVisible(estado);
        frame.PaisVascoAzul.setVisible(estado);
        frame.PaisVascoRojo.setVisible(estado);
        frame.PaisVascoMorado.setVisible(estado);
        break;
    case 11: // La Rioja
        frame.LaRiojaVerde.setVisible(estado);
        frame.LaRiojaAzul.setVisible(estado);
        frame.LaRiojaRojo.setVisible(estado);
        frame.LaRiojaMorado.setVisible(estado);
        break;
    case 12: // Cantabria
        frame.CantabriaVerde.setVisible(estado);
        frame.CantabriaAzul.setVisible(estado);
        frame.CantabriaRojo.setVisible(estado);
        frame.CantabriaMorado.setVisible(estado);
        break;
    case 13: // Asturias
        frame.AsturiasVerde.setVisible(estado);
        frame.AsturiasAzul.setVisible(estado);
        frame.AsturiasRojo.setVisible(estado);
        frame.AsturiasMorado.setVisible(estado);
        break;
    case 14: // Galicia
        frame.GaliciaVerde.setVisible(estado);
        frame.GaliciaAzul.setVisible(estado);
        frame.GaliciaRojo.setVisible(estado);
        frame.GaliciaMorado.setVisible(estado);
        break;
    case 15: // Baleares
        frame.BalearesVerde.setVisible(estado);
        frame.BalearesAzul.setVisible(estado);
        frame.BalearesRojo.setVisible(estado);
        frame.BalearesMorado.setVisible(estado);
        break;
    case 16: // Canarias
        frame.CanariasVerde.setVisible(estado);
        frame.CanariasAzul.setVisible(estado);
        frame.CanariasRojo.setVisible(estado);
        frame.CanariasMorado.setVisible(estado);
        break;
    case 17: // Ceuta
        frame.CeutaVerde.setVisible(estado);
        frame.CeutaAzul.setVisible(estado);
        frame.CeutaRojo.setVisible(estado);
        frame.CeutaMorado.setVisible(estado);
        break;
    case 18: // Melilla
        frame.MelillaVerde.setVisible(estado);
        frame.MelillaAzul.setVisible(estado);
        frame.MelillaRojo.setVisible(estado);
        frame.MelillaMorado.setVisible(estado);
        break;
}
}
public List<String> obtenerSoloGanadores(SessionFactory factory) {
    List<String> ganadores = new ArrayList<>();
    Session session = factory.openSession();
    
    try {
        // Importante: ORDER BY id para que coincida con tu switch numérico
        List<ComunidadPartido> comunidades = session.createQuery(
            "from ComunidadPartido order by id", ComunidadPartido.class).list();
        
        for (ComunidadPartido cp : comunidades) {
            int vX = cp.getVotosx();
            int vY = cp.getVotosy();
            int vW = cp.getVotosw();
            int vZ = cp.getVotosz();
            
            String ganador = "N/A"; // Por si no hay votos aún
            int maxVotos = 0;
            
            // Comparamos para sacar solo la letra (más fácil para tu switch)
            if (vX > maxVotos) { maxVotos = vX; ganador = "X"; }
            if (vY > maxVotos) { maxVotos = vY; ganador = "Y"; }
            if (vW > maxVotos) { maxVotos = vW; ganador = "W"; }
            if (vZ > maxVotos) { maxVotos = vZ; ganador = "Z"; }
            
            ganadores.add(ganador);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }
    
    return ganadores;
}
}

