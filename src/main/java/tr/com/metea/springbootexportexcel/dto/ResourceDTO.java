package tr.com.metea.springbootexportexcel.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
@Getter
@Setter
public class ResourceDTO {
    private Resource resource;
    private MediaType mediaType;
    private String fileName;
}
