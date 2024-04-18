package Skufestivalback.skufestival.lostItem.Domain.Repository;

import Skufestivalback.skufestival.lostItem.Domain.Entity.lostItemBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface lostItemBoardRepository extends JpaRepository<lostItemBoard, Long> {
}
