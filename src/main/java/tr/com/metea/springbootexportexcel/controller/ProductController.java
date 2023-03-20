package tr.com.metea.springbootexportexcel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metea.springbootexportexcel.dto.ProductDTO;
import tr.com.metea.springbootexportexcel.dto.ResourceDTO;
import tr.com.metea.springbootexportexcel.entity.Product;
import tr.com.metea.springbootexportexcel.service.ProductService;

import java.util.List;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.create(productDTO));
    }

    @GetMapping("/get-all-products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportProducts() {
        ResourceDTO resourceDTO = productService.exportExcel();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition",
                "attachment; filename=" + resourceDTO.getFileName() + ".xlsx");

        return ResponseEntity.ok().contentType(resourceDTO.getMediaType())
                .headers(httpHeaders).body(resourceDTO.getResource());
    }
}
