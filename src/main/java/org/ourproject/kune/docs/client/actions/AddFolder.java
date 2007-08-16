package org.ourproject.kune.docs.client.actions;

import org.ourproject.kune.platf.client.dto.ContainerDTO;
import org.ourproject.kune.platf.client.dto.GroupDTO;
import org.ourproject.kune.platf.client.rpc.ContentService;
import org.ourproject.kune.platf.client.rpc.ContentServiceAsync;
import org.ourproject.kune.sitebar.client.Site;
import org.ourproject.kune.workspace.client.dto.StateDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class AddFolder extends AbstractAddAction {
    public static final String KEY = "docs.addFolder";
    GroupDTO group;

    public AddFolder() {
	group = null;
    }

    public void execute(final Object value, final Object extra) {
	group = (GroupDTO) extra;
	// i18n
	showNewDocDialog((ContainerDTO) value, "create new folder");
    }

    protected void add() {
	// i18n
	Site.showProgress("adding document");
	ContentServiceAsync server = ContentService.App.getInstance();
	String name = form.getName();
	server.addFolder(user, group.getShortName(), containerDTO.getId(), name, new AsyncCallback() {
	    public void onFailure(final Throwable caught) {
	    }

	    public void onSuccess(final Object result) {
		StateDTO content = (StateDTO) result;
		stateManager.setState(content);
	    }
	});
    }
}
