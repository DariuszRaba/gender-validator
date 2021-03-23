package com.project.gendervalidator.service;

import com.project.gendervalidator.dao.TxtTokenFilesDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GenderService {

    private final TxtTokenFilesDAO txtTokenFilesDAO;

    public String getAllTokens(){
        return txtTokenFilesDAO.getMalesTokens() + txtTokenFilesDAO.getFemalesTokens();
    }
}
