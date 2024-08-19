package com.luckraw.eventos_tec.services;

import com.luckraw.eventos_tec.domain.coupon.Coupon;
import com.luckraw.eventos_tec.domain.coupon.CouponRequestDTO;
import com.luckraw.eventos_tec.domain.event.Event;
import com.luckraw.eventos_tec.repositories.CouponRepository;
import com.luckraw.eventos_tec.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(Long id, CouponRequestDTO request) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(request.code());
        coupon.setDiscount(request.discount());
        coupon.setValid(new Date(request.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

    public List<Coupon> consultCoupons(Long eventId, Date currentDate) {
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}
