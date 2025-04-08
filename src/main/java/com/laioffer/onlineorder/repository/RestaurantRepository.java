package com.laioffer.onlineorder.repository;

import com.laioffer.onlineorder.entity.RestaurantEntity;
import net.datafaker.providers.base.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
}
