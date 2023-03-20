package tr.com.metea.springbootexportexcel.service;

import tr.com.metea.springbootexportexcel.dto.ExcelMetadataDTO;
import tr.com.metea.springbootexportexcel.dto.ResourceDTO;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
public interface ExcelService {

    ResourceDTO exportExcel(ExcelMetadataDTO excelMetadataDTO);
}
