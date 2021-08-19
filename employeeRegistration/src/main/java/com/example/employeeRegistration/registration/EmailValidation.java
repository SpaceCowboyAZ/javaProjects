package com.example.employeeRegistration.registration;

import java.util.function.Predicate;

public class EmailValidation implements Predicate<String> {
@Override
public boolean test(String s) {
//	TODO: Regex to validate email
	return true;
}
}
