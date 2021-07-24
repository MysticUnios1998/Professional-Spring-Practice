package co.edu.platzi.spring.persistence.entity.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Embeddable

@Getter @Setter
public class ComprasProductoPK implements Serializable{
	
	@Column(name="id_compra")
	private Integer compraID;
	
	@Column(name="id_producto")
	private Integer productoID;

}
