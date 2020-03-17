package com.anna.repository;

import com.anna.model.entity.UserTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserTourRepository extends JpaRepository<UserTour, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into user_tour (user_id, tour_id) VALUES (:userId, :tourId)", nativeQuery = true)
    void saveWithoutId(Long userId, Long tourId);

}
