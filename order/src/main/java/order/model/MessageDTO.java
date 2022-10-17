package order.model;

import lombok.Data;

@Data
public class MessageDTO {
    private int idOrder;
    private String address;

    public static MessageDTO of(int idOrder, String address) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.idOrder = idOrder;
        messageDTO.address = address;
        return messageDTO;
    }
}