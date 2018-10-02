package guru.springframewrok.spring5webapp.repositories;

import guru.springframewrok.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
