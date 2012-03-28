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
package cc.kune.core.server.persist;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DataSourceOpenfireSessionProvider implements Provider<Session> {
  /** The entity manger to retrieve the session from. */
  @Inject
  @DataSourceOpenfire
  private Provider<EntityManager> entityManagerProvider;

  /**
   * @return the Hibernate session, being the delegate of the entity manager
   *         provided by the injected entity manager provider.
   */
  @Override
  public Session get() {
    final Session session = (Session) entityManagerProvider.get().getDelegate();
    // configure session i.e. flush mode or filtering
    return session;
  }
};