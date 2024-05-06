package com.mobiauto.resale.mapper;

import com.mobiauto.resale.dto.ResaleDto;
import com.mobiauto.resale.dto.ResaleRequestDto;
import com.mobiauto.resale.entity.ResaleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResaleMapper {
    ResaleDto toResaleDto(ResaleEntity entity);
    ResaleEntity toResaleEntity(ResaleRequestDto dto);

}
