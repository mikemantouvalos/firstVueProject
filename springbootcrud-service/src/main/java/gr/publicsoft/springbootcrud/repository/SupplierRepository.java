package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT DISTINCT s FROM Supplier s WHERE s.companyName LIKE CONCAT('%',?1,'%')" +
            "OR s.vatNumber LIKE CONCAT('%',?1,'%')")
    List<Supplier> getSupplierByCompanyName(@Param("query") String searchInput);

}
