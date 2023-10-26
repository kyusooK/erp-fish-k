package erpfish.domain;

import erpfish.MasterApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Item_table")
@Data
//<<< DDD / Aggregate Root
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;

    private String itemCode;

    private ItemUnit itemUnit;

    public static ItemRepository repository() {
        ItemRepository itemRepository = MasterApplication.applicationContext.getBean(
            ItemRepository.class
        );
        return itemRepository;
    }
}
//>>> DDD / Aggregate Root
