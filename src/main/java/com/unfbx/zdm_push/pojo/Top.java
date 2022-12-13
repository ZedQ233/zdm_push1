package com.unfbx.zdm_push.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZedQ
 * @Date: 2022/12/13 11:48
 * @Description: 排行类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top {

    private long index;
    private String title;
    private String link;
    private String hot;
}
