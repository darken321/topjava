package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);
//        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
/*         TODO return filtered list with excess. Implement by cycles
         сделать подсчет калорий за день и прописать excess в записи этого дня
         поле UserMealWithExcess.excess должно показывать,
         превышает ли сумма калорий за весь день значение caloriesPerDay*/
        Map<LocalDate, Integer> everydayCaloriesMap = new TreeMap<>();
        // прохожу по циклу и выбираю калории еды одного дня в мапу, ключ - день, значение - сумма калорий
        for (UserMeal meal : meals) {
            LocalDate day = meal.getDateTime().toLocalDate();
//             Смотрим в мапе, если в ключах есть значение такого дня, то добавляем к нему калории. Если нет, то добавляем в мапу день и калории
            everydayCaloriesMap.merge(day, meal.getCalories(), Integer::sum);
        }
        List<UserMealWithExcess> userMealWithExcessList = new ArrayList<>();
        for (UserMeal meal : meals) {
//            если в мапе по ключу дня текущего meal значение калорий превышает лимит, то в поле excess ставлю true
            LocalDate day = meal.getDateTime().toLocalDate();
            LocalTime time = meal.getDateTime().toLocalTime();
            boolean excess = everydayCaloriesMap.get(day) > caloriesPerDay;
            //если meal находится в интервале времени, то добавляем ее в лист.
            if (TimeUtil.isBetweenHalfOpen(time, startTime, endTime)) {
                userMealWithExcessList.add(
                        new UserMealWithExcess(
                                meal.getDateTime(),
                                meal.getDescription(),
                                meal.getCalories(),
                                excess));
            }
        }
        return userMealWithExcessList;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        return null;
    }
}
