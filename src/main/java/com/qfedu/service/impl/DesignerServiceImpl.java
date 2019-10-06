package com.qfedu.service.impl;

import com.qfedu.entity.Designer;
import com.qfedu.mapper.DesignerMapper;
import com.qfedu.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DesignerServiceImpl implements DesignerService {
    @Autowired
    DesignerMapper designerMapper;
    public List<Designer> selectAllDesigner() {
        List<Designer> designerList = designerMapper.selectAllDesigner();
        return designerList;
    }

    public Designer selectDesignerById(Integer id) {
        Designer designer =designerMapper.selectDesignerById(id);
        return designer;
    }
}
