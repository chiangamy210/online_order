package com.laioffer.onlineorder;


import com.laioffer.onlineorder.entity.*;
import com.laioffer.onlineorder.repository.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.List;


@Component
public class DevRunner implements ApplicationRunner {


    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final RestaurantRepository restaurantRepository;


    public DevRunner(
            CartRepository cartRepository,
            CustomerRepository customerRepository,
            MenuItemRepository menuItemRepository,
            OrderItemRepository orderItemRepository,
            RestaurantRepository restaurantRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        CustomerEntity customer0 = new CustomerEntity(null, "user_a@mail.com", "123", true, "Foo", "Bar");
        customerRepository.save(customer0);


        CustomerEntity customer1 = new CustomerEntity(null, "user_b@mail.com", "123", true, "Zoo", "Yoo");
        customerRepository.save(customer1);


        cartRepository.saveAll(List.of(
                new CartEntity(null, 1L, 0.0),
                new CartEntity(null, 2L, 0.0)
        ));


        List<RestaurantEntity> newRestaurants = List.of(
                new RestaurantEntity(null, "restaurant_a", "address_a", "6505550000", "https://001.jpg"),
                new RestaurantEntity(null, "restaurant_b", "address_b", "6505550001", "https://002.jpg"),
                new RestaurantEntity(null, "restaurant_c", "address_c", "6505550002", "https://003.jpg")
        );
        restaurantRepository.saveAll(newRestaurants);
        List<MenuItemEntity> newMenuItems = List.of(
                new MenuItemEntity(null, 4L, "entree_aa", "description_aa", 10.0, "https://001.jpg"),
                new MenuItemEntity(null, 4L, "entree_ab", "description_ab", 20.0, "https://002.jpg"),
                new MenuItemEntity(null, 4L, "entree_ac", "description_ac", 33.3, "https://003.jpg"),
                new MenuItemEntity(null, 5L, "entree_ba", "description_ba", 1.0, "https://004.jpg"),
                new MenuItemEntity(null, 5L, "entree_bb", "description_bb", 2.0, "https://005.jpg"),
                new MenuItemEntity(null, 5L, "entree_bc", "description_bc", 3.3, "https://006.jpg"),
                new MenuItemEntity(null, 6L, "entree_ca", "description_ca", 100.0, "https://007.jpg"),
                new MenuItemEntity(null, 6L, "entree_cb", "description_cb", 200.0, "https://008.jpg"),
                new MenuItemEntity(null, 6L, "entree_dd", "description_cc", 333.3, "https://009.jpg")
        );
        menuItemRepository.saveAll(newMenuItems);


        List<OrderItemEntity> newOrderItems = List.of(
                new OrderItemEntity(null, 1L, 1L, 1.0, 1),
                new OrderItemEntity(null, 3L, 1L, 10.0, 1),
                new OrderItemEntity(null, 5L, 1L, 20.0, 1),
                new OrderItemEntity(null, 7L, 1L, 200.0, 1),
                new OrderItemEntity(null, 9L, 1L, 30.0, 1),
                new OrderItemEntity(null, 1L, 2L, 1.0, 1),
                new OrderItemEntity(null, 2L, 2L, 10.0, 1),
                new OrderItemEntity(null, 3L, 2L, 20.0, 1),
                new OrderItemEntity(null, 4L, 2L, 200.0, 1),
                new OrderItemEntity(null, 5L, 2L, 30.0, 1)
        );
        orderItemRepository.saveAll(newOrderItems);

        customerRepository.deleteById(2L);
        restaurantRepository.deleteById(4L);
        customerRepository.updateNameByEmail("user_a@mail.com", "first", "last");
    }
}
