package bg.softuni;


import bg.softuni.entities.Transfer;
import bg.softuni.entities.User;
import bg.softuni.entities.Address;
import bg.softuni.entities.dtos.TransferDTO;
import bg.softuni.entities.dtos.UserDeliveryDTO;
import bg.softuni.entities.dtos.UserLoginDTO;
import bg.softuni.entities.dtos.UserPublicInfoDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("Sofia", "BG");
        User user = new User("user", "pass", "first", "last", 22, address);
        User sender = new User("sender", "pass", "sender", "senderov", 226, address);

        ModelMapper mapper = new ModelMapper();

        Transfer transfer = new Transfer(sender, user, BigDecimal.TEN, LocalDate.now(), Instant.now());

        Converter<Instant, String> instantToString =
                context -> context.getSource().get(ChronoField.NANO_OF_SECOND) + "";
        PropertyMap<Transfer, TransferDTO> transferToDTOMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setSenderName(source.getSender().getFirstName());
                map().setReceiverName(source.getReceiver().getFirstName());
            }
        };
        mapper.addMappings(transferToDTOMap);
        mapper.addConverter(instantToString, Instant.class, String.class);


        TransferDTO dto = mapper.map(transfer, TransferDTO.class);
        System.out.println(dto);
        //demoDeliveryInfo(mapper, user);

        //demoMethods(user);
    }

    private static void demoDeliveryInfo(ModelMapper mapper, User user) {
        UserDeliveryDTO userDeliveryInfo = mapper.map(user, UserDeliveryDTO.class);
        System.out.println(userDeliveryInfo.toString());
    }

    private static void demoMethods(User user, ModelMapper mapper) {
        UserLoginDTO mappedUser = mapper.map(user, UserLoginDTO.class);
        System.out.println(mappedUser.toString());

        User loginUser = mapper.map(mappedUser, User.class);
        System.out.println(loginUser.toString());

        UserPublicInfoDTO names = mapper.map(user, UserPublicInfoDTO.class);
        User emptyUser = new User();
        mapper.map(names,emptyUser);
        System.out.println(emptyUser.toString());
    }
}
