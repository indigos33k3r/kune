package cc.kune.docs.client.viewers;

import javax.annotation.Nonnull;

import cc.kune.common.client.actions.ui.descrip.GuiActionDescCollection;
import cc.kune.core.client.actions.ActionRegistryByType;
import cc.kune.core.client.registry.ContentCapabilitiesRegistry;
import cc.kune.core.client.registry.IconsRegistry;
import cc.kune.core.client.services.FileDownloadUtils;
import cc.kune.core.client.services.ImageSize;
import cc.kune.core.client.state.Session;
import cc.kune.core.client.state.StateManager;
import cc.kune.core.shared.domain.ContentStatus;
import cc.kune.core.shared.domain.utils.AccessRights;
import cc.kune.core.shared.domain.utils.StateToken;
import cc.kune.core.shared.dto.BasicMimeTypeDTO;
import cc.kune.core.shared.dto.ContainerDTO;
import cc.kune.core.shared.dto.ContainerSimpleDTO;
import cc.kune.core.shared.dto.ContentSimpleDTO;
import cc.kune.core.shared.dto.HasContent;
import cc.kune.core.shared.dto.StateContainerDTO;
import cc.kune.core.shared.i18n.I18nTranslationService;
import cc.kune.docs.client.DocsClientTool;
import cc.kune.docs.client.actions.DocsClientActions;
import cc.kune.gspace.client.actions.perspective.MenuPerspective;
import cc.kune.gspace.client.tool.ContentViewer;
import cc.kune.gspace.client.tool.ContentViewerSelector;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class FolderViewerPresenter extends
        Presenter<FolderViewerPresenter.FolderViewerView, FolderViewerPresenter.FolderViewerProxy> implements
        ContentViewer {

    @ProxyCodeSplit
    public interface FolderViewerProxy extends Proxy<FolderViewerPresenter> {
    }

    public interface FolderViewerView extends View {

        void addItem(FolderItemDescriptor item, DoubleClickHandler handler);

        void attach();

        void clear();

        void detach();

        void setActions(GuiActionDescCollection actions);

        void setContainer(StateContainerDTO state);
    }

    private final ActionRegistryByType actionsRegistry;
    private final ContentCapabilitiesRegistry capabilitiesRegistry;
    private final Provider<FileDownloadUtils> downloadUtilsProvider;
    private final I18nTranslationService i18n;
    private final IconsRegistry iconsRegistry;
    private final Session session;
    private final StateManager stateManager;
    private final boolean useGenericImageIcon;

    @Inject
    public FolderViewerPresenter(final EventBus eventBus, final FolderViewerView view, final FolderViewerProxy proxy,
            final Session session, final StateManager stateManager, final I18nTranslationService i18n,
            final ContentViewerSelector viewerSelector, final ActionRegistryByType actionsRegistry,
            final DocsClientActions actions, final Provider<FileDownloadUtils> downloadUtilsProvider,
            final ContentCapabilitiesRegistry capabilitiesRegistry) {
        super(eventBus, view, proxy);
        this.session = session;
        this.stateManager = stateManager;
        this.i18n = i18n;
        this.actionsRegistry = actionsRegistry;
        this.downloadUtilsProvider = downloadUtilsProvider;
        this.capabilitiesRegistry = capabilitiesRegistry;
        iconsRegistry = capabilitiesRegistry.getIconsRegistry();
        viewerSelector.register(this, true, DocsClientTool.TYPE_ROOT, DocsClientTool.TYPE_FOLDER);
        useGenericImageIcon = false;
    }

    private void addItem(final String title, final String contentTypeId, final BasicMimeTypeDTO mimeType,
            final ContentStatus status, final StateToken stateToken, final StateToken parentStateToken,
            final AccessRights rights, final boolean isNodeSelected) {
        final Object icon = getIcon(stateToken, contentTypeId, mimeType);
        final String tooltip = getTooltip(stateToken, mimeType);
        final FolderItemDescriptor item = new FolderItemDescriptor(genId(stateToken), genId(parentStateToken), icon,
                title, tooltip, status, stateToken, capabilitiesRegistry.isDragable(contentTypeId)
                        && rights.isAdministrable(), capabilitiesRegistry.isDropable(contentTypeId)
                        && rights.isAdministrable(), actionsRegistry.getCurrentActions(stateToken, contentTypeId,
                        session.isLogged(), rights, MenuPerspective.class));
        if (status.equals(ContentStatus.inTheDustbin) && !session.getShowDeletedContent()) {
            // Don't show
        } else {
            getView().addItem(item, new DoubleClickHandler() {

                @Override
                public void onDoubleClick(final DoubleClickEvent event) {
                    stateManager.gotoStateToken(stateToken);
                }
            });
        }
    }

    @Override
    public void attach() {
        getView().attach();
    }

    private void createChildItems(final ContainerDTO container, final AccessRights containerRights) {
        for (final ContainerSimpleDTO siblingFolder : container.getChilds()) {
            addItem(siblingFolder.getName(), siblingFolder.getTypeId(), null, ContentStatus.publishedOnline,
                    siblingFolder.getStateToken(),
                    siblingFolder.getStateToken().copy().setFolder(siblingFolder.getParentFolderId()), containerRights,
                    false);
        }
        for (final ContentSimpleDTO content : container.getContents()) {
            // content.getTitle()
            addItem(content.getStateToken().toString(), content.getTypeId(), content.getMimeType(),
                    content.getStatus(), content.getStateToken(), content.getStateToken().copy().clearDocument(),
                    content.getRights(), false);
        }
    }

    @Override
    public void detach() {
        getView().detach();
    }

    private String genId(final StateToken token) {
        return "k-cnav-" + token.toString().replace(StateToken.SEPARATOR, "-");
    }

    private Object getIcon(final StateToken token, final String contentTypeId, final BasicMimeTypeDTO mimeType) {
        if (contentTypeId.equals(DocsClientTool.TYPE_FOLDER)) {
            return null;
        } else if (!useGenericImageIcon && mimeType != null && mimeType.getType().equals("image")) {
            return downloadUtilsProvider.get().getImageResizedUrl(token, ImageSize.ico);
        } else {
            return iconsRegistry.getContentTypeIcon(contentTypeId, mimeType);
        }
    }

    private String getTooltip(final StateToken token, final BasicMimeTypeDTO mimeType) {
        if (mimeType != null && (mimeType.isImage() || mimeType.isPdf())) {
            // Used for previews
            return null;
        } else {
            return i18n.t("Double click to open");
        }
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }

    @Override
    public void setContent(@Nonnull final HasContent state) {
        getView().clear();
        final StateContainerDTO stateContainer = (StateContainerDTO) state;
        final AccessRights rights = stateContainer.getContainerRights();
        final GuiActionDescCollection actions = actionsRegistry.getCurrentActions(stateContainer.getGroup(),
                stateContainer.getTypeId(), session.isLogged(), rights);
        getView().setActions(actions);
        getView().setContainer(stateContainer);
        createChildItems(stateContainer.getContainer(), stateContainer.getContainerRights());
        // view.setEditable(rights.isEditable());
    }
}