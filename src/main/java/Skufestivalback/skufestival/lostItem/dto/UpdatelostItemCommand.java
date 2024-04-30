package Skufestivalback.skufestival.lostItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatelostItemCommand {
    private final Long id;
    private final String lostItemName;
    private final String lostDate;
    private final String lostLocation;
}