package co.edu.platzi.spring.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="compras")

@Getter @Setter
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Integer compraID;
	
	@Column(name="id_cliente")
	private String clienteID;
	
	// como este atributo se llama igual que la columna en la tabla, no es necesario el @Column
	private LocalDateTime fecha;
	
	@Column(name="medio_pago")
	private String medioPago;
	
	private String comentario;
	
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", insertable=false, updatable=false)
	private Cliente cliente;
	
	@OneToMany(mappedBy="compra", cascade={CascadeType.ALL})
	private List<ComprasProducto> productos;

}
