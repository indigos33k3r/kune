/*
 *
 * Copyright (C) 2007-2008 The kune development team (see CREDITS for details)
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

package org.ourproject.kune.platf.server.content;

import java.util.Date;

import org.ourproject.kune.platf.client.errors.DefaultException;
import org.ourproject.kune.platf.server.domain.Container;
import org.ourproject.kune.platf.server.domain.Content;
import org.ourproject.kune.platf.server.domain.I18nLanguage;
import org.ourproject.kune.platf.server.domain.User;
import org.ourproject.kune.platf.server.manager.Manager;
import org.ourproject.kune.platf.server.manager.impl.SearchResult;

public interface ContentManager extends Manager<Content, Long> {

    public void addAuthor(User user, Long contentId, String authorShortName) throws DefaultException;

    public Content createContent(String title, String body, User user, Container container);

    public void delContent(User user, Long contentId) throws DefaultException;

    public Double getRateAvg(Content content);

    public Long getRateByUsers(Content content);

    public Double getRateContent(User user, Content content);

    public void rateContent(User rater, Long contentId, Double value) throws DefaultException;

    public void removeAuthor(User user, Long contentId, String authorShortName) throws DefaultException;

    public String renameContent(User user, Long contentId, String newName) throws DefaultException;

    public Content save(User editor, Content descriptor, String content);

    public I18nLanguage setLanguage(User user, Long contentId, String languageCode) throws DefaultException;

    public void setPublishedOn(User user, Long contentId, Date publishedOn) throws DefaultException;

    public void setTags(User user, Long contentId, String tags) throws DefaultException;

    SearchResult<Content> search(String search);

    SearchResult<Content> search(String search, Integer firstResult, Integer maxResults);

}
