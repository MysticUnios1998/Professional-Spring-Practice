package co.edu.platzi.spring.persistence.entity.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable

@Getter @Setter
public class ComprasProductoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3437497932046993799L;
	
	@Column(name="id_compra")
	private Integer compraID;
	
	@Column(name="id_producto")
	private Integer productoID;

}
