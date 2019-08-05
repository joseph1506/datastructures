package tests;

import java.util.Objects;

public class TestHashCode {

    public static void main(String[] args) {
        System.out.println("MAS".hashCode());
        System.out.println("MSA".hashCode());
        System.out.println(Objects.hash("MAS"));
        System.out.println(Objects.hash("MSA"));
    }
}
