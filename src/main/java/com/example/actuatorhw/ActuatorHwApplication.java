package com.example.actuatorhw;

import io.github.agebhar1.micrometer.security.cert.CustomGlobalTrustStoreX509Certificates;
import io.github.agebhar1.micrometer.security.cert.DefaultX509CertificateMetricTagFactory;
import io.github.agebhar1.micrometer.security.cert.X509CertificateExpirationMetrics;
import io.github.agebhar1.micrometer.security.cert.X509CertificateSourceComposite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorHwApplication {

    @Bean
    public X509CertificateExpirationMetrics x509CertificateExpirationMetrics() {
        var factory = new DefaultX509CertificateMetricTagFactory();
        var source = X509CertificateSourceComposite.of(new CustomGlobalTrustStoreX509Certificates());
        return new X509CertificateExpirationMetrics(factory, source);
    }

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\pelll\\.jdks\\openjdk-17.0.2\\lib\\security\\cacerts");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.trustStoreType", "jks");

        SpringApplication.run(ActuatorHwApplication.class, args);
    }
}
