package com.mapinfo.service;

import com.mapinfo.domain.Coordinate;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Israj PC on 10/17/2016.
 */
public interface CoordinateRepository extends CrudRepository<Coordinate,String> {
}
