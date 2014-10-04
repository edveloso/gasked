package br.com.eveloso.gasked.jetty.web.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class ConstantsUtil {

	public static final String INDEX = "index";
	public static final String RESPOSTA = "resposta-";
	public static final String OPCAO = "opcao-";
	public static final String EVANGELHO = "evangelho";
	public static final String PERGUNTA = "pergunta-";

	
	private static CompositeConfiguration config;
	
	public ConstantsUtil() {
		try {
			config = new CompositeConfiguration();
			config.addConfiguration(new SystemConfiguration());
			config.addConfiguration(new PropertiesConfiguration("application.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key){
		if(config == null) new ConstantsUtil();
		return config.getString(key);
	}
	

}
