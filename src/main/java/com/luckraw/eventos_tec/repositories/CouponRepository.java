package com.luckraw.eventos_tec.repositories;

import com.luckraw.eventos_tec.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findByEventIdAndValidAfter(Long eventId, Date currentDate);
}
