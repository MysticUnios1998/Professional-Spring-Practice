package co.edu.platzi.spring.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.platzi.spring.persistence.entity.embeddable.ComprasProductoPK;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="compras_productos")

@Getter @Setter
public class ComprasProducto {
	
	@EmbeddedId
	private ComprasProductoPK id;
	
	private Integer cantidad;
	
	private BigDecimal total;
	
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_compra", insertable=false, updatable=false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="id_producto", insertable=false, updatable=false)
	private Producto producto;

}
