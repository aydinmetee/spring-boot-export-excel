package tr.com.metea.springbootexportexcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metea.springbootexportexcel.entity.Product;

/**
 * @author Mete Aydin
 * <p>
 * 20.03.2023
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
