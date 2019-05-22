package com.vivolvle.common.command;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: weilz
 * @Date: 2019/5/22 10:02
 */
@Data
public class TestCommand {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "姓名不能为空")
    private Integer age;
}
