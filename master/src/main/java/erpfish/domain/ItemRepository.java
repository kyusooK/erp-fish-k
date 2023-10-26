package erpfish.domain;

import erpfish.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository
    extends PagingAndSortingRepository<Item, Long> {}
