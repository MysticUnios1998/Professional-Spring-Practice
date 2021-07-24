package co.edu.platzi.spring.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.platzi.spring.domain.dto.Product;
import co.edu.platzi.spring.persistence.entity.Producto;

@Mapper(componentModel="spring", uses={CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productoID", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "categoriaID", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct(Producto producto);
    
    List<Product> toProductList(List<Producto> productos);
    
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
