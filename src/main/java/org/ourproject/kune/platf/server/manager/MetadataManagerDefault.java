package org.ourproject.kune.platf.server.manager;

import org.ourproject.kune.platf.server.domain.AccessLists;
import org.ourproject.kune.platf.server.model.AccessRights;
import org.ourproject.kune.platf.server.model.Content;

import com.google.inject.Singleton;

@Singleton
public class MetadataManagerDefault implements MetadataManager {
    public void fill(final Content content, final AccessLists accessList, final AccessRights accessRights) {
	content.prepare();
	content.setAccessLists(accessList);
	content.setAccessRights(accessRights);
	content.setRate(content.getDescriptor().calculateRate(content.getDescriptor()));
	content.setRateByUsers(content.getDescriptor().calculateRateNumberOfUsers(content.getDescriptor()));
    }
}
