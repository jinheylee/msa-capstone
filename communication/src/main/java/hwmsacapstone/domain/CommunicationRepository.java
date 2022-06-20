package hwmsacapstone.domain;

import hwmsacapstone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "communications",
    path = "communications"
)
public interface CommunicationRepository
    extends PagingAndSortingRepository<Communication, Long> {}
