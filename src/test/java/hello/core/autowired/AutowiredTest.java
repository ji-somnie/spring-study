package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); //TestBean을 스프링빈으로 등록해줌
    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1) { //스프링 컨테이너에 관리되지 않는 Member로 테스트 예제
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { //스프링 컨테이너에 관리되지 않는 Member로 테스트 예제
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
