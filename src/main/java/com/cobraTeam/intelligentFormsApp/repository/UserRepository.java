package com.cobraTeam.intelligentFormsApp.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.cobraTeam.intelligentFormsApp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CosmosRepository<User, String> {

    @Query(value = "SELECT * FROM u")
    List<User> getAllUsers();
}
