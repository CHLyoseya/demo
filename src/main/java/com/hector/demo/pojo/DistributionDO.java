package com.hector.demo.pojo;

import lombok.Data;

/**
 * @author hector.lin
 * @date 2020/9/24 13:52
 */
@Data
public class DistributionDO {
    private String provider;

    private Double proportion;

    public DistributionDO(String provider,Double proportion){
        this.proportion=proportion;
        this.provider = provider;
    }
}
