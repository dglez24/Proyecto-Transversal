package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Funcionalidad;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class VistaPrincipal extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel Mapa;
	public JLabel AragonVerde;
	public JLabel AragonAzul;
	public JLabel AragonRojo;
	public JLabel AragonMorado;
	public JLabel LaManchaVerde;
	public JLabel LaManchaAzul;
	public JLabel LaManchaRojo;
	public JLabel LaManchaMorado;
	public JLabel MadridVerde;
	public JLabel MadridAzul;
	public JLabel MadridRojo;
	public JLabel MadridMorado;
	public JLabel ExtremaduraVerde;
	public JLabel ExtremaduraAzul;
	public JLabel ExtremaduraRojo;
	public JLabel ExtremaduraMorado;
	public JLabel AndaLuciaVerde;
	public JLabel AndaLuciaAzul;
	public JLabel AndaLuciaRojo;
	public JLabel AndaLuciaMorado;
	public JLabel MurciaVerde;
	public JLabel MurciaAzul;
	public JLabel MurciaRojo;
	public JLabel MurciaMorado;
	public JLabel ComValencianaVerde;
	public JLabel ComValencianaAzul;
	public JLabel ComValencianaRojo;
	public JLabel ComValencianaMorado;
	public JLabel CataluniaVerde;
	public JLabel CataluniaAzul;
	public JLabel CataluniaRojo;
	public JLabel CataluniaMorado;
	public JLabel CastillaLeonVerde;
	public JLabel CastillaLeonAzul;
	public JLabel CastillaLeonRojo;
	public JLabel CastillaLeonMorado;
	public JLabel NavarraVerde;
	public JLabel NavarraAzul;
	public JLabel NavarraRojo;
	public JLabel NavarraMorado;
	public JLabel PaisVascoVerde;
	public JLabel PaisVascoAzul;
	public JLabel PaisVascoRojo;
	public JLabel PaisVascoMorado;
	public JLabel LaRiojaVerde;
	public JLabel LaRiojaAzul;
	public JLabel LaRiojaRojo;
	public JLabel LaRiojaMorado;
	public JLabel CantabriaVerde;
	public JLabel CantabriaAzul;
	public JLabel CantabriaRojo;
	public JLabel CantabriaMorado;
	public JLabel AsturiasVerde;
	public JLabel AsturiasAzul;
	public JLabel AsturiasRojo;
	public JLabel AsturiasMorado;
	public JLabel GaliciaVerde;
	public JLabel GaliciaAzul;
	public JLabel GaliciaRojo;
	public JLabel GaliciaMorado;
	public JLabel BalearesVerde;
	public JLabel BalearesAzul;
	public JLabel BalearesRojo;
	public JLabel BalearesMorado;
	public JLabel CeutaVerde;
	public JLabel CeutaAzul;
	public JLabel CeutaRojo;
	public JLabel CeutaMorado;
	public JLabel MelillaVerde;
	public JLabel MelillaAzul;
	public JLabel MelillaRojo;
	public JLabel MelillaMorado;
	public JLabel CanariasVerde;
	public JLabel CanariasAzul;
	public JLabel CanariasRojo;
	public JLabel CanariasMorado;
	public JButton BtnSimular;
	public JProgressBar BarraZ;
	public JProgressBar BarraW;
	public JProgressBar BarraY;
	public JProgressBar BarraX;
	public JLabel LblTituloGanador;
	public JLabel LblPartidoGanador;
	public JButton BtnGalicia;
	public JButton BtnAsturias;
	public JButton BtnCantabria;
	public JButton BtnPaisVasco;
	public JButton BtnNavarra;
	public JButton BtnLaRioja;
	public JButton BtnAragon;
	public JButton BtnCatalunia;
	public JButton BtnCastillaLeon;
	public JButton BtnMadrid;
	public JButton BtnExtremadura;
	public JButton BtnLaMancha;
	public JButton BtnComValenciana;
	public JButton BtnBaleares;
	public JButton BtnAndalucia;
	public JButton BtnMurcia;
	public JButton BtnCanarias;
	public JButton BtnCeuta;
	public JButton BtnMelilla;
	public JPanel PMostrarElecciones;
	public JButton BtnAtras;
	public JLabel LblTituloGanadorComAutonoma;
	public JLabel LblGandorComAutonoma;
	public JProgressBar BarraComAutonomaX;
	public JProgressBar BarraComAutonomaY;
	public JProgressBar BarraComAutonomaW;
	public JProgressBar BarraComAutonomaZ;
	public JLabel LblPorX;
	public JLabel LblPorY;
	public JLabel LblPorW;
	public JLabel LblPorZ;
	public JLabel LblComAutonomaX;
	public JLabel LblComAutonomaY;
	public JLabel LblComAutonomaW;
	public JLabel LblComAutonomaZ;
	public JLabel LblZ;
	public JLabel LblW;
	public JLabel LblY;
	public JLabel LblX;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
	                Funcionalidad funcion = new Funcionalidad(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaPrincipal() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        double scaleX = screen.width / 1400.0;
        double scaleY = screen.height / 800.0;
        
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PMostrarElecciones = new JPanel();
		PMostrarElecciones.setBounds(0, 0, 1034, 718);
		contentPane.add(PMostrarElecciones);
		PMostrarElecciones.setLayout(null);
		PMostrarElecciones.setVisible(false);
		
		BtnAtras = new JButton("Atras");
		BtnAtras.setBackground(new Color(192, 192, 192));
		BtnAtras.setFont(new Font("Tahoma", Font.BOLD, 30));
		BtnAtras.setBounds(805, 653, 219, 55);
		PMostrarElecciones.add(BtnAtras);
		
		LblTituloGanadorComAutonoma = new JLabel("Ganador de");
		LblTituloGanadorComAutonoma.setFont(new Font("Sylfaen", Font.BOLD, 50));
		LblTituloGanadorComAutonoma.setHorizontalAlignment(SwingConstants.CENTER);
		LblTituloGanadorComAutonoma.setBounds(10, 10, 1014, 66);
		PMostrarElecciones.add(LblTituloGanadorComAutonoma);
		
		LblGandorComAutonoma = new JLabel("(Equipo Gandador)");
		LblGandorComAutonoma.setHorizontalAlignment(SwingConstants.CENTER);
		LblGandorComAutonoma.setFont(new Font("Sylfaen", Font.BOLD, 40));
		LblGandorComAutonoma.setBounds(10, 86, 1014, 66);
		PMostrarElecciones.add(LblGandorComAutonoma);
		
		BarraComAutonomaX = new JProgressBar();
		BarraComAutonomaX.setForeground(new Color(0, 255, 64));
		BarraComAutonomaX.setBounds(122, 249, 840, 35);
		PMostrarElecciones.add(BarraComAutonomaX);
		
		BarraComAutonomaY = new JProgressBar();
		BarraComAutonomaY.setForeground(new Color(0, 128, 255));
		BarraComAutonomaY.setBounds(122, 352, 840, 35);
		PMostrarElecciones.add(BarraComAutonomaY);
		
		BarraComAutonomaW = new JProgressBar();
		BarraComAutonomaW.setForeground(new Color(255, 0, 0));
		BarraComAutonomaW.setBounds(122, 459, 840, 35);
		PMostrarElecciones.add(BarraComAutonomaW);
		
		BarraComAutonomaZ = new JProgressBar();
		BarraComAutonomaZ.setForeground(new Color(128, 0, 128));
		BarraComAutonomaZ.setBounds(122, 560, 840, 35);
		PMostrarElecciones.add(BarraComAutonomaZ);
		
		LblPorX = new JLabel("0%");
		LblPorX.setHorizontalAlignment(SwingConstants.CENTER);
		LblPorX.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblPorX.setBounds(122, 294, 840, 48);
		PMostrarElecciones.add(LblPorX);
		
		LblPorY = new JLabel("0%");
		LblPorY.setHorizontalAlignment(SwingConstants.CENTER);
		LblPorY.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblPorY.setBounds(122, 401, 840, 48);
		PMostrarElecciones.add(LblPorY);
		
		LblPorW = new JLabel("0%");
		LblPorW.setHorizontalAlignment(SwingConstants.CENTER);
		LblPorW.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblPorW.setBounds(122, 504, 840, 48);
		PMostrarElecciones.add(LblPorW);
		
		LblPorZ = new JLabel("0%");
		LblPorZ.setHorizontalAlignment(SwingConstants.CENTER);
		LblPorZ.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblPorZ.setBounds(122, 605, 840, 48);
		PMostrarElecciones.add(LblPorZ);
		
		LblComAutonomaX = new JLabel("X");
		LblComAutonomaX.setHorizontalAlignment(SwingConstants.CENTER);
		LblComAutonomaX.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblComAutonomaX.setBounds(10, 249, 102, 35);
		PMostrarElecciones.add(LblComAutonomaX);
		
		LblComAutonomaY = new JLabel("Y");
		LblComAutonomaY.setHorizontalAlignment(SwingConstants.CENTER);
		LblComAutonomaY.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblComAutonomaY.setBounds(10, 352, 102, 35);
		PMostrarElecciones.add(LblComAutonomaY);
		
		LblComAutonomaW = new JLabel("W");
		LblComAutonomaW.setHorizontalAlignment(SwingConstants.CENTER);
		LblComAutonomaW.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblComAutonomaW.setBounds(10, 459, 102, 35);
		PMostrarElecciones.add(LblComAutonomaW);
		
		LblComAutonomaZ = new JLabel("Z");
		LblComAutonomaZ.setHorizontalAlignment(SwingConstants.CENTER);
		LblComAutonomaZ.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblComAutonomaZ.setBounds(10, 560, 102, 35);
		PMostrarElecciones.add(LblComAutonomaZ);
		
		BtnGalicia = new JButton("");
		BtnGalicia.setBackground(new Color(255, 255, 255));
		BtnGalicia.setBounds(100, 27, 116, 114);
		BtnGalicia.setOpaque(false);
		BtnGalicia.setBorderPainted(false);
		contentPane.add(BtnGalicia);
		
		
		BtnAsturias = new JButton("");
		BtnAsturias.setBackground(new Color(255, 255, 255));
		BtnAsturias.setBounds(241, 10, 139, 53);
		BtnAsturias.setOpaque(false);
		BtnAsturias.setBorderPainted(false);
		contentPane.add(BtnAsturias);
		
		BtnCantabria = new JButton("");
		BtnCantabria.setBackground(new Color(255, 255, 255));
		BtnCantabria.setBounds(390, 17, 92, 59);
		BtnCantabria.setOpaque(false);
		BtnCantabria.setBorderPainted(false);
		contentPane.add(BtnCantabria);
		
		BtnPaisVasco = new JButton("");
		BtnPaisVasco.setBackground(new Color(255, 255, 255));
		BtnPaisVasco.setBounds(492, 17, 62, 75);
		BtnPaisVasco.setOpaque(false);
		BtnPaisVasco.setBorderPainted(false);
		contentPane.add(BtnPaisVasco);
		
		BtnNavarra = new JButton("");
		BtnNavarra.setBackground(new Color(255, 255, 255));
		BtnNavarra.setBounds(555, 40, 81, 75);
		BtnNavarra.setOpaque(false);
		BtnNavarra.setBorderPainted(false);
		contentPane.add(BtnNavarra);
		
		BtnLaRioja = new JButton("");
		BtnLaRioja.setBackground(new Color(255, 255, 255));
		BtnLaRioja.setBounds(502, 110, 81, 31);
		BtnLaRioja.setOpaque(false);
		BtnLaRioja.setBorderPainted(false);
		contentPane.add(BtnLaRioja);
		
		BtnAragon = new JButton("");
		BtnAragon.setBackground(new Color(255, 255, 255));
		BtnAragon.setBounds(599, 107, 116, 165);
		BtnAragon.setOpaque(false);
		BtnAragon.setBorderPainted(false);
		contentPane.add(BtnAragon);
		
		BtnCatalunia = new JButton("");
		BtnCatalunia.setBackground(new Color(255, 255, 255));
		BtnCatalunia.setBounds(725, 91, 181, 165);
		BtnCatalunia.setOpaque(false);
		BtnCatalunia.setBorderPainted(false);
		contentPane.add(BtnCatalunia);
		
		BtnCastillaLeon = new JButton("");
		BtnCastillaLeon.setBackground(new Color(255, 255, 255));
		BtnCastillaLeon.setBounds(228, 89, 230, 149);
		BtnCastillaLeon.setOpaque(false);
		BtnCastillaLeon.setBorderPainted(false);
		contentPane.add(BtnCastillaLeon);
		
		BtnMadrid = new JButton("");
		BtnMadrid.setBackground(new Color(255, 255, 255));
		BtnMadrid.setBounds(423, 241, 70, 66);
		BtnMadrid.setOpaque(false);
		BtnMadrid.setBorderPainted(false);
		contentPane.add(BtnMadrid);
		
		BtnExtremadura = new JButton("");
		BtnExtremadura.setBackground(new Color(255, 255, 255));
		BtnExtremadura.setBounds(207, 273, 126, 176);
		BtnExtremadura.setOpaque(false);
		BtnExtremadura.setBorderPainted(false);
		contentPane.add(BtnExtremadura);
		
		BtnLaMancha = new JButton("");
		BtnLaMancha.setBackground(new Color(255, 255, 255));
		BtnLaMancha.setBounds(354, 306, 246, 130);
		BtnLaMancha.setOpaque(false);
		BtnLaMancha.setBorderPainted(false);
		contentPane.add(BtnLaMancha);
		
		BtnComValenciana = new JButton("");
		BtnComValenciana.setBackground(new Color(255, 255, 255));
		BtnComValenciana.setBounds(648, 284, 108, 205);
		BtnComValenciana.setOpaque(false);
		BtnComValenciana.setBorderPainted(false);
		contentPane.add(BtnComValenciana);
		
		BtnBaleares = new JButton("");
		BtnBaleares.setBackground(new Color(255, 255, 255));
		BtnBaleares.setBounds(786, 319, 239, 130);
		BtnBaleares.setOpaque(false);
		BtnBaleares.setBorderPainted(false);
		contentPane.add(BtnBaleares);
		
		BtnAndalucia = new JButton("");
		BtnAndalucia.setBackground(new Color(255, 255, 255));
		BtnAndalucia.setBounds(199, 459, 349, 143);
		BtnAndalucia.setOpaque(false);
		BtnAndalucia.setBorderPainted(false);
		contentPane.add(BtnAndalucia);
		
		BtnMurcia = new JButton("");
		BtnMurcia.setBackground(new Color(255, 255, 255));
		BtnMurcia.setBounds(555, 451, 92, 75);
		BtnMurcia.setOpaque(false);
		BtnMurcia.setBorderPainted(false);
		contentPane.add(BtnMurcia);
		
		BtnCanarias = new JButton("");
		BtnCanarias.setBackground(new Color(255, 255, 255));
		BtnCanarias.setBounds(0, 631, 239, 87);
		BtnCanarias.setOpaque(false);
		BtnCanarias.setBorderPainted(false);
		contentPane.add(BtnCanarias);
		
		BtnCeuta = new JButton("");
		BtnCeuta.setBackground(new Color(255, 255, 255));
		BtnCeuta.setBounds(309, 622, 54, 31);
		BtnCeuta.setOpaque(false);
		BtnCeuta.setBorderPainted(false);
		contentPane.add(BtnCeuta);
		
		BtnMelilla = new JButton("");
		BtnMelilla.setBackground(new Color(255, 255, 255));
		BtnMelilla.setBounds(464, 657, 54, 31);
		BtnMelilla.setOpaque(false);
		BtnMelilla.setBorderPainted(false);
		contentPane.add(BtnMelilla);

		
		
		CanariasVerde = crearImagen(
		        "Imagenes/CanariasVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CanariasVerde);
		CanariasVerde.setVisible(false);
		
		CanariasAzul = crearImagen(
		        "Imagenes/CanariasAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CanariasAzul);
		CanariasAzul.setVisible(false);
		
		CanariasRojo = crearImagen(
		        "Imagenes/CanariasRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CanariasRojo);
		CanariasRojo.setVisible(false);
		
		CanariasMorado = crearImagen(
		        "Imagenes/CanariasMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(CanariasMorado);
		CanariasMorado.setVisible(false);
		
		
		MelillaVerde = crearImagen(
		        "Imagenes/MelillaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MelillaVerde);
		MelillaVerde.setVisible(false);
		
		MelillaAzul = crearImagen(
		        "Imagenes/MelillaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MelillaAzul);
		MelillaAzul.setVisible(false);
		
		MelillaRojo = crearImagen(
		        "Imagenes/MelillaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MelillaRojo);
		MelillaRojo.setVisible(false);
		
		MelillaMorado = crearImagen(
		        "Imagenes/MelillaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(MelillaMorado);
		MelillaMorado.setVisible(false);
		
		CeutaVerde = crearImagen(
		        "Imagenes/CeutaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CeutaVerde);
		CeutaVerde.setVisible(false);
		
		CeutaAzul = crearImagen(
		        "Imagenes/CeutaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CeutaAzul);
		CeutaAzul.setVisible(false);
		
		CeutaRojo = crearImagen(
		        "Imagenes/CeutaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CeutaRojo);
		CeutaRojo.setVisible(false);
		
		CeutaMorado = crearImagen(
		        "Imagenes/CeutaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(CeutaMorado);
		CeutaMorado.setVisible(false);
		

		BalearesVerde = crearImagen(
		        "Imagenes/BalearesVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(BalearesVerde);
		BalearesVerde.setVisible(false);
		
		BalearesAzul = crearImagen(
		        "Imagenes/BalearesAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(BalearesAzul);
		BalearesAzul.setVisible(false);
		
		BalearesRojo = crearImagen(
		        "Imagenes/BalearesRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(BalearesRojo);
		BalearesRojo.setVisible(false);
		
		BalearesMorado = crearImagen(
		        "Imagenes/BalearesMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(BalearesMorado);
		BalearesMorado.setVisible(false);
		
		GaliciaVerde = crearImagen(
		        "Imagenes/GaliciaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(GaliciaVerde);
		GaliciaVerde.setVisible(false);
		
		GaliciaAzul = crearImagen(
		        "Imagenes/GaliciaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(GaliciaAzul);
		GaliciaAzul.setVisible(false);
		
		GaliciaRojo = crearImagen(
		        "Imagenes/GaliciaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(GaliciaRojo);
		GaliciaRojo.setVisible(false);
		
		GaliciaMorado = crearImagen(
		        "Imagenes/GaliciaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(GaliciaMorado);
		GaliciaMorado.setVisible(false);
		
		AsturiasVerde = crearImagen(
		        "Imagenes/AsturiasVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AsturiasVerde);
		AsturiasVerde.setVisible(false);
		
		AsturiasAzul = crearImagen(
		        "Imagenes/AsturiasAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AsturiasAzul);
		AsturiasAzul.setVisible(false);
		
		AsturiasRojo = crearImagen(
		        "Imagenes/AsturiasRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AsturiasRojo);
		AsturiasRojo.setVisible(false);
		
		AsturiasMorado = crearImagen(
		        "Imagenes/AsturiasMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(AsturiasMorado);
		AsturiasMorado.setVisible(false);
		
		CantabriaVerde = crearImagen(
		        "Imagenes/CantabriaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CantabriaVerde);
		CantabriaVerde.setVisible(false);
		
		CantabriaAzul = crearImagen(
		        "Imagenes/CantabriaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CantabriaAzul);
		CantabriaAzul.setVisible(false);
		
		CantabriaRojo = crearImagen(
		        "Imagenes/CantabriaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CantabriaRojo);
		CantabriaRojo.setVisible(false);
		
		CantabriaMorado = crearImagen(
		        "Imagenes/CantabriaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(CantabriaMorado);
		CantabriaMorado.setVisible(false);
		
		LaRiojaVerde = crearImagen(
		        "Imagenes/LaRiojaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaRiojaVerde);
		LaRiojaVerde.setVisible(false);
		
		LaRiojaAzul = crearImagen(
		        "Imagenes/LaRiojaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaRiojaAzul);
		LaRiojaAzul.setVisible(false);
		
		LaRiojaRojo = crearImagen(
		        "Imagenes/LaRiojaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaRiojaRojo);
		LaRiojaRojo.setVisible(false);
		
		LaRiojaMorado = crearImagen(
		        "Imagenes/LaRiojaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(LaRiojaMorado);
		LaRiojaMorado.setVisible(false);
		
		PaisVascoVerde = crearImagen(
		        "Imagenes/PaisVascoVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(PaisVascoVerde);
		PaisVascoVerde.setVisible(false);
		
		PaisVascoAzul = crearImagen(
		        "Imagenes/PaisVascoAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(PaisVascoAzul);
		PaisVascoAzul.setVisible(false);
		
		PaisVascoRojo = crearImagen(
		        "Imagenes/PaisVascoRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(PaisVascoRojo);
		PaisVascoRojo.setVisible(false);
		
		PaisVascoMorado = crearImagen(
		        "Imagenes/PaisVascoMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(PaisVascoMorado);
		PaisVascoMorado.setVisible(false);
		
		NavarraVerde = crearImagen(
		        "Imagenes/NavarraVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(NavarraVerde);
		NavarraVerde.setVisible(false);
		
		NavarraAzul = crearImagen(
		        "Imagenes/NavarraAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(NavarraAzul);
		NavarraAzul.setVisible(false);
		
		NavarraRojo = crearImagen(
		        "Imagenes/NavarraRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(NavarraRojo);
		NavarraRojo.setVisible(false);
		
		NavarraMorado = crearImagen(
		        "Imagenes/NavarraMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(NavarraMorado);
		NavarraMorado.setVisible(false);
		

		CastillaLeonVerde = crearImagen(
		        "Imagenes/CastillaLeonVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CastillaLeonVerde);
		CastillaLeonVerde.setVisible(false);
		
		CastillaLeonAzul = crearImagen(
		        "Imagenes/CastillaLeonAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CastillaLeonAzul);
		CastillaLeonAzul.setVisible(false);
		
		CastillaLeonRojo = crearImagen(
		        "Imagenes/CastillaLeonRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CastillaLeonRojo);
		CastillaLeonRojo.setVisible(false);
		
		CastillaLeonMorado = crearImagen(
		        "Imagenes/CastillaLeonMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		        
		);
		getContentPane().add(CastillaLeonMorado);
		CastillaLeonMorado.setVisible(false);
		
		CataluniaVerde = crearImagen(
		        "Imagenes/CataluniaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CataluniaVerde);
		CataluniaVerde.setVisible(false);
		
		CataluniaAzul = crearImagen(
		        "Imagenes/CataluniaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CataluniaAzul);
		CataluniaAzul.setVisible(false);
		
		CataluniaRojo = crearImagen(
		        "Imagenes/CataluniaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CataluniaRojo);
		CataluniaRojo.setVisible(false);
		
		CataluniaMorado = crearImagen(
		        "Imagenes/CataluniaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(CataluniaMorado);
		CataluniaMorado.setVisible(false);
		
		ComValencianaVerde = crearImagen(
		        "Imagenes/ComValencianaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ComValencianaVerde);
		ComValencianaVerde.setVisible(false);
		
		ComValencianaAzul = crearImagen(
		        "Imagenes/ComValencianaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ComValencianaAzul);
		ComValencianaAzul.setVisible(false);
		
		ComValencianaRojo = crearImagen(
		        "Imagenes/ComValencianaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ComValencianaRojo);
		ComValencianaRojo.setVisible(false);
		
		ComValencianaMorado = crearImagen(
		        "Imagenes/ComValencianaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ComValencianaMorado);
		ComValencianaMorado.setVisible(false);
		
		MurciaVerde = crearImagen(
		        "Imagenes/MurciaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MurciaVerde);
		MurciaVerde.setVisible(false);
		
		MurciaAzul = crearImagen(
		        "Imagenes/MurciaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MurciaAzul);
		MurciaAzul.setVisible(false);
		
		MurciaRojo = crearImagen(
		        "Imagenes/MurciaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MurciaRojo);
		MurciaRojo.setVisible(false);
		
		MurciaMorado = crearImagen(
		        "Imagenes/MurciaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MurciaMorado);
		MurciaMorado.setVisible(false);
		
		AndaLuciaVerde = crearImagen(
		        "Imagenes/AndaLuciaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AndaLuciaVerde);
		AndaLuciaVerde.setVisible(false);
		
		AndaLuciaAzul = crearImagen(
		        "Imagenes/AndaLuciaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AndaLuciaAzul);
		AndaLuciaAzul.setVisible(false);
		
		AndaLuciaRojo = crearImagen(
		        "Imagenes/AndaLuciaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AndaLuciaRojo);
		AndaLuciaRojo.setVisible(false);
		
		AndaLuciaMorado = crearImagen(
		        "Imagenes/AndaLuciaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AndaLuciaMorado);
		AndaLuciaMorado.setVisible(false);
		
		ExtremaduraVerde = crearImagen(
		        "Imagenes/ExtremaduraVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ExtremaduraVerde);
		ExtremaduraVerde.setVisible(false);
		
		ExtremaduraAzul = crearImagen(
		        "Imagenes/ExtremaduraAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ExtremaduraAzul);
		ExtremaduraAzul.setVisible(false);
		
		ExtremaduraRojo = crearImagen(
		        "Imagenes/ExtremaduraRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ExtremaduraRojo);
		ExtremaduraRojo.setVisible(false);
		
		ExtremaduraMorado = crearImagen(
		        "Imagenes/ExtremaduraMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(ExtremaduraMorado);
		ExtremaduraMorado.setVisible(false);
		
		MadridVerde = crearImagen(
		        "Imagenes/MadridVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MadridVerde);
		MadridVerde.setVisible(false);
		
		MadridAzul = crearImagen(
		        "Imagenes/MadridAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MadridAzul);
		MadridAzul.setVisible(false);
		
		MadridRojo = crearImagen(
		        "Imagenes/MadridRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MadridRojo);
		MadridRojo.setVisible(false);
		
		MadridMorado = crearImagen(
		        "Imagenes/MadridMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(MadridMorado);
		MadridMorado.setVisible(false);
		
		LaManchaVerde = crearImagen(
		        "Imagenes/LaManchaVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaManchaVerde);
		LaManchaVerde.setVisible(false);
		
		LaManchaAzul = crearImagen(
		        "Imagenes/LaManchaAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaManchaAzul);
		LaManchaAzul.setVisible(false);
		
		LaManchaRojo = crearImagen(
		        "Imagenes/LaManchaRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaManchaRojo);
		LaManchaRojo.setVisible(false);
		
		LaManchaMorado = crearImagen(
		        "Imagenes/LaManchaMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(LaManchaMorado);
		LaManchaMorado.setVisible(false);
		
		AragonVerde = crearImagen(
		        "Imagenes/AragonVerde.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AragonVerde);
		AragonVerde.setVisible(false);
		
		AragonAzul = crearImagen(
		        "Imagenes/AragonAzul.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AragonAzul);
		AragonAzul.setVisible(false);
		
		AragonRojo = crearImagen(
		        "Imagenes/AragonRojo.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AragonRojo);
		AragonRojo.setVisible(false);
		
		AragonMorado = crearImagen(
		        "Imagenes/AragonMorado.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(AragonMorado);
		AragonMorado.setVisible(false);
		
		Mapa = crearImagen(
		        "Imagenes/MapaEspania.png",
		        0, 0, 942, 663,
		        scaleX, scaleY
		);
		getContentPane().add(Mapa);
		
		BtnSimular = new JButton("Simular\r\n");
		BtnSimular.setBackground(new Color(255, 255, 255));
		BtnSimular.setFont(new Font("Serif", Font.PLAIN, 40));
		BtnSimular.setBounds(1044, 657, 332, 51);
		contentPane.add(BtnSimular);
		
		BarraZ = new JProgressBar(JProgressBar.VERTICAL);
		BarraZ.setForeground(new Color(128, 0, 128));
		BarraZ.setBounds(1063, 202, 38, 408); 
		contentPane.add(BarraZ);

		BarraZ.setOrientation(JProgressBar.VERTICAL);
		
		BarraW = new JProgressBar(SwingConstants.VERTICAL);
		BarraW.setForeground(new Color(255, 0, 0));
		BarraW.setBounds(1151, 202, 38, 408);
		contentPane.add(BarraW);
		
		BarraY = new JProgressBar(SwingConstants.VERTICAL);
		BarraY.setForeground(new Color(0, 128, 255));
		BarraY.setBounds(1237, 202, 38, 408);
		contentPane.add(BarraY);
		
		BarraX = new JProgressBar(SwingConstants.VERTICAL);
		BarraX.setForeground(new Color(0, 255, 64));
		BarraX.setBounds(1323, 202, 38, 408);
		contentPane.add(BarraX);
		
		LblTituloGanador = new JLabel("Ganador General");
		LblTituloGanador.setFont(new Font("Tahoma", Font.BOLD, 35));
		LblTituloGanador.setHorizontalAlignment(SwingConstants.CENTER);
		LblTituloGanador.setBounds(1031, 0, 355, 59);
		contentPane.add(LblTituloGanador);
		
		LblPartidoGanador = new JLabel("(Eq Ganador)");
		LblPartidoGanador.setFont(new Font("Verdana", Font.BOLD, 25));
		LblPartidoGanador.setHorizontalAlignment(SwingConstants.CENTER);
		LblPartidoGanador.setBounds(1063, 99, 298, 66);
		contentPane.add(LblPartidoGanador);
		
		LblZ = new JLabel("Z");
		LblZ.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblZ.setHorizontalAlignment(SwingConstants.CENTER);
		LblZ.setBounds(1063, 622, 38, 31);
		contentPane.add(LblZ);
		
		LblW = new JLabel("W");
		LblW.setHorizontalAlignment(SwingConstants.CENTER);
		LblW.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblW.setBounds(1151, 622, 38, 31);
		contentPane.add(LblW);
		
		LblY = new JLabel("Y");
		LblY.setHorizontalAlignment(SwingConstants.CENTER);
		LblY.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblY.setBounds(1237, 622, 38, 31);
		contentPane.add(LblY);
		
		LblX = new JLabel("X");
		LblX.setHorizontalAlignment(SwingConstants.CENTER);
		LblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblX.setBounds(1323, 622, 38, 31);
		contentPane.add(LblX);
		

		

		
		

		

		
		
		

	}
	
	public JLabel crearImagen(
	        String ruta,
	        int x, int y,
	        int w, int h,
	        double scaleX, double scaleY
	) {
	    int ancho = (int)(w * scaleX);
	    int alto  = (int)(h * scaleY);

	    ImageIcon icon = new ImageIcon(ruta);
	    Image img = icon.getImage().getScaledInstance(
	            ancho,
	            alto,
	            Image.SCALE_SMOOTH
	    );

	    JLabel lbl = new JLabel(new ImageIcon(img));
	    lbl.setBounds(
	            (int)(x * scaleX),
	            (int)(y * scaleY),
	            ancho,
	            alto
	    );
	    return lbl;
	}
}
