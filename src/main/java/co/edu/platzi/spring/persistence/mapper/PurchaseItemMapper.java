package co.edu.platzi.spring.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.platzi.spring.domain.dto.PurchaseItem;
import co.edu.platzi.spring.persistence.entity.ComprasProducto;

@Mapper(componentModel="spring", uses= {ProductMapper.class})
public interface PurchaseItemMapper {
	
	@Mappings({
		@Mapping(source="id.productoID", target="productId"),
		@Mapping(source="cantidad", target="quantity"),
		@Mapping(source="total", target="totalPrice"),
		@Mapping(source="estado", target="active")
	})
	PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target="compra", ignore=true),
		@Mapping(target="producto", ignore=true),
		@Mapping(target="id.compraID", ignore=true)
	})
	ComprasProducto toComprasProducto(PurchaseItem purchaseItem);

}
