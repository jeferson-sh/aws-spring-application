package com.example.jvm.memory.dump.controllers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FatorialController}.
 */
@Generated
public class FatorialController__BeanDefinitions {
  /**
   * Get the bean definition for 'fatorialController'.
   */
  public static BeanDefinition getFatorialControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FatorialController.class);
    beanDefinition.setInstanceSupplier(FatorialController::new);
    return beanDefinition;
  }
}
