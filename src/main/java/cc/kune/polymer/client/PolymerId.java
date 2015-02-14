/*
 *
 * Copyright (C) 2007-2013 Licensed to the Comunes Association (CA) under
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

package cc.kune.polymer.client;

import cc.kune.common.client.ui.HTMLId;

/**
 * The Enum PolymerId, are ids attributes in ws.html
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public enum PolymerId implements HTMLId {
  /* @formatter:off */

  CHAT_SITEBAR_ICON_GROUP("sitebar_chat_icon_group"),
  DOC_CONTENT("doc_content"),
  DOC_CONTENT_SECTION("doc_content_section"),
  DOC_HEADER_LEFT_EXTENSIONBAR("doc_header_left_extensionbar"),
  DOC_HEADER_RIGHT_EXTENSIONBAR("doc_header_right_extensionbar"),
  DOC_TOOLBAR_EXTENSION("doc_toolbar_extension"),
  DOCUMENT_NAME("document_name"),
  GROUP_ENTITY_TOOLBAR("k_group_entity_toolbar"),
  GROUP_FOLLOWERS("group_followers"),
  GROUP_SPACE("group_space"),
  GROUP_SPACE_ICON("group_space_icon"),
  GROUP_TOOLS_TOOLBAR("group_tools_toolbar"),
  HEADER_BOTTOMBAR("header_bottom_extensionbar"),
  HEADER_CORE_TOOLBAR("header_core_toolbar"),
  HEADER_GROUP_LOGO("header_group_logo"),
  HEADER_GROUP_NAME("header_group_name"),
  HEADER_GROUP_SHADOW("header_group_paper_shadow"),
  HEADER_SHORT_GROUP_NAME("header_short_group_name"),
  HEADER_SOCIAL_NET("header_social_net"),
  HOME_CENTER("k_home_center"),
  HOME_GLOBAL_STATS("k-home-global-stats"),
  HOME_GROUP_STATS("k-home-group-stats"),
  HOME_SPACE_ICON("home_space_icon"),
  HOME_TOOLBAR("k_home_toolbar"),
  INBOX_NEW_MESSAGE("inbox_new_message"),
  INBOX_RESULT("inbox_result"),
  INBOX_SHOW_HIDE("inbox_show_hide"),
  INBOX_SITEBAR_ICON_GROUP("sitebar_user_space_icon_group"),
  KUNE_TEMPLATE("kunetemplate"),
  MIGA("miga"),
  SITE_BOTTOMBAR("site_bottombar"),
  SITEBAR_LEFT_EXTENSIONBAR("sitebar_left_extensionbar"),
  SITEBAR_RIGHT_EXTENSIONBAR("sitebar_right_extensionbar"),
  SITEBAR_SEARCH_ICON("sitebar_search_icon"),
  SITEBAR_SEARCH_INPUT("sitebar_search_input"),
  SPACE_SELECTOR("space_selector_paper_tabs"),
  USER_SPACE("user_space"),
  USER_SPACE_ICON("user_space_icon");
  /* @formatter:on */

  private final String id;

  PolymerId(final String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }

}
