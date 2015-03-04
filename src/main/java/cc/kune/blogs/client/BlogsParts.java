/*
 *
 * Copyright (C) 2007-2015 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
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
package cc.kune.blogs.client;

import cc.kune.blogs.client.actions.BlogsClientActions;
import cc.kune.blogs.shared.BlogsToolConstants;
import cc.kune.core.shared.SessionConstants;
import cc.kune.gspace.client.tool.ContentViewerSelector;
import cc.kune.gspace.client.viewers.ContentViewerPresenter;
import cc.kune.gspace.client.viewers.FolderViewerPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class BlogsParts.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class BlogsParts {

  /**
   * Instantiates a new blogs parts.
   *
   * @param session the session
   * @param clientTool the client tool
   * @param viewerSelector the viewer selector
   * @param blogsActions the blogs actions
   * @param contentViewer the content viewer
   * @param folderViewer the folder viewer
   */
  @Inject
  public BlogsParts(final SessionConstants session, final Provider<BlogsClientTool> clientTool,
      final ContentViewerSelector viewerSelector, final BlogsClientActions blogsActions,
      final ContentViewerPresenter contentViewer, final FolderViewerPresenter folderViewer) {
    clientTool.get();
    viewerSelector.register(contentViewer, true, BlogsToolConstants.TYPE_POST);
    viewerSelector.register(folderViewer, true, BlogsToolConstants.TYPE_ROOT,
        BlogsToolConstants.TYPE_BLOG);
  }
}
