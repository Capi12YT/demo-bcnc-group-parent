

import demo.bcnc.MainDemoBcnc;
import demo.bcnc.controller.DemoBcncApiDelegateImpl;
import demo.bcnc.interfaces.PriceService;
import demo.bcnc.model.TarifaResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TarifaControllerTest {

    @InjectMocks
    private DemoBcncApiDelegateImpl demoBcncApiDelegate = new DemoBcncApiDelegateImpl();

    @Mock
    private PriceService tarifaService;


    private TarifaResponse mockPriceDTO(OffsetDateTime start,String idProducto, String brandId) {
        TarifaResponse dto = new TarifaResponse();
        dto.setIdProducto(idProducto);
        dto.setFechaInicio(start);
        dto.setIdCadena(brandId);
        return dto;
    }

    @Test
   public void test1_fecha14_10h(){
        OffsetDateTime fecha = OffsetDateTime.parse("2020-06-14T10:00:00Z");
        when(tarifaService.getPrices(fecha, "35455", "1"))
                .thenReturn(List.of(mockPriceDTO(fecha, "35455", "1")));

        demoBcncApiDelegate.tarifaGet(fecha, "35455", "1");

       verify(tarifaService).getPrices(fecha, "35455", "1");
    }

    @Test
    public void test2_fecha14_16h(){
        OffsetDateTime fecha = OffsetDateTime.parse("2020-06-14T16:00:00Z");
        when(tarifaService.getPrices(fecha, "35455", "1"))
                .thenReturn(List.of(mockPriceDTO(fecha, "35455", "1")));

        demoBcncApiDelegate.tarifaGet(fecha, "35455", "1");

        verify(tarifaService).getPrices(fecha, "35455", "1");
    }

    @Test
    public void test3_fecha14_21h(){
        OffsetDateTime fecha = OffsetDateTime.parse("2020-06-14T21:00:00Z");
        when(tarifaService.getPrices(fecha, "35455", "1"))
                .thenReturn(List.of(mockPriceDTO(fecha, "35455", "1")));

        demoBcncApiDelegate.tarifaGet(fecha, "35455", "1");

        verify(tarifaService).getPrices(fecha, "35455", "1");
    }

    @Test
    public void test4_fecha15_10h(){
        OffsetDateTime fecha = OffsetDateTime.parse("2020-06-15T10:00:00Z");
        when(tarifaService.getPrices(fecha, "35455", "1"))
                .thenReturn(List.of(mockPriceDTO(fecha, "35455", "1")));

        demoBcncApiDelegate.tarifaGet(fecha, "35455", "1");

        verify(tarifaService).getPrices(fecha, "35455", "1");
    }

    @Test
    public void test5_fecha16_21h(){
        OffsetDateTime fecha = OffsetDateTime.parse("2020-06-16T21:00:00Z");
        when(tarifaService.getPrices(fecha, "35455", "1"))
                .thenReturn(List.of(mockPriceDTO(fecha, "35455", "1")));

        demoBcncApiDelegate.tarifaGet(fecha, "35455", "1");

        verify(tarifaService).getPrices(fecha, "35455", "1");
    }



}