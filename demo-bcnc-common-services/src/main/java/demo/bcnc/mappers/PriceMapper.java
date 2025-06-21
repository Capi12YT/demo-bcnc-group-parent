package demo.bcnc.mappers;

import demo.bcnc.model.Price;
import demo.bcnc.model.TarifaResponse;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceMapper {

    private final ModelMapper modelMapper;

    public PriceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void setupMappings() {
        modelMapper.addMappings(new PropertyMap<Price, TarifaResponse>() {
            @Override
            protected void configure() {
                map(source.getProducto().getId(), destination.getIdProducto());
                map(source.getGrupo().getId(), destination.getIdCadena());
                map(source.getPriceList().getId(), destination.getTarifaAplicar());
                using(mapLocalDateTimeToOffDateTime()).map(source.getStartDate(), destination.getFechaInicio());
                map(source.getPrice(), destination.getPrecioFinal());
            }
        });

    }

    private Converter<LocalDateTime, OffsetDateTime> mapLocalDateTimeToOffDateTime() {
        return new Converter<LocalDateTime, OffsetDateTime>() {
            @Override
            public OffsetDateTime convert(MappingContext<LocalDateTime, OffsetDateTime> context) {
                LocalDateTime localDateTime = context.getSource();
                if (localDateTime == null) {
                    return null;
                }
                return localDateTime.atOffset(ZoneOffset.UTC);
            }
        };
    }

    public TarifaResponse convertPriceToTarifaResponse(Price price) {
        return modelMapper.map(price, TarifaResponse.class);
    }
}
