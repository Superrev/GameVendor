package springBootApp.entities;

/**
 * Created by Superduo on 8/10/16.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VendorDAO extends CrudRepository<Vendor, Long> {
}

