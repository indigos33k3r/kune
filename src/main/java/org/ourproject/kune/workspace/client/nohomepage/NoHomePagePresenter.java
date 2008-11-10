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
 */package org.ourproject.kune.workspace.client.nohomepage;

import org.ourproject.kune.platf.client.View;
import org.ourproject.kune.platf.client.dto.StateAbstractDTO;
import org.ourproject.kune.platf.client.dto.StateNoContentDTO;
import org.ourproject.kune.platf.client.state.StateManager;
import org.ourproject.kune.workspace.client.entitylogo.EntityLogo;

import com.calclab.suco.client.ioc.Provider;
import com.calclab.suco.client.listener.Listener;

public class NoHomePagePresenter implements NoHomePage {

    private NoHomePageView view;

    public NoHomePagePresenter(final StateManager stateManager, final Provider<EntityLogo> entityLogoProvider) {
        stateManager.onStateChanged(new Listener<StateAbstractDTO>() {
            public void onEvent(StateAbstractDTO state) {
                if (state instanceof StateNoContentDTO) {
                    view.clearWs();
                    entityLogoProvider.get().refreshGroupLogo();
                }
            }
        });
    }

    public View getView() {
        return view;
    }

    public void init(NoHomePageView view) {
        this.view = view;
    }
}