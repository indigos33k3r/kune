/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package cc.kune.core.client.registry;

import com.google.inject.Inject;

public class ContentCapabilitiesRegistry {

    private final AclEditableRegistry aclEditable;
    private final AuthorableRegistry authorable;
    private final CanBeHomepageRegistry canBeHomepage;
    private final ComentableRegistry comentable;
    private final DragableRegistry dragable;
    private final DropableRegistry dropable;
    private final EmailSubscribeAbleRegistry emailSubscribeAble;
    private final ContentIconsRegistry iconsRegistry;
    private final LicensableRegistry licensable;
    private final PublishModerableRegistry publishModerable;
    private final RateableRegistry rateable;
    private final RenamableRegistry renamable;
    private final TageableRegistry tageable;
    private final TranslatableRegistry translatable;
    private final VersionableRegistry versionable;
    private final XmppComentableRegistry xmppComentable;
    private final XmppNotifyCapableRegistry xmppNotifyCapable;

    @Inject
    public ContentCapabilitiesRegistry(final AuthorableRegistry authorableRegistry,
            final AclEditableRegistry aclEditableRegistry, final ContentIconsRegistry iconsRegistry,
            final CanBeHomepageRegistry canBeHomepage, final ComentableRegistry comentable,
            final DragableRegistry dragable, final DropableRegistry dropable,
            final EmailSubscribeAbleRegistry emailSubscribeAble, final LicensableRegistry licensable,
            final PublishModerableRegistry publishModerable, final RateableRegistry rateable,
            final TageableRegistry tageable, final RenamableRegistry renamable,
            final TranslatableRegistry translatable, final VersionableRegistry versionable,
            final XmppComentableRegistry xmppComentable, final XmppNotifyCapableRegistry xmppNotifyCapable) {
        this.authorable = authorableRegistry;
        this.aclEditable = aclEditableRegistry;
        this.iconsRegistry = iconsRegistry;
        this.canBeHomepage = canBeHomepage;
        this.comentable = comentable;
        this.dragable = dragable;
        this.dropable = dropable;
        this.emailSubscribeAble = emailSubscribeAble;
        this.licensable = licensable;
        this.publishModerable = publishModerable;
        this.rateable = rateable;
        this.tageable = tageable;
        this.renamable = renamable;
        this.translatable = translatable;
        this.versionable = versionable;
        this.xmppComentable = xmppComentable;
        this.xmppNotifyCapable = xmppNotifyCapable;
    }

    public boolean canBeHomepage(final String typeId) {
        return canBeHomepage.contains(typeId);
    }

    public AclEditableRegistry getAclEditable() {
        return aclEditable;
    }

    public AuthorableRegistry getAuthorable() {
        return authorable;
    }

    public CanBeHomepageRegistry getCanBeHomepage() {
        return canBeHomepage;
    }

    public ComentableRegistry getComentable() {
        return comentable;
    }

    public DragableRegistry getDragable() {
        return dragable;
    }

    public DropableRegistry getDropable() {
        return dropable;
    }

    public EmailSubscribeAbleRegistry getEmailSubscribeAble() {
        return emailSubscribeAble;
    }

    public ContentIconsRegistry getIconsRegistry() {
        return iconsRegistry;
    }

    public LicensableRegistry getLicensable() {
        return licensable;
    }

    public PublishModerableRegistry getPublishModerable() {
        return publishModerable;
    }

    public RateableRegistry getRateable() {
        return rateable;
    }

    public RenamableRegistry getRenamable() {
        return renamable;
    }

    public TageableRegistry getTageable() {
        return tageable;
    }

    public TranslatableRegistry getTranslatable() {
        return translatable;
    }

    public VersionableRegistry getVersionable() {
        return versionable;
    }

    public XmppComentableRegistry getXmppComentable() {
        return xmppComentable;
    }

    public XmppNotifyCapableRegistry getXmppNotificyCapable() {
        return xmppNotifyCapable;
    }

    public boolean isAclEditable(final String typeId) {
        return aclEditable.contains(typeId);
    }

    public boolean isAuthorable(final String typeId) {
        return authorable.contains(typeId);
    }

    public boolean isComentable(final String typeId) {
        return comentable.contains(typeId);
    }

    public boolean isDragable(final String typeId) {
        return dragable.contains(typeId);
    }

    public boolean isDropable(final String typeId) {
        return dropable.contains(typeId);
    }

    public boolean isEmailSubscribeAble(final String typeId) {
        return emailSubscribeAble.contains(typeId);
    }

    public boolean isLicensable(final String typeId) {
        return licensable.contains(typeId);
    }

    public boolean isPublishModerable(final String typeId) {
        return publishModerable.contains(typeId);
    }

    public boolean isRateable(final String typeId) {
        return rateable.contains(typeId);
    }

    public boolean isRenamable(final String typeId) {
        return renamable.contains(typeId);
    }

    public boolean isTageable(final String typeId) {
        return tageable.contains(typeId);
    }

    public boolean isTranslatable(final String typeId) {
        return translatable.contains(typeId);
    }

    public boolean isVersionable(final String typeId) {
        return versionable.contains(typeId);
    }

    public boolean isXmppComentable(final String typeId) {
        return xmppComentable.contains(typeId);
    }

    public boolean isXmppNotifyCapable(final String typeId) {
        return xmppNotifyCapable.contains(typeId);
    }

}