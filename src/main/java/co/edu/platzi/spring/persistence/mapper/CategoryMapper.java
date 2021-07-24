package co.edu.platzi.spring.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.platzi.spring.domain.dto.Category;
import co.edu.platzi.spring.persistence.entity.Categoria;

@Mapper(componentModel="spring")
public interface CategoryMapper {

	@Mappings({
		@Mapping(source="categoriaID", target="categoryId"),
		@Mapping(source="descripcion", target="category"),
		@Mapping(source="estado", target="active")
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration
	@Mapping(target="productos", ignore=true)
	Categoria toCategoria(Category category);
	
}
