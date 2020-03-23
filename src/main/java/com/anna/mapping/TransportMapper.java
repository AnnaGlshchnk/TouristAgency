package com.anna.mapping;

import com.anna.model.dto.TransportDto;
import com.anna.model.entity.Transport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransportMapper {

    TransportMapper INSTANCE = Mappers.getMapper(TransportMapper.class);

    TransportDto transportEntityToTransportDto(Transport transport);

    Transport transportDtoToTransportEntity(TransportDto transportDto);
}
