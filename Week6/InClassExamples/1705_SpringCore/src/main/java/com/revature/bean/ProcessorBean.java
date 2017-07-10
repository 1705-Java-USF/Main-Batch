package com.revature.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProcessorBean implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof GenericBean){
			System.out.println("STEP 9: POST initialization Bean Post Processor: " + beanName);
		
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof GenericBean){
			System.out.println("STEP 6: PRE initialization Bean Post Processor: " + beanName);
		}
		return bean;
	}

}
