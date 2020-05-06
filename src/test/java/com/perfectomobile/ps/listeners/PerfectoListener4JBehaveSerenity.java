package com.perfectomobile.ps.listeners;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResult;
import com.perfecto.reportium.test.result.TestResultFactory;
import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.*;

import java.io.File;
import java.util.Map;

import static net.thucydides.core.model.TestResult.FAILURE;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PerfectoListener4JBehaveSerenity implements StepListener {

    ReportiumClient reportiumClient;


    @Override
    public void testSuiteStarted(Class<?> aClass) {
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("My Project", "1.0"))
                .withJob(new Job("My Job", 45))
                .withContextTags("tag1")
                .withWebDriver(getDriver())
                .build();
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);

    }

    @Override
    public void testSuiteStarted(Story story) {
        PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
                .withProject(new Project("JBehaveSerenity Project", "1.0"))
                .withJob(new Job("JBehaveSerenity Job", 1))
                .withContextTags("dictionarySearch")
                .withWebDriver(getDriver())
                .build();
        reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);



    }

    @Override
    public void testSuiteFinished() {


    }

    @Override
    public void testStarted(String s) {

        reportiumClient.testStart(s,new TestContext());

    }

    @Override
    public void testStarted(String s, String s1) {
        reportiumClient.testStart(s,new TestContext());

    }

    @Override
    public void testFinished(TestOutcome testOutcome) {
        reportiumClient.testStop(TestResultFactory.createSuccess());

    }

    @Override
    public void testRetried() {

    }

    @Override
    public void stepStarted(ExecutedStepDescription executedStepDescription) {
        reportiumClient.stepStart(executedStepDescription.getName());

    }

    @Override
    public void skippedStepStarted(ExecutedStepDescription executedStepDescription) {

    }

    @Override
    public void stepFailed(StepFailure stepFailure) {
        reportiumClient.testStop(TestResultFactory.createFailure(stepFailure.getMessage().toString()));

    }

    @Override
    public void lastStepFailed(StepFailure stepFailure) {

    }

    @Override
    public void stepIgnored() {

    }

    @Override
    public void stepPending() {

    }

    @Override
    public void stepPending(String s) {

    }

    @Override
    public void stepFinished() {

    }

    @Override
    public void testFailed(TestOutcome testOutcome, Throwable throwable) {
    }

    @Override
    public void testIgnored() {

    }

    @Override
    public void testSkipped() {

    }

    @Override
    public void testPending() {

    }

    @Override
    public void testIsManual() {

    }

    @Override
    public void notifyScreenChange() {

    }

    @Override
    public void useExamplesFrom(DataTable dataTable) {

    }

    @Override
    public void addNewExamplesFrom(DataTable dataTable) {

    }

    @Override
    public void exampleStarted(Map<String, String> map) {

    }

    @Override
    public void exampleFinished() {

    }

    @Override
    public void assumptionViolated(String s) {

    }

    @Override
    public void testRunFinished() {

    }
}
