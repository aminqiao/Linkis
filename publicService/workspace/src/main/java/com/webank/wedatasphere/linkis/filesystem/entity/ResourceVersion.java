package com.webank.wedatasphere.linkis.filesystem.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wuzm
 * @date 2019-10-09 11:30:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResourceVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer version;

    private String commitPerson;

    private Date commitTime;

    private String model;

    private String remark;


}