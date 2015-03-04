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

package cc.kune.wave.client.kspecific;

import cc.kune.common.client.log.Log;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

/**
 * The Class PostWaveOpenActions.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class PostWaveOpenActions {

  @Inject
  public PostWaveOpenActions(final EventBus eventBus) {
    eventBus.addHandler(BeforeOpenWaveEvent.getType(), new BeforeOpenWaveEvent.BeforeOpenWaveHandler() {
      @Override
      public void onBeforeOpenWave(final BeforeOpenWaveEvent event) {
        beforeWaveOpen(event.getWaveId());
      }
    });
    eventBus.addHandler(AfterOpenWaveEvent.getType(), new AfterOpenWaveEvent.AfterOpenWaveHandler() {
      @Override
      public void onAfterOpenWave(final AfterOpenWaveEvent event) {
        afterWaveOpen(event.getWaveId());
      }
    });
  }

  private void afterWaveOpen(final String waveUri) {
    Log.info("After open wave: " + waveUri);
  }

  private void beforeWaveOpen(final String waveUri) {
    Log.info("Before open wave: " + waveUri);
  }

}
