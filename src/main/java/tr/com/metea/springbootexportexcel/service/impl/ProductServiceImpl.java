package tr.com.metea.springbootexportexcel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.metea.springbootexportexcel.dto.ExcelMetadataDTO;
import tr.com.metea.springbootexportexcel.dto.ProductDTO;
import tr.com.metea.springbootexportexcel.dto.ResourceDTO;
import tr.com.metea.springbootexportexcel.entity.Product;
import tr.com.metea.springbootexportexcel.repository.ProductRepository;
import tr.com.metea.springbootexportexcel.service.ExcelService;
import tr.com.metea.springbootexportexcel.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ExcelService excelService;
    private final ProductRepository productRepository;

    @Override
    public Product create(ProductDTO productDTO) {
        final var product = new Product();
        product.setCode(productDTO.getCode());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ExcelMetadataDTO prepareExcelData() {
        final var excelMetadataDTO = new ExcelMetadataDTO();
        excelMetadataDTO.setTableName("Products");
        excelMetadataDTO.setHeaders(List.of("ID", "Name", "Code", "Quantity", "Price"));
        final var products = getAllProduct();
        List<Map<String, String>> metadata = new ArrayList<>();

        for (Product product : products) {
            Map<String, String> data = new HashMap<>();
            data.put("ID", product.getId().toString());
            data.put("Name", product.getName());
            data.put("Code", product.getCode());
            data.put("Quantity", product.getQuantity().toString());
            data.put("Price", product.getPrice().toString());
            metadata.add(data);
        }
        excelMetadataDTO.setDatas(metadata);
        return excelMetadataDTO;
    }

    @Override
    public ResourceDTO exportExcel() {
        final var resourceDTO = excelService.exportExcel(prepareExcelData());
        resourceDTO.setFileName("Products");
        return resourceDTO;
    }
}
