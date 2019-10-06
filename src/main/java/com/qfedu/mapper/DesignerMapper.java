package com.qfedu.mapper;

import com.qfedu.entity.Designer;

import java.util.List;

public interface DesignerMapper {
    Designer selectDesignerById(int id);

    List<Designer> selectAllDesigner();
}
