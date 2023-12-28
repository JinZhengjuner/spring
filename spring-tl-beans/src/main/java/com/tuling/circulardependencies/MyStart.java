package com.tuling.circulardependencies;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyStart {

	private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
	/**
	 * 读取bean定义，当然在spring中肯定是根据配置 动态扫描注册
	 */
	public static void loadBeanDefinitions() {
		RootBeanDefinition aBeanDefinition=new RootBeanDefinition(InstanceA.class);
		RootBeanDefinition bBeanDefinition=new RootBeanDefinition(InstanceB.class);
		beanDefinitionMap.put("instanceA",aBeanDefinition);
		beanDefinitionMap.put("instanceB",bBeanDefinition);
	}

	public static void main(String[] args) {
		loadBeanDefinitions();
		for (String key : beanDefinitionMap.keySet()) {
			RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(key);

			//先创建A

		}
	}


}
