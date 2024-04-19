package listenerstestng;

import org.testng.IExecutionListener;

public class CustomerListener implements IExecutionListener {
    //Can use those methods inside the interface IExecutionListener

    //Right click -> Generate -> Override method -> select the methods needed


    @Override
    public void onExecutionStart() {
        // A Copy code
        //adding some logs
        long endTime = System.currentTimeMillis();
        System.out.println("~~~Finished Execution~~~"+" "+endTime );
        /* To send mail to the team or lead
         * after completion of the test case
         */
    }

    @Override
    public void onExecutionFinish() {
        /* this method gives many advantages we can use many specifications while starting
         * of the execution
         *
         * Even aftersuite method is an alternate but only listeners have more information
         * about the test cases so they have their hand help up
         *
         * Read Excel file, JSON File, Allure Report can start,
         * Reporting, Mention to start the logs
         *
         */
        long startTime = System.currentTimeMillis();
        System.out.println("~~~Started Execution~~~"+" "+startTime);
    }
}
