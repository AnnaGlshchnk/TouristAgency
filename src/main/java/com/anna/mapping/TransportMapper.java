package com.anna.mapping;

import com.anna.model.dto.TransportDto;
import com.anna.model.entity.Transport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransportMapper {

    TransportDto transportEntityToTransportDto(Transport transport);

    Transport transportDtoToTransportEntity(TransportDto transportDto);
}
