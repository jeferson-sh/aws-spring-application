package com.example.jvm.memory.dump.components;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MemoryLeakSimulator}.
 */
@Generated
public class MemoryLeakSimulator__BeanDefinitions {
  /**
   * Get the bean definition for 'memoryLeakSimulator'.
   */
  public static BeanDefinition getMemoryLeakSimulatorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MemoryLeakSimulator.class);
    beanDefinition.setInstanceSupplier(MemoryLeakSimulator::new);
    return beanDefinition;
  }
}
