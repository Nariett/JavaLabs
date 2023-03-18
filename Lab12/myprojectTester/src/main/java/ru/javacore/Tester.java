package ru.javacore;

public class Tester {
    private String name;
    private String surname;
    private int experienceInYears;
    private String englishLevel;
    private double salary;

    public Tester(String name, String surname) {
        this(name, surname, 0, "A1", 0);
    }
    public Tester(String name, String surname, int experienceInYears) {
        this(name, surname, experienceInYears, "A1", 0);
    }
    public Tester(String name, String surname, int experienceInYears, String englishLevel, double salary) {
        this.name = name;
        this.surname = surname;
        this.experienceInYears = experienceInYears;
        this.englishLevel = englishLevel;
        this.salary = salary;
    }
    public void printInfo() {
        System.out.println("Название тестировки: " + name + " " + surname + ", Опыт работы: " + experienceInYears + " лет, Уровень значния английского: " + englishLevel + ", Зарплата: " + salary + " USD");
    }
    public void printInfo(boolean includeSalary) {
        if (includeSalary) {
            printInfo();
        } else {
            System.out.println("Название тестировки: " + name + " " + surname + ", Опыт работы: " + experienceInYears + " лет, Уровень значния английского: " + englishLevel);
        }
    }
    public void printInfo(String message) {
        System.out.println(message + " " + name + " " + surname);
    }
    public static double convertToEuro(double amountInUsd, double exchangeRate) {
        return amountInUsd * exchangeRate;
    }
}