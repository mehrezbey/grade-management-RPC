package org.isi.impl;

import org.isi.service.IGradeService;

public class GradeServiceImpl implements IGradeService {


    @Override
    public double add(double a, double b) {
        return a+b;
    }

    @Override
    public double multiply(double a, double b) {
        return  a*b;
    }

    @Override
    public double subtract(double a, double b) {
        return a-b;
    }

    @Override
    public double divide(double a, double b) {
        return a/b;
    }

    @Override
    public String insert(String name, double grade) {
        grades.put(name,grade);
        return "Graded was added successfully";
    }

    @Override
    public String delete(String name) {
        if(grades.containsKey(name))
            grades.remove(name);
        return "Graded was deleted successfully";

    }

    @Override
    public String edit(String name, double grade) {
        grades.put(name,grade);
        return "Graded was edited successfully";

    }

    @Override
    public String all() {
        return grades.toString();
    }


}
