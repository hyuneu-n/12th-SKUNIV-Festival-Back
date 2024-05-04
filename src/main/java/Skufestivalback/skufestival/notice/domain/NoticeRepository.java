package Skufestivalback.skufestival.notice.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>, CustomNoticeRepository {

    // @Query(nativeQuery = true, value = "SELECT * FROM notice WHERE id < :lastId ORDER BY id DESC LIMIT :pageSize")
    // List<Notice> find(@Param("lastId") Long lastId, @Param("pageSize") int pageSize);

    @Query(nativeQuery = true, value = "SELECT * FROM notice ORDER BY id DESC")
    List<Notice> findAllNotices();
}
