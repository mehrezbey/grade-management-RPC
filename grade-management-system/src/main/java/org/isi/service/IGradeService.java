package org.isi.service;

import java.util.HashMap;
import java.util.Map;

public interface IGradeService {
    Map<String, Double> grades = new HashMap<>();

    double add(double a, double b);
    double multiply(double a, double b);
    double subtract(double a, double b);
    double divide(double a, double b);
    String insert(String name, double grade);
    String delete(String name);
    String edit(String name, double grade);
    String all();
}
