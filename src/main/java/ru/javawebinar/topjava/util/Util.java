package ru.javawebinar.topjava.util;

import org.springframework.lang.Nullable;

//общий метод сравнения дат по паттерну стратегия
//3_2_filter.mp3
//добавить в meals.jsp и MealServlet фильтрацию еды по дате и по времени
public class Util {
    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(T value, @Nullable T start, @Nullable T end) {
        return (start == null || value.compareTo(start) >= 0) && (end == null || value.compareTo(end) < 0);
    }
}