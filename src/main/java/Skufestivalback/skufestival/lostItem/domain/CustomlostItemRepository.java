package Skufestivalback.skufestival.lostItem.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomlostItemRepository {

    lostItem findByIdOrElseThrow(Long id);
}
