package com.example.pincode_dist.repository;

import com.example.pincode_dist.model.PincodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeInfoRepository extends JpaRepository<PincodeInfo, String> {
}
