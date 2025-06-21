package demo.bcnc.controller;

import demo.bcnc.api.DemoBcncApiDelegate;
import demo.bcnc.interfaces.PriceService;
import demo.bcnc.model.TarifaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
public class DemoBcncApiDelegateImpl implements DemoBcncApiDelegate {

    @Autowired
    private PriceService priceService;

    @Override
    public ResponseEntity<List<TarifaResponse>> tarifaGet(OffsetDateTime fechaAplicacion,
                                                          String idProducto,
                                                          String idCadena) {
        List<TarifaResponse> tarifaResponsesList = priceService.getPrices(fechaAplicacion, idProducto, idCadena);
        if (tarifaResponsesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tarifaResponsesList, HttpStatus.OK);

    }

}
