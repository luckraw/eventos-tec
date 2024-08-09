package com.luckraw.eventos_tec.controller;

import com.luckraw.eventos_tec.domain.coupon.Coupon;
import com.luckraw.eventos_tec.domain.coupon.CouponRequestDTO;
import com.luckraw.eventos_tec.services.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Coupon> addCouponToEvent(@PathVariable Long eventId, @RequestBody CouponRequestDTO body) {
        Coupon coupons = couponService.addCouponToEvent(eventId, body);
        return ResponseEntity.ok(coupons);
    }
}
