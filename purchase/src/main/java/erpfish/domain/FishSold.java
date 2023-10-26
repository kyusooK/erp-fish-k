package erpfish.domain;

import erpfish.domain.*;
import erpfish.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FishSold extends AbstractEvent {

    private String itemId;
    private Integer stock;

    public FishSold(Purchase aggregate) {
        super(aggregate);
    }

    public FishSold() {
        super();
    }
}
//>>> DDD / Domain Event
