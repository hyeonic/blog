package me.hyeonic.chapter07.item42;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewTest {

    @DisplayName("Crew를 정상 생성한다.")
    @Test
    void 크루_정상_생성() {
        Crew crew = new Crew("매트", Course.BACKEND);

        crew.sendPullRequest();
    }

    @DisplayName("Crew를 익명 생성한다.")
    @Test
    void 크루_익명_생성() {

        Crew crew = new Crew() {

            @Override
            public void sendPullRequest() {
                System.out.println("익명의 크루가 리뷰요청을 보냈습니다.");
            }
        };

        crew.sendPullRequest();
    }

    @DisplayName("람다 표현식의 장점을 확인한다.")
    @Test
    void 람다_표현식() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1, 4, 10, 5, 7));
        numbers.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        System.out.println(numbers);
    }

    @DisplayName("람다 표현식의 장점을 확인한다.")
    @Test
    void 람다_표현식_v2() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1, 4, 10, 5, 7));
        numbers.sort((o1, o2) -> Integer.compare(o1, o2));

        System.out.println(numbers);
    }

    @DisplayName("람다 표현식의 장점을 확인한다.")
    @Test
    void 람다_표현식_v3() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 1, 4, 10, 5, 7));
        numbers.sort(Comparator.comparingInt(o -> o));

        System.out.println(numbers);
    }
}