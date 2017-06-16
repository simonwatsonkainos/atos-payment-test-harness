package uk.gov.hmpo.helpers;

import uk.gov.hmpo.ExternalConfiguration;

public class ConfigurationHelper {

    private static ExternalConfiguration configuration;

    public static ExternalConfiguration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(ExternalConfiguration configuration) {
        ConfigurationHelper.configuration = configuration;
    }
}
