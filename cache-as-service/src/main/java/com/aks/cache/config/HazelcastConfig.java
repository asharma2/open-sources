package com.aks.cache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.aks.cache.constants.Caches;
import com.aks.cache.model.CacheResponse;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Configuration
public class HazelcastConfig {

	@Autowired
	private Environment environment;

	@Bean
	public Config hazelCastConfig() {
		Config config = new Config();
		String instanceName = environment.getProperty("hazelcast.instance.name");
		config.setInstanceName(instanceName);

		MapConfig usersCache = new MapConfig();
		usersCache.setTimeToLiveSeconds(20);
		usersCache.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
		usersCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("users", usersCache);

		MapConfig booksCache = new MapConfig();
		booksCache.setTimeToLiveSeconds(600);
		booksCache.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("books", booksCache);

		MapConfig caches = new MapConfig();
		caches.setEvictionPolicy(EvictionPolicy.LFU);
		config.getMapConfigs().put("caches", caches);
		
//		NetworkConfig network = config.getNetworkConfig();
//		JoinConfig join = network.getJoin();
//		join.getMulticastConfig().setEnabled( false )
//		            .addTrustedInterface( "192.168.1.102" );
//		join.getTcpIpConfig().addMember( "10.45.67.32" ).addMember( "10.45.67.100" )
//		            .setRequiredMember( "192.168.10.100" ).setEnabled( true );

		return config;
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		return Hazelcast.newHazelcastInstance(hazelCastConfig());
	}

	@Bean
	public IMap<Caches, CacheResponse<?>> caches() {
		return hazelcastInstance().getMap("caches");
	}
}
