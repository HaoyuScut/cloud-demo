package com.itwhy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: {NAME}
 * @Auther: why
 * @Date: 2023/07/04 09 29
 * @Version: v1.0
 */
@SpringBootTest
public class stringTest {

    @Test
    public void sTest(){
        List<String> custList = new ArrayList<>();
        custList.add("nihao");
        custList.add("nihao1");
        custList.add("nihao2");
        custList.add("nihao3");
        String custId = String.format("('%s')",String.join("','", custList));
        System.out.println(custId);
    }
}
