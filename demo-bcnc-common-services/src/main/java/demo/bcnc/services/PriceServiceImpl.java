package demo.bcnc.services;

import demo.bcnc.interfaces.PriceService;
import demo.bcnc.mappers.PriceMapper;
import demo.bcnc.model.Price;
import demo.bcnc.model.TarifaResponse;
import demo.bcnc.repositorys.PriceRepository;
import demo.bcnc.repositorys.PriceRepositorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceMapper priceMapper;

    /**
     * @param idProducto
     * @param idCadena
     * @param fechaAplicacion
     * @return
     */
    @Override
    public List<TarifaResponse> getPrices(OffsetDateTime fechaAplicacion,
                                          String idProducto,
                                          String idCadena) {


        Specification<Price> specification = Specification.where(PriceRepositorySpecification.hasFechaAplicacion(fechaAplicacion))
                .and(PriceRepositorySpecification.hasIdProducto(idProducto))
                .and(PriceRepositorySpecification.hasIdCadena(idCadena));

        List<Price> prices = priceRepository.findAll(specification);

        return prices.stream()
                .map(price -> priceMapper.convertPriceToTarifaResponse(price))
                .toList();
    }
}
