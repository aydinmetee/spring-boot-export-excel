package tr.com.metea.springbootexportexcel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
@Getter
@Setter
public class ExcelMetadataDTO {
    private String tableName;
    private List<String> headers;
    private List<Map<String, String>> datas;
}
