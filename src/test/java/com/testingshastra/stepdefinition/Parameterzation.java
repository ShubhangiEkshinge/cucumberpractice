package com.testingshastra.stepdefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Parameterzation {
	int x, y, result = 0;
	String first, second;
	double d1, d2, dresult = 0;
	List<Integer> numbers;

	@Then("Print result")
	public void print_result() {
		System.out.println("Result =" + result);
	}

	@Given("I add them")
	public void m2() {
		result = x + y;
	}

	@Given("I have {int} and {int}")
	public void I_have_and(Integer int1, Integer int2) {
		x = int1;
		y = int2;
	}

	@Given("I have two words like {word} and {word}")
	public void m1(String first, String second) {
		this.first = first;
		this.second = second;
	}

	@Then("print them in alphabetic order")
	public void arrangeInAlphabeticalOrder() {
		if (first.compareTo(second) == 0) {
		} else if (first.compareTo(second) > 0) {
			System.out.println(second + " " + first);
		} else {
			System.out.println(first + " " + second);
		}
	}

//	@Given("I have two float numbers {double} and {double}") // here we pass parameter whatever parameter we want
//	public void i_have_two_float_numbers(Double double1, Double double2) {
//		d1 = double1;
//		d2 = double2;
//	}

	@Given("I have two float numbers {float} and {float}")
	public void i_have_two_float_numbers(float double1, float double2) {
		d1 = double1;
		d2 = double2;
	}

	@Then("add both float numbers")
	public void add_both_float_numbers() {
		dresult = d1 + d2;
	}

	@Then("Print float result")
	public void print_float_result() {
		System.out.println("double result:" + dresult);
	}

	@Given("I have following number:")
	public void i_have_following_number(io.cucumber.datatable.DataTable dataTable) {
		numbers = dataTable.asList(Integer.class);
	}

	@Then("print all numbers from list")
	public void print_list_items() {
		for (Integer integer : numbers) {
			System.out.println(integer);
		}

	}

	@Given("I have follwing table:")
	public void get_numbers_from_table(DataTable table) {
		System.out.println(table);// Here i dataTable If we don't want to convert in other

		// we can get only row,only coulmn, only cell when data is in dataTable format
//		List l = table.row(0);
//		System.err.println(l);
		Map<String, List<Integer>> m = table.asMap(String.class, List.class);// Here dataTable conver into map
		System.out.println("Map: " + m);
	}

	@Then("print them in row coulmn format")
	public void print_in_row_column_format() {

	}

	@Then("Verify if result is prime")
	public void verify_if_result_is_prime() {
		int count = 0;
		for (int i = 1; i < result; i++) {
			if (result % i == 0) {
				count++;
			}
		}
		if (count > 2) {
			System.out.println("Result is NOT prime:" + result);
		} else {
			System.out.println("result is prime:" + result);
		}
	}
	
	@Given("I have two numbers from {int}")
	public void readNumbersFromExcel(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/numbers.xlsx");
          XSSFWorkbook book = new XSSFWorkbook(fis);
          Sheet sheet =book.getSheetAt(0);
          x = (int) sheet.getRow(rowNum).getCell(1).getNumericCellValue();
          y = (int) sheet.getRow(rowNum).getCell(2).getNumericCellValue();
	}

}

