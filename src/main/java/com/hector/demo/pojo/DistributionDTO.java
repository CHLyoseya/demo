package com.hector.demo.pojo;

import lombok.Data;

/**
 * @author hector.lin
 * @date 2020/9/24 16:27
 */
@Data
public class DistributionDTO {
    private String type;
    private String provider;
    private String encryptType;
    private Double proportion;

    public DistributionDTO(String type,String encryptType){
        this.type = type;
        this.encryptType = encryptType;
    }

    public DistributionDTO(String type,String encryptType,String provider,Double proportion){
        this.type = type;
        this.encryptType = encryptType;
        this.provider = provider;
        this.proportion = proportion;
    }
}
