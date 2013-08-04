package TOI.dao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DaoFactory {
	static Resource resource = null;
	static BeanFactory bf = null;

	static {
		init();
	}

	public static synchronized void init() {
		resource = new ClassPathResource("dao-bean.xml");
		bf = new XmlBeanFactory(resource);
	}

	public static SenderOrderDao getSenderOrderDao() {
		return (SenderOrderDao) bf.getBean("senderOrderDao");
	}
}
