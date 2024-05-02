package Skufestivalback.skufestival.lostItem.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface lostItemRepository extends JpaRepository<lostItem, Long>, CustomlostItemRepository {

    @Query(nativeQuery = true, value = "SELECT * FROM lost_item WHERE id < :lastId ORDER BY id DESC LIMIT :pageSize")
    List<lostItem> find(@Param("lastId") Long lastId, @Param("pageSize") int pageSize);

}
