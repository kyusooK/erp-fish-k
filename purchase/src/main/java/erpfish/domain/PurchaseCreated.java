package erpfish.domain;

import erpfish.domain.*;
import erpfish.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseCreated extends AbstractEvent {

    private Long id;
    private String purchaseType;
    private Date purchaseDate;
    private Date warehouseArrivalDate;
    private Date storageFeePaymentDate;
    private Boolean storageFeePaymentStatus;
    private String mainShipName;
    private String productName;
    private AccountId accountId;
    private List<PurchaseDetail> purchaseDetails;

    public PurchaseCreated(Purchase aggregate) {
        super(aggregate);
    }

    public PurchaseCreated() {
        super();
    }
}
//>>> DDD / Domain Event
