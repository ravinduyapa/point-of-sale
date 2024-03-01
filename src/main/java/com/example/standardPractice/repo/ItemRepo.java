package com.example.standardPractice.repo;

import com.example.standardPractice.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> getAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    List<Item> getItemByActiveState(boolean b);

    Page<Item> getItemByActiveState(boolean activeState, Pageable pageable);


    int countAllByActiveStateEquals(boolean activeState);
}
