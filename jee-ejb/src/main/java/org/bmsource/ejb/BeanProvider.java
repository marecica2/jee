package org.bmsource.ejb;

import java.util.Set;

import javax.ejb.Stateless;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

@Stateless
public class BeanProvider {

	@Inject
	BeanManager beanManager;

	public void getBeans() {
		Set<Bean<?>> beans = beanManager.getBeans(Object.class);
		beans.stream().forEach(bean -> System.out.println(bean.getBeanClass().getName()));
	}
}
