package Skufestivalback.skufestival.lostItem.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface lostItemRepository extends JpaRepository<lostItem, Long>, CustomlostItemRepository {

    // 분실 여부에 따라 분실물 조회
    List<lostItem> findByLost(boolean lost);
    
    @Query(nativeQuery = true, value = "SELECT * FROM lost_item ORDER BY id DESC")
    List<lostItem> findAllSortedByIdDesc();
}
