package com.vivolvle.fundation.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/8/29 10:24
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
@Data
public class IndexCommand {
    @NotNull
    private String name;

    private List<CodeCell> list;

}
