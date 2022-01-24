package com.freewater.mybatis.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class MybatisSpringBootDemoApplicationTests {

    @Test
    void contextLoads(CapturedOutput output) {
        Assertions.assertThat(output.getOut()).contains("2,San Francisco,CA,US");
    }
}
