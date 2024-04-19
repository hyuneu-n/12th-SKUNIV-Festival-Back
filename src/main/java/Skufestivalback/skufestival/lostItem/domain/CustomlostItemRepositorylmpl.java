package Skufestivalback.skufestival.lostItem.domain;

import Skufestivalback.skufestival.common.exception.CustomException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomlostItemRepositorylmpl implements CustomlostItemRepository {

    private final EntityManager entityManager;

    @Override
    public lostItem findByIdOrElseThrow(Long id) {
        TypedQuery<lostItem> query = entityManager.createQuery("SELECT n FROM lostItem n WHERE n.id = :id", lostItem.class);
        query.setParameter("id", id);

        //예외상황 (유저를 불러오지 못했을때)
        List<lostItem> resultList = query.getResultList();
        if(resultList.isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "User Not Found");
        }

        return resultList.get(0);
    }
}
