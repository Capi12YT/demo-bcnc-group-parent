package demo.bcnc.interfaces;

import demo.bcnc.model.TarifaResponse;

import java.time.OffsetDateTime;
import java.util.List;

public interface PriceService {

    List<TarifaResponse> getPrices(OffsetDateTime fechaAplicacion,
                                   String idProducto,
                                   String idCadena);
}
