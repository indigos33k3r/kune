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
package cc.kune.core.shared.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

// TODO: Auto-generated Javadoc
/**
 * The Class TagCount.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class TagCount implements IsSerializable {

  // FIXME: try to use Integer
  /** The count. */
  private Long count;
  /** The name. */
  private String name;

  /**
   * Instantiates a new tag count.
   */
  public TagCount() {
    this(null, null);
  }

  /**
   * Instantiates a new tag count.
   * 
   * @param name
   *          the name
   */
  public TagCount(final String name) {
    this(name, null);
  }

  /**
   * Instantiates a new tag count.
   * 
   * @param name
   *          the name
   * @param count
   *          the count
   */
  public TagCount(final String name, final Long count) {
    this.name = name;
    this.count = count;
  }

  /**
   * Gets the count.
   * 
   * @return the count
   */
  public Long getCount() {
    return count;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the count.
   * 
   * @param count
   *          the new count
   */
  public void setCount(final Long count) {
    this.count = count;
  }

  /**
   * Sets the name.
   * 
   * @param name
   *          the new name
   */
  public void setName(final String name) {
    this.name = name;
  }

}
