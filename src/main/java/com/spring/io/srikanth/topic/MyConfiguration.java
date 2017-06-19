package com.spring.io.srikanth.topic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;


@Configuration
public class MyConfiguration {
	@Value("${port}")
	public int port;
	@Value("${ssl.key-store}")
	public String keystoreFile;
	@Value("${ssl.key-store-password}")
	public String keystorePass;
	@Value("${ssl.keyStoreType}")
	public String keystoreType;
	@Value("${ssl.keyStoreProvider}")
	public String keystoreProvider;
	@Value("${ssl.keyAlias}")
	public String keystoreAlias;
	
	@Autowired
	private TextEncryptor textEncrypt;
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {

		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(this.port);
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
			public void customize(Connector con) {
				Http11NioProtocol proto = (Http11NioProtocol) con.getProtocolHandler();
				proto.setSSLEnabled(true);
				con.setScheme("https");
				con.setSecure(true);
				proto.setKeystoreFile(keystoreFile);
				proto.setKeystorePass(textEncrypt.decrypt(keystorePass));
				proto.setKeystoreType(keystoreType);
				proto.setProperty("keystoreProvider", keystoreProvider);
				proto.setKeyAlias(keystoreAlias);
			}
		});
		return factory;
	}
}
