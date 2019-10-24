package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreUsuario;
	private String email;
	private String password;
	private String rol;
	private int edad;
	private double peso;
	private double altura;
	private double IndiceMasaCorporal;
	private String ClasificacionImc;
	private double TotalCalQuemadas;


	@ManyToOne
	@JoinColumn(name="FK_Evento")
	private Evento evento;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Usuario_Evento",
			joinColumns = { @JoinColumn(name = "usuario_id") },
			inverseJoinColumns = { @JoinColumn(name = "evento_id") }
	)
	Set<Evento> eventos = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getIndiceMasaCorporal() {
		return IndiceMasaCorporal;
	}

	public void setIndiceMasaCorporal(double peso, double altura) {

		this.IndiceMasaCorporal = peso/(altura*altura);
	}

	public String getClasificacionImc() {
		return ClasificacionImc;
	}

	public void setClasificacionImc(Double indiceMasaCorporal) {
		Double imc = indiceMasaCorporal;
		String cad="";
		if(imc<16.00){
			cad="Infrapeso: Delgadez Severa";
		}else if(imc<=16.00 || imc<=16.99){
			cad="Infrapeso: Delgadez moderada";
		}else if(imc<=17.00 ||imc<=18.49){
			cad="Infrapeso: Delgadez aceptable";
		}else if(imc<=18.50 || imc<=24.99){
			cad="Peso Normal";
		}else if(imc<=25.00 || imc<=29.99){
			cad="Sobrepeso";
		}else if(imc<=30.00 || imc<=34.99){
			cad="Obeso: Tipo I";
		}else{cad = "clasificacion no existe";}

		this.ClasificacionImc = cad;
	}

	public double getTotalCalQuemadas() {
		return TotalCalQuemadas;
	}

	public void setTotalCalQuemadas(Evento calQuemadas) {
		TotalCalQuemadas += calQuemadas.getCalEstimadasQuemadas();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Evento evento) {
		this.eventos.add(evento);
	}


}
