package co.edu.platzi.spring.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categorias")

@Getter @Setter
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Integer categoriaID;
	
	private String descripcion;
	
	private Boolean estado;
	
	@OneToMany(mappedBy="categoria")
	private List<Producto> productos;
	
}
