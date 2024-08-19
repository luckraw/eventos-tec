package com.luckraw.eventos_tec.domain.event;

import java.util.Date;
import java.util.List;

public record EventDetailsDTO(Long id,
                              String title,
                              String description,
                              Date date,
                              String city,
                              String state,
                              String imgUrl,
                              String eventUrl,
                              List<CouponDTO> coupons) {

    public record CouponDTO(
            String code,
            Integer discount,
            Date valid) {
    }
}
