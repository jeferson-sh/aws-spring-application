package org.springframework.boot.actuate.autoconfigure.observation.web.reactive;

import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.server.reactive.observation.DefaultServerRequestObservationConvention;

/**
 * Bean definitions for {@link WebFluxObservationAutoConfiguration}.
 */
@Generated
public class WebFluxObservationAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.actuate.autoconfigure.observation.web.reactive.WebFluxObservationAutoConfiguration'.
   */
  private static BeanInstanceSupplier<WebFluxObservationAutoConfiguration> getWebFluxObservationAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebFluxObservationAutoConfiguration>forConstructor(ObservationProperties.class)
            .withGenerator((registeredBean, args) -> new WebFluxObservationAutoConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'webFluxObservationAutoConfiguration'.
   */
  public static BeanDefinition getWebFluxObservationAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxObservationAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getWebFluxObservationAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'metricsHttpServerUriTagFilter'.
   */
  private static BeanInstanceSupplier<MeterFilter> getMetricsHttpServerUriTagFilterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MeterFilter>forFactoryMethod(WebFluxObservationAutoConfiguration.class, "metricsHttpServerUriTagFilter", MetricsProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(WebFluxObservationAutoConfiguration.class).metricsHttpServerUriTagFilter(args.get(0)));
  }

  /**
   * Get the bean definition for 'metricsHttpServerUriTagFilter'.
   */
  public static BeanDefinition getMetricsHttpServerUriTagFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MeterFilter.class);
    beanDefinition.setInstanceSupplier(getMetricsHttpServerUriTagFilterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultServerRequestObservationConvention'.
   */
  private static BeanInstanceSupplier<DefaultServerRequestObservationConvention> getDefaultServerRequestObservationConventionInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultServerRequestObservationConvention>forFactoryMethod(WebFluxObservationAutoConfiguration.class, "defaultServerRequestObservationConvention")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(WebFluxObservationAutoConfiguration.class).defaultServerRequestObservationConvention());
  }

  /**
   * Get the bean definition for 'defaultServerRequestObservationConvention'.
   */
  public static BeanDefinition getDefaultServerRequestObservationConventionBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultServerRequestObservationConvention.class);
    beanDefinition.setInstanceSupplier(getDefaultServerRequestObservationConventionInstanceSupplier());
    return beanDefinition;
  }
}
