package com.github.satwiksanand.portfolioBackend.repositories;

import com.github.satwiksanand.portfolioBackend.models.Projects;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Projects, String> {

}
