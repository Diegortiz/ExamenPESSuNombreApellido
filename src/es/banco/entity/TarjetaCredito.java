package es.banco.entity;

public class TarjetaCredito {
	private int id;
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private String tipo;
	private int numeroComprobacion;
	private int contrase�a;
	private boolean bloqueada;
	
	
	public TarjetaCredito() {
		super();
	}


	



	public TarjetaCredito(int id, String numero, int cupoMaximo,
			int cupoDisponible, String tipo, int numeroComprobacion,
			int contrase�a, boolean bloqueada) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrase�a = contrase�a;
		this.bloqueada = bloqueada;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCupoMaximo() {
		return cupoMaximo;
	}


	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}


	public int getCupoDisponible() {
		return cupoDisponible;
	}


	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getNumeroComprobacion() {
		return numeroComprobacion;
	}


	public void setNumeroComprobacion(int numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}


	public int getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(int contrase�a) {
		this.contrase�a = contrase�a;
	}


	public boolean isBloqueada() {
		return bloqueada;
	}


	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}


	@Override
	public String toString() {
		return "TarjetaCredito [id=" + id + ", numero=" + numero
				+ ", cupoMaximo=" + cupoMaximo + ", cupoDisponible="
				+ cupoDisponible + ", tipo=" + tipo + ", numeroComprobacion="
				+ numeroComprobacion + ", contrase�a=" + contrase�a
				+ ", bloqueada=" + bloqueada + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bloqueada ? 1231 : 1237);
		result = prime * result + contrase�a;
		result = prime * result + cupoDisponible;
		result = prime * result + cupoMaximo;
		result = prime * result + id;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + numeroComprobacion;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		if (bloqueada != other.bloqueada)
			return false;
		if (contrase�a != other.contrase�a)
			return false;
		if (cupoDisponible != other.cupoDisponible)
			return false;
		if (cupoMaximo != other.cupoMaximo)
			return false;
		if (id != other.id)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (numeroComprobacion != other.numeroComprobacion)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}


	public static void add(TarjetaCredito c) {
		
		
	}
	
	
	
	
}
