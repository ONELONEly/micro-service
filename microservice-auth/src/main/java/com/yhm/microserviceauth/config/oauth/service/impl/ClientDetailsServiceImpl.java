package com.yhm.microserviceauth.config.oauth.service.impl;

import com.yhm.microserviceauth.entity.Do.SysClient;
import com.yhm.microserviceauth.service.ISysClientService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Arrays;

/**
 * @deprecated
 */
@Data
@Log4j2
public class ClientDetailsServiceImpl implements ClientDetailsService {

    ISysClientService sysClientService;

    public ClientDetailsServiceImpl(ISysClientService sysClientService) {
        if(sysClientService==null){
            throw new NullPointerException("sysClientService is not allow null");
        }
        this.sysClientService = sysClientService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        SysClient sysClient = sysClientService.getById(clientId);
        if (sysClient == null) {
            log.error("No client with requested id: " + clientId);
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(sysClient.getClientId());
        baseClientDetails.setClientSecret(sysClient.getClientSecret());
        baseClientDetails.setAuthorizedGrantTypes(Arrays.asList(sysClient.getAuthorizedGrantTypes().split(",")));
        baseClientDetails.setAccessTokenValiditySeconds(sysClient.getAccessTokenValiditySeconds().intValue());
        baseClientDetails.setRefreshTokenValiditySeconds(sysClient.getRefreshTokenValiditySeconds().intValue());
        baseClientDetails.setScope(Arrays.asList(sysClient.getScopes().split(",")));
        return baseClientDetails;
    }

}