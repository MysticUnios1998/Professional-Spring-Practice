package co.edu.platzi.spring.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes")

@Getter @Setter
public class Cliente {

	@Id
	@Column(name="id")
	private String clienteID;
	
	private String nombre;
	
	private String apellidos;
	
	private Integer celular;
	
	private String direccion;
	
	@Column(name="correo_electronico")
	private String correoElectronico;
	
	@OneToMany(mappedBy="cliente")
	private List<Compra> compras;
	
}
