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
package cc.kune.core.server.utils;

import cc.kune.core.shared.utils.ChangedLogosRegistry;
import cc.kune.core.shared.utils.SharedFileDownloadUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The Class AbsoluteFileDownloadUtils get url of avatars etc, with absolute
 * urls (with domain, etc).
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
@Singleton
public class ServerFileDownloadUtils extends SharedFileDownloadUtils {
  @Inject
  public ServerFileDownloadUtils(final ChangedLogosRegistry changedLogosRegistry) {
    super(changedLogosRegistry);
  }

  /**
   * Instantiates a new absolute file download utils.
   *
   * @param properties
   *          the properties
   */
  public ServerFileDownloadUtils(final String prefix, final ChangedLogosRegistry changedLogosRegistry) {
    super(prefix, changedLogosRegistry);
  }

}
