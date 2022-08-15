package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;;

public class dummyStepdef {

    @Given("^Able to launch SpringBoot project with Gradle and cucumber$")
    public void Able_to_launch_SpringBoot_project_with_Gradle_and_cucumber(){
        System.out.println("************-----------OUTPUT----------************");
        System.out.println("Finally !!!!...Able to launch SpringBoot project with Gradle and cucumber issue was -");
        System.out.println("I used testImplementation under main folder which i took reference from MS project,\nthat should be used in test folder not in main but later changing it to implementation solved the issue");
        System.out.println("************-----------END----------************");
    }

    @Given("By parameterizing i am able to print my first name {string} and last name {string}")
    public void by_parameterizing_i_am_able_to_print_my_first_name_and_last_name(String fname, String lname) {
        System.out.println("First name is : "+fname);
        System.out.println("Last name is : "+lname);
        System.out.println("************-----------END----------************");
    }

    @Then("By parameterizing and doing same action with multiple arg i am able to print my first name {string} and last name {string}")
    public void by_parameterizing_and_doing_same_action_with_multiple_arg_i_am_able_to_print_my_first_name_and_last_name(String fname, String lname) {
        System.out.println("Fname is : "+fname+" and Last name is : "+lname);
        System.out.println("************-----------END----------************");
    }

}
