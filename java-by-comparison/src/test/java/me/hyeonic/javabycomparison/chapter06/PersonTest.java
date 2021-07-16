package me.hyeonic.javabycomparison.chapter06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    static final double TOLERANCE = 0.01;

    Person person;

    static Person createPerson() {
        return new Person("hyeonic", Gender.MALE, 178.0, 70.0);
    }

    @BeforeEach
    void setUp() {
        person = new Person("hyeonic", Gender.MALE, 178.0, 70.0);
    }

    @Test
    @DisplayName("person에 성별을 MALE로 설정하는 테스트")
    void setGenderMAIE() {
        // given
//        Person person = new Person();
        Person person = createPerson();

        // when
        person.setGender(Gender.MALE);

        // then
        Assertions.assertEquals(person.getGender(), Gender.MALE);
    }

    @Test
//    @Disabled("[why it's disabled] TODO: [What's the plan to enable again]")
    void testGetBmi() {
        // given
//        Person person = new Person("hyeonic", Gender.MALE, 178.0, 70.0);
        Person person = createPerson();

        // when
        person.addWeight(5.0);

        // then
        Assertions.assertEquals(23.67, person.getBmi(), TOLERANCE);
    }

//    @Test
//    void newPerson() {
//        Person person = new Person();
//
//        try {
//            person.throwException();
//        } catch (IOException e) {
//            Assertions.fail(e.getMessage());
//        }
//    }

//    @Test
//    void newPersonFail() {
//        Person person = new Person();
//
//        try {
//            person.throwException();
//            Assertions.fail("fail");
//        } catch (IOException e) {
//        }
//    }

//    @Test
//    void newPerson() throws IOException {
//        Person person = new Person();
//
//        person.throwException();
//
//        Assertions.assertEquals(person.getHeight(), 0.0);
//    }
//
//    @Test
//    void newPersonFail() {
//        Person person = new Person();
//
//        Executable when = () -> person.throwException();
//
//        assertThrows(IOException.class, when);
//    }

    @ParameterizedTest
    @ValueSource(ints = {60, 70, 80})
    void isBmiLessThen25(double weight) {
        Person person = new Person();

        person.setHeight(180);
        person.setWeight(weight);

        Assertions.assertTrue(25.0 > person.getBmi());
    }
}