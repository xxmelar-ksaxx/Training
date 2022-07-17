package com.to;

public class Employee {

		private int employeeID;
		private String employeeName;
		
		public Employee() {
			System.out.println("Defalt constructer called");
		}

		
		
		public Employee(int employeeID, String employeeName) {
			super();
			this.employeeID = employeeID;
			this.employeeName = employeeName;
			System.out.println("Prametrized constructer called");
		}
      


		public int getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(int employeeID) {
			System.out.println("Setting e id called");
			this.employeeID = employeeID;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			System.out.println("Setting e name called");
			this.employeeName = employeeName;
		}

		@Override
		public String toString() {
			return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + "]";
		}
	
		
	
}
