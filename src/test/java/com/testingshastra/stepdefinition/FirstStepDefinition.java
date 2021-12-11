package com.testingshastra.stepdefinition;

import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepDefinition {
	//Feature File
	/**
	 * Feature: My First feature file
	 * Scenario: We learn cucumber
	 *  Given Take two numbers as input from user
	 *  When Iadd them
	 *  Then verify if the addition is prime
	 * 
	 */
	
	// int x, y, result;

//	@Given("Take two numbers as input from user")
//	public void m1() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter two numbers:");
//		x = sc.nextInt();
//		y = sc.nextInt();
//
//	}

//	@When("I add them")//If step Definition duplicate then cucmber throws DuplicateStepDefinitionException
//	public void m2() {
//		result = x + y;
//
//	}

//	@Then("verify if the addition is prime")
//	public void m3() {
//		int count = 0;
//		for (int i = 1; i < result; i++) {
//			if (result % i == 0) {
//				count++;
//			}
//		}
//		if (count > 2) {
//			System.out.println("Result is not prime:" + result);
//
//		} else {
//			System.out.println("Result is prime:" + result);
//
//		}
//	}

}
