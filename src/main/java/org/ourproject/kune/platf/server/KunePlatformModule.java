package org.ourproject.kune.platf.server;

import org.ourproject.kune.platf.client.rpc.ContentService;
import org.ourproject.kune.platf.client.rpc.KuneService;
import org.ourproject.kune.platf.server.access.Accessor;
import org.ourproject.kune.platf.server.access.AccessorDefault;
import org.ourproject.kune.platf.server.access.Finder;
import org.ourproject.kune.platf.server.access.FinderDefault;
import org.ourproject.kune.platf.server.manager.ContentDescriptorManager;
import org.ourproject.kune.platf.server.manager.FolderManager;
import org.ourproject.kune.platf.server.manager.GroupManager;
import org.ourproject.kune.platf.server.manager.LicenseManager;
import org.ourproject.kune.platf.server.manager.SocialNetworkManager;
import org.ourproject.kune.platf.server.manager.ToolConfigurationManager;
import org.ourproject.kune.platf.server.manager.UserManager;
import org.ourproject.kune.platf.server.manager.impl.ContentDescriptorManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.FolderManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.GroupManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.LicenseManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.SocialNetworkManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.ToolConfigurationManagerDefault;
import org.ourproject.kune.platf.server.manager.impl.UserManagerDefault;
import org.ourproject.kune.platf.server.mapper.DozerMapper;
import org.ourproject.kune.platf.server.mapper.Mapper;
import org.ourproject.kune.platf.server.properties.KuneProperties;
import org.ourproject.kune.platf.server.properties.KunePropertiesDefault;
import org.ourproject.kune.platf.server.services.ContentServerService;
import org.ourproject.kune.platf.server.services.SiteBarServerService;
import org.ourproject.kune.platf.server.state.StateServiceDefault;
import org.ourproject.kune.platf.server.state.StateService;
import org.ourproject.kune.platf.server.tool.ToolRegistry;
import org.ourproject.kune.sitebar.client.rpc.SiteBarService;

import com.google.inject.AbstractModule;
import com.wideplay.warp.persist.PersistenceService;

public class KunePlatformModule extends AbstractModule {
    @Override
    protected void configure() {
	install(PersistenceService.usingJpa().buildModule());
	bind(KunePersistenceService.class);

	bindManagers();
	bindRemoteServices();
	bind(KuneProperties.class).to(KunePropertiesDefault.class);
	bind(Mapper.class).to(DozerMapper.class);
	bind(ToolRegistry.class);

    }

    private void bindRemoteServices() {
	bind(KuneService.class).to(KuneServerService.class);
	bind(ContentService.class).to(ContentServerService.class);
	bind(SiteBarService.class).to(SiteBarServerService.class);
    }

    private void bindManagers() {
	bind(Accessor.class).to(AccessorDefault.class);
	bind(UserManager.class).to(UserManagerDefault.class);
	bind(GroupManager.class).to(GroupManagerDefault.class);
	bind(ContentDescriptorManager.class).to(ContentDescriptorManagerDefault.class);
	bind(ToolConfigurationManager.class).to(ToolConfigurationManagerDefault.class);
	bind(Finder.class).to(FinderDefault.class);
	bind(StateService.class).to(StateServiceDefault.class);
	bind(FolderManager.class).to(FolderManagerDefault.class);
	bind(LicenseManager.class).to(LicenseManagerDefault.class);
	bind(SocialNetworkManager.class).to(SocialNetworkManagerDefault.class);
    }
}
