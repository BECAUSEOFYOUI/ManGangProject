package com.qfedu.service;

import com.qfedu.entity.Designer;

import java.util.List;

public interface DesignerService {
    List<Designer> seletAllDesigner();

    Designer selectDesignerById(Integer id);
}
