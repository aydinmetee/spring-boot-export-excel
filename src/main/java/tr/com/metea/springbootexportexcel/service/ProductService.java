package tr.com.metea.springbootexportexcel.service;

import tr.com.metea.springbootexportexcel.dto.ExcelMetadataDTO;
import tr.com.metea.springbootexportexcel.dto.ProductDTO;
import tr.com.metea.springbootexportexcel.dto.ResourceDTO;
import tr.com.metea.springbootexportexcel.entity.Product;

import java.util.List;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
public interface ProductService {
    Product create(ProductDTO productDTO);

    List<Product> getAllProduct();

    ExcelMetadataDTO prepareExcelData();

    public ResourceDTO exportExcel();
}
