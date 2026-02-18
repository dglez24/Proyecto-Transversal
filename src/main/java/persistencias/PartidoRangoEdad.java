package persistencias;
// Generated 17 feb 2026, 19:01:20 by Hibernate Tools 6.5.1.Final

import javax.persistence.*;

@Entity
@Table(name = "PARTIDO_RANGO_EDAD")
public class PartidoRangoEdad implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    // Esta es la contraparte de la relación que pusimos en la otra clase
    @ManyToOne
    @JoinColumn(name = "ID_COMUNIDAD") 
    private ComunidadPartido comunidadPartido;

    @Column(name = "PARTIDO")
    private String partido;

    @Column(name = "RANGO1")
    private int rango1;

    @Column(name = "RANGO2")
    private int rango2;
    @Column(name = "RANGO3")
    private int rango3;
    @Column(name = "RANGO4")
    private int rango4;
	public PartidoRangoEdad() {
	}

	public PartidoRangoEdad(ComunidadPartido comunidadPartido, String partido, int rango1, int rango2, int rango3,
			int rango4) {
		this.comunidadPartido = comunidadPartido;
		this.partido = partido;
		this.rango1 = rango1;
		this.rango2 = rango2;
		this.rango3 = rango3;
		this.rango4 = rango4;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComunidadPartido getComunidadPartido() {
		return this.comunidadPartido;
	}

	public void setComunidadPartido(ComunidadPartido comunidadPartido) {
		this.comunidadPartido = comunidadPartido;
	}

	public String getPartido() {
		return this.partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getRango1() {
		return this.rango1;
	}

	public void setRango1(int rango1) {
		this.rango1 = rango1;
	}

	public int getRango2() {
		return this.rango2;
	}

	public void setRango2(int rango2) {
		this.rango2 = rango2;
	}

	public int getRango3() {
		return this.rango3;
	}

	public void setRango3(int rango3) {
		this.rango3 = rango3;
	}

	public int getRango4() {
		return this.rango4;
	}

	public void setRango4(int rango4) {
		this.rango4 = rango4;
	}

}
