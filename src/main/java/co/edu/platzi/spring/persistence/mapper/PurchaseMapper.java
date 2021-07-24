package co.edu.platzi.spring.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import co.edu.platzi.spring.domain.dto.Purchase;
import co.edu.platzi.spring.persistence.entity.Compra;

@Mapper(componentModel="spring", uses= {PurchaseItemMapper.class})
public interface PurchaseMapper {

	@Mappings({
		@Mapping(source="compraID", target="purchaseId"),
		@Mapping(source="clienteID", target="clientId"),
		@Mapping(source="fecha", target="date"),
		@Mapping(source="medioPago", target="paymentMethod"),
		@Mapping(source="comentario", target="comment"),
		@Mapping(source="estado", target="state"),
		@Mapping(source="productos", target="items")
	})
	Purchase toPurchase(Compra compra);
	List<Purchase> toPurchases(List<Compra> compras);
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target="cliente", ignore=true)
	})
	Compra toCompra(Purchase purchase);
	
}
