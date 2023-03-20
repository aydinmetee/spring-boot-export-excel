package tr.com.metea.springbootexportexcel.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
@Getter
@Setter
public class ProductDTO {
    private String name;
    private String code;
    private BigDecimal price;
    private Long quantity;
}
