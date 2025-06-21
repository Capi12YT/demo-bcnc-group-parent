package demo.bcnc.repositorys;

import demo.bcnc.model.Price;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class PriceRepositorySpecification {

    public static Specification<Price> hasIdProducto(String idProducto) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("producto").get("id"), idProducto);
    }

    public static Specification<Price> hasIdCadena(String idCadena) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("grupo").get("id"), idCadena);
    }

    public static Specification<Price> hasFechaAplicacion(OffsetDateTime fechaAplicacion) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(
                criteriaBuilder.literal(fechaAplicacion.toLocalDateTime()),
                root.get("startDate"),
                root.get("endDate")
        );
    }
}
