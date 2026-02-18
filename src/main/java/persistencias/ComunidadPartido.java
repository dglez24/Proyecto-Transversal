package persistencias;
// Generated 17 feb 2026, 19:01:20 by Hibernate Tools 6.5.1.Final

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ComunidadPartido mapeada para recibir votos
 */
@Entity
@Table(name = "COMUNIDAD_PARTIDO")
public class ComunidadPartido implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "COMUNIDAD_AUTONOMA")
    private String comunidadAutonoma;

    @Column(name = "VOTOSW")
    private int votosw;

    @Column(name = "VOTOSX")
    private int votosx;

    @Column(name = "VOTOSY")
    private int votosy;

    @Column(name = "VOTOSZ")
    private int votosz;

    // Relación con la tabla de rangos (la "hija")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comunidadPartido")
    private Set<PartidoRangoEdad> partidoRangoEdads = new HashSet<>(0);
	public ComunidadPartido() {
	}

	public ComunidadPartido(String comunidadAutonoma, int votosw, int votosx, int votosy, int votosz) {
		this.comunidadAutonoma = comunidadAutonoma;
		this.votosw = votosw;
		this.votosx = votosx;
		this.votosy = votosy;
		this.votosz = votosz;
	}

	public ComunidadPartido(String comunidadAutonoma, int votosw, int votosx, int votosy, int votosz,
			Set partidoRangoEdads) {
		this.comunidadAutonoma = comunidadAutonoma;
		this.votosw = votosw;
		this.votosx = votosx;
		this.votosy = votosy;
		this.votosz = votosz;
		this.partidoRangoEdads = partidoRangoEdads;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComunidadAutonoma() {
		return this.comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public int getVotosw() {
		return this.votosw;
	}

	public void setVotosw(int votosw) {
		this.votosw = votosw;
	}

	public int getVotosx() {
		return this.votosx;
	}

	public void setVotosx(int votosx) {
		this.votosx = votosx;
	}

	public int getVotosy() {
		return this.votosy;
	}

	public void setVotosy(int votosy) {
		this.votosy = votosy;
	}

	public int getVotosz() {
		return this.votosz;
	}

	public void setVotosz(int votosz) {
		this.votosz = votosz;
	}

	public Set getPartidoRangoEdads() {
		return this.partidoRangoEdads;
	}

	public void setPartidoRangoEdads(Set partidoRangoEdads) {
		this.partidoRangoEdads = partidoRangoEdads;
	}

}
