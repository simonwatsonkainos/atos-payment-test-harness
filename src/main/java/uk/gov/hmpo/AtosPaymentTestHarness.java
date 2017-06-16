package uk.gov.hmpo;

import sips.en.contract.dvla.NotificationServiceImpl;
import uk.gov.hmpo.controllers.StartPaymentController;
import uk.gov.hmpo.health.ApplicationHealthCheck;
import uk.gov.hmpo.helpers.ConfigurationHelper;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import javax.xml.ws.Endpoint;

public class AtosPaymentTestHarness extends Application<ExternalConfiguration> {

    public static void main(String[] args) throws Exception {
        new AtosPaymentTestHarness().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExternalConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle("/assets/", "/assets/", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/", "/assets/", null, "js"));
    }

    @Override
    public void run(ExternalConfiguration configuration, Environment environment){

        /* System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true"); */

        ConfigurationHelper.setConfiguration(configuration);
        final StartPaymentController startPaymentController = new StartPaymentController();

        JerseyEnvironment jerseyEnvironment = environment.jersey();
        jerseyEnvironment.register(startPaymentController);

        ApplicationHealthCheck applicationHealthCheck = new ApplicationHealthCheck();
        environment.healthChecks().register("alive", applicationHealthCheck);

        Endpoint.publish(configuration.getSoapServer().getBaseUrl(), new NotificationServiceImpl());
    }
}
